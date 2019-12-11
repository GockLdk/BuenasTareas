# Especificaciones de la Tarea
### Comparacion de CountingSort y RadixSort
Se deben programar los algoritmos de ordenamiento CountingSort y RadixSort para obtener los tiempos de ejecucion para las listas aleatorias de enteros entre el 0 - 1,000,000 (k) de diferentes tamanios (n):

- 10
- 100
- 1000
- 10000

Realizar minimo de 3 veces para cada tamanio y para cada caso:

- Mejor Caso (El valor del elemento mas grande es igual a n).
- Peor Caso (El valor del elemento mas grande es igual a k).
- Caso Promedio (Lista Aleatoria).

Para obtener el promedio y generar una conclusion al comparar dichos algoritmos.

**Notas**: 

- Se tiene tanto la tabla de los tiempos en PDF y Excel.
- En la carpeta Graficas, se tienen las graficas de comparacion de tiempos entre los algoritmos para cada caso y cada tamanio, ademas de contener el codigo en Python para graficar los datos.

---
# Conclusion General
En ambos ordenamientos se puede ver una clara diferencia con el metodo sort de la listas de python que viene por defecto, ya que en todos los promedios en los casos con diferentes tamanios cada uno los tiempos son menores que a los de este. Pero esto no quiera decir que sean mejores que ese, ya que tienes una mayor velocidad al ordenar pero un mal gaste horrible de memoria, debidoa a la naturaleza de ambos ya que Counting necesita de listas alternas de tamanio de maximo elemento de la lista para poder funcionar, y aunque tengamos una lista de 10 pero hay un elemento de valor 10000 se desperdicia mucha memoria. Mientras que Radix Sort tiene otro problema de memoria debido a la cantidad de listas que ocupa para poder guardar segun los digitos. Solo podemos decir que Radix llega a ser mas rapido en general que Counting y optimiza mejor memoria que este pero eso no quita que ambos son unos pesimos algoritmos de ordenamiento, hablando de manejo de memoria.  

---
### Tabla de tiempos
![Tabla de Tiempos](Tabla.png)
