// Libreria Plastico.h
// Define la estructura que representan a un Plastico con todas sus caracteristicas
// Nombre Corto: nombre
// Nombre Completo: nombreCompleto
// Propiedades: propiedades
// Usos: aplicaciones
#include <stdio.h>

// Estructura Material2 con "apodo" Plastico
// Contiene solamente apuntadores de caracteres
typedef struct Material2 {
	char *nombre;
	char *nombreCompleto; 
	char *propiedades;
	char *aplicaciones;
} Plastico;  

// Funcion imprimirPlastico
// Recibe una variable de tipo Plastico y te imprime en pantalla todas sus caracteristicas
// Formato para pura estetica
void imprimirPlastico(Plastico plastico)
{
	printf("\n---> Plastico: %s",plastico.nombre);
	printf("Nombre: %s",plastico.nombreCompleto);
	printf("Composicion: %s",plastico.propiedades);
	printf("Aplicaciones: %s ",plastico.aplicaciones);
}
