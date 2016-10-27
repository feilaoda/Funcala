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

expression: variableReference
    | expression OP expression
    | expression '.' functionName '(' argumentList ')'
    | functionName '(' argumentList ')'
    | newClassExpression
    | returnExpression;

newClassExpression: 'new' newClassName '(' argumentList ')';
returnExpression: 'return' expression;

argumentList : argument? (',' a=argument)*
             | namedArgument? (',' namedArgument)*  ;
argument : expression ;
namedArgument : argumentName '=' expression ;

argumentName: NAME;

newClassName: qualifiedName;

qualifiedName : NAME ('.' NAME)*;

functionName: NAME;

printStatement : PRINT '(' (STRING|NUMBER|NAME) ')' ;


OP : '+'
    | '-'
    | '*'
    | '/';

variableReference: NAME ;


type: 'Int'
    | 'String' ;

PRINT: 'print';
NAME : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER : [0-9]+ ;
WS: [ \t\n\r]+ -> skip ; //special TOKEN for skipping whitespaces
STRING : '"'.*?'"' ;

modifiers: ( 'private' | 'public' );