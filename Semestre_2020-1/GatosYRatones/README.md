#### [Regresar](../../README.md)
# Especificaciones de la tarea
### Gatos y Ratones
Se pidio un tablero (matriz) donde cada casilla podia contener un raton o gato, donde la logica del programa es la siguiente:

- Se le pide al usuario el tamanio de su tablero (nxn), el numero de gatos y ratones que habra en el tablero, y el numero de ciclos que se repetira el programa.
- Luego aleatoriamente se colocaran los gatos y ratones en el tablero.
- Para cada ciclo, cada raton y gato avanzaran hacia su arriba, abajo, derecha o izquierda segun un numero aleatorio (unico para cada uno) entre 1 al 4. Avanzara a dicha direccion mientras no se salga del tablero o no este ocupada esa casilla.
- Luego cada gato y raton verificara sus casillas que lo rodean de su ubicacion, donde para:
    + Gatos: 
        * Si lo rodean 4 o mas ratones, este muere.
    + Ratones:
        * Si lo rodea al menos un gato, muere el raton.


