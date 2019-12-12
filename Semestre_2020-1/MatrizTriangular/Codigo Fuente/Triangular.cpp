#include<iostream>

using namespace std;

int main ()

{
    // Variable a ocupar
    // i y j: para recorrer la matriz
    // m: numero de filas
    // ut: indica si la matriz es triangular superior (ut = 0) por defecto ut = 0
    // ul: indica si la matriz es triangular inferior (ul = 0) por defecto ul = 0
    // A[50][50]: Matriz maxima que recibe (50x50)
    // res[100]: Arreglo de respuestas (maximo de 100 matrices a ingresar)
    //           2 = Si es una matriz triangular
    //           1 = No es una matriz triangular
    //           Nota: No se ocupo el 0 ya que por defecto C++ llena un arreglo de 0 cuando se declara
    // cont; Contador para saber el numero de matrices ingresadas al momento y en que casilla guardar la respuesta en el arreglo de respuestas por defecto cont = 0
    int i, j, m = -1 ,ut = 0, lt = 0, A[50][50], res[100],cont=0;
    
    cout << "***Matriz Triangular o NO Triangular***\n" ;

    // Mientras el numero de renglones no sea 0
    while(m!=0)
    {   
        cout << "Ingresa el numero de filas de la matriz cuadrada: ";
        // Ingresa el numero de filas
        cin >> m ;

        // Si m es menor a 0
        if (m < 0)
        {
            // Es una matriz invalida y se sale del programa
            cout << "Matriz cuadrada invalida!" << endl;;
            exit(0); 

        }
        // Si es m es mayor a 50 
        if (m > 50)
        {
            // Es una matriz mayor a la aceptada y se sale del programa
            cout << "Matriz cuadrada excede el limite 50x50!" << endl;;
            exit(0);
        }
        // Si m es diferente de 0 (Esto para evitar que haga una matriz demas y salga una respuesta de mas al final)
        if(m!=0)
        {
            cout << "Ingresa los elementos de la matriz: " << endl;
            // Se ingresa los elementos en la matriz hasta que llegue a m
            for (i = 0; i < m; i++)
                for (j = 0; j < m; j++)	
                {
                    cout << "matriz[" << i <<"][" << j <<"]: ";
                    cin >> A[i][j];
                    // Si j es mayor que i (En pocas palabras que la casilla este sobre la diagonal)
                    // y el elemento de esa casilla es diferente de 0 
                    if( j > i && A[i][j] != 0)
                        ut = 1; // Se marca que es una matriz no triangular superior
                    // Si j es menor que i (En pocas palabras que la casilla este debajo de la diagonal)
                    // y el elemento de esa casilla es diferente de 0
                    if( j < i && A[i][j] != 0) 
                        lt = 1; // Se marca que es una matriz no triangular inferior
                }

            // Se recorre la matriz hasta m para imprimirla y notificar que numero de matriz es hasta el momento
            cout << "\nMatriz " << cont+1 <<": " << endl;
            cout << " ";
            for (i = 0; i < m; i++)
            {
                for (j = 0; j < m; j++) 
                    cout << A[i][j] << " ";
                cout << "\n ";
            }
            cout << "\n";


            // Se verifica ut y ul
            if( ut == 0 || lt == 0) // Si la matriz es triangular superior o inferior
                res[cont] = 2; // Se guarda como respuesta que si en el arreglo de respuestas en la posicion vaya marcando el contador de matrices ingresadas "cont" 
            else // En caso de que no se triangular superior o inferior
                res[cont] = 1; //Se guarda como respuesta que no en el arreglo de respuestas en la posicion vaya marcando el contador de matrices ingresadas "cont" 
            
            cont++; // Aumenta el contador
            
            // Una vez guardado la respuesta se borran los datos de la matriz y se ponen ceros
            // Esto para evitar que revulevan datos 
            for (i = 0; i < m; i++)
                for (j = 0; j < m; j++) 
                    A[i][j] = 0;

            // Se vuelven a marcar ut y lt como 0
            ut = 0; 
            lt = 0;
        }
    }

    cout << "\nMatriz Triangular?\n" << endl;
    // Se imprimen las respuetas de cada matriz que se ingreso
    for(i = 0; i<100;i++)
    {   
        if(res[i] == 2) // Si es un 2
        {
            // Imprime que si es una matriz triangular
            cout << "Matriz " << i+1 << ": ";
            cout << "SI" << endl;
        }
        if (res[i] == 1) // Si es un 1
        {
            // Imprime que no es una matriz triangular
            cout << "Matriz " << i+1 << ": ";
            cout << "NO" << endl;
        }
    }
    
    cout << "\nHasta Luego :)" <<endl;
   
    return 0;
}