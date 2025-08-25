LET costoBase = 150.75
LET tasaImpuesto = 0.18
LET cliente = "Juan Pérez"
LET descripcion = "Reparación de aire acondicionado"

REM Calcular el impuesto y el costo total
LET impuesto = costoBase * tasaImpuesto
LET costoTotal = costoBase + impuesto
REM Concatenaciones con cadenas
PRINT "Factura para: " + cliente
PRINT "Servicio: " + descripcion
PRINT "Costo base: " + costoBase  + " €"
PRINT "Impuesto (18%): " + impuesto  + " €"
PRINT "Costo total: " + costoTotal  + " €"

REM Mostrar el desglose del costo acumulado paso a paso
FOR i = 1 TO 10 STEP 2
    LET costoAcumulado = costoBase + (i * 0.5)
    PRINT "Paso " +  i + ": Costo acumulado " + costoAcumulado + " €"
NEXT

REM Comparacion de un entero con un float
IF i >= 9.9999 THEN
    PRINT "Bucle for ejecutado 5 veces, debido al step 2, con valor final de i = " + i
ELSE
    PRINT "El bucle se ha ejecutado menos de 5 veces"
END
