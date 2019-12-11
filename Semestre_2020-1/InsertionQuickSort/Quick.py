import time ,random
lst =[random.randint(0,100) for _ in range(10)]
#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
print(lst) # Comprobando lsta ordenada

contador = 0

# Toma el ultimo elemento como pivote,  
# coloca el pivote en su posicion correcta en la lista, 
# pone a su izquierda todos los elementos menores al pivote 
# y a su derecha los elementos mayores. 
def partition(lista,inicio,final): 
    global contador
    i = ( inicio-1 )         # indice del elemento menor 
    pivote = lista[final]     # pivote 
  
    for j in range(inicio , final): 
  
        # Si el elemento es menor igual al pivote 
 
        if   lista[j] <= pivote: 
            contador += 1
            # incrementa el indice del elemento menor 
            # y cambia de posicion
            i = i+1 
            lista[i],lista[j] = lista[j],lista[i] 
    contador += 1
    lista[i+1],lista[final] = lista[final],lista[i+1] 
    return ( i+1 ) 
  
# Funcion QuickSort 
# lista --> Lista, 
# inicio  --> Indice inicial. 
# final  --> Indice final. 
def quickSort(lista,inicio,final): 
    global contador
    if inicio < final:
        contador += 1
  
        # Indice de la particion
        pi = partition(lista,inicio,final) 
  
        # Separa y ordena para la parte derecha e izquierda 
        quickSort(lista, inicio, pi-1) 
        quickSort(lista, pi+1, final) 
        quickSort(lista, pi+1, final) 

inicio = time.time()
quickSort(lst,0,len(lst)-1)
fin= time.time()
print("Ordenado:")
print(lst)
print("Tiempo en seg.")
print(fin-inicio)
print("Comparaciones: ")
print(contador)
