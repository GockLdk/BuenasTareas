#include<iostream>
#include<cmath>

using namespace std;

// Funcion que mide la distancia entre dos numeros 
// Recibe dos string (Para un manejo mas facil) que representan al numero 1 y numero 2
// Se puede ver una string como un arreglo de caracteres
void Distanciadigitos(string num1, string num2)
{
	// Sacamos la cantidad de digitos que contiene cada numero (tamanio)
	int tamanio1 = num1.size();
    int tamanio2 = num2.size();

    // Si la cantidad de digitos difierene
    if( tamanio1 != tamanio2)
    	cout << "Los numeros deben tener los mismos digitos" << endl; // no se puede medir la distancia entre ellos
    else // Si coincide
    {
    	int total[tamanio1]; // Arreglo que contendra el valor absoluto de la resta de los digitos de los numeros
    	int distancia = 0; // Distancia entre ellos
    	// Se va a repetir para cada digito
    	for (int i = 0; i < tamanio1; ++i)
    	{
    		//cout << "Iteracion: " << i << endl;
    		char s = num1.at(i); // Obtiene el caracter en la posicion i del string num1
    		char s1 = num2.at(i);// Obtiene el caracter en la posicion i del string num2
    		int n = (int)s - 48; //Convierte el caracter de num1 en numero (se le resta 48 ya que el casteo incial es en codigo ASCII)
    		int n1 = (int)s1 - 48; //Convierte el caracter de num2 en numero (se le resta 48 ya que el casteo incial es en codigo ASCII)
    		//cout << "num1: " << n << endl;
    		//cout << "num2: " << n1 << endl;
    		total[i] = abs(n - n1); // Guarda el valor absoluto de la rest entre el digito de num1 menos el de num2 en el arreglo total en la posicion i
    	}

    	// Recorremos el arreglo
    	for (int i = 0; i < tamanio1; ++i)
    	{
    		//cout << "total[" << i << "]: " << total[i] << endl;
    		distancia += total[i]; // Vamos sumando los resultado de las restas
    	}
    	// Se imprime la distancia
    	cout << "Distancia entre " << num1 << " y " << num2 << ": " << distancia << endl; 

    }
}

int main()
{
    // String son internamente un arreglo de caracteres o apuntador de caracteres
	string num1;
	string num2;
    

	cout <<"Numero 1 : ";
    // Recomendacion usar la funcion getline ya que scanf y fgets no guardaban el numero 2 en 
    // un apuntador de caracteres o un arreglo de caracteres
    // getline recibe de parametros: 
    // cin : que es la entrada por default
    // num1 : que es una string donde se guardara
	getline(cin, num1);
    
    // Recomendacion usar la funcion getline ya que scanf y fgets no guardaban el numero 2 en 
    // un apuntador de caracteres o un arreglo de caracteres
    // getline recibe de parametros: 
    // cin : que es la entrada por default
    // num2 : que es una string donde se guardara
    cout <<"Numero 2 : ";
	getline(cin, num2);
    
    Distanciadigitos(num1,num2);

	return 0;
}