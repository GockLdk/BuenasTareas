#### [Menu](../../README.md)
#### [Regresar](README.md)
# Reporte de la Tarea JSON-PYTHON

**Consideraciones para que los programas lean el archivo debe cumplir con lo siguiente:**

- Nombre del archivo json: Catalogo_de_Bienes_Inmuebles_en_administracion_susceptibles_de_venta.json
- Los programas deben estar en la misma carpeta donde esta el archivo json.
- Cada programa (Ejercicio1.py, Ejercicio2.py y PuntoExtra.py) al final genera un archivo 
  json o xlsx segun corresponda (Ejercicio1.json, Ejercicio2.json y PuntoExtra.xlsx) en caso
  de que no exista en la carpeta, si existen sobreescribiran dichos archivos.

---

### EJERCICIO 1 (1.1.A)
El programa de dicho ejercicio es "Ejercicio1.py" el cual funciona:

- Importa la libreria JSON que se ocupa para el manejo de datos de archivo json con python
- Luego abre el archivo internamente con la funcion open('NombreArchivo.json',encoding = 'Caracteres del espanol')
  lo guarda como myfile, para luego ocupar la funcion read() para guardar la info del archivo json
- Como las estructuras de datos de json no las maneja igual python, se hace un casteo con json.load(data)
  donde los '[]' los toma como lista y '{}' como diccionarios donde "ClaveDelDicionario" : "Valor" , en resumen
  los datos se guardan como un lista donde cada casilla contiene un diccionario con la info de cada inmueble, el nombre de esa lista es "obj".
- Luego se crea una lista llamada "lista" donde se guardara la informacion requerida de cada inmueble, que en este caso son "NumeroSIAB" , "TipoInmueble" y "EntidadFederativa".
- Luego con un for se recorre la lista obj (que contiene toda la info del archivo) y para cada elemento de dicha
  lista se crea un diccionario llamado "dic" el cual guardara solo los datos "NumeroSIAB" , "TipoInmueble" y "EntidadFederativa", para luego agregar dicho diccionaro a lista.
- Una vez acabado el for se guardo la info especificada de cada inmueble en a lista asi que solo se ocupa a funcion
  open("NombreArchivoDondeEscribiraDatos.json",'w') la cual crea un archivo con el nombre puesto (en caso de no existir)
  llamado "archivo". Nota: 'w' indica que se ocupara el archivo como escritura.
- Y finalmente se ocupa la funcion json.dump(lista,archivo) la cual recibe la lista con diccionarios y el archivo donde se escribira lo contenido en la lista.



### EJERCICIO 2 (1.2.B)
El programa de dicho ejercicio es "Ejercicio2.py" el cual funciona:

- Importa la libreria JSON que se ocupa para el manejo de datos de archivo json con python
- Luego abre el archivo internamente con la funcion open('NombreArchivo.json',encoding = 'Caracteres del espanol')
  lo guarda como myfile, para luego ocupar la funcion read() para guardar la info del archivo json
- Como las estructuras de datos de json no las maneja igual python, se hace un casteo con json.load(data)
  donde los '[]' los toma como lista y '{}' como diccionarios donde "ClaveDelDicionario" : "Valor" , en resumen
  los datos se guardan como un lista donde cada casilla contiene un diccionario con la info de cada inmueble, el nombre de esa lista es "obj".
- Se creara una lista llamada "Entidades" que contendra el nombre de todas la entidades federativas que existen 
  en los datos (sin repetirse).
- Con un for se recorre la lista y de cada inmueble compara su llave "EntidadFederativa" y si no esta en la lista
  entindades, lo agrega, en caso de que este, no hace nada (esto para asegurar que no ponga una entidad dos veces).
- Luego se crea una lista llamada "listaFinal" donde se guardara la informacion requerida de cada inmueble, que 
  en este caso son "EntidadFederativa", Numero de inmuebles que estan ubicados en esa entidad y una lista "inmueble"
  que contiene el "NumeroSIAB", "Estatus" y "DescripcionEstatus" de todos los inmuebles ubicados en esa entidad federativa.
