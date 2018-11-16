grammar Tiger;

options {
//language = JAVA;
output = AST;
backtrack = false;
k=1 ;
}

tokens {
	//tokens des règles de réécriture
	MULTEXP ;
	LETEXP;
	IFTHEN ;
	RECTY ;
	ROOT ;
	WHILE ;
	FOR ;
	NEGATION ;
	//
	ID ;
	INTLIT ;
	STRINGLIT ;
	ADDOP ;
	MULTOP;
	LOGOP;
}

program
	: exp -> ^(ROOT exp)
	;

dec
	: tyDec
	| varDec
	| funDec
	;

tyDec
	: 'type' tyid '=' ty //-> ^('type' tyid ty)
	;

ty
	: tyid
	| arrTy
	| recTy
	;

arrTy
	: 'array' 'of' tyid //->^()
	;

recTy
	: '{' (fieldDec (',' fieldDec)*)? '}' //->^(RECTY fieldDec+)
	;

fieldDec
	: ID ':' tyid
	;

funDec
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' returnType '=' exp //-> ^('function' ID fieldDec* returnType)
	;

returnType
	: ':' tyid //-> ^(tyid)
	|
	;

varDec
	: 'var' ID vd ':=' exp //-> ^('var' ID vd exp)
	;

vd
	: ':' tyid //->^('vd' tyid)
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
	: '[' exp ']' lValue //-> ^(lValue exp lValue)
	| '.' ID lValue //-> ^()
	|
	;


exp
	: e (options{greedy=true;}: LOGOP e)*
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
	: multExp (options{greedy=true;}: ADDOP multExp)*  //-> ^(e multExp (ADDOP multExp)*)
	;

multExp
	: atom (options{greedy=true;}: MULTOP atom)*  //-> ^(multExp atom (MULTOP atom)*)
	;

atom
	: 'nil'
	| INTLIT
	| STRINGLIT
	| seqExp
	//| negation
	| ID idBegin
	| ifThen
	| whileExp
	| forExp
	| 'break'
	| letExp
	;

seqExp
	: '(' (exp (';' exp)*)? ')' //-> ^(seqExp exp+)
	;

negation
	: '-' exp //-> ^(negation exp)
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
	: 'if' exp 'then' exp (options{greedy=true;}: 'else' exp)? //-> ^('ifThen' exp exp exp)
	;


/*els : 'else' exp
	|
	;*/

whileExp
	: 'while' exp 'do' exp //-> ^(WHILE exp exp)
	;

forExp
	: 'for' ID ':=' exp 'to' exp 'do' exp //-> ^(FOR ID exp exp exp)
	;

letExp
	: 'let' (dec)+ 'in' (exp(';' exp)*)? 'end' //-> ^('letExp' dec+ exp+)
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

LOGOP	: '='
	| '<>'
	|	'>'
	| '<'
	| '>='
	| '<='
	| '&'
	| '|'
	;

WS : (' ' | '\t' | '\n' | '\r' | '/*'.*'*/' | '//'.* ('\r'|'\n'))+ {$channel = HIDDEN; }
   ;
