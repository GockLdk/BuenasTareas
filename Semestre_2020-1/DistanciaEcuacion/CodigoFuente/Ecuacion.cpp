#include<iostream>
#include<cmath> // Biblioteca necearia para usar sqrt (Raiz) y pow (potencia)

using namespace std;

// Funcion que recibe numeros double que representan a,b y c en una ecuacion cuadratica
// y obtiene las soluciones de dicha ecuacion
// Usa la formula general para resolverla
void Soluciones(double a,double b,double c)
{
    // Posibles soluciones x1 y x2
    double x1,x2;
    // Imprime la ecuacion
    cout << "Ecuacion: (" << a <<"x^2) + ("<< b <<"x) + (" << c << ") = 0" <<endl;

    // Si que esta dentro de la raiz es negativo 
    if ( (pow(b,2)-4*a*c) < 0)
    {
        // Sus soluciones dentro del campo de los reales no existen
        // Soluciones imaginarias
        cout<<"No es una ecuacion real por lo tanto no tiene soluciones"<<endl;
    }
    else // En caso contrario
    {
        // Obtiene tanto la solucion positiva y negativa de la formual general
        // -b+raiz(b^2-4ac))/(2a)
        x1 = (-b+sqrt(pow(b,2)-4*a*c))/(2*a);
        x2 = (-b-sqrt(pow(b,2)-4*a*c))/(2*a);
        // En caso de que las soluciones sean iguales
        if(x1==x2)
        { 
            // Se dice que entonces es solo una solucion y solo se imprime una
            cout<<"Solo tiene una solucion: "<<endl;
            cout << "x = " << x1 << endl;
        }
        else // En caso que sean diferentes
        {
            // Tiene dos soluciones y se imprimen ambas
            cout<<"Tiene dos soluciones: "<<endl;
            cout << "x1 = " << x1 << endl;
            cout << "x2 = " << x2 << endl;
        }
    }
}

int main()
{
    
    double a,b,c;

    cout <<"a = ";
    cin >> a;
    cout <<"b = ";
    cin >> b;
    cout <<"c = ";
    cin >> c;

    Soluciones(a,b,c);

    return 0;
}