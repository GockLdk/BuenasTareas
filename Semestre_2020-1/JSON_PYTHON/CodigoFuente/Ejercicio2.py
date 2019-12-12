# Libreria de manejo de JSON
import json

# Para leer el archivo JSON, con caracteres en espanol
with open('Catalogo_de_Bienes_Inmuebles_en_administracion_susceptibles_de_venta.json',  encoding='utf-8-sig') as myfile:
    data=myfile.read() # Lo gurada como objeto jason

# Lo castea a una lista
obj = json.loads(data)

# Comprobacion de que la cantidad de inmuebles es la correcta (Imprime 6 veces Queretaro)
#for h in obj:
#	if h['EntidadFederativa'] == "QUERETARO" :
#		print(h['EntidadFederativa'])

# Lista donde estaran los nombres de todos las entidades federativas que contiene el archivo
Entidades = []

# Recorre la lista con los datos del archivo
for x in obj:
	if x['EntidadFederativa'] in Entidades: # y si el nombre de la entidad federativa esta en la la lista de entidades
		pass # Pasa (No hace nada)
	else: # En caso de que no este en ella
		Entidades.append(x['EntidadFederativa']) # Agrega el nombre de la entidad federativa a la lista de entidades

# Lista final donde guardaremos los datos finales y ocuparemos para escribir el nuevo JSON
listaFinal = []

# Para cada nombre de la lista de entidades
for entidad in Entidades:
	numero = 0 # inicia un contador de inmuebles
	inmueble = [] # declara una lista vacia donde guardara la info de los inmuebles
	for x in obj: # Recorre la lista con todos los datos
		if x['EntidadFederativa'] == entidad : # Si coincide el nombre de la entidad con el que estamos verificando en la lista de todos los datos
			numero = numero + 1 # Aumenta el contador
			# Crea un diccionario con los datos de es inmueble (NumeroSIAB, Estatus, DescripcionEstatus  y Tipo de inmueble)
			dicci = dict(NumeroSIAB = x['NumeroSIAB'],Estatus = x['Estatus'],DescripcionEstatus = x['DescripcionEstatus'],TipoInmueble = x['TipoInmueble'])
			inmueble.append(dicci) # Agrega el diccionario a la lista de inmuebles (Guarda la info del inmueble checado)
			# Se crea otro diccionario que contendra la EntidadFederativa, NumeroInmuebles y la lista de inmubles con la informacion de cada uno que esta ubicado en esa entidad federativa
	dic = dict(EntidadFederativa = entidad, NumeroInmuebles = numero, Inmuebles = inmueble) 
	listaFinal.append(dic) # Se agrega a la lista final (En pocas palabras guarda toda la info de los inmuebles de esa entidad federativa)

# Comprobacion de que guarda bien (Comprueba en la primera posicion donde es queretaro, y el numero de inmuebles son 6)
#print(listaFinal[0])

# Crea si no existe o abre si existe un archivo llamdo "Ejercicio1.json" para escribir "w"
with open('Ejercicio2.json', 'w') as archivo:  
	json.dump(listaFinal, archivo) # Serializa los datos de la lista y los escribe en el archivo