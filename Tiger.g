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
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' '=' exp
	| 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' ':' TYID '=' exp
	;

varDec 
	: 'var' ID vd ':=' exp
	;

vd
	: ':' TYID
	| 
	;

lValue
	: ID
	| subscript
	| fieldExp
	;

subscript 
	: lValue '[' exp ']'
	;

fieldExp
	: lValue '.' ID
	;

exp 
	: lValue infixExp 
	| 'nil' infixExp 
	| INTLIT infixExp 
	| STRINGLIT infixExp 
	| seqExp infixExp 
	| negation infixExp 
	| callExp infixExp 
	| infixExp infixExp 
	| arrCreate infixExp 
	| recCreate infixExp 
	| assignment infixExp 
	| ifThenElse infixExp 
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

arrCreate
	: TYID '[' exp ']' 'of' exp
	;

recCreate
	: TYID '{' (fieldCreate(',' fieldCreate)*)? '}'
	;

fieldCreate
	: ID '=' exp
	;

assignment
	: lValue ':=' exp
	;

ifThenElse
	: 'if' exp 'then' exp 'else' exp
	;

ifThen
	: 'if' exp 'then' exp
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
INFIXOP 
	: '+'|'-'|'*'|'/'
	;