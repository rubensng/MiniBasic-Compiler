import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;


class VarInfo {
    String type; // "INT" o "STRING"
    int index;
    String func = "";
    VarInfo(String type, int index) {
        this.type = type;
        this.index = index;
    }
    VarInfo(String type, int index, String func) {
        this.type = type;
        this.index = index;
        this.func = func;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "TYPE: " + type + ", INDEX:" + index + " FUNC: " + func;
    }
}

public class MyVisitor extends GMiniBParserBaseVisitor<String> {
    private int variableCounter = 0; 
    private int buclesCounter = 0; 
    private int condicionalCounter = 0;
    private Map<String, VarInfo> symbolTable = new HashMap<>();
    private Stack<Integer> pilaBucles = new Stack<>();
    private StringBuilder functionDeclarations = new StringBuilder(); // Almacenar funciones globales
    private Map<String, StringBuilder> pendingFunctions = new HashMap<>();
    private Map<String, Map<String, VarInfo>> functionSymbolTables = new HashMap<>();
    private Map<String, GMiniBParser.DefFuncContext> functionContexts = new HashMap<>();


    @Override 
    public String visitFich(GMiniBParser.FichContext ctx) { 
        StringBuilder builder = new StringBuilder();
        for (ParseTree child : ctx.children) {
            String result = visit(child);
            if (result != null && !result.isEmpty()) {
                builder.append(result).append("\n");
            }
        }
        builder.append("\n"
        + "fin:\n"
        + "   return\n"
        + "\n"
        + ".end method\n");

        builder.append(functionDeclarations.toString());
        for (StringBuilder functionCode : pendingFunctions.values()) {
            builder.append(functionCode).append("\n");
        }
        return builder.toString().trim(); 
    }

    @Override 
    public String visitBloq(GMiniBParser.BloqContext ctx) { 
        StringBuilder builder = new StringBuilder();
        for (ParseTree child : ctx.children) {
            String result = visit(child);
            if (result != null && !result.isEmpty()) {
                builder.append(result).append("\n");
            }
        }
        return builder.toString().trim(); 
    }

    @Override
    public String visitDeclaracionAsignacion(GMiniBParser.DeclaracionAsignacionContext ctx) {
        return visitChildren(ctx);
    }

    @Override 
    public String visitAsign(GMiniBParser.AsignContext ctx) { 
        String variableName = ctx.var.getText();
        String operationCode = "";
        String assignedType = "INT"; // Por defecto INT, pero deduciremos.

        if (ctx.valor != null) {
            // valorGenerico puede ser expr, funcion o cadena
            assignedType = deduceExprType(ctx.valor);
            operationCode = visit(ctx.valor);
        } else if (ctx.valorInt != null) {
            // Es un entero literal
            assignedType = "INT";
            operationCode = "ldc " + ctx.valorInt.getText();
        }

        if (!symbolTable.containsKey(variableName)) {
            // Variable nueva
            symbolTable.put(variableName, new VarInfo(assignedType, variableCounter++));
        } else {
            // Variable existente: check tipo
            VarInfo info = symbolTable.get(variableName);
            if (!info.type.equals(assignedType)) {
                // Decidir si permitir cambio de tipo o lanzar error
                // Aquí lanzamos error
                throw new RuntimeException("Tipo incompatible. La variable " 
                                           + variableName + " es " + info.type 
                                           + " y se intenta asignar " + assignedType);
            }
        }
        int variableIndex = symbolTable.get(variableName).index;
            String storeInstruction;
            switch (assignedType) {
                case "STRING":
                    storeInstruction = "astore";
                    break;
                case "FLOAT":
                    storeInstruction = "fstore";
                    break;
                default:
                    // Por defecto int
                    storeInstruction = "istore";
                    break;
            }

            return operationCode + "\n" + storeInstruction + " " + variableIndex + "\n";
    }

    @Override
    public String visitInputFunc(GMiniBParser.InputFuncContext ctx) {
        StringBuilder jasminCode = new StringBuilder();

        // Carga `System.out` para imprimir el mensaje
        jasminCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");

        // Genera el código para cargar el mensaje
        String mensajeCode = visit(ctx.mensaje);
        if (mensajeCode != null) {
            jasminCode.append(mensajeCode).append("\n");
        } else {
            throw new IllegalArgumentException("El mensaje de INPUT no es válido.");
        }

        // Imprime el mensaje al usuario
        jasminCode.append("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n");

        // Leer entrada del usuario usando `System.in`
        jasminCode.append("new java/util/Scanner\n");
        jasminCode.append("dup\n");
        jasminCode.append("getstatic java/lang/System/in Ljava/io/InputStream;\n");
        jasminCode.append("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V\n");

        // Llamar a `nextLine` para leer una cadena
        jasminCode.append("invokevirtual java/util/Scanner/nextLine()Ljava/lang/String;\n");

        // Almacenar la entrada en una variable
        String variableName = ctx.variable.getText();
        if (!symbolTable.containsKey(variableName)) {
            VarInfo info = new VarInfo("STRING", variableCounter++);
            symbolTable.put(variableName, info);
        }
        int variableIndex = symbolTable.get(variableName).index; // Asignar un índice a la variable
        jasminCode.append("astore_").append(variableIndex).append("\n");

        return jasminCode.toString();
    }

    @Override
    public String visitDeclaracionFuncion(GMiniBParser.DeclaracionFuncionContext ctx) {
        return visitChildren(ctx);
    }


    @Override 
    public String visitStr(GMiniBParser.StrContext ctx) { 
        return "ldc " + ctx.valor.getText();
    }

