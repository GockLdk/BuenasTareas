// ARCHIVO PRINCIPAL
// PROGRAMA QUE SIMULA UNA BASE DE DATOS DE MATERIALES (METALES Y PLASTICOS)
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
// SE INCLUYEN PARA TENER LOS TIPOS DE DATOS METAL Y PLASTICO.
#include "Metal.h"
#include "Plastico.h"

// PARA SIMULAR LA BASE DE DATOS TENEMOS DOS VARIABLES GLOBALES
// QUE SON DOS ARREGLOS QUE ALMACENARAN METALES (metales) y PLASTICOS (plasticos) 
// RESPECTIVAMENTE.
// DE INICIO ESTAN VACIOS HASTA QUE SE USE LA FUNCION inicializarBaseDeDatos
// NOTA: SI SE DESEA CAMBIAR EL TAMANIO, RECORDAR DE CAMBIAR EL VALOR EN LOS
// ARREGLOS Y FUNCIONES mostrarMetales,mostrarPlasticos,registroMetal,registroPlastico,
// buscarMetal Y buscarPlastico.
Metal metales[20];
Plastico plasticos[20];

// VARIABLES GLOBALES
// CONTADORES DEL TOTAL DE METALES Y PLASTICOS REGISTRADOS
// TIENE VALOR DIFERENTE DE CERO DEBIDO A QUE SE VA A USAR LA FUNCION inicializarBaseDeDatos
// EN CASO DE NO USARLA SE DEBE IGUALAR A CERO.
int totalMetales = 2;
int totalPlasticos = 3;

// FUNCION mostrarMetales
// RECORRE EL ARREGLO Y MIENTRAS LA CASILLA TENGA UN REGISTRO
// IMPRIME LOS DATOS DE ESE REGISTRO (METAL)
void mostrarMetales()
{
	int i;
	printf("\n***Catalogo de Metales***");
	printf("\nTotales: %d\n",totalMetales);
	for (i = 0;i<20;i++)
	{
		if(metales[i].nombre != NULL) // SI HAY UN REGISTRO (NOMBRE NO ES IGUAL A NULL)
			imprimirMetal(metales[i]);	// LO IMPRIME
	}	
}

// FUNCION mostrarPlasticos
// RECORRE EL ARREGLO Y MIENTRAS LA CASILLA TENGA UN REGISTRO
// IMPRIME LOS DATOS DE ESE REGISTRO (PLASTICO)
void mostrarPlasticos()
{
	int i;
	printf("\n***Catalogo de Plasticos***");
	printf("\nTotales: %d\n",totalPlasticos);
	for (i = 0;i<20;i++)
	{
		if(plasticos[i].nombre != NULL) // SI HAY UN REGISTRO (NOMBRE NO ES IGUAL A NULL)
			imprimirPlastico(plasticos[i]);	// LO IMPRIME
	}	
}

