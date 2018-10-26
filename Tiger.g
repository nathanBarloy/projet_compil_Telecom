grammar Tiger;

options {
//language = JAVA;
output = AST;
backtrack = flase;
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
 	TYID '=' exp
	;

a : ':' TYID
	|
	;
varDec 
		: 'var' ID ':=' exp
		| 'var' ID ':' TYID ':=' exp
		;

lValue : ID v
		;

v : '[' exp ']' v
	| '.' ID v
	|
	;
exp 
	: lValue
	| 'nil'
	| INTLIT
	| STRINGLIT
	| seqExp
	| negation
	| callExp
	| infixExp
	| arrCreate
	| recCreate
	| assignment
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

callExp
	: ID '(' (exp(';' exp)*)? ')'
	;

infixExp
	: exp INFIXOP exp
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

ifThen
	: 'if' exp 'then' exp else
	;

else : 	else exp
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
INTLIT 	:	DIGIT+
	;
STRINGLIT :	'"' (PRINTABLE | ESC)* '"'
	;

INFIXOP : '+'
		|'-'
		|'*'
		|'/'
	;