    @Override
    public String visitDeclaracionWhile(GMiniBParser.DeclaracionWhileContext ctx) {
        return visitChildren(ctx);
    }

    
    @Override
    public String visitWhile(GMiniBParser.WhileContext ctx) {
        StringBuilder jasminCode = new StringBuilder();
        int indiceBucle = buclesCounter++;
        pilaBucles.push(indiceBucle);

        // Etiqueta de inicio del bucle
        jasminCode.append("inicio_").append(indiceBucle).append(":\n");
        
        // Generar código de la condición
        String expressionCode = visit(ctx.condicion);
        if (expressionCode.endsWith("\n")) {
            expressionCode = expressionCode.substring(0, expressionCode.length() - 1);
        }
        // Salto a la etiqueta 'fin' si la condición no se cumple
        jasminCode.append(expressionCode).append(" fin_").append(indiceBucle).append("\n");
        
        // Generar el cuerpo del bucle
        String bloque = visit(ctx.cuerpo);
        jasminCode.append(bloque).append("\n");
        
        // Regreso al inicio del bucle
        jasminCode.append("iteracion_").append(indiceBucle).append(":\n");
        jasminCode.append("goto inicio_").append(indiceBucle).append("\n");
        
        // Etiqueta de fin del bucle
        jasminCode.append("fin_").append(indiceBucle).append(":\n");

        pilaBucles.pop();
        return jasminCode.toString();
    }
    @Override
    public String visitFor(GMiniBParser.ForContext ctx) {
        StringBuilder jasminCode = new StringBuilder();
        int loopIndex = buclesCounter++;
        String variableName = ctx.var.getText(); // Acceso correcto
        String initValue = visit(ctx.inicio);  // Obtiene el código para el valor inicial
        pilaBucles.push(loopIndex);
        if(ctx.paso == null ){  
            codigoPasoPositivo(variableName, initValue, loopIndex, jasminCode, ctx);
        }else{
            if(Integer.parseInt(ctx.paso.getText()) > 0 ){
                codigoPasoPositivo(variableName, initValue, loopIndex, jasminCode, ctx);
            }else{
                codigoPasoNegativo(variableName, initValue, loopIndex, jasminCode, ctx);

            }
        }
        pilaBucles.pop();
        return jasminCode.toString();
    }
    @Override public String visitExit(GMiniBParser.ExitContext ctx) { 
        if (pilaBucles.isEmpty()) {
            throw new RuntimeException("EXIT no esta dentro de un bucle");
        }
        return "goto fin_" + pilaBucles.peek() + "\n";
     }

     @Override 
     public String visitContinue(GMiniBParser.ContinueContext ctx) { 
        if (pilaBucles.isEmpty()) {
            throw new RuntimeException("CONTINUE no esta dentro de un bucle");
        }
        return "goto iteracion_" + pilaBucles.peek() + "\n";
    }
    public void codigoPasoPositivo(String variableName, String initValue, int loopIndex, StringBuilder jasminCode, GMiniBParser.ForContext ctx){
        if (!symbolTable.containsKey(variableName)) {
            // Si no está, se agrega a la tabla de símbolos
            VarInfo info = new VarInfo("INT", variableCounter++);  // asumimos que los bucles for trabajan con enteros
            symbolTable.put(variableName, info);
            jasminCode.append(initValue).append("\n");  // Carga el valor inicial
            jasminCode.append("istore ").append(info.index).append("\n");  // Almacena el valor en su índice
        } else {
            // Si ya está definida, se tiene que mostrar un error ya que esto cambiaria el valor de la variable en el bucle
            throw new RuntimeException("Variable del bucle for ya inicializada");
        }

        // Etiqueta de inicio del bucle
        jasminCode.append("inicio_").append(loopIndex).append(":\n");

        VarInfo varInfo = symbolTable.get(variableName);
        jasminCode.append("iload ").append(varInfo.index).append("\n");
        jasminCode.append(visit(ctx.limite)).append("\n");
        jasminCode.append("if_icmpgt fin_").append(loopIndex).append("\n");  // Solo para depuración
        
        
        jasminCode.append(visit(ctx.cuerpo)).append("\n");
        jasminCode.append("iteracion_" + loopIndex + ":\n");
        // Incremento
        if (ctx.paso != null) {
            jasminCode.append("iinc ").append(varInfo.index).append(" ").append(ctx.paso.getText()).append("\n");
        } else {
            jasminCode.append("iinc ").append(varInfo.index).append(" 1\n");
        }

        // Salto al inicio
        jasminCode.append("goto inicio_").append(loopIndex).append("\n");

        // Etiqueta de fin
        jasminCode.append("fin_").append(loopIndex).append(":\n");
    }
    public void codigoPasoNegativo(String variableName, String initValue, int loopIndex, StringBuilder jasminCode, GMiniBParser.ForContext ctx){
        if (!symbolTable.containsKey(variableName)) {
            // Si no está, se agrega a la tabla de símbolos
            VarInfo info = new VarInfo("INT", variableCounter++);  // asumimos que los bucles for trabajan con enteros
            symbolTable.put(variableName, info);
            jasminCode.append(initValue).append("\n");  // Carga el valor inicial
            jasminCode.append("istore ").append(info.index).append("\n");  // Almacena el valor en su índice
        } else {
            // Si ya está definida, se tiene que mostrar un error ya que esto cambiaria el valor de la variable en el bucle
            throw new RuntimeException("Variable del bucle for ya inicializada");
        }

        // Etiqueta de inicio del bucle
        jasminCode.append("inicio_").append(loopIndex).append(":\n");

        VarInfo varInfo = symbolTable.get(variableName);
        jasminCode.append("iload ").append(varInfo.index).append("\n");
        jasminCode.append(visit(ctx.limite)).append("\n");

        jasminCode.append("if_icmplt fin_").append(loopIndex).append("\n");  

        jasminCode.append(visit(ctx.cuerpo)).append("\n");
        jasminCode.append("iteracion_" + loopIndex + ":\n");
        if (ctx.paso != null) {
            
            jasminCode.append("iinc ").append(varInfo.index).append(" ").append(ctx.paso.getText()).append("\n");
        } else {
            jasminCode.append("iinc ").append(varInfo.index).append(" 1\n");
        }

        // Salto al inicio
        jasminCode.append("goto inicio_").append(loopIndex).append("\n");

        // Etiqueta de fin
        jasminCode.append("fin_").append(loopIndex).append(":\n");
    }

