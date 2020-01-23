#### [Regresar](../../README.md)
# Especficaciones de la Tarea
### Simulador de una Cola de Banco
Lo solicitado en este simulador de una cola de banco fue, que en un banco con una sola fila para la unica caja para atender a clientes se haga lo siguiente segun un numero aleatorio entre 1 y 6:

- Si el numero esta en el rango del 4 al 6: Llega un cliente al banco y se forma en la cola.
- Se tiene dos estados de la caja ocupada y desocupada (inicialmente desocupada). Si el numero esta en el rango del 1 al 3: 
    + Si la caja esta desocupada, un cliente de la fila sale de la fila para ser atendido, y la caja pasa a estar ocupada.
    + Si la caja esta ocupada, no se realiza nada.

Esta simulacion se repite un numero de iteraciones que define el usuario al principio del programa donde una iteracion es equivalente a un minuto.
Al final de todas las simulaciones se muestra:

- El total de clientes que llegaron al banco y se formaron.
- El numero de clientes atendidos (que pasaron en la caja).
- El numero de clientes que se quedaron sin atender.
- El tiempo transcurrido (minutos).

**Nota**: Este programa fue hecho con Java 11 y en Netbeans 11.

---
## Algunas Screenshots de su funcionamiento
![S1](ScreenShots/1.JPG)

---
![S2](ScreenShots/2.JPG) 

---
![S3](ScreenShots/3.JPG)

---
![S5](ScreenShots/5.JPG)  

