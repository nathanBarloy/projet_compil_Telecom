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
	VAR;
	FOR ;
	LET;
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
	SEQEXP ;
	CALLEXP ;
	FUNDEC;
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
	: '{' (fieldDec (',' fieldDec)*)? '}'  -> ^(RECTY fieldDec*)
	;

fieldDec
	: ID ':' tyid -> ^(FIELDDEC ID tyid)
	;

funDec
	: 'function' ID '(' (fieldDec(',' fieldDec)*)? ')' returnType? '=' exp -> ^(FUNDEC ID fieldDec* returnType? exp)
	;

returnType
	: ':' tyid -> tyid
	;

varDec
	: 'var' ID vd? ':=' exp -> ^(VARDEC ID vd? exp)
	;

vd
	: ':' tyid -> tyid
	;

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
	: e (options{greedy=true;}: logop^ e)*
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
	: multExp (options{greedy=true;}: addop^ multExp)*  //-> ^(multExp (addop multExp)*)
	;

multExp
	: atom (options{greedy=true;}: multop^ atom)*  //-> ^(atom (multop atom)*)
	;

atom
	: 'nil'
	| INTLIT
	| STRINGLIT
	| seqExp
	| negation
	| ID idBegin  -> ^(IDBEG ID idBegin?)
	| ifThen
	| whileExp
	| forExp
	| 'break'
	| letExp
	;

seqExp
	: '(' (exp (';' exp)*)? ')' -> ^(SEQEXP exp*)
	;

negation
	: '-' exp -> ^(NEGATION exp)
	;

idBegin
	: '[' exp ']' bracBegin 					-> ^(EXPBEG exp bracBegin)
	| '.' ID lValue								-> ^(IDBEG ID lValue)
	| '{' (fieldCreate(',' fieldCreate)*)? '}'	-> ^(FIELDDEC fieldCreate*)
	| assignment
	| '(' (exp(',' exp)*)? ')' 					-> ^(CALLEXP exp*)
	|
	;

bracBegin
	:  'of' exp 	-> ^(BRACBEG exp)
	| lValue
	;

fieldCreate
	: ID '=' exp 	-> ^(FIELDCREATE ID exp)
	;


ifThen
	: 'if' exp 'then' exp (options{greedy=true;}: 'else' exp)? 	-> ^(IFTHEN exp exp+)
	;

whileExp
	: 'while' exp 'do' exp 	-> ^(WHILE exp exp)
	;

forExp
	: 'for' ID ':=' exp 'to' exp 'do' exp -> ^(FOR ID exp exp exp)
	;

letExp
	: 'let' dec+ 'in' (exp(';' exp)*)? 'end' -> ^(LET dec+ exp*)
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
	| '>'
	| '<'
	| '>='
	| '<='
	| '&'
	| '|'
	;

//definition des expressions regulieres reconnaissant les tokens

ID 	:	 ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | ('0'..'9') | '_')*
	;

INTLIT
	:	('0'..'9')+
	;

STRINGLIT
	:	'"' ('a'..'z' 
	| 'A'..'Z' 
	| '0'..'9' 
	|'!'
	|'#'..'@'
	|' '
	|'\u00C0'..'\u00D6' //caractères accentués
	|'\u00D8'..'\u00F6'
	|'\u00F8'..'\u02FF'
	|'\u0370'..'\u037D'
	|'\u037F'..'\u1FFF'
	|'\u200C'..'\u200D'
    |'\u2070'..'\u218F'
    |'\u2C00'..'\u2FEF'
    |'\u3001'..'\uD7FF'
    |'\uF900'..'\uFDCF'
    |'\uFDF0'..'\uFFFD')* '"'
	;


WS : (' ' | '\t' | '\n' | '\r' | '/*'.*'*/' | '//'.*('\r'|'\n'))+ {$channel = HIDDEN; }
   ;