    @Override
    public String visitIf(GMiniBParser.IfContext ctx) {
        StringBuilder jasminCode = new StringBuilder();
        int indiceCondicional = condicionalCounter++;

        // Etiquetas 
        String etiquetaElse = "else_" + indiceCondicional;
        String etiquetaFin = "finIF_" + indiceCondicional;

        // Condicion
        String condicionCode = visit(ctx.condicion);
        if (condicionCode.endsWith("\n")) {
            condicionCode = condicionCode.substring(0, condicionCode.length() - 1);
        }

        if (esValorNumerico(ctx.condicion)) {
            // Comparar si condicion es 0(fasle) o 1(true)
            if(!condicionCode.equals("ldc 1")){
                jasminCode.append(condicionCode).append("\n");
                jasminCode.append("ldc 0\n"); 
                jasminCode.append("if_icmpeq ").append(etiquetaElse).append("\n"); // Si es 0, salta al bloque else
                jasminCode.append("new java/lang/RuntimeException\n");
                jasminCode.append("dup\n");
                jasminCode.append("ldc \"Error: condición no válida (se esperaba 0 o 1)\"\n");
                jasminCode.append("invokespecial java/lang/RuntimeException/<init>(Ljava/lang/String;)V\n");
                jasminCode.append("athrow\n");
            }
            
        } else {
            // Una comparacion habitual
            jasminCode.append(condicionCode).append(" ").append(etiquetaElse).append("\n");
        }
        // Bloque if
        String bloqueIfCode = visit(ctx.cuerpoVerdadero);
        jasminCode.append(bloqueIfCode).append("\n");

        // Salto al final
        jasminCode.append("goto ").append(etiquetaFin).append("\n");

        jasminCode.append(etiquetaElse).append(":\n");

        // Bloque else
        if (ctx.cuerpoFalso != null) {
            String bloqueElseCode = visit(ctx.cuerpoFalso);
            jasminCode.append(bloqueElseCode).append("\n");
        }
        jasminCode.append(etiquetaFin).append(":\n");

        return jasminCode.toString();
    }

    private boolean esValorNumerico(ParseTree condicion) {
        return condicion instanceof GMiniBParser.ExpresionEnteroCondContext ||
               condicion instanceof GMiniBParser.ValorExprCondContext;
    }

    @Override
    public String visitDefFunc(GMiniBParser.DefFuncContext ctx) {
        String nombre = ctx.ID().getText();
        StringBuilder functionCode = new StringBuilder();

        // Guardar el contexto de la función
        functionContexts.put(nombre, ctx);

        // Generar la firma de la función
        functionCode.append(".method public static ").append(nombre).append("(");

        // Índice inicial para los parámetros
        int paramIndex = 0;

        // Registrar parámetros con índices únicos en symbolTable
        if (ctx.parametros() != null) {
            for (ParseTree parametro : ctx.parametros().valorGenerico()) {
                String paramName = parametro.getText();
                symbolTable.put(paramName, new VarInfo("GENERIC", paramIndex, nombre));
                functionCode.append("Ljava/lang/Object;"); // Tipo genérico inicial
                paramIndex++;
            }
        }

        functionCode.append(")\n");



        
        // El índice inicial para variables locales será el siguiente al último parámetro
        variableCounter = paramIndex;
        
        functionCode.append(".limit stack 100\n");
        functionCode.append(".limit locals ").append(variableCounter + 100).append("\n");
        
        // Insertar un marcador para el cuerpo
        functionCode.append("<<BODY>>\n");

        // Verificar si existe un nodo devolver
        if (ctx.devolver() != null) {
            functionCode.append(visit(ctx.devolver())); // Procesar el nodo devolver
        } else {
            functionCode.append("return\n");
        }
        functionCode.append(".end method\n");

        // Guardar en `pendingFunctions` para regeneración posterior
        pendingFunctions.put(nombre, functionCode);

        return "";
    }




