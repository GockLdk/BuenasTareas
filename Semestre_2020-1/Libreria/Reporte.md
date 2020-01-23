#### [Menu](../../README.md)
#### [Regresar](README.md)

# Reportes de la Practicas 10 y 12
### Practica 10
#### EJERCICIO 1

**Explicacion a grandes rasgos, en las clases mas complejas hya comentarios en el codigo para mas detalles.**

Este programa tiene 4 carpetas "almacen,aplicacion,controles,eventos" donde cada carpeta contiene:

- Carpeta almacen:
    - Administrador.java : Clase encargada de manejar el registro de libros de texto y audio, tiene los metodos para tanto escribir  y leer archivos donde esta contenido la informacion de los libro.

- Capeta datos:
    - Registro.java : Clase Abstracta que contiene una entero que es el indice de los registros.

- Carpeta aplicacion:
    - Libreria.java : GUI (Interfaz Grafica) del programa, contiene un Objeto Administrador, ManejadorEventos y componentes de JFrame.
        Define y configura todos los elementos del JFrame dentro de la ventana (JRadioButtons, JLabel, JTextFields, Listas,etc).

- Carpeta controles: Aqui estan las clases de los botones, textfield, etc. que tendra nuestra GUI. (Las divido en "Se Ocupan" y "NO se Ocupan" por que el codigo donde se genera el PanelCentro con los botones de registrar y cancelar NO muestra nada cuando se descomenta o simplemente no se ocuparon esos componentes en Libreria.java).
    - "Se Ocupan"
    - BotonSeleccion.java : Clase que Hereda de JRadioButton donde solo se crea apartir de un nombre dado.
    - CajaTexto.java : Clase que Hereda de JTextField donde crea dos tipos de JTextfield dependiendo si son numeros o una String lo que recibe.
    - Etiqueta.java : Clase que Hereda de JLabel donde crea una etiqueta con la string que se le de.
    - ListaDesplegable.java :  Clase que Hereda de JComboBox que crea una lista desplegable segun la lista que se le proporcione.
    - "NO se Ocupan"
    - Boton.java : Clase que Hereda de JButton que crea un boton con la string dada y tiene un evento por si lo seleccionan.
    - CasillaVerificacion.java : Clase que hereda de JCheckBox que crea una casilla de verificacion (Como el Radio Button pero cuadrado).
    - Imagen.java : Clase que Hereda de JPanel donde el constructor recibe un Archivo (imagen) y las dimensiones de la imagen, lee la imagen y tiene un metodo para mostrarla.

- Carpeta eventos:
    - ManejadorEventos.java :  Clase que implementa los metodos de ActionListener, recibe un objeto de tipo Libreria, y si detecta que se seleccion un componente especifico, hace algo ya definido.

En resumen es un Programa con registro de Libros y Audio Libros el cual tiene una interfaz grafica donde podemos poner los datos como Titulo y Autor, seleccionar si es de Texto o Audio, y dependiendo de esos especificar que tipo es de cada uno.
Solo que es un programa esta a medias ya que aunque existe el codigo para registrar libros (crear y leer archivos) no lo hace, a su vez como mostrar el panel donde estan los botones de Registrar y Cancelar, y tener clases de componentes que no se ocupan como la de Imagen.java.  

