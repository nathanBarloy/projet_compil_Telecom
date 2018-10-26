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
	: 'var' ID ':=' exp
	| 'var' ID ':' TYID ':=' exp
	;

lValue
	: ID v2
	;

v2		// penser a changer le nom
	: '[' exp ']' v2
	| '.' ID v2
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
	| ifThenElse
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
