parser grammar GMiniBParser;

options {
    tokenVocab = GMiniBLexer;
    language = Java;
}

fichero: (declaracion | comentario | INTRO)* #Fich; 
bloque: (declaracion | INTRO)+ #Bloq;

// Declaraciones y asignaciones con etiquetas intermedias
declaracion: asignacion #DeclaracionAsignacion
           | bucleWhile #DeclaracionWhile
           | repetir #DeclaracionRepeat
           | funcion #DeclaracionFuncion
           | bucleFor #DeclaracionFor
           | sentIF #DeclaracionIf
           | controlFlujo #DeclaracionControlFlujo
           | func #DeclaracionFunc
           | array #DeclaracionArray
           | llamadaFuncCreada #DeclaracionLlamada;

comentario: token_comentario texto* (FINAL_COMENTARIO_NL | FINAL_COMENTARIO_EOF);

array: ARRAY ID #ArrayDeclaracion 
     | ID ICOR entero DCOR #ArrayAcceder
     | ID ADD IPAREN expr DPAREN #ArrayAgregar
     | ID ICOR entero DCOR OPASIG valorGenerico #ArrayAsignacion
     ;

asignacion: token_asignacion? var=identificador token_igual (valor=valorGenerico | valorInt=entero) #Asign;

// Estructuras de control
bucleWhile: token_while condicion=cond1 cuerpo=bloque token_end #While;

bucleFor: token_for var=identificador token_igual inicio=expr token_to limite=expr (token_step paso=expr)? cuerpo=bloque token_next #For;

sentIF: token_if condicion=cond1 token_then cuerpoVerdadero=bloque INTRO (token_else cuerpoFalso=bloque)? token_end #If;

repetir: (token_repeat cuerpo=bloque token_until condicion=cond1) #RepeatUntil
       | token_repeat condicion=cond1 #Repeat;

// Funciones
// Funciones
funcion: printStatement #FuncionPrint
       | inputStatement #FuncionInput;


printStatement: token_print 
                primerElemento=valorGenerico
                (op+=operador siguienteElemento+=valorGenerico)* #PrintFunc;

inputStatement: token_input mensaje=cadena variable=identificador #InputFunc;


// Expresiones con etiquetas intermedias
expr: valorBoolean = booleano #ExpresionBoolean
    |left=expr OPASIG right=expr #OperacionIgual 
    | referencia=identificador #ExpresionVariable
    | left=expr op=(OPMUL | OPDIV | OPMOD) right=expr #OperacionMultDivMod
    | left=expr op=(OPSUM | OPRES) right=expr #OperacionSumaResta
    | left=expr op=(OPBLT | OPBGT | OPBGE | OPBLE | OPEQ | OPNEQ) right=expr #OperacionComparacion
    | OPRES factor=entero # NumeroNeg
    | OPRES factorFlotante=flotante # FlotanteNeg
    | IPAREN inner=expr DPAREN #ExpresionParentesis
    | valor=entero #ExpresionEntero 
    | valorFloat = flotante #ExpresionFlotante
    
    ;

// Otros elementos
llamadasFuncion: nombreFuncion=token_funcion IPAREN argumento=valorGenerico DPAREN #LlamadaFuncion;


func: FUNC ID IPAREN parametros? DPAREN (bloque | bloque devolver INTRO?) END #DefFunc;

parametros: valorGenerico (',' valorGenerico)*;

devolver: RETURN valorRetorno=valorGenerico #Return;

llamadaFuncCreada: ID '(' parametros? ')' #LlamadaFunc;

valorGenerico: expr #ValorExpr
             | llamadasFuncion #ValorFuncion
             | cadena #ValorCadena
             | llamadaFuncCreada #ValorFuncionLlamada;

flotante: valorFlot=FLOAT #ValorFlotante;
cadena: valor=STRING #Str;
identificador: nombre=ID #Var;
entero: valor=ENTERO #Int;
texto: contenido=TEXTO_COMENTARIO+ #TextoComentario;
booleano: valor=BOOLEAN #ValorBool;

// Tokens etiquetados
controlFlujo: EXIT #Exit
            | CONTINUE #Continue;

cond1: left=cond1 op=(OPBLT | OPBLE | OPBGE | OPBGT | OPASIG | OPEQ | OPNEQ) right=cond1 #Condicion1
    | expresion = exprCond #ValorExprCond
    | llamadasFuncion #ValorFuncionCond;
exprCond: valorBooleano = booleano #ValorBooleanoCond
    |referencia=identificador #ExpresionVariableCond
    | OPRES factor=entero # NumeroNegCond
    | OPRES factorFlotante=flotante # FlotanteNegCond
    | IPAREN inner=expr DPAREN #ExpresionParentesisCond
    | valor=entero #ExpresionEnteroCond
    | valorFloat=FLOAT #ValorFloatCond
    
    ;

token_repeat: REPEAT;
token_for: FOR;
token_if: IF;
token_to: TO;
token_else: ELSE;
token_next: NEXT;
token_then: THEN;
token_until: UNTIL;
token_step: STEP;
token_comentario: REM;
token_asignacion: LET;
token_igual: OPASIG;
token_print: PRINT;
token_input: INPUT;
token_end: END;
token_while: WHILE;
token_funcion: VAL #FuncionVal | LEN #FuncionLen | ISNAN #FuncionIsNan;
operador: OPMUL | OPDIV | OPMOD | OPSUM | OPRES | OPBLT | OPBGT | OPBGE | OPBLE | OPEQ | OPNEQ;