---
#### EJERCICIO 2
En Java hay una clase en el paquete Swing la cual se llama ButtonGroup la cual es la encargada de juntar RadioButton en un grupo o lista y por defecto si dentro del grupo esta seleccionado X RadioButton los demas se deselecciona.
Codigo agregado a Libreria.java para que solo se seleccion un RadioButton a la vez.
```java
    // GRUPO DE RADIOBUTTON "EJERCICIO 2"
    private ButtonGroup grupoRadioButton;
    // CREANDO GRUPO DE RADIOBUTTON Y AGREGADO AL GRUPO LOS RADIO BUTTON  "EJERCICIO 2"
    this.grupoRadioButton = new ButtonGroup();
    this.grupoRadioButton.add(tipoRegistroTxt);
    this.grupoRadioButton.add(tipoRegistroAudio);   
```
Para poder mostrar o no un componente hay un metodo llamado setVisible(); el cual recibe un booleano, si es true se muestra el componente y si es false lo oculta.
Codigo agregado a ManejadorEventos.java para ocultar y mostrar las lista dependiendo del Botton seleccionado.
```java
    // MOSTRANDO LA LISTA DE TEXTO Y OCULTANDO LA DE AUDIO  "EJERCICIO 2"
    this.lib.getTipoTxtLD().setVisible(true);
    this.lib.getTipoAudioLD().setVisible(false);    
  
    // MOSTRANDO LA LISTA DE AUDIO Y OCULTANDO LA DE TEXTO  "EJERCICIO 2"
    this.lib.getTipoTxtLD().setVisible(false);
    this.lib.getTipoAudioLD().setVisible(true); 

**Nota**: El codigo agregado al programa de este ejercicio esta comentado con Mayusculas y tiene la palabra "EJERCICIO 2"
```
---    
#### EJERCICIO 3
Codigo agregado a Administrador.java para que guarde libros de texto, audiolibros e imagenes en archivos de texto diferentes.
```java     
    public final static String NOMBRE_ARCHIVO="Almacen.txt"; // ELIMINAR SI NO SE OCUPA EL PRIMER CONSTRUCTOR "EJERCICIO 3"
    // ATRIBUTOS STATIC AGREGADOS "EJERCICIO 3"
    public final static String NOMBRE_ARCHIVO_TEXTO="AlmacenTEXTO.txt";
    public final static String NOMBRE_ARCHIVO_AUDIO="AlmacenAUDIO.txt";
    public final static String NOMBRE_ARCHIVO_IMG="AlmacenIMG.txt";


    // "EJERCICIO 3"
    /* SOBRECARGA DEL CONSTRUCTOR
    RECIBE UN ENTERO QUE SERA EL TIPO
    1: LIBROS DE TEXTO
    2: LIBROS DE AUDIO
    3: IMAGENES
    */
    public Administrador(int tipo) {
      this.almacen= generarClaseFile(tipo); // en el constructor genera un archivo del tipo segun se mande
    }


    // "EJERCICIO 3"
    /* SOBRECARGA DEL METODO generarClaseFile
    RECIBE UN ENTERO Y DEPENDIENDO DEL ENTERO GUARDA EL LIBRO EN ARCHIVOS DIFERENTES
    1: LIBROS DE TEXTO
    2: LIBROS DE AUDIO
    3: IMAGENES
    */
    public static File generarClaseFile(int opcion){
      String rutaCompleta="";
      switch (opcion) {
      case 1:
        rutaCompleta=RUTA_ARCHIVO_1+NOMBRE_ARCHIVO_TEXTO;
        break;
      case 2:
        rutaCompleta=RUTA_ARCHIVO_1+NOMBRE_ARCHIVO_AUDIO;
        break;
      case 3:
        rutaCompleta=RUTA_IMAGENES_2+NOMBRE_ARCHIVO_IMG;
        break;
      default:
        break;
      }
      System.out.println("rutaCompleta:"+rutaCompleta);
      return new File(rutaCompleta);
    }

Codigo agregado a Libreria.java para probar el constructor

    public static void main(String[] args) {
      new Administrador(); // COMENTAR ESTA LINEA Y DESCOMENTAR LA DE ABAJO PARA EL EJERCICIO 3 
      //new Administrador(2); // PRUEBA DE ARCHIVO DE AUDIOS "EJERCICIO 3"
          new Libreria(); 
    }

**Nota**: El codigo agregado al programa de este ejercicio esta comentado con Mayusculas y tiene la palabra "EJERCICIO 3"

En resumen se hicieron otro constructor y otro metodo generarClaseFile para que recibieran un entero que significa el tipo de libro y dependiendo del libro se guardara en el archivo AlmacenTEXTO.txt (si es un libro de texto "tipo 1"), AlmacenAUDIO.txt (si es audiolibro "tipo 2") o AlmacenIMG.txt (si es una imagen "tipo 3"). Y se comprueba por que al imprimir la rutaCompleta puedes ver en que archivo lo guarda.
```
---
### Practica 12
#### EJERCICIO 1
**Explicacion a grandes rasgos, en las clases mas complejas hya comentarios en el codigo para mas detalles.**

Este programa tiene 4 carpetas "almacen,aplicacion,controles,eventos" donde cada carpeta contiene:

- Carpeta almacen:
    - Administrador.java : Clase encargada de manejar el registro de libros de texto y audio, tiene los metodos para tanto escribir  y leer archivos donde esta contenido la informacion de los libro.
