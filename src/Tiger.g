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
	ARRTY ;
	TYDEC ;
	ASSIGNMENT ;
	ROOT ;
	WHILE ;
	FOR ;
	NEGATION ;
	RETURNTYPE ;
	VARDEC ;
	VD ;
	EXPSTOR ;
	IDSTOR ;
	STRINGLIT ;
	NIL ;
	BREAK ;
	IDBEG ;
	EXPBEG ;
	FIELDDEC ;
	BRACBEG ;
	FIELDCREATE ;
	IFTHEN ;
	LET ;
	ID ;
	INTLIT ;
	STRINGLIT ;
	SEQEXP ;
	CALLEXP ;
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
	: 'type' tyid '=' ty -> ^(TYDEC tyid ty)
	;

ty
	: tyid
	| arrTy
	| recTy
	;

arrTy
	: 'array' 'of' tyid -> ^(ARRTY tyid)
	;

recTy
	: '{' (fieldDec (',' fieldDec)*)? '}'  ->^(RECTY fieldDec*)
	;

fieldDec
	: ID ':' tyid -> ^(FIELDDEC ID tyid)
	;

funDec
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' returnType '=' exp -> ^(ID fieldDec* returnType exp)
	;

returnType
	: ':' tyid -> ^(RETURNTYPE tyid)
	|
	;

varDec
	: 'var' ID vd ':=' exp -> ^(VARDEC ID vd exp)
	;

vd
	: ':' tyid ->^(VD tyid)
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
	: '[' exp ']' lValue -> ^(EXPSTOR exp lValue)
	| '.' ID lValue -> ^(IDSTOR ID lValue)
	| assignment
	|
	;

assignment
	: ':=' exp -> ^(ASSIGNMENT exp)
	;

exp
	: e (options{greedy=true;}: logop e)* -> ^(e (logop e)*)
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
	: multExp (options{greedy=true;}: addop multExp)*  -> ^(multExp (addop multExp)*)
	;

multExp
	: atom (options{greedy=true;}: multop atom)*  -> ^(atom (multop atom)*)
	;

atom
	: 'nil'			-> ^(NIL)
	| INTLIT 		-> ^(INTLIT)
	| STRINGLIT 	-> ^(STRINGLIT)
	| seqExp 		-> ^(seqExp)
	| negation 		-> ^(negation)
	| ID idBegin 	-> ^(IDBEG)
	| ifThen 		-> ^(ifThen)
	| whileExp 		-> ^(whileExp)
	| forExp 		-> ^(forExp)
	| 'break' 		-> ^(BREAK)
	| letExp 		-> ^(letExp)
	;

seqExp
	: '(' (exp (';' exp)*)? ')' -> ^(SEQEXP exp*)
	;

negation
	: '-' exp -> ^(NEGATION exp)
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
	: '[' exp ']' bracBegin 					-> ^(EXPBEG exp bracBegin)
	| '.' ID lValue								-> ^(IDBEG ID lValue)
	| '{' (fieldCreate(',' fieldCreate)*)? '}'	-> ^(FIELDDEC fieldCreate*)
	| assignment 								-> ^(assignment)
	| '(' (exp(',' exp)*)? ')' 					-> ^(CALLEXP exp*)
	|
	;

bracBegin
	:  'of' exp 	-> ^(BRACBEG exp)
	| lValue		-> ^(lValue)
	;

/*arrRec
	: '[' exp ']' 'of' exp
	| '{' (fieldCreate(',' fieldCreate)*)? '}'
	;
	*/

fieldCreate
	: ID '=' exp 	-> ^(FIELDCREATE ID exp)
	;


ifThen
	: 'if' exp 'then' exp (options{greedy=true;}: 'else' exp)? 	-> ^(IFTHEN exp exp+)
	;


/*els : 'else' exp
	|
	;*/

whileExp
	: 'while' exp 'do' exp 	-> ^(WHILE exp exp)
	;

forExp
	: 'for' ID ':=' exp 'to' exp 'do' exp -> ^(FOR ID exp exp exp)
	;

letExp
	: 'let' (dec)+ 'in' (exp(';' exp)*)? 'end' -> ^(LET dec+ exp*)
	;

tyid
	: ID
	;

addop
	: '+'
	| '-'
	;

multop
	: '*'
	| '/'
	;

logop	: '='
	| '<>'
	|	'>'
	| '<'
	| '>='
	| '<='
	| '&'
	| '|'
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



WS : (' ' | '\t' | '\n' | '\r' | '/*'.*'*/' | '//'.* ('\r'|'\n'))+ {$channel = HIDDEN; }
   ;
