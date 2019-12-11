import time ,random

# Caso promedio
lst =[random.randint(0,1000000) for _ in range(10)]

#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
#print(lst) # Comprobando lsta ordenada

def countingSort(lista,k):
  C = [0 for _ in range(k+1)]
  B = [0 for _ in range(len(lista))]
  
  for j in range(0,len(lista)):
    C[lista[j]] = C[lista[j]]+1

  for i in range(1,k+1):
    C[i] = C[i] + C[i-1]

  for j in range(len(lista)-1,-1,-1):
    B[C[lista[j]]-1] = lista[j]
    C[lista[j]] = C[lista[j]]-1
  return B

inicio = time.time()
lst1 = countingSort(lst,1000000)
fin= time.time()
total = fin - inicio
inicioS = time.time()
lst.sort()
finS= time.time()
totalS = finS - inicioS
#print(lst1) 
print("Tiempo en seg.")
print(total)
print("Tiempo en seg. (Sort)")
print(totalS)

## Para asegurar que era el mejor caso
# lst =[random.randint(0,n) for _ in range(n-1)] # Hacemos una lista de numeros aleatorios del 0 a n de tamanio n-1
# lst.insert(random.randint(0,n-1),n) # agreagamos el numero n en una posicion aleatoria dentro de la lista
# lst1 = countingSort(lst,n) # Indicando cual es el numero maximo a contar

## Para asegurar el peor caso
# lst =[random.randint(0,k) for _ in range(n-1)] # Hacemos una lista de numeros aleatorios del 0 a k de tamanio n-1
# lst.insert(random.randint(0,n-1),k) # agreagamos el numero k en una posicion aleatoria dentro de la lista
# lst1 = countingSort(lst,k) # Indicando cual es el numero maximo a contar
