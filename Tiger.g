grammar Tiger;

options {
//language = JAVA;
output = AST;
backtrack = false;
k=1 ;
}

tokens {
	ID ;
	TYID ;
	INTLIT ;
	STRINGLIT ;
	INFIXOP ;
}

program
	: exp
	;

dec
	: tyDec
	| varDec
	| funDec
	;
tyDec
	: 'type' TYID '=' ty
	;

ty
	: TYID
	| arrTy
	| recTy
	;

arrTy
	: 'array' 'of' TYID
	;

recTy
	: '{' (fieldDec (',' fieldDec)*)? '}'
	;

fieldDec
	: ID ':' TYID
	;

funDec
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' a '=' exp
	;

a
	: ':' TYID
	|
	;

varDec
	: 'var' ID vd ':=' exp
	;

vd
	: ':' TYID
	|
	;

//v : ID v
		//;

/*masto	: ID v
		;

v 		: lValue
		| '(' (exp(';' exp)*)? ')'
		| ID lValue
		|
		;

lValue : '[' exp ']' lValue
	| '.' ID lValue
	|
	;
*/

lValue
	: ID v
	;

v
	: '[' exp ']' v
	| '.' ID v
	|
	;


exp
	// : masto infixExp
	: lValue infixExp
	| 'nil' infixExp
	| INTLIT infixExp
	| STRINGLIT infixExp
	| seqExp infixExp
	| negation infixExp
	| arrRecCreate infixExp
	| ifThen infixExp
	| whileExp infixExp
	| forExp infixExp
	| 'break' infixExp
	| letExp infixExp
	;

seqExp
	: '(' (exp (';' exp)*)? ')'
	;

negation
	: '-' exp
	;


infixExp
	: INFIXOP exp infixExp
	|
	;

arrRecCreate
	: TYID arrRec
	;

arrRec
	: '[' exp ']' 'of' exp
	| '{' (fieldCreate(',' fieldCreate)*)? '}'
	;

fieldCreate
	: ID '=' exp
	;


ifThen
	: 'if' exp 'then' exp (options{greedy=true;}: 'else' exp)?
	;

/*els : 'else' exp
	|
	;*/

whileExp
	: 'while' exp 'do' exp
	;

forExp
	: 'for' ID ':=' exp 'to' exp 'do' exp
	;

letExp
	: 'let' (dec)+ 'in' (exp(';' exp)*)? 'end'
	;

//definition des expressions regulieres reconnaissant les tokens

ID 	:	 ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | ('0'..'9') | '_')*
	;

TYID 	:	 ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | ('0'..'9') | '_')*
	;

INTLIT
	:	('0'..'9')+
	;

STRINGLIT
	:	'"' ('a'..'z' | 'A'..'Z' | '0'..'9' |'!'..'@')* '"'
	;

INFIXOP
	: '+'
	| '-'
	| '*'
	| '/'
	;
