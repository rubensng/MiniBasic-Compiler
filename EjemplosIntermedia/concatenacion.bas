REM Concatenaciones simples de cadenas
PRINT "Hola" + ", " + "mundo!"

REM Concatenaciones con espacios intermedios
PRINT "Nombre: " + "Ana" + " " + "García"

REM Concatenaciones con múltiples frases
PRINT "Este es un ejemplo de concatenación: " + "cadena uno, " + "cadena dos, " + "cadena tres."

REM Concatenaciones en un bucle con entero
FOR i = 1 TO 3
    PRINT "Iteración " + i + ": " + "Este es un mensaje en el bucle."
NEXT

REM Concatenaciones en un bucle con float
LET j = 1.0
FOR k = 1 TO 3
    j = j + 2.5
    PRINT "Numero: " + j + ": " + "Este es un mensaje en el bucle."
NEXT


REM Concatenaciones con identificadores
LET nombre = "Carlos"
LET apellido = "Pérez"
PRINT "Hola " + nombre + " " + apellido + ", ¿cómo estás?"