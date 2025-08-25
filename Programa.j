.class public Programa
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
   .limit stack 100
   .limit locals 100

getstatic java/lang/System/out Ljava/io/PrintStream;
new java/lang/StringBuilder
dup
invokespecial java/lang/StringBuilder/<init>()V
ldc "Hello world!"
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


fin:
   return

.end method
.method public static safeParseInt(Ljava/lang/String;)I
   .limit stack 2
   .limit locals 1

TryStart:
   aload_0
   invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
TryEnd:
   ireturn

Handler:
   pop
   ldc 0
   ireturn
.catch java/lang/NumberFormatException from TryStart to TryEnd using Handler
.end method

