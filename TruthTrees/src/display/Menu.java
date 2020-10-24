package display;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

class Menu extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	private Component comp;

	Menu(Component comp) {
		this.comp = comp;
	}

	void addItem(String text, Consumer<ActionEvent> action) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(new ItemListener(action, this.comp));
		this.add(item);
	}

	MouseAdapter getListener() {
		return new MenuListener(this);
	}

	class ItemListener implements ActionListener, PopupMenuListener {
		private Component comp;
		
		Consumer<ActionEvent> action;

		public ItemListener(Consumer<ActionEvent> action, Component comp) {
			this.action = action;
			this.comp = comp;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			comp.repaint();
			this.action.accept(e);
		}

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			comp.repaint();
		}

		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		}
	}

	class MenuListener extends MouseAdapter {
		private JPopupMenu menu;

		MenuListener(JPopupMenu menu) {
			this.menu = menu;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}

		private void showMenu(MouseEvent e) {
			this.menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