// FUNCION registroMetal
// FUNCION QUE RESGISTRA UN METAL CON LOS DATOS DATOS POR EL USUARIO
// MIENTRAS NO SE SOBREPASE EL LIMITE DEL ARREGLO metales
// PEDIRA TODOS LOS DATOS CORRESPONDIENTES DEL METAL
// Y LOS GUARDARA EN LA SIGUIENTE POSICION LIBRE DEL ARREGLO
void registroMetal()
{
	if(totalMetales < 20) // MIENTRAS NO SE SOBREPASE EL LIMITE
	{
		char nombre[20]; // NOMBRE DE MAX 20 CARACTERES
		double temp; 
		double resis;
		char ale[50]; // ALEACION MAX 50 CARACTERES
		char comp[200]; // COMPOSICION MAX 200 CARACTERES
		char apli[200]; // APLICACIONES MAX 200 CARACTERES
		
		// PIDE LOS DATPS CORRESPONDIENTES
		printf("\n** Registro Metal**\nFavor de proporcionar los datos correspondientes\n");
		getchar();
		printf("Nombre del Metal: ");
		fgets(nombre, sizeof(nombre), stdin);
		printf("Temperatura: ");
		scanf("%lf",&temp);
		printf("Resistividad: ");
		scanf("%lf",&resis);
		getchar(); // GETCHAR PARA ATRAPAR EL ENTER DE RESISTIVIDAD Y QUE NO LO AGARRE LA SIGUIENTE FUNCION FGETS
		printf("Mejor Aleacion: ");
		fgets(ale, sizeof(ale), stdin);
		printf("Composicion: ");
		fgets(comp, sizeof(comp), stdin);
		printf("Aplicaciones o Usos: ");
		fgets(apli, sizeof(apli), stdin);	
		
		// PARA CADA UNO EN LA SIGUIENTE POSICION LIBRE "POSICION[totalMetales]"
		// NOMBRE 
		metales[totalMetales].nombre = (char *) malloc(strlen(nombre)+1); // APARTA LA MEMORIA PARA EL NOMBRE QUE DIO EL USUARIO
		strcpy(metales[totalMetales].nombre,nombre); // COPIA EL NOMBRE QUE DIO EL USUARIO EN LA CARACTERISTICA NOMBRE
		// TEMPERATURA
		metales[totalMetales].temperatura = temp; // GUARDA LA TEMPERATURA
		// RESISTIVIDAD
		metales[totalMetales].resistividad = resis; // GUARDA LA RESISTIVIDAD
		// ALEACION
		metales[totalMetales].aleacion = (char *) malloc(strlen(ale)+1);
		strcpy(metales[totalMetales].aleacion,ale);
		// COMPOSICION
		metales[totalMetales].composicion = (char *) malloc(strlen(comp)+1);
		strcpy(metales[totalMetales].composicion,comp);
		// APLICACIONES
		metales[totalMetales].aplicaciones = (char *) malloc(strlen(apli)+1);
		strcpy(metales[totalMetales].aplicaciones,apli);
		
		// COMPROBACION DE QUE SE GUARDO CORRECTAMENTE
		//imprimirMetal(metales[totalMetales]);
		
		totalMetales ++; // AUMENTA CONTADOR DE METALES
		printf("\n**REGISTRO EXITOSO**\n");
	}
	else // EN CASO CONTRARIO SE NOTIFICA
	{
		printf("\n ** NO SE PUEDE REGISTRAR MAS METALES **\n-- Limite 20 metales registrados --\n");
	}
}

