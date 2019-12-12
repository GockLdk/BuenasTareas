# Libreria de manejo de JSON
import json

# Para leer el archivo JSON, con caracteres en espanol
with open('Catalogo_de_Bienes_Inmuebles_en_administracion_susceptibles_de_venta.json',  encoding='utf-8-sig') as myfile:
    data=myfile.read() # Lo guarda como objeto jason

# Lo castea a una lista
obj = json.loads(data)

lista = [] # Lista donde se guardaran los datos especificos

#Recorremos la lista con los datos
for x in obj:
	# Creamos un Diccionario con los datos NumeroSIAB , TipoInmueble y EntidadFederativa
	dic = dict(NumeroSIAB = x['NumeroSIAB'],TipoInmueble = x['TipoInmueble'],EntidadFederativa = x['EntidadFederativa'])
	lista.append(dic) # Se agrega a la lista el diccionario

# Imprime la lista
#for j in lista:
#	print(j)
#	print("------------------------------------------------------------------")	

# Crea si no existe o abre si existe un archivo llamdo "Ejercicio1.json" para escribir "w"
with open('Ejercicio1.json', 'w') as archivo:  
	json.dump(lista, archivo) # Serializa los datos de la lista y los escribe en el archivo

