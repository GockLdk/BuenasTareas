import random
import time

from copy import copy, deepcopy


# Variables Globales
tablero = []
tableroAux = []
n = 0
n_gatos = 0
n_ratones = 0

# imprime el arreglo (tablero)
def imprimirTablero():
	global tablero
	print("\nTablero: ")
	for i in tablero:
		for j in i:
			print("| " + str(j) +" |", end='', flush=True) 
		print("")
	print()

# Dado el numero de gatos y ratones los agregara aleatoriamente en el arreglo
def inicializarTablero():
	global tablero, n_ratones , n_gatos , n
	
	# columna y renglon aleatorio
	columnaRandom = random.randint(0,n-1)
	renglonRandom = random.randint(0,n-1)

	# lo repite segun el numero de gatos va al hueco y si esta vacio pone al gato para luego generar otros numero aleatorios
	for x in range(n_gatos):
		if tablero[columnaRandom][renglonRandom] != 'R' and tablero[columnaRandom][renglonRandom] != 'G':
			tablero[columnaRandom][renglonRandom] = 'G'
			columnaRandom = random.randint(0,n-1)
			renglonRandom = random.randint(0,n-1)
		else : # En caso de que este ocupado se vuelve a sacar otra posicion aleatoria
			columnaRandom = random.randint(0,n-1)
			renglonRandom = random.randint(0,n-1)
			if tablero[columnaRandom][renglonRandom] != 'R' and tablero[columnaRandom][renglonRandom] != 'G':
				tablero[columnaRandom][renglonRandom] = 'G'

	# Lo mismo para los ratones
	for x in range(n_ratones):
		if tablero[columnaRandom][renglonRandom] != 'R' and tablero[columnaRandom][renglonRandom] != 'G':
			tablero[columnaRandom][renglonRandom] = 'R'
			columnaRandom = random.randint(0,n-1)
			renglonRandom = random.randint(0,n-1)
		else :
			columnaRandom = random.randint(0,n-1)
			renglonRandom = random.randint(0,n-1)
			if tablero[columnaRandom][renglonRandom] != 'R' and tablero[columnaRandom][renglonRandom] != 'G':
				tablero[columnaRandom][renglonRandom] = 'R'

# Copia lo del tablero a un tablero auxiliar 
def copiarTablero():
	global tablero , tableroAux

	tableroAux = deepcopy(tablero)

# Verifica las casillas alrededor del gato y si encuentra mas de 4 regrea un true de que va a morir
def inspeccionarGato(i,j):
	global tablero , n
	
	ratones = 0 # Contador de ratones

	# En cada posicion de alrededor verifica que no se salga del tablero y si encuentra un raton aumenta el contador 

	# Esquina superior izquierda [i-1][j-1]
	if j-1>=0 and i-1>=0:
		if tablero[i-1][j-1] == 'R':
			ratones = ratones + 1
	# Lado izquierdo [i][j-1]
	if j-1>=0 :
		if tablero[i][j-1] == 'R':
			ratones = ratones + 1
	# Esquina inferior izquierda [i+1][j-1]
	if j-1<n and i+1>n:
		if tablero[i+1][j-1] == 'R':
			ratones = ratones + 1
	# Lado superior [i-1][j]
	if i-1<=0:
		if tablero[i-1][j] == 'R':
			ratones = ratones + 1
	# Lado inferior [i+1][j]
	if i+1<n:
		if tablero[i+1][j] == 'R':
			ratones = ratones + 1
	# Esquina superior derecha [i-1][j+1]
	if j+1<n and i-1>=0:
		if tablero[i-1][j+1] == 'R':
			ratones = ratones + 1
	# Lado derecho [i][j+1]
	if j+1<n:
		if tablero[i][j+1] == 'R':
			ratones = ratones + 1
	# Esquina inferior derecha [j+1][i+1]
	if j+1<n and i+1<n:
		if tablero[i+1][j+1] == 'R':
			ratones = ratones + 1

	if ratones >= 4 :
		return True
	else :
		return False

# # Verifica las casillas alrededor del gato y si encuentra un gato regresa un true de que va a morir
def inspeccionarRaton(i,j):
	global tablero , n

	# En cada posicion de alrededor verifica que no se salga del tablero y si encuentra un gato regres true 

	# Esquina superior izquierda [i-1][j-1]
	if j-1>=0 and i-1>=0:
		if tablero[i-1][j-1] == 'G':
			return True
	# Lado izquierdo [i][j-1]
	if j-1>=0 :
		if tablero[i][j-1] == 'G':
			return True
	# Esquina inferior izquierda [i+1][j-1]
	if j-1<n and i+1>n:
		if tablero[i+1][j-1] == 'G':
			return True
	# Lado superior [i-1][j]
	if i-1<=0:
		if tablero[i-1][j] == 'G':
			return True
	# Lado inferior [i+1][j]
	if i+1<n:
		if tablero[i+1][j] == 'G':
			return True
	# Esquina superior derecha [i-1][j+1]
	if j+1<n and i-1>=0:
		if tablero[i-1][j+1] == 'G':
			return True
	# Lado derecho [i][j+1]
	if j+1<n:
		if tablero[i][j+1] == 'G':
			return True
	# Esquina inferior derecha [j+1][i+1]
	if j+1<n and i+1<n:
		if tablero[i+1][j+1] == 'G':
			return True

	return False