// FUNCION registroPlastico
// FUNCION QUE RESGISTRA UN PLASTICO CON LOS DATOS DATOS POR EL USUARIO
// MIENTRAS NO SE SOBREPASE EL LIMITE DEL ARREGLO plasticos
// PEDIRA TODOS LOS DATOS CORRESPONDIENTES DEL PLASTICO
// Y LOS GUARDARA EN LA SIGUIENTE POSICION LIBRE DEL ARREGLO
void registroPlastico()
{
	if(totalPlasticos < 20) // MIENTRAS NO SE SOBRE PASE LE LIMITE
	{
		char nombre[20]; // NOMBRE DE MAX 20 CARACTERES
		char nombreComp[50]; // NOMBRE COMPLETO DE MAX 50 CARACTERES
		char propi[200]; // PROPIEDADES MAX 200 CARACTERES
		char apli[200]; // USOS MAX 200 CARACTERES
		
		// SOLICITA LOS DATOS AL USUARIO
		printf("\n** Registro Plastico**\nFavor de proporcionar los datos correspondientes\n");
		getchar();
		printf("Nombre del Plastico: ");
		fgets(nombre, sizeof(nombre), stdin);
		printf("Nombre Completo: ");
		fgets(nombreComp, sizeof(nombreComp), stdin);
		printf("Composicion: ");
		fgets(propi, sizeof(propi), stdin);
		printf("Aplicaciones o Usos: ");
		fgets(apli, sizeof(apli), stdin);	
		
		// PARA CADA UNO EN LA SIGUIENTE POSICION LIBRE "POSICION[totalPlasticos]"
		// NOMBRE CORTO
		plasticos[totalPlasticos].nombre = (char *) malloc(strlen(nombre)+1); // RESERVA EL ESPACIO PARA EL NOMBRE DADO POR EL USUARIO
		strcpy(plasticos[totalPlasticos].nombre,nombre); // COPIA EL NOMBRE QUE DIO EL USUARIO EN EL ATRIBUTO DE NOMBRE
		// NOMBRE COMPLETO
		plasticos[totalPlasticos].nombreCompleto = (char *) malloc(strlen(nombreComp)+1); 
		strcpy(plasticos[totalPlasticos].nombreCompleto,nombreComp);
		// PROPIEDADES
		plasticos[totalPlasticos].propiedades = (char *) malloc(strlen(propi)+1);
		strcpy(plasticos[totalPlasticos].propiedades,propi);
		// USOS
		plasticos[totalPlasticos].aplicaciones = (char *) malloc(strlen(apli)+1);
		strcpy(plasticos[totalPlasticos].aplicaciones,apli);
		
		// COMPROBACION DE QUE SE GUARDADON LOS DATOS
		//imprimirMetal(metales[totalMetales]);
		
		totalPlasticos ++; // AUMENTA EL CONTADOR DE PLASTICOS
		printf("\n**REGISTRO EXITOSO**\n");
	}
	else // EN CASO CONTRARIO SE NOTIFICA
	{
		printf("\n ** NO SE PUEDE REGISTRAR MAS PLASTICOS **\n-- Limite 20 plasticos registrados --\n");
	}
}

// FUNCION buscarMetal
// RECIBE UN APUNTADOR DE CARACTERES QUE ES EL NOMBRE DEL METAL A BUSCAR
// RECORRE EL ARREGLO COMPARANDO EL NOMBRE CORTO DEL PLASTICO CON EL QUE DIO EL CLIENTE
// SI ENCUENTRA EL METAL LO NOTIFICA Y MUESTRA CARACTERISTICAS
// EN CASO CONTRARIO NOTIFICA QUE NO SE ENCONTRO 
void buscarMetal(char *metalNom)
{
	int i;
	int encontrado = 0;
	for(i = 0; i<20 ; i++ )
	{
		if(metales[i].nombre != NULL) // SI EN LA CASILLA DEL ARREGLO HAY UN REGISTRO DE UN METAL (NOMBRE NO ES IGUAL A NULL)
		{
			if(strcmp(metales[i].nombre, metalNom)==0) // COMPARA SU NOMBRE CON EL QUE DIO EL USUARIO Y EN CASO DE QUE COINCIDAN
			{
				printf("\n-- METAL ENCONTRADO--\n");
				imprimirMetal(metales[i]); // IMPRIME LOS DATOS DEL METAL
				encontrado = 1; // SE MARCA QUE FUE ENCONTRADO
			}
		}
	}
	if(encontrado == 0) // SI NO SE MARCO QUE SE ENCONTRO EL METAL
	{
		printf("\n-- METAL NO ENCONTRADO--\n"); // LO NOTIFICA
	}
}

