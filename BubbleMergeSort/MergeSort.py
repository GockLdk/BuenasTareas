import time ,random
lst =[random.randint(0,1000) for _ in range(50)]
#print(len(lst)) # Comprobando longitud
#lst.sort() # Ordenando lista Ascedentemente
#lst.sort(reverse=True) # Ordenando lista Descendentemente
#print(lst) # Comprobando lsta ordenada

contador = 0

#Funcion recursiva merge_sort que divide la lista hasta no mas poder
def merge_sort(lista):
    global contador # Contador global
    if len(lista) <= 1: # Mientras el tamanio de la lista sea menor o igual a 1
        contador += 1 # Se cuenta como comparacion
        return lista # Se regresa la lista ya que no hay elementos en la lista
    # Si no
    mitad = len(lista) // 2 # Se obtiene la mitad de la lista 
    izquierda = merge_sort(lista[:mitad]) # Se divide la lista en lista izquierda y se repite el proceso
    derecha = merge_sort(lista[mitad:]) # Se divide la lista en lista derecha y se repite el proceso
    return merge(izquierda, derecha) # Y despues de divir la lista hasta no mas poder, la junta con la funcion merge

# Funcion recursiva merge que juntara los elementos
def merge(izquierda, derecha):
    global contador # Contador global
    if not izquierda: # Si no hay lista izquierda
        contador += 1 # Cuenta como comparacion
        return derecha # regresa lista derecha
    if not derecha: # Si no hay lista derecha
        contador += 1 # Cuenta como comparacion
        return izquierda # regresa lista izquierda
    # En caso de que haya las dos lista
    if izquierda[0] < derecha[0]: #Si el primer elemento de la lista izquierda es mayor al de la derecha
        contador += 1 # Contamos como comparacion
        # Regresa el primer elemento de la lista izquierda mas lo que regrese la funcion recursiva merge pero sin contar el primer elemento
        # y la lista derecha
        return [izquierda[0]] + merge(izquierda[1:], derecha)
    # Regresa el primer elemento de la lista derecha mas lo que regrese la funcion recursiva merge pero sin contar el primer elemento
    # y la lista derecha  
    return [derecha[0]] + merge(izquierda, derecha[1:])




inicio_merge = time.time()
lista_final = merge_sort(lst)
fin_merge= time.time()
total_merge = fin_merge - inicio_merge
print("Tiempo en seg.")
print(total_merge)
print("Numero de comparaciones")
print(contador)
#print(lista_final)