# Dado la posicion de un gato genera un numero aleatorio del 1-4
# 1: Arriba, 2:Abajo, 3:Izquierda, 4:Derecha
# Antes de ver a que posicion avanzar, compara la misma posicion de tablero y tableroAux (Para evitar que modifique uno que ya haya avanzado)
# Luego verifica a donde avanza, luego verifica que pueda avanzar para luego ver si esta vacio el espacio y si esta vacio modifica los valores para simlar que avanzo
# descomentar los print y comentar los pass si se quiere saber que hicieron los ratones y gatos
def avanzarGato(i,j):
	global tablero , tableroAux
	avanzarRandom = random.randint(1,4)
	if tablero[i][j] == tableroAux[i][j] :
		if avanzarRandom == 1:
			# Arriba [i-1][j]
			if i-1<=0:
				if tablero[i-1][j] == 'X':
					tablero[i][j] = 'X'
					tablero[i-1][j] = 'G'
				else:
					#print("Un gato se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un gato se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 2:
			# Abajo [i+1][j]
			if i+1<n:
				if tablero[i+1][j] == 'X':
					tablero[i][j] = 'X'
					tablero[i+1][j] = 'G'
				else:
					#print("Un gato se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un gato se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 3:
			# Izquierda [i][j-1]
			if j-1>=0 :
				if tablero[i][j-1] == 'X':
					tablero[i][j] = 'X'
					tablero[i][j-1] = 'G'
				else:
					#print("Un gato se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un gato se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 4:	
			# Lado derecho [i][j+1]
			if j+1<n:
				if tablero[i][j+1] == 'X':
					tablero[i][j] = 'X'
					tablero[i][j+1] = 'G'
				else:
					#print("Un gato se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un gato se quiso mover fuera del tablero")
				pass

# La misma logica pero con los ratos
# descomentar los print y comentar los pass si se quiere saber que hicieron los ratones y gatos
def avanzarRaton(i,j):
	global tablero , tableroAux
	avanzarRandom = random.randint(1,4)
	if tablero[i][j] == tableroAux[i][j]:
		#print(str(tablero[i][j]) +" " +str(tableroAux[i][j]))
		if avanzarRandom == 1:
			# Arriba [i-1][j]
			if i-1<=0:
				if tablero[i-1][j] == 'X':
					tablero[i][j] = 'X'
					tablero[i-1][j] = 'R'
				else:
					#print("Un raton se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un raton se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 2:
			# Abajo [i+1][j]
			if i+1<n:
				if tablero[i+1][j] == 'X':
					tablero[i][j] = 'X'
					tablero[i+1][j] = 'R'
				else:
					#print("Un raton se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un raton se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 3:
			# Izquierda [i][j-1]
			if j-1>=0 :
				if tablero[i][j-1] == 'X':
					tablero[i][j] = 'X'
					tablero[i][j-1] = 'R'
				else:
					#print("Un raton se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un raton se quiso mover fuera del tablero")
				pass

		if avanzarRandom == 4:	
			# Lado derecho [i][j+1]
			if j+1<n:
				if tablero[i][j+1] == 'X':
					tablero[i][j] = 'X'
					tablero[i][j+1] = 'R'
				else:
					#print("Un raton se quiso mover a un lugar ocupado")
					pass
			else:
				#print("Un raton se quiso mover fuera del tablero")
				pass

# Funcion que recorre el arreglo (tablero) y si encuentra un gato o raton lo hara avanzar
def avanzar():
	global tablero , n

	for i in range(n-1):
		for j in range(n-1):
			if tablero[i][j] == 'G' :
				avanzarGato(i,j)
				
			if tablero[i][j] == 'R':
				avanzarRaton(i,j)

# # Funcion que recorre el arreglo (tablero) y si encuentra un gato o raton inspecciona si muere o vive
def revisar():
	global tablero

	for i in range(n-1):
		for j in range(n-1):
			if tablero[i][j] == 'G' :
				rev = inspeccionarGato(i,j)
				if rev == True :
					tablero[i][j] = "X"
					#print("Un Gato murio")
				
			if tablero[i][j] == 'R':
				rev = inspeccionarRaton(i,j)
				if rev == True :
					tablero[i][j] = "X"
					#print("Un raton murio")

	

# main
# X: Espacio vacio
# G: Gato en casilla
# R: Raton en casill
def main():
	# Le dice que son variables globales
	global tablero, tableroAux ,n_ratones , n_gatos , n , ciclos

	print("***Gatos y Ratones***\nFavor de teclear los datos solicitados")
	n = int(input("Tamanio del tablero nxn (RECOMENDABLEMENTE 10 O MAS): ")) # Pide el tamanio del tablero

	# Crea los dos tableros inciializados con X
	tablero = [["X"] * n for i in range(n)]
	tableroAux = [["X"] * n for i in range(n)]

	# Pide el numero de gatos y ratones
	n_gatos = int(input("Numero de gatos que habra en el tablero: "))
	n_ratones = int(input("Numero de ratones que habra en el tablero: "))

	#Pone los gatoe y ratones en el tablero y luego copia el tablero en tableroaux
	inicializarTablero()	
	copiarTablero()	
	
	# Pide el numero de ciclos que se realizaran
	ciclos = int(input("Numero de ciclos (veces que avanzaran los Gatos y Ratones): "))
	n_avances = 1	
	while n_avances<=ciclos: 
		print("Avance: " + str(n_avances)) # imprime avances, pasos o ciclos
		imprimirTablero() # imprime el tablero actual
		
		avanzar() # Avanza a ratones y gatos
		copiarTablero() # Copia lo que avanzaron a tableroaux
		revisar() # Revisa quien fallece o no
		
		n_avances = n_avances + 1
		time.sleep(3) # Se espera tres segundo el programa (Pura estetica)

main() # Se corre la funcion main
