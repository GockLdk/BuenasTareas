import time ,random

contador = 0
lst =[random.randint(0,100) for _ in range(10)]
#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
print(lst) # Comprobando lsta ordenada

def insertionSort(lista): 
    global contador
    # Para todos los elementos de la lista
    for i in range(1, len(lista)): 
  
        llave = lista[i] 
  
        # Mueve los elementos de la lista [0..i-1], que son
        # mayor a la llave, a la siguiente posicion
        # con respecto de su posicion actual
        j = i-1
        while j >= 0 and llave < lista[j] : 
                contador += 1
                lista[j + 1] = lista[j] 
                j -= 1
        lista[j + 1] = llave

inicio = time.time()
insertionSort(lst)
fin= time.time()
print("Ordenado:")
print(lst)
print("Tiempo en seg.")
print(fin-inicio)
print("Comparaciones: ")
print(contador)