// FUNCION buscarPlastico
// RECIBE UN APUNTADOR DE CARACTERES QUE ES EL NOMBRE DEL PLASTICO A BUSCAR
// RECORRE EL ARREGLO COMPARANDO EL NOMBRE CORTO DEL PLASTICO CON EL QUE DIO EL CLIENTE
// SI ENCUENTRA EL PLASTICO LO NOTIFICA Y MUESTRA CARACTERISTICAS
// EN CASO CONTRARIO NOTIFICA QUE NO SE ENCONTRO 
void buscarPlastico(char *plasticoNom)
{
	int i;
	int encontrado = 0;
	for(i = 0; i<20 ; i++ )
	{
		if(plasticos[i].nombre != NULL) // SI EN LA CASILLA DEL ARREGLO HAY UN REGISTRO DE UN PLASTICO (NOMBRE NO ES IGUAL A NULL)
		{
			if(strcmp(plasticos[i].nombre, plasticoNom)==0) // COMPARA SU NOMBRE CON EL QUE DIO EL USUARIO Y EN CASO DE QUE COINCIDAN
			{
				printf("\n-- PLASTICO ENCONTRADO--\n");
				imprimirPlastico(plasticos[i]); // IMPRIME LOS DATOS DEL PLASTICO
				encontrado = 1; // SE MARCA QUE FUE ENCONTRADO
			}
		}
	}
	if(encontrado == 0) // SI NO SE MARCO QUE SE ENCONTRO
	{
		printf("\n-- PLASTICO NO ENCONTRADO--\n"); // MUESTRA QUE NO SE ENCONTRO
	}
}

// FUNCION registroMaterial	
// DEPENDIENDO DEL TIPO SE LLAMARA A LA FUNCION REGISTRO CORRESPONDIENTE
void registroMaterial(int tipo)
{
	if(tipo == 1)
	{
		registroMetal();
	}
	else if(tipo == 2)
	{
		registroPlastico();
	}
}

// FUNCION busquedMaterial
// DEPENDIENDO DEL TIPO (1 O 2) SE LE PREGUNTARA AL USUARIO SI QUIERE VER TODO EL CATALOGO
// DE ESE TIPO, EN CASO DE QUE ASI LO QUIERE SE LE MOSTRARA TODO EL CATALOGO
// EN CASO CONTRARIO SE HARA UNA CONSULTA POR NOMBRE
void busquedaMaterial(int tipo)
{
	char nomBusqueda[15];
	int todos = 2; // VARIABLE QUE DEFINE SI VER O NO EL CATALOGO
	printf("\nDesea ver todo el catalogo?\n1.-Si\n2.-No\nOpcion: ");
	scanf("%d",&todos);
	if(todos == 1)
	{
		if(tipo == 1);
			mostrarMetales();
		if(tipo == 2)
			mostrarPlasticos();
	}
	if(todos == 2)
	{
		printf("\n**Busqueda Especifica (Por Nombre)**");
		printf("\nFavor de teclear el nombre del material a buscar\n*Para confirmar teclee Enter*\nMaterial: ");
		//scanf("%s",nomBusqueda);
		getchar();
		fgets(nomBusqueda, sizeof(nomBusqueda), stdin);
		if(tipo == 1)
		{
			//printf("Buscando tipo 1");
			buscarMetal(nomBusqueda);	// BUSCA EL METAL POR EL NOMBRE DADO
		}	
		else if (tipo == 2)
		{
			//printf("buscando tipo 2");
			buscarPlastico(nomBusqueda); // BUSCA EL PLASTICO POR EL NOMBRE DADO
		}
	}
}

