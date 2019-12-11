import time ,random

# Caso promedio
lst =[random.randint(0,1000000) for _ in range(10)]

#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
#print(lst) # Comprobando lsta ordenada

# Funcion RadixSort
def radixsort( aList ):
  RADIX = 10 # Referencia del digito que se compara
  maxLength = False # Variable de referencia cuando se llega a la maxima longitud
  tmp , placement = -1, 1

  # Mientras no se llegue a la ultima posicion
  while not maxLength:
    maxLength = True# Se cambia a True
    # Crea el arreglo de del tamanio del maximo valor
    buckets = [list() for _ in range( RADIX )]

    # Acomoda cada elemento de la lista en su casilla correspondiente
    # Segun el digito a verificar
    for  i in aList:
      tmp = i // placement
      buckets[tmp % RADIX].append( i )
      if maxLength and tmp > 0:
        maxLength = False

    # Recorre el arreglo y va poniendo los elementos en orden segun los conto
    a = 0
    for b in range( RADIX ):
      buck = buckets[b]
      for i in buck:
        aList[a] = i
        a += 1

    # Se mueve al siguiente digito
    placement *= RADIX
  return aList

inicio = time.time()
lst1 = radixsort(lst)
fin= time.time()
total = fin - inicio
inicioS = time.time()
lst.sort()
finS= time.time()
totalS = finS - inicioS
print(lst1) 
print("Tiempo en seg.")
print(total)
print("Tiempo en seg. (Sort)")
print(totalS)

## Para asegurar que era el mejor caso
# lst =[random.randint(0,n) for _ in range(n-1)] # Hacemos una lista de numeros aleatorios del 0 a n de tamanio n-1
# lst.insert(random.randint(0,n-1),n) # agreagamos el numero n en una posicion aleatoria dentro de la lista

## Para asegurar el peor caso
# lst =[random.randint(0,k) for _ in range(n-1)] # Hacemos una lista de numeros aleatorios del 0 a k de tamanio n-1
# lst.insert(random.randint(0,n-1),k) # agreagamos el numero k en una posicion aleatoria dentro de la lista




