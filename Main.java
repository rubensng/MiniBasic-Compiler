import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;

        if (args.length > 0) {
            inputFile = args[0];
        }
        if (inputFile != null) {
            System.out.println(compile(inputFile));
        }
    }

    public static String compile(String inputFile) throws IOException {
        GMiniBLexer lexer = new GMiniBLexer(CharStreams.fromFileName(inputFile));
        GMiniBParser parser = new GMiniBParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.fichero();
        String jasminInstructions = new MyVisitor().visit(tree);
        createJasminFile(jasminInstructions);
        return jasminInstructions;
    }

    private static void createJasminFile(String instructions) throws IOException {
        String jasminContent = ".class public Programa\n"
                + ".super java/lang/Object\n"
                + "\n"
                + ".method public static main([Ljava/lang/String;)V\n"
                + "   .limit stack 100\n"
                + "   .limit locals 100\n"
                + "\n"
                + instructions + "\n"
                // Finalmente, agregas el método safeParseInt
                +".method public static safeParseInt(Ljava/lang/String;)I\n"
                +"   .limit stack 2\n"
                +"   .limit locals 1\n\n"
                +"TryStart:\n"
                +"   aload_0\n"
                +"   invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I\n"
                +"TryEnd:\n"
                +"   ireturn\n\n"
                +"Handler:\n"
                +"   pop\n"
                +"   ldc 0\n"
                +"   ireturn\n"
                +".catch java/lang/NumberFormatException from TryStart to TryEnd using Handler\n"
                +".end method\n";
        
        try (PrintWriter out = new PrintWriter(new FileWriter("Programa.j"))) {
            out.println(jasminContent);
        }
    }
}