// INICIALIZACION DE LA BASE DE DATOS
// PARA SIMULAR LA BASE DE DATOS LOS ARREGLOS metales Y plasticos QUE ESTAN VACIOS
// SE LES VAN A AGREGAR ELEMENTOS, ESPECIFICAMENTE A metales SE LE AGREGARAN 2 METALES 
// Y A plasticos SE LES AGREGARA 3 PLASTICOS
void inicializarBaseDeDatos()
{	
	// SE AGREGAN EL METAL Aluminio CON TODAS SUS CARACTERISTICAS EN LA POSICION 0 DE metales
	metales[0].nombre = "Aluminio\n";
	metales[0].temperatura = 0.0039;
	metales[0].resistividad = 0.000000028;
	metales[0].aleacion = "Cuproaluminio\n";
	metales[0].composicion = "Aleacion de cobre y aluminio.\n";
	metales[0].aplicaciones = "Helices de barco,turbinas,etc.\n";
	
	// SE AGREGAN EL METAL Cobre CON TODAS SUS CARACTERISTICAS EN LA POSICION 1 DE metales
	metales[1].nombre = "Cobre\n";
	metales[1].temperatura = 0.0039;
	metales[1].resistividad = 0.000000017;
	metales[1].aleacion = "Bronce\n";
	metales[1].composicion = "Ordinario. Solo lleva cobre y estanio(5-30%).\nEspecial. Lleva cobre, estanio y otros elementos quimicos.\n";
	metales[1].aplicaciones = "Esculturas y cables electricos.\n";

	// SE AGREGAN EL PLASTICO PET CON TODAS SUS CARACTERISTICAS EN LA POSICION 0 DE plasticos
	plasticos[0].nombre = "PET\n" ;
	plasticos[0].nombreCompleto = "Polietilen Tereflalato\n";
	plasticos[0].propiedades = "Contacto alimentario, resistencia fisica, propiedades termicas, propiedades barreras, ligereza y resistencia quimica.\n" ;
	plasticos[0].aplicaciones = "Bebidas, refrescos y agua, envases para alimentos (aderezos, mermeladas, jaleas, cremas, etc.).\n" ;
	
	// SE AGREGAN EL PLASTICO HDPE CON TODAS SUS CARACTERISTICAS EN LA POSICION 1 DE plasticos
	plasticos[1].nombre = "HDPE\n" ;
	plasticos[1].nombreCompleto = "Polietileno de alta densidad\n" ;
	plasticos[1].propiedades = "Poco flexible, resistente a quimicos, opaco, facil de pigmentar, fabricar y manejar. Se suaviza a los 75 grados Centigrados.\n" ;
	plasticos[1].aplicaciones = "Algunas bolsas de supermercado, bolsas para congelar, envases para leche, helados, jugos, shampoo, quimicos y detergentes, cubetas, tapas, etc.\n" ;
	
	// SE AGREGAN EL PLASTICO PVC CON TODAS SUS CARACTERISTICAS EN LA POSICION 2 DE plasticos
	plasticos[2].nombre = "PVC\n" ;
	plasticos[2].nombreCompleto = "Policloruro de vinilo\n" ;
	plasticos[2].propiedades =  "Es duro, resistente, puede ser claro, puede ser utilizado con solventes, se suaviza a los 80 grados Centigrados. Flexible, claro, elastico, puede ser utilizado con solventes.\n" ;
	plasticos[2].aplicaciones = "Envases para plomeria, tuberias 'blister packs', envases en general, mangueras, suelas para zapatos, cables, correas para reloj.\n";
	
	/* 
	// COMPROBACION DE QUE SE INICIALIZARON LOS ARREGLOS (BASE DE DATOS) CON 2 METALES Y 3 PLASTICOS
	imprimirMetal(metales[0]);
	imprimirMetal(metales[1]);
	imprimirPlastico(plasticos[0]);
	imprimirPlastico(plasticos[1]);
	imprimirPlastico(plasticos[2]);
	*/
}	

// MENU DE REGISTRO DE MATERIALES
// MIESTRAS EL USUARIO LO DESEE Y RESPETE EL LIMITE DE LOS ARREGLOS
// PODRA REGISTRAR METALES Y PLASTICOS ADICIONALES
// TIPO 1: METALES
// TIPO 2: PLASTICOS
void menuRegistro()
{
	int opc = 1;
	int tipo = 0;
	while(opc!=0)
	{
		printf("\n***Registro de Materiales***\n");
		printf("Que tipo de material quiere Registrar?\nTeclee el numero de la opcion deseada\n1.-Metal\n2.-Plastico\n3.-Regresar\nOpcion:");
		scanf("%d",&tipo);
		switch(tipo)
		{
			case 1:
				tipo = 1;
				registroMaterial(tipo);
			break;
			
			case 2:
				tipo = 2;
				registroMaterial(tipo);
			break;
			
			case 3:
				opc = 0;
			break;
			
			default:
				printf("Opcion Invalida\n");
			break;
		}
	}
}

