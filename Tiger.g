grammar Tiger;

options {
  backtrack=true;
}

program : exp ;
dec : tyDec
	| varDec
	| funDec
	;
tyDec : type tyId '=' ty ;

ty : tyId
	| arrTy
	| recTy;

arrTy : 'array of' tyId ;

recTy : '{' (fieldDec(,fieldDec)*)?'}';

fieldDec : id ':' tyId;

funDec : function id '('(fieldDec(,fieldDec)*)?')' '=' exp
	|	 function id '('(fieldDec(,fieldDec)*)?')' ':' tyId '=' exp
	;

varDec : var id ':=' exp
		|var id : tyId ':=' exp
		;

lValue : id
		|subscript
		|fieldExp
		;

subscript : lValue '[' exp ']';

fieldExp : lValue '.' id
		;

exp : lValue
	|nil
	|intLit
	|stringLit
	|seqExp
	|negation
	|callExp
	|infixExp
	|arrCreate
	|recCreate
	|assignment
	|ifThenElse
	|ifThen
	|whileExp
	|forExp
	|break
	|letExp
	;

seqExp : '(' (exp(;exp)*)? ')'

negation : '-' exp;

callExp : id '(' (exp(;exp)*)? ')';

infixExp : exp infixOp exp;

arrCreate : tyId '[' exp ']' 'of' exp;

recCreate : tyId '{' (fieldCreate(,fieldCreate)*)? '}';

fieldCreate : id '=' exp ;

assignment : lValue ':=' exp ;

ifThenElse : 'if' exp 'then' exp 'else' exp;

ifThen : 'if' exp 'then' exp;

whileExp : 'while' exp 'do' exp ;

forExp : 'for' id ':=' exp 'to' exp 'do' exp;

letExp : 'let' (dec)+ 'in' (exp(;exp)*)? 'end';