- A continuacion con un for se recorre la lista de entidades y para cada entidad creara un contador de inmuebles
  llamado "numero" y una lista llamada "inmueble", luego con otro for recorrera la lista con todos los dicionarios
  y si la llave "EntidadFederativa" y el nombre de esa entidad coinciden, aumenta el contador uno, crea un diccionario llamado "dicci" que guardara el "NumeroSIAB", "Estatus" y "DescripcionEstatus" de ese inmueble que 
  coincidio su entidad federativa, para luego agregarlo a la lista inmueble, y al final del este for creara un 
  diccionario llamado "dic" el cual tendra el nombre de la entidad federativa, el contador de inmuebles y la 
  lista de inmuebles con la info pedida que estan en dicha entidad federativa, para luego dicho diccionario "dic"
  sea agregado a la listaFinal, asi asegurando que en cada casilla esta la informacion pedida de cada entidad federativa.
- Una vez acabado el for se guardo la info especificada de cada entidad federativa en la listaFinal, asi que solo se ocupa a funcion
  open("NombreArchivoDondeEscribiraDatos.json",'w') la cual crea un archivo con el nombre puesto (en caso de no existir)
  llamado "archivo". Nota: 'w' indica que se ocupara el archivo como escritura.
- Y finalmente se ocupa la funcion json.dump(listaFinal,archivo) la cual recibe la listaFinal con diccionarios y el archivo donde se escribira lo contenido en la lista.


### PUNTO EXTRA (1.3)
El programa de dicho ejercicio es "PuntoExtra.py" el cual funciona:

- Importa la libreria JSON que se ocupa para el manejo de datos de archivo json con python
- Luego abre el archivo internamente con la funcion open('NombreArchivo.json',encoding = 'Caracteres del espanol')
  lo guarda como myfile, para luego ocupar la funcion read() para guardar la info del archivo json
- Como las estructuras de datos de json no las maneja igual python, se hace un casteo con json.load(data)
  donde los '[]' los toma como lista y '{}' como diccionarios donde "ClaveDelDicionario" : "Valor" , en resumen
  los datos se guardan como un lista donde cada casilla contiene un diccionario con la info de cada inmueble, el nombre de esa lista es "obj" .
- Luego se crea una lista llamada "lista" donde se guardara la informacion requerida de cada inmueble, que en este caso son "NumeroSIAB" , "TipoInmueble" y "EntidadFederativa".
- Luego con un for se recorre la lista obj (que contiene toda la info del archivo) y para cada elemento de dicha
  lista se crea un diccionario llamado "dic" el cual guardara solo los datos "NumeroSIAB" , "TipoInmueble" y "EntidadFederativa", para luego agregar dicho diccionaro a lista.
- A continuacion se importa la funcion WorkBook de la biblioteca openxpyxl la cual te crea un objeto que se puede 
  manejar y guardar como un archivo excel, que es lo que se hace con la siguiente linea "wb = Workbook()".
- Luego con el metodo "wb.active()" creamos una hoja de del libro de excel "wb" y la llamamos "ws".
- Para darle un poco de formato al archivo en las primeras celdas se pone los titulos de cada columna y esto se 
  hace usando ws['PosicionDeLaCelda'] = "algo". Nota: en este caso vamos a insertar la info solicita en filas
  en el siguiente orden "NumeroSIAB" , "TipoInmueble" y "EntidadFederativa".
- Se recorre con un for todo la lista "lista", para que en cada iteracion ocupar el metodo "append()" de ws que
  recibe una lista y esa lista la agrega a la siguiente fila vacia que encuentre dentro de la hoja de excel "ws",
  asi que la lista que le mandamos contiene los valores de las llaves "NumeroSIAB" , "TipoInmueble" y 
  "EntidadFederativa" de los diccionarios guardados. En resumen va agregando filas con la informacion de la lista "lista".
- Finalmente se ocupa el metodo "wb.save("PuntoExtra.xlsx")" que guarda el libro excel con el nombre dado en caso
  de que no exista, sobreescibe si es que existe.