    @Override
    public String visitLlamadaFunc(GMiniBParser.LlamadaFuncContext ctx) {
        String functionName = ctx.ID().getText();
        StringBuilder functionCallCode = new StringBuilder();
        StringBuilder signatureBuilder = new StringBuilder();

        // Recuperar los parámetros de la función y sus índices
        List<String> parametros = new ArrayList<>();
        for (Map.Entry<String, VarInfo> entry : symbolTable.entrySet()) {
            if (entry.getValue().getFunc().equals(functionName)) {
                parametros.add(entry.getKey());
            }
        }

        // Ordenar los parámetros por índice
        parametros.sort(Comparator.comparingInt(p -> symbolTable.get(p).index));

        // Procesar los argumentos
        int argIndex = 0;
        if (ctx.parametros() != null) {
            for (ParseTree argumento : ctx.parametros().valorGenerico()) {
                String argumentoTexto = argumento.getText();
                String tipo;

                if (symbolTable.containsKey(argumentoTexto)) {
                    // El argumento es una variable definida
                    VarInfo varInfo = symbolTable.get(argumentoTexto);
                    tipo = varInfo.type;

                    String loadInstruction;
                    switch (tipo) {
                        case "STRING":
                            loadInstruction = "aload";
                            break;
                        case "FLOAT":
                            loadInstruction = "fload";
                            break;
                        default:
                            // Por defecto int
                            loadInstruction = "iload";
                            break;
                    }
                    // Cargar la variable en la pila
                    
                    functionCallCode.append(loadInstruction).append(" ").append(varInfo.index).append("\n");
                } else {
                    // El argumento es un literal
                    tipo = deduceExprType(argumento);
                    if (tipo.equals("INT") || tipo.equals("FLOAT") || tipo.equals("STRING")) {
                        functionCallCode.append("ldc ").append(argumentoTexto).append("\n");
                    } else {
                        throw new RuntimeException("Tipo de argumento no soportado: " + tipo);
                    }
                }

                // Actualizar el tipo del parámetro correspondiente
                if (argIndex < parametros.size()) {
                    String paramName = parametros.get(argIndex);
                    VarInfo paramInfo = symbolTable.get(paramName);

                    if (paramInfo != null) {
                        paramInfo.type = tipo;
                        symbolTable.put(paramName, paramInfo); // Actualizar en symbolTable
                    }
                }

                // Añadir el tipo a la firma de la función
                if (tipo.equals("INT")) {
                    signatureBuilder.append("I");
                } else if (tipo.equals("STRING")) {
                    signatureBuilder.append("Ljava/lang/String;");
                }else if (tipo.equals("FLOAT")) {
                    signatureBuilder.append("F");
                }

                argIndex++;
            }
        }

        // Generar la llamada a la función
        String signature = signatureBuilder.toString();
        functionCallCode.append("invokestatic Programa/")
                .append(functionName)
                .append("(").append(signature).append(")");


        // Determinar el tipo de retorno
        String returnType = "V"; // Por defecto, `void`
        GMiniBParser.DefFuncContext defFuncCtx = functionContexts.get(functionName);
        if (defFuncCtx != null && defFuncCtx.devolver() != null) {
            GMiniBParser.ReturnContext returnCtx = (GMiniBParser.ReturnContext) defFuncCtx.devolver();
            String returnExprType = deduceExprType(returnCtx.valorRetorno);
            if (returnExprType.equals("INT")) {
                returnType = "I";
            } else if (returnExprType.equals("STRING")) {
                returnType = "Ljava/lang/String;";
            }else if (returnExprType.equals("FLOAT")) {
                returnType = "F";
            }
        }

        functionCallCode.append(returnType.equals("V") ? "V\n" : returnType).append("\n");

        // Actualizar la firma y el cuerpo de la función
        if (pendingFunctions.containsKey(functionName)) {
            StringBuilder functionCode = pendingFunctions.get(functionName);

            // Recuperar el contexto de definición
            if (defFuncCtx == null) {
                throw new RuntimeException("No se encontró el contexto para la función: " + functionName);
            }

            // Determinar el tipo de retorno
            if (defFuncCtx.devolver() != null) {
                GMiniBParser.ReturnContext returnCtx = (GMiniBParser.ReturnContext) defFuncCtx.devolver();
                String returnExprType = deduceExprType(returnCtx.valorRetorno);
                if (returnExprType.equals("INT")) {
                    returnType = "I";
                } else if (returnExprType.equals("STRING")) {
                    returnType = "Ljava/lang/String;";
                }else if (returnExprType.equals("FLOAT")) {
                    returnType = "F";
                }
            }

            // Actualizar la firma con parámetros y tipo de retorno
            String updatedMethodHeader = functionCode.toString()
                    .replaceFirst("\\.method public static " + functionName + "\\(.*?\\).*",
                            ".method public static " + functionName + "(" + signature + ")" + returnType);

            // Regenerar el cuerpo de la función
            String updatedBody = regenerateFunctionBody(defFuncCtx);
            updatedMethodHeader = updatedMethodHeader.replace("<<BODY>>", updatedBody);

            // Actualizar en `pendingFunctions`
            pendingFunctions.put(functionName, new StringBuilder(updatedMethodHeader));
        }

        return functionCallCode.toString();
    }



    private String regenerateFunctionBody(GMiniBParser.DefFuncContext ctx) {
        // Revisitar el bloque de la función para regenerar el código con los tipos actualizados
        return visit(ctx.bloque());
    }


