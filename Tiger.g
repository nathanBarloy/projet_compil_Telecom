grammar Tiger;

options {
//language = JAVA;
output = AST;
backtrack = false;
k=1 ;
}

tokens {
	ID ;
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
	: 'type' tyid '=' ty
	;

ty
	: tyid
	| arrTy
	| recTy
	;

arrTy
	: 'array' 'of' tyid
	;

recTy
	: '{' (fieldDec (',' fieldDec)*)? '}'
	;

fieldDec
	: ID ':' tyid
	;

funDec
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' a '=' exp
	;

a
	: ':' tyid
	|
	;

varDec
	: 'var' ID vd ':=' exp
	;

vd
	: ':' tyid
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
	: tyid arrRec
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

<<<<<<< HEAD
els
	: 'else' exp
=======
/*els : 'else' exp
>>>>>>> 58f3663e8957781772bd06d0e8266248c395fd10
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

tyid
	: ID
	;
//definition des expressions regulieres reconnaissant les tokens

ID 	:	 ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | ('0'..'9') | '_')*
	;

//TYID 	:	 ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | ('0'..'9') | '_')*
//	;

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
