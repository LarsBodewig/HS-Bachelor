grammar Logic;

options {
	language = Java;
}

@header {
package grammar.logic;
}

// rules
variable:
	ALPHA (ALPHA | DIGIT)*;
term:
	  variable #var
	| NOT variable #varNeg
	| term AND term #conjunction
	| NOT PARENTHESES_OPEN term AND term PARENTHESES_CLOSE #sheffer
	| term OR term #disjunction
	| NOT PARENTHESES_OPEN term OR term PARENTHESES_CLOSE #peirce
	| term IMPLY term #subjunction
	| NOT PARENTHESES_OPEN term IMPLY term PARENTHESES_CLOSE #inhibition
	| PARENTHESES_OPEN term PARENTHESES_CLOSE #precedence
	| NOT PARENTHESES_OPEN term PARENTHESES_CLOSE #precedenceNeg;
statement:
	term;
statements:
	  statement (STATEMENT_DELIMIT statement)*
	| STATEMENTS_OPEN? statement (STATEMENT_DELIMIT statement)* STATEMENTS_CLOSE?;


// tokens
ALPHA: [a-zA-Z];
DIGIT: [0-9];

NOT: 'NOT' | 'not' | '¬';
AND: 'AND' | 'and' | '∧';
OR: 'OR' | 'or' | '∨';
IMPLY: 'IMPLY' | 'imply' | '→';

PARENTHESES_OPEN: '(';
PARENTHESES_CLOSE: ')';
STATEMENT_DELIMIT: ',' | ';';
STATEMENTS_OPEN: '{';
STATEMENTS_CLOSE: '}';

WS: [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines
