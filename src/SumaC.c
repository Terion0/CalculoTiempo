#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h> // Necesario para Sleep y GetCurrentProcessId

int generate_random_number() {
    srand(time(NULL) + GetCurrentProcessId()); // Usar GetCurrentProcessId en lugar de getpid
    int delay = rand() % 7 + 2;   // Tiempo aleatorio entre 2 y 8 segundos
    Sleep(delay * 1000);          // Pausa por el tiempo aleatorio (en milisegundos)
    return rand() % 10 + 3;       // Número aleatorio entre 3 y 12
}

int main() {
    int randomNum= generate_random_number();
    printf("%d\n", randomNum);
    return randomNum;
}