grammar Funcala;

funcalaBlock: packageBlock?
           importBlock*
           (classBlock | functionBlock)* EOF;

packageBlock: 'package' packageName ;

packageName:  NAME ('.' NAME)* ;

importBlock: 'import' importName ;
importName: NAME ('.' NAME)* ;

classBlock: modifiers? ('class' | 'interface' ) className  classBody  ;

className: NAME ;
classBody: '{' classMember*  '}' ;
//classMembers: memberDeclaration* ;

classMember: property
    | functionBlock ;


property: modifiers? ('var' | 'final') propertyDeclaration;

propertyDeclaration: type NAME
    | type? NAME '=' expression ;

functionBlock: modifiers? 'func' functionReturnType? functionName '(' parametersBlock? ')' functionBody;

functionReturnType: type;

functionBody: '=' expression
    | statementBlock;

parametersBlock: parameter (',' parameter)* ;

parameter: type NAME;

statementBlock : '{' statement* '}' ;
statement: statementBlock
    | expression
    | property
    | printStatement ;

expression: varReference #VarReferenceExpression
    | expression OP expression #OpExpression
    | caller=expression '.' functionName '(' argumentList ')' #FunctionCallExpression
    | functionName '(' argumentList ')' #FunctionCallExpression
    | 'new' newClassName '(' argumentList ')' #NewCallExpression
    | 'return' expression #ReturnExpression
    | value # ValueExpression
    ;

//newClassExpression: 'new' newClassName '(' argumentList ')';
//returnExpr: 'return' expression;

argumentList : argument? (',' a=argument)*
             | namedArgument? (',' namedArgument)*  ;
argument : expression ;
namedArgument : argumentName '=' expression ;

argumentName: NAME;

newClassName: qualifiedName;

qualifiedName : NAME ('.' NAME)*;

functionName: NAME;

printStatement : PRINT '(' expression ')' ;

callExpression: functionName '(' argumentList ')';

value : NUMBER
      | BOOL
      | STRING ;


OP : '+'
    | '-'
    | '*'
    | '/';

varReference: NAME ;


type: 'Int'
    | 'String' ;

PRINT: 'print';
NAME : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER : [0-9]+ ;
WS: [ \t\n\r]+ -> skip ; //special TOKEN for skipping whitespaces
STRING : '"'.*?'"' ;
BOOL : 'true' | 'false' ;

modifiers: ( 'private' | 'public' );