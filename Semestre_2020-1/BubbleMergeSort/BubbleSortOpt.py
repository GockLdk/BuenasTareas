import time ,random
lst =[random.randint(0,1000) for _ in range(50)]
#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
#print(lst) # Comprobando lsta ordenada

def bubbleSort(lista):
    n = len(lista) - 1 #Longitud de la lista
    bandera = True
    comparaciones = 0 # Contador de comparaciones
    while bandera: # Mientras la bandera sea True
        bandera = False #Cambia la bandera
        for i in range(n): # Recorre toda la lista
            comparaciones += 1 # Va contando la compararcion
            if lista[i] > lista[i+1]:   ##
                temp = lista[i]         ##
                lista[i] = lista[i+1]   ## Comparacion e intercambio de bubblesort
                lista[i+1] =  temp      ##
                bandera = True          ##
    return lista, comparaciones # Regresa la lista ordenada y el numero de comparaciones

inicio_bubble = time.time()
lista_final = bubbleSort(lst)
fin_bubble = time.time()
total_bubble = fin_bubble - inicio_bubble
print("Tiempo en seg.")
print(total_bubble)
print("Numero de comparaciones")
print(lista_final[1])