    @Override
    public String visitReturn(GMiniBParser.ReturnContext ctx) {
        String returnExprCode = visit(ctx.valorRetorno);
        String returnType = deduceExprType(ctx.valorRetorno);

        StringBuilder jasminCode = new StringBuilder();

        // Generar el código para devolver el valor
        jasminCode.append(returnExprCode).append("\n");
        if (returnType.equals("INT")) {
            jasminCode.append("ireturn\n");
        } else if (returnType.equals("STRING")) {
            jasminCode.append("areturn\n");
        }else if (returnType.equals("FLOAT")) {
            jasminCode.append("freturn\n");
        } else {
            throw new RuntimeException("Tipo de retorno no soportado: " + returnType);
        }

        return jasminCode.toString();
    }
    @Override
    public String visitRepeatUntil(GMiniBParser.RepeatUntilContext ctx) {
        StringBuilder jasminCode = new StringBuilder();
        int indiceBucle = buclesCounter++;
        pilaBucles.push(indiceBucle);
        
        // Etiqueta de inicio del bucle
        jasminCode.append("inicio_").append(indiceBucle).append(":\n");
        String bloque = visit(ctx.cuerpo);
        jasminCode.append(bloque + "\n");

        String expressionCode = visit(ctx.condicion);
        if (expressionCode.endsWith("\n")) {
            expressionCode = expressionCode.substring(0, expressionCode.length() - 1);
        }
        
        expressionCode ="\n" +  expressionCode + " inicio_" + indiceBucle + "\n" + "\n";
        jasminCode.append(expressionCode);

        pilaBucles.pop();
        return jasminCode.toString();
    }
    @Override
    public String visitCondicion1(GMiniBParser.Condicion1Context ctx) {
        String leftCode = visit(ctx.left); 
        String rightCode = visit(ctx.right);
        
        String leftType = deduceExprType(ctx.left);
        String rightType = deduceExprType(ctx.right);
    
        if (leftType.equals("STRING") || rightType.equals("STRING")) {
            throw new RuntimeException("Comparación de strings no implementada");
        }
        // Determinar si necesitamos float
        boolean isFloat = leftType.equals("FLOAT") || rightType.equals("FLOAT");
    
        // Convertir a float si es necesario
        if (isFloat) {
            if (leftType.equals("INT")) {
                leftCode += "\ni2f";
            }
            if (rightType.equals("INT")) {
                rightCode += "\ni2f";
            }
        }
    
        // Determinar la operación
        int opType = ctx.op.getType();
        // En la lógica original, por ejemplo:
        // OPBLT => "if_icmpge" (el opuesto de < es >=)
        // Aquí haremos lo mismo, pero si es float, usamos fcmpl y luego ifge, ifle, etc.
    
        StringBuilder code = new StringBuilder();
        code.append(leftCode).append("\n").append(rightCode).append("\n");
    
        if (!isFloat) {
            // Comparaciones con int utilizando if_icmpXX
            String operation;
            switch (opType) {
                case GMiniBLexer.OPBLT:
                    operation = "if_icmpge"; // x < y => salta si x >= y
                    break;
                case GMiniBLexer.OPBGT:
                    operation = "if_icmple"; // x > y => salta si x <= y
                    break;
                case GMiniBLexer.OPBLE:
                    operation = "if_icmpgt"; // x <= y => salta si x > y
                    break;
                case GMiniBLexer.OPBGE:
                    operation = "if_icmplt"; // x >= y => salta si x < y
                    break;
                case GMiniBLexer.OPEQ:
                    operation = "if_icmpne"; // x == y => salta si x != y
                    break;
                case GMiniBLexer.OPNEQ:
                    operation = "if_icmpeq"; // x != y => salta si x == y
                    break;
                default:
                    throw new UnsupportedOperationException("Operación desconocida: " + ctx.op.getText());
            }
            code.append(operation).append("\n");
        } else {
            // Comparaciones con float
            // Usamos fcmpl: resultado en la pila: -1 si x<y, 0 si x==y, 1 si x>y
            // Luego usamos ifeq, ifne, iflt, ifle, ifgt, ifge
            code.append("fcmpl\n");
            String operation;
            switch (opType) {
                case GMiniBLexer.OPBLT:
                    // x < y => negación: x >= y => resultado >=0 => ifge
                    operation = "ifge";
                    break;
                case GMiniBLexer.OPBGT:
                    // x > y => negación: x <= y => resultado <=0 => ifle
                    operation = "ifle";
                    break;
                case GMiniBLexer.OPBLE:
                    // x <= y => negación: x > y => resultado >0 => ifgt
                    operation = "ifgt";
                    break;
                case GMiniBLexer.OPBGE:
                    // x >= y => negación: x < y => resultado <0 => iflt
                    operation = "iflt";
                    break;
                case GMiniBLexer.OPEQ:
                    // x == y => negación: x != y => resultado !=0 => ifne
                    operation = "ifne";
                    break;
                case GMiniBLexer.OPNEQ:
                    // x != y => negación: x == y => resultado ==0 => ifeq
                    operation = "ifeq";
                    break;
                default:
                    throw new UnsupportedOperationException("Operación desconocida: " + ctx.op.getText());
            }
            code.append(operation).append("\n");
        }
    
        return code.toString();
    }
    @Override 
    public String visitValorFloatCond(GMiniBParser.ValorFloatCondContext ctx) { 
        return "ldc " + ctx.valorFloat.getText();
    }

