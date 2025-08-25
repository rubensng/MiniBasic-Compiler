FUNC suma(a, b)
    LET res = a + b
    PRINT "El resultado es: " + res
    RETURN 0
END

FUNC resta(a, b)
    LET resultado = a - b
    PRINT "El resultado es: " + resultado
    RETURN "Operación ejecutada con éxito"
END


LET x = 10
LET y = 20
suma(x, y)
resta(x, y)

