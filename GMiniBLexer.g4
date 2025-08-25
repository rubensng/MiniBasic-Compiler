lexer grammar GMiniBLexer;

LET             :'LET';
ARRAY           : 'ARRAY';
ADD             : '.ADD';   // Para los arrays dinámicos
ICOR            : '[';
DCOR            : ']';
OPSUM           : '+';
OPRES           : '-';
OPMUL           : '*';
OPDIV           : '/';
OPMOD           : 'MOD';
OPBLT           : '<';
OPBGT           : '>';
OPBLE           : '<='; // Mejora
OPBGE           : '>='; // Mejora
IPAREN          : '(';
DPAREN          : ')';
SSEPARADOR      : ',';
OPASIG          : '=';
OPEQ            : '=='; // Mejora
OPNEQ           : '!='; // Mejora
END             : 'END'|'end';
PRINT           : 'PRINT'|'print';
INPUT           : 'INPUT';
FOR             : 'FOR';
TO              : 'TO';
IF              : 'IF'|'if';
ELSE            : 'ELSE'|'else';
THEN            : 'THEN'|'then';
CONTINUE        : 'CONTINUE';
NEXT            : 'NEXT';
EXIT            : 'EXIT';
FUNC            : 'FUNC';
VAL             : 'VAL';
LEN             : 'LEN';
ISNAN           : 'ISNAN';
WHILE           : 'WHILE';
REPEAT          : 'REPEAT';
UNTIL           : 'UNTIL';
STEP            : 'STEP'; // Mejora
RETURN          : 'RETURN';
REM             : 'REM ' -> pushMode(COMENTARIO);
BOOLEAN         : 'TRUE'|'true'|'FALSE'|'false';
ID              : [a-zA-Z]+;
STRING          : '"' ( ~["\\] | '\\' . )* '"';
//~["\\]: Esto permite cualquier carácter excepto comillas dobles (") o barra invertida (\), que son los caracteres especiales en una cadena
//'\\' .: Esto permite caracteres escapadoss, como \" (comillas dobles dentro de la cadena) o \n
ENTERO          : ('0' | [1-9][0-9]*);

FLOAT           : ENTERO'.'[0-9]+;
INTRO           : [\r\n]+ ;
WS              : ' ' -> skip;

// mode CADENA_TEXTO;
// COMILLA_CIERRE: '"' -> popMode;
// TEXTO_CADENA: .+?;

mode COMENTARIO;
FINAL_COMENTARIO_NL: '\n' -> popMode;
FINAL_COMENTARIO_EOF: EOF -> popMode;
TEXTO_COMENTARIO: .+?;