- Capeta datos:
    - Registro.java : Clase Abstracta que contiene una entero que es el indice de los registros.
- Carpeta tipos:
    - Audio.java : Clase para definir los objetos tipo AudioLibro
    - Texto.java : para definir os objetos tipo Libro de Texto

**Nota**: Para cada clase se agregaron los atributos Autor, Titulo, Info y tipo. 

Donde:

- Autor y titulo seran el autor y tipo de los audio libro.
- Info: Es el tipo de AudioLibro (Cassete,LP o CD).
- tipo: Variable estatica para futuras comparaciones    
    - 1 = Libro de Texto  
    - 2 = AudioLibro

- Carpeta aplicacion:
    - Libreria.java : GUI (Interfaz Grafica) del programa, contiene un Objeto Administrador, ManejadorEventos y componentes de JFrame.
        Define y configura todos los elementos del JFrame dentro de la ventana (JRadioButtons, JLabel, JTextFields, Listas,etc).

- Carpeta controles: Aqui estan las clases de los botones, textfield, etc. que tendra nuestra GUI. (Las divido en "Se Ocupan" y "NO se Ocupan" por que el codigo donde se genera el PanelCentro con los botones de registrar y cancelar NO muestra nada cuando se descomenta o simplemente no se ocuparon esos componentes en Libreria.java).
 
    - "Se Ocupan"
    - BotonSeleccion.java : Clase que Hereda de JRadioButton donde solo se crea apartir de un nombre dado.
    - CajaTexto.java : Clase que Hereda de JTextField donde crea dos tipos de JTextfield dependiendo si son numeros o una String lo que recibe.
    - Etiqueta.java : Clase que Hereda de JLabel donde crea una etiqueta con la string que se le de.
    - ListaDesplegable.java :  Clase que Hereda de JComboBox que crea una lista desplegable segun la lista que se le proporcione.
    - "NO se Ocupan"
    - Boton.java : Clase que Hereda de JButton que crea un boton con la string dada y tiene un evento por si lo seleccionan.
    - CasillaVerificacion.java : Clase que hereda de JCheckBox que crea una casilla de verificacion (Como el Radio Button pero cuadrado).
    - Imagen.java : Clase que Hereda de JPanel donde el constructor recibe un Archivo (imagen) y las dimensiones de la imagen, lee la imagen y tiene un metodo para mostrarla.

- Carpeta eventos:
    - ManejadorEventos.java :  Clase que implementa los metodos de ActionListener, recibe un objeto de tipo Libreria, y si detecta que se seleccion un componente especifico, hace algo ya definido.

En resumen es un Programa con registro de Libros y Audio Libros el cual tiene una interfaz grafica donde podemos poner los datos como Titulo y Autor, seleccionar si es de Texto o Audio, y dependiendo de esos especificar que tipo es de cada uno.
Solo que es un programa esta a medias ya que aunque existe el codigo para registrar libros (crear y leer archivos) no lo hace, a su vez como mostrar el panel donde estan los botones de Registrar y Cancelar , y tener clases de componentes que no se ocupan como la de Imagen.java.  

---
#### EJERCICIO 2
Para poder hacer la escritura de archivos se ocupo la serializacion de objetos, en este caso de los objetos Audio y Texto, se creo una carpeta almacen a la altura de la carpeta unam, la cual contiene dos subcarpetas donde se guardaran los archivos de cada registro segun su tipo.

**Nota**: El codigo agregado al programa de este ejercicio esta comentado con Mayusculas y tiene la palabra "EJERCICIO 2"

----
#### EJERCICIO 3
Para poder hacer consulta de los libros se modifico Libreria.java agregando un boton de consulta.
Luego en Administrador.java se agrego un metodo consulta para poder crear dos lista con todos los registros que se hagan en las carpetas y los respectivos metodos de busqueda (por titulo e indice de lista) para poder buscar un libro o audiolibro, en ambos se notifica si se encuentra o no, tambien se puso la opcion de mostrar todos los registros de los libros por texto o por audio.
Finalmente en Manejador de Eventos, se agrego al switch la opcion de que si presionan el boton, los lleve a un submenu para hacer cualquier consulta de cualquier lista.

**Nota**: El codigo agregado al programa de este ejercicio esta comentado con Mayusculas y tiene la palabra "EJERCICIO 3"