    @Override
    public String visitFuncionPrint(GMiniBParser.FuncionPrintContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitPrintFunc(GMiniBParser.PrintFuncContext ctx) {
        StringBuilder jasminCode = new StringBuilder();

        // Obtenemos el tipo del primer elemento
        String tipoPrimer = deduceExprType(ctx.primerElemento);

        // Iniciamos con System.out
        jasminCode.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
        
        // Creamos un nuevo StringBuilder
        jasminCode.append("new java/lang/StringBuilder\n");
        jasminCode.append("dup\n");
        jasminCode.append("invokespecial java/lang/StringBuilder/<init>()V\n");

        // Append del primer elemento
        jasminCode.append(convertToString(visit(ctx.primerElemento), tipoPrimer));

        // Ahora procesamos las operaciones y los siguientes elementos
        for (int i = 0; i < ctx.op.size(); i++) {
            String operador = ctx.op.get(i).getText();
            ParseTree siguienteElem = ctx.siguienteElemento.get(i);
            String tipoSig = deduceExprType(siguienteElem);

            if (operador.equals("+")) {
                // Concatenación de cadenas
                jasminCode.append(convertToString(visit(siguienteElem), tipoSig));
            } else {
                // Si quisieras soportar otras operaciones, aquí las manejarías.
                throw new RuntimeException("Operación no soportada en PRINT: " + operador);
            }
        }

        // Convertimos a string
        jasminCode.append("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n");
        // Llamamos a println(String)
        jasminCode.append("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");

        return jasminCode.toString();
    }


    @Override
    public String visitValorExpr(GMiniBParser.ValorExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitValorExprCond(GMiniBParser.ValorExprCondContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitNumeroNeg(GMiniBParser.NumeroNegContext ctx) {
        String valueCode = visit(ctx.factor);
        return valueCode + "\nineg\n"; 
    }


    @Override
    public String visitOperacionSumaResta(GMiniBParser.OperacionSumaRestaContext ctx) {
        // Deducción de tipos
        String leftType = deduceExprType(ctx.left);
        String rightType = deduceExprType(ctx.right);

        String leftCode = visit(ctx.left);
        String rightCode = visit(ctx.right);

        // Caso STRING: concatenación
        if (leftType.equals("STRING") || rightType.equals("STRING")) {
            // Sólo soportamos '+' para concatenar
            if (ctx.op.getType() == GMiniBLexer.OPSUM) {
                StringBuilder code = new StringBuilder();
                code.append("new java/lang/StringBuilder\n")
                    .append("dup\n")
                    .append("invokespecial java/lang/StringBuilder/<init>()V\n");

                // Append left
                code.append(convertToString(leftCode, leftType));
                // Append right
                code.append(convertToString(rightCode, rightType));

                code.append("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n");
                return code.toString();
            } else {
                throw new RuntimeException("Operación no definida entre STRING y '-'");
            }
        }

        // Caso numérico (INT o FLOAT)
        boolean isFloat = leftType.equals("FLOAT") || rightType.equals("FLOAT");

        // Convertimos int a float si es necesario
        if (isFloat) {
            // Si left es int y isFloat es true, convertir a float
            if (leftType.equals("INT")) {
                leftCode = leftCode + "\ni2f";
            }

            // Si right es int y isFloat es true, convertir a float
            if (rightType.equals("INT")) {
                rightCode = rightCode + "\ni2f";
            }
        }

        // Determinamos la instrucción a usar
        String operation;
        if (ctx.op.getType() == GMiniBLexer.OPSUM) {
            operation = isFloat ? "fadd" : "iadd";
        } else {
            operation = isFloat ? "fsub" : "isub";
        }

        return leftCode + "\n" + rightCode + "\n" + operation + "\n";
    }
    @Override
    public String visitOperacionMultDivMod(GMiniBParser.OperacionMultDivModContext ctx) {
        String leftCode = visit(ctx.left);
        String rightCode = visit(ctx.right);
    
        String leftType = deduceExprType(ctx.left);
        String rightType = deduceExprType(ctx.right);
    
        if (leftType.equals("STRING") || rightType.equals("STRING")) {
            throw new RuntimeException("No se puede multiplicar/dividir/mod con STRING");
        }
    
        // Unificamos el tipo: si alguno es FLOAT => FLOAT, sino INT
        boolean isFloat = leftType.equals("FLOAT") || rightType.equals("FLOAT");
    
        // Convertir si es necesario
        if (isFloat) {
            if (leftType.equals("INT")) {
                leftCode = leftCode + "\ni2f";
            }
            if (rightType.equals("INT")) {
                rightCode = rightCode + "\ni2f";
            }
        }
    
        String operation;
        switch (ctx.op.getType()) {
            case GMiniBLexer.OPMUL:
                operation = isFloat ? "fmul" : "imul";
                break;
            case GMiniBLexer.OPDIV:
                operation = isFloat ? "fdiv" : "idiv";
                break;
            case GMiniBLexer.OPMOD:
                operation = isFloat ? "frem" : "irem";
                break;
            default:
                throw new UnsupportedOperationException("Operación desconocida: " + ctx.op.getText());
        }
    
        return leftCode + "\n" + rightCode + "\n" + operation + "\n";
    }
    

    
    

    @Override
    public String visitOperacionComparacion(GMiniBParser.OperacionComparacionContext ctx) {
        String leftCode = visit(ctx.left); 
        String rightCode = visit(ctx.right);

        String leftType = deduceExprType(ctx.left);
        String rightType = deduceExprType(ctx.right);

 

        if (leftType.equals("STRING") || rightType.equals("STRING")) {
            throw new RuntimeException("Comparación de strings no implementada");
        }

        // Determinar si usamos float o int
        boolean isFloat = leftType.equals("FLOAT") || rightType.equals("FLOAT");

        // Convertir a float si alguno es float
        if (isFloat) {
            if (leftType.equals("INT")) {
                leftCode += "\ni2f";
            }
            if (rightType.equals("INT")) {
                rightCode += "\ni2f";
            }
        }

        // Determinar operación
        int opType = ctx.op.getType();
        // Para float:
        // fcmpl deja en la pila un int: -1 si left<right, 0 si ==, 1 si left>right
        // Luego comparamos con ifeq, ifne, iflt, ifle, ifgt, ifge
        // Para int:
        // if_icmpeq, if_icmpne, if_icmplt, if_icmple, if_icmpgt, if_icmpge

        if (!isFloat) {
            // Comparación entera
            String operation;
            switch (opType) {
                case GMiniBLexer.OPBLT:
                    operation = "if_icmplt";
                    break;
                case GMiniBLexer.OPBGT:
                    operation = "if_icmpgt";
                    break;
                case GMiniBLexer.OPBLE:
                    operation = "if_icmple";
                    break;
                case GMiniBLexer.OPBGE:
                    operation = "if_icmpge";
                    break;
                case GMiniBLexer.OPEQ:
                    operation = "if_icmpeq";
                    break;
                case GMiniBLexer.OPNEQ:
                    operation = "if_icmpne";
                    break;
                default:
                    throw new UnsupportedOperationException("Operación desconocida: " + ctx.op.getText());
            }
            return leftCode + "\n" + rightCode + "\n" + operation + "\n";
        } else {
            // Comparación de floats
            // Primero cargamos left y right, luego fcmpl
            // Luego usamos ifeq, ifne, iflt, ifle, ifgt, ifge según la operación
            StringBuilder code = new StringBuilder();
            code.append(leftCode).append("\n").append(rightCode).append("\n");
            code.append("fcmpl\n");

            // Ahora según la operación
            String operation;
            switch (opType) {
                case GMiniBLexer.OPBLT:
                    // left < right => fcmpl = -1 si left<right, 0 si ==, 1 si left>right
                    // Para true en left<right, necesitamos iflt (salta si valor<0)
                    operation = "iflt";
                    break;
                case GMiniBLexer.OPBGT:
                    // left > right => salta si valor>0 => ifgt
                    operation = "ifgt";
                    break;
                case GMiniBLexer.OPBLE:
                    // left <= right => fcmpl: saltar si valor <=0 => ifle
                    operation = "ifle";
                    break;
                case GMiniBLexer.OPBGE:
                    // left >= right => fcmpl: saltar si valor >=0 => ifge
                    operation = "ifge";
                    break;
                case GMiniBLexer.OPEQ:
                    // left == right => fcmpl: valor=0 => ifeq
                    operation = "ifeq";
                    break;
                case GMiniBLexer.OPNEQ:
                    // left != right => fcmpl: valor!=0 => ifne
                    operation = "ifne";
                    break;
                default:
                    throw new UnsupportedOperationException("Operación desconocida: " + ctx.op.getText());
            }

            code.append(operation).append("\n");
            return code.toString();
        }
    }

    @Override
    public String visitExpresionParentesis(GMiniBParser.ExpresionParentesisContext ctx) {
        return visit(ctx.inner);
    }

    @Override
    public String visitExpresionEntero(GMiniBParser.ExpresionEnteroContext ctx) {
        return "ldc " + ctx.valor.getText();
    }

    @Override
    public String visitExpresionVariable(GMiniBParser.ExpresionVariableContext ctx) {
        String variableName = ctx.referencia.getText();
        if (!symbolTable.containsKey(variableName)) {
            throw new IllegalArgumentException("Variable no definida: " + variableName);
        }
        VarInfo info = symbolTable.get(variableName);
        String loadInstruction;
        switch (info.type) {
            case "STRING":
                loadInstruction = "aload";
                break;
            case "FLOAT":
                loadInstruction = "fload";
                break;
            default: // INT
                loadInstruction = "iload";
        }
        return loadInstruction + " " + info.index;
    }


    @Override
    public String visitExpresionVariableCond(GMiniBParser.ExpresionVariableCondContext ctx) {
        String variableName = ctx.referencia.getText();
        if (!symbolTable.containsKey(variableName)) {
            throw new IllegalArgumentException("Variable no definida: " + variableName);
        }
        VarInfo info = symbolTable.get(variableName);
        String loadInstruction;
        switch (info.type) {
            case "STRING":
                loadInstruction = "aload";
                break;
            case "FLOAT":
                loadInstruction = "fload";
                break;
            default: // INT
                loadInstruction = "iload";
        }
        return loadInstruction + " " + info.index;
    }

    @Override
    public String visitInt(GMiniBParser.IntContext ctx) {
        return "ldc " + ctx.valor.getText();
    }
        @Override 
    public String visitValorFlotante(GMiniBParser.ValorFlotanteContext ctx) { 
        return "ldc " + ctx.valorFlot.getText(); 
    }
    @Override
    public String visitFlotanteNeg(GMiniBParser.FlotanteNegContext ctx) {
        String valueCode = visit(ctx.factorFlotante);
        return valueCode + "\nfneg\n"; 
    }

    @Override
    public String visitFlotanteNegCond(GMiniBParser.FlotanteNegCondContext ctx) {
        String valueCode = visit(ctx.factorFlotante);
        return valueCode + "\nfneg\n"; 
    }
    @Override
    public String visitLlamadaFuncion(GMiniBParser.LlamadaFuncionContext ctx) {
        String funcion = ctx.nombreFuncion.getText();
        String argCode = visit(ctx.argumento);
        String neg = "";

        if (deduceExprType(ctx.argumento) == "INT") {
            throw new IllegalArgumentException("El argumento debe ser un String.");
        } 
        switch (funcion) {
            case "VAL":
                // Ahora llamas al metodo auxiliar en vez de Integer.parseInt directamente.
                return argCode + "\n" +
                    "invokestatic Programa/safeParseInt(Ljava/lang/String;)I";
            case "LEN":
                return argCode + "\n" +
                    "invokevirtual java/lang/String/length()I";
            case "ISNAN":
                // Lógica de ISNAN como antes
                int labelIndex = condicionalCounter++;
                String elseLabel = "else_isnan_" + labelIndex;
                String endLabel = "end_isnan_" + labelIndex;

                return argCode + "\n" +
                    "invokestatic Programa/safeParseInt(Ljava/lang/String;)I\n" +
                    "dup\n" +
                    "ldc 0\n" +
                    "if_icmpne " + elseLabel + "\n" +
                    "pop\n" + 
                    "ldc 1\n" +
                    "goto " + endLabel + "\n" +
                    elseLabel + ":\n" +
                    "pop\n" +
                    "ldc 0\n" +
                    endLabel + ":";
            default:
                throw new RuntimeException("Función no implementada: " + funcion);
        }
    
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) {
            return nextResult;
        }
        if (nextResult == null) {
            return aggregate;
        }
        return new StringBuilder(aggregate).append("\n").append(nextResult).toString();
    }



     private String deduceExprType(ParseTree ctx) {
    
        if (ctx instanceof GMiniBParser.ExpresionFlotanteContext) {
            return "FLOAT";
        } else if (ctx instanceof GMiniBParser.ValorFlotanteContext) {
            return "FLOAT";
        } else if (ctx instanceof GMiniBParser.ValorFloatCondContext) {
            return "FLOAT";
        } else if (ctx instanceof GMiniBParser.FlotanteNegContext) {
            return "FLOAT";
        } else if (ctx instanceof GMiniBParser.FlotanteNegCondContext) {
            return "FLOAT";
        } else if (ctx instanceof GMiniBParser.StrContext) {
            return "STRING";
        } else if (ctx instanceof GMiniBParser.IntContext) {
            return "INT";
        } else if (ctx instanceof GMiniBParser.ValorCadenaContext) {
            return "STRING";
        } else if (ctx instanceof GMiniBParser.ExpresionEnteroContext) {
            return "INT";
        } else if (ctx instanceof GMiniBParser.ValorFloatCondContext) {
            return "FLOAT";        
        } else if (ctx instanceof GMiniBParser.ExpresionVariableContext) {
            String varName = ((GMiniBParser.ExpresionVariableContext)ctx).referencia.getText();
            VarInfo info = symbolTable.get(varName);
            return info != null ? info.type : "UNKNOWN";
        } else if (ctx instanceof GMiniBParser.ValorExprContext) {
            // Explora el nodo interno para determinar su tipo
            return deduceExprType(((GMiniBParser.ValorExprContext) ctx).expr());
        } else if (ctx instanceof GMiniBParser.NumeroNegContext) {
            GMiniBParser.NumeroNegContext negCtx = (GMiniBParser.NumeroNegContext) ctx;
            return deduceExprType(negCtx.factor);
        } else if (ctx instanceof GMiniBParser.ExpresionParentesisContext) {
            return deduceExprType(((GMiniBParser.ExpresionParentesisContext)ctx).inner);
        } else if (ctx instanceof GMiniBParser.OperacionSumaRestaContext) {
            GMiniBParser.OperacionSumaRestaContext c = (GMiniBParser.OperacionSumaRestaContext)ctx;
            String left = deduceExprType(c.left);
            String right = deduceExprType(c.right);
            if (left.equals("STRING") || right.equals("STRING")) {
                return "STRING";
            }
            return left.equals("FLOAT") || right.equals("FLOAT") ? "FLOAT" : "INT";
        } else if (ctx instanceof GMiniBParser.ExpresionVariableCondContext) {
            String varName = ((GMiniBParser.ExpresionVariableCondContext) ctx).referencia.getText();
            VarInfo info = symbolTable.get(varName);
            if (info == null) {
                throw new RuntimeException("Variable no definida: " + varName);
            }
            return info.type; // Retorna el tipo de la variable (INT o FLOAT).
                
        } else if (ctx instanceof GMiniBParser.OperacionMultDivModContext) {
            GMiniBParser.OperacionMultDivModContext c = (GMiniBParser.OperacionMultDivModContext)ctx;
            String left = deduceExprType(c.left);
            String right = deduceExprType(c.right);
            return left.equals("FLOAT") || right.equals("FLOAT") ? "FLOAT" : "INT";
        } else if (ctx instanceof GMiniBParser.OperacionComparacionContext) {
            GMiniBParser.OperacionComparacionContext c = (GMiniBParser.OperacionComparacionContext) ctx;
            String left = deduceExprType(c.left);
            String right = deduceExprType(c.right);
            return left.equals("FLOAT") || right.equals("FLOAT") ? "FLOAT" : "INT";
        } else if (ctx instanceof GMiniBParser.ValorFuncionContext) {
            return "INT"; // Asumiendo INT como predeterminado
        } else if (ctx instanceof GMiniBParser.Condicion1Context) {
            GMiniBParser.Condicion1Context c = (GMiniBParser.Condicion1Context) ctx;
            String left = deduceExprType(c.left);
            String right = deduceExprType(c.right);
            return left.equals("FLOAT") || right.equals("FLOAT") ? "FLOAT" : "INT";
        } else if (ctx instanceof GMiniBParser.ValorExprCondContext) {
            GMiniBParser.ValorExprCondContext valorExprCondCtx = (GMiniBParser.ValorExprCondContext) ctx;
            // Llama recursivamente a deduceExprType para procesar exprCond
            return deduceExprType(valorExprCondCtx.expresion);
        }
        return "INT";
    }
   
    



    private String convertToString(String code, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(code).append("\n");
        if (type.equals("STRING")) {
            sb.append("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;\n");
        } else if(type.equals("INT")){
            sb.append("invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;\n");
        } else if(type.equals("FLOAT")){
            sb.append("invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;\n");
        }
        return sb.toString();
    }
}