// MENU CONSULTA
// MIENTRAS EL USUARIO QUIERA PODRA CONSULTAR EL CATALOGO DE PLASTICOS O METALES
// TIPO 1: METALES
// TIPO 2: PLASTICOS
void menuConsulta()
{
	int opc = 1;
	int tipo = 0;
	while(opc!=0)
	{
		printf("\n***Consulta de Materiales***\n");
		printf("Que tipo de material quiere Consultar?\nTeclee el numero de la opcion deseada\n1.-Metal\n2.-Plastico\nOpcion:");
		scanf("%d",&tipo);
		switch(tipo)
		{
			case 1:
				tipo = 1;
				busquedaMaterial(tipo);
			break;
			
			case 2:
				tipo = 2;
				busquedaMaterial(tipo);
			break;
			
			default:
				printf("Opcion Invalida\n");
			break;
		}
		
		printf("\n### Desea hacer otra Consulta? ###\nTeclee el numero de la opcion deseada\n1.-Si\n2.-No\nOpcion:");
		scanf("%d",&opc);
		switch(opc)
		{
			case 1:
			break;
			
			case 2:
				opc = 0;
			break;
			
			default:
				printf("Opcion Invalida\n");
			break;
		}
	}
}

// SI DESEAS PROBAR UN MAIN DESCOMENTALO Y COMENTA TODOS LOS DEMAS
// MENU PRINCIPAL O DE BIENVENIDA
// MIENTRAS EL USUARIO QUIERA PODRA ENTRAR A LOS SUBMENUS PARA CONSULTAR O REGISTRAR METALES O PLASTICOS
int main()
{
	int opc;
	inicializarBaseDeDatos();
	while(opc!=3)
	{
		printf("\n***Bases de Datos de Materiales***\n");
		printf("Teclee el numero de la opcion deseada\n1.-Registro\n2.-Consulta\n3.-Salir\nOpcion: ");
		scanf("%d",&opc);
		switch(opc)
		{
			case 1:
				//printf("Registro\n");
				menuRegistro();
			break;
			
			case 2:
				//printf("Menu consulta\n");
				menuConsulta();
			break;
			
			case 3:
				// SIMULACION DE LIMPIAR PANTALLA DE CONSOLA
				printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				printf("Hasta Luego");
			break;
			
			default:
				printf("Opcion Invalida\n");
			break;
		}	
	}
	return 0;
}

// PRUEBA DE LA INICIALIZACION DE LA BASE DE DATOS Y EL COMPARAR APUNTADORES DE CARACTERES
/*
int main()
{
	inicializarBaseDeDatos();
	char *nom = "PET";
	printf("%d",strcmp(plasticos[0].nombre, nom));
	return 0;
}*/

// PRUEBA DE LA BIBLIOTECA METAL.H
/*
int main()
{
	char nombre[20] = "oro";
	char ale[50] = "No se que sea eso :'3";
	char comp[150] = "Amarrillo bien brilloso";
	char apli[100] = "Inversion";
	
	Metal metal = {.nombre = nombre, .temperatura = 21.89,.resistividad = 89.08,.aleacion = ale,.composicion = comp, .aplicaciones = apli};
	imprimirMetal(metal);
	
	
	return 0;
}
*/
// PRUEBA DE LA BILBIOTECA PLASTICO.H
/*
int main()
{
	char nombre[20] = "PVC";
	char nombreCom[20] = "Ploricloruro de vinilo"
	char comp[150] = "Duro,Resistente,claro,Flexibe,caro";
	char apli[100] = "Envases para plomeria, tuberias,etc.";
	
	Plastico plastico = {.nombre = nombre, .nombreCompleto = nombreCom,.propiedades = comp, .aplicaciones = apli};
	imprimirPlastico(plastico);
	
	return 0;
}*/
