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
	ADDOP ;
	MULTOP;
	OPLOG;
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
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' returnType '=' exp
	;

returnType
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

/*lValue
	: ID v
	;
	*/

lValue
	: '[' exp ']' lValue
	| '.' ID lValue
	|
	;


exp
	: e (OPLOG e)*
	;
/*	: 'nil'
	| INTLIT
	| STRINGLIT
	| seqExp
	| negation
	| ID idBegin
	| ifThen
	| whileExp
	| forExp
	| 'break'
	| letExp		*/


e
	: multExp (ADDOP multExp)*
	;

multExp
	: atom (MULTOP atom)*
	;

atom
	: 'nil'
	| INTLIT
	| STRINGLIT
	| seqExp
	| negation
	| ID idBegin
	| ifThen
	| whileExp
	| forExp
	| 'break'
	| letExp
	;

seqExp
	: '(' (exp (';' exp)*)? ')'
	;

negation
	: '-' exp
	;

/*
infixExp
	: exp INFIXOP exp
	;
	*/

/*
arrRecCreate
	: tyid arrRec
	;
*/

idBegin
	: '[' exp ']' bracBegin
	| '.' ID lValue
	| '{' (fieldCreate(',' fieldCreate)*)? '}'
	;

bracBegin
	:  'of' exp
	| lValue
	;

/*arrRec
	: '[' exp ']' 'of' exp
	| '{' (fieldCreate(',' fieldCreate)*)? '}'
	;
	*/

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

ADDOP
	: '+'
	| '-'
	;

MULTOP
	: '*'
	| '/'
	;

OPLOG
	: '='
	| '<>'
	|	'>'
	| '<'
	| '>='
	| '<='
	| '&'
	| '|'
	;
