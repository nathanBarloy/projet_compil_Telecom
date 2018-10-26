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

a : ':' TYID
	|
	;

varDec
	: 'var' ID vd ':=' exp
	;

vd
	: ':' TYID
	|
	;

lValue : ID v
		;

v : '[' exp ']' v
	| '.' ID v
	|
	;

exp
	: lValue infixExp
	| 'nil' infixExp
	| INTLIT infixExp
	| STRINGLIT infixExp
	| seqExp infixExp
	| negation infixExp
	| callExp infixExp
	| infixExp
	| arrRecCreate infixExp
	| assignment infixExp
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

callExp
	: ID '(' (exp(';' exp)*)? ')'
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

assignment
	: lValue ':=' exp
	;

ifThen
	: 'if' exp 'then' exp els
	;

els : 	'else' exp
		|
	;

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
fragment DIGIT  : '0'..'9' ;
fragment UPPERCASE : 'A'..'Z' ;
fragment LOWERCASE : 'a'..'z' ;
fragment LETTRE
	: LOWERCASE
	| UPPERCASE
	;
fragment ESC
	: '\\' 'n'
	| '\\' 't'
	| '\\' '^c'
	| '\\' DIGIT DIGIT DIGIT
	| '\\' '"'
	| '\\' '\\'
	//| '\\s...s\\'
	;
fragment PONCTUATION
	: '.'|','|';'|':'|'?'|'!'|'\''
	;
fragment PRINTABLE
	: LETTRE
	| DIGIT
	| PONCTUATION
	| '+'|'-'|'*'|'/'|'='
	;


ID 	:	 LETTRE (LETTRE | DIGIT | '_')*
	;

TYID 	:	 LETTRE (LETTRE | DIGIT | '_')*
	;

INTLIT
	:	DIGIT+
	;

STRINGLIT
	:	'"' (PRINTABLE | ESC)* '"'
	;

INFIXOP : '+'
		|'-'
		|'*'
		|'/'
	;
