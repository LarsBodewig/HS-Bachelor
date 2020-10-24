package display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.collections4.map.ListOrderedMap;

import truthtrees.Branch;
import truthtrees.Term;

public class View extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int START_Y = 40;
	private static final int TERM_GAP = 5;
	private static final int NODE_GAP_Y = 80;
	private static final int EDGE_GAP = 10;
	private static final int EDGE_OFFESET_X = 8;
	private static final int EDGE_STROKE = 2;
	private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	private static final BufferedImage SET_OPEN = createSymbol("{");
	private static final BufferedImage SET_CLOSE = createSymbol("}");
	private final Branch root;
	private final JFrame frame;
	private final int width;

	public View(Branch tree, int width) {
		super(new GridLayout());
		this.root = tree;
		this.width = width;
		this.frame = new JFrame();
		initialize();
	}

	private void initialize() {
		this.frame.setTitle("TruthTrees");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		JScrollPane scroll = new JScrollPane(this);
		scroll.setBackground(Color.WHITE);
		scroll.setPreferredSize(new Dimension(this.width, 600));
		scroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		this.frame.add(scroll);
		Menu menu = new Menu(this.frame);
		menu.addItem("Save as image", this::saveWithMenu);
		this.addMouseListener(menu.getListener());
		this.frame.pack();
		this.paint(this.frame.getGraphics());
	}

	private void saveWithMenu(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "*.png";
			}
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".png");
			}
		});
		if (JFileChooser.APPROVE_OPTION == jfc.showSaveDialog(this)) {
			File file = jfc.getSelectedFile();
			String fileName = file.getAbsolutePath();
			if (!file.exists() && !file.getName().toLowerCase().endsWith(".png")) {
				fileName += ".png";
			}
			this.saveToFile(fileName);
		} else {
			this.frame.repaint();
		}
	}

	public void display() {
		this.frame.setVisible(true);
	}

	public void saveToFile(String fileName) {
		BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.paint(g2d);
		try {
			ImageIO.write(img, "png", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				this.frame.dispose();
			} catch(Exception e) {
				System.exit(0);
			}
		}
	}

	private static BufferedImage createSymbol(String text) {
		Font font = new Font(Font.SERIF, Font.PLAIN, 256);
		FontRenderContext frc = new FontRenderContext(null, true, true);
		TextLayout layout = new TextLayout(text, font, frc);
		Rectangle r = layout.getPixelBounds(null, 0, 0);
		BufferedImage bi = new BufferedImage(r.width + 1 + 30, r.height + 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bi.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		layout.draw(g2d, 0, -r.y);
		g2d.dispose();
		return bi;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setFont(View.FONT);
		g.setColor(Color.BLACK);
		printTree(g, this.root, View.START_Y, 0, this.frame.getWidth() - 100);
	}

	private void printTree(Graphics g, Branch tree, int y, int minX, int maxX) {
		int meanX = (maxX + minX) / 2;
		int widestTerm = 0;
		ListOrderedMap<String, Integer> termWidth = new ListOrderedMap<>();
		for (Term term : tree.value()) {
			String value = term.toString();
			int width = g.getFontMetrics(View.FONT).stringWidth(value);
			widestTerm = Math.max(widestTerm, width);
			if (termWidth.size() < tree.value().size() - 1) {
				value += ",";
			}
			termWidth.put(value, Integer.valueOf(width));
		}
		int startY = y;
		int lineHeight = g.getFontMetrics(View.FONT).getHeight();
		if (tree.value().size() > 1) {
			int nodeHeight = tree.value().size() * (lineHeight + View.TERM_GAP) - 10;
			g.drawImage(View.SET_OPEN, (int) (meanX - widestTerm / 2 - 12 - 12 * Math.sqrt(tree.value().size())),
					startY - 15, (int) (12 * Math.sqrt(tree.value().size())), nodeHeight, null);
			g.drawImage(View.SET_CLOSE, meanX + widestTerm / 2 + 10, startY - 15,
					(int) (12 * Math.sqrt(tree.value().size())), nodeHeight, null);
		}
		for (int i = 0; i < termWidth.size(); i++) {
			int startX = meanX - termWidth.getValue(i).intValue() / 2;
			g.drawString(termWidth.get(i), startX, startY);
			if (i < termWidth.size() - 1) {
				startY += lineHeight + View.TERM_GAP;
			}
		}
		int edgeStart = startY + View.EDGE_GAP;
		startY += View.NODE_GAP_Y;
		int edgeEnd = startY - lineHeight - View.EDGE_GAP / 2;
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(View.EDGE_STROKE));
		if (tree.children().size() == 1) {
			printTree(g, (Branch) tree.children().get(0), startY, minX, maxX);
			g2d.drawLine(meanX, edgeStart, meanX, edgeEnd);
		} else if (tree.children().size() == 2) {
			printTree(g, (Branch) tree.children().get(0), startY, minX, meanX);
			printTree(g, (Branch) tree.children().get(1), startY, meanX, maxX);
			g2d.drawLine(meanX, edgeStart, (meanX + minX) / 2 + View.EDGE_OFFESET_X, edgeEnd);
			g2d.drawLine(meanX, edgeStart, (meanX + maxX) / 2 - View.EDGE_OFFESET_X, edgeEnd);
		} else if (tree.contradicts()) {
			g.drawString("X", meanX - g.getFontMetrics(View.FONT).stringWidth("X") / 2, startY);
			g2d.drawLine(meanX, edgeStart, meanX, edgeEnd);
		}
		if (startY > this.getHeight()) {
			this.setPreferredSize(new Dimension(this.frame.getWidth() - 100, startY));
			this.setSize(new Dimension(this.frame.getWidth() - 100, startY));
		}
	}
}
