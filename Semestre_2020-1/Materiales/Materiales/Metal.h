// Libreria Metal.h
// Define la estructura que representan a un Metal con todas sus caracteristicas
// Nombre: nombre
// Coeficiente de temperatura : temperatura
// Resistividad: resistividad
// Mejor Aleacion: aleacion
// Tipos/Composicion: composicion
// Aplicaciones: aplicaciones
#include <stdio.h>

// Estructura Material1 con "apodo" Metal
// Contiene apuntadores de caracteres y numeros reales largos (double)
typedef struct Material1 {
	char *nombre;
	double temperatura;
	double resistividad;
	char *aleacion;
	char *composicion;
	char *aplicaciones;
} Metal;  

// Funcion imprimirMetal
// Recibe una variable de tipo Metal y te imprime en pantalla todas sus caracteristicas
// Formato para pura estetica
void imprimirMetal(Metal metal)
{
	printf("\n---> Metal: %s",metal.nombre);
	printf("Temperatura: %.6f",metal.temperatura);
	printf("\nResistividad: %.10f",metal.resistividad);
	printf("\nAleacion: %s",metal.aleacion);
	printf("Composicion: %s",metal.composicion);
	printf("Aplicaciones: %s",metal.aplicaciones);
}
