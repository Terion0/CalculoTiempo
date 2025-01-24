import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Esta clase mide los tiempos entre python y C.
 *
 * @author José María y Rodrigo
 * @version 1.0
 */
public class Main {
    /**
     * Main
     * En el se encuentra la ejecución del programa
     *
     *
     */
    public static void main(String[] args) {

        try {
            long comienzoPy = System.currentTimeMillis();
            int resultadoPython = 1;
            for (int i = 0; i < 3; i++) {
                resultadoPython *= ejecutarComandoYdevolverDato("python src\\SumaPython.py");
            }
            long FinPy = System.currentTimeMillis();
            int tiempoPy =devolverDiferencia(comienzoPy,FinPy);
            long ComienzoC = System.currentTimeMillis();
            int ResultadoC = 1;
            for (int i = 0; i < 3; i++) {
                ResultadoC *= ejecutarComandoYdevolverDato("src\\SumaC.exe");
            }
            long FinalC = System.currentTimeMillis();
            int TiempoC =devolverDiferencia(ComienzoC,FinalC);
           resultadosPython(tiempoPy,resultadoPython);
           resultadosC(TiempoC,ResultadoC );
           sumarResultados(resultadoPython,ResultadoC);
           lenguajeMasRapido(tiempoPy, TiempoC);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /**
 * Muestra los resultados de la ejecución en Python.
 *
 * @param tiempoPy el tiempo que tardó el programa en ejecutarse en segundos
 * @param resultadoPy el resultado del programa
 */
public static void resultadosPython(int tiempoPy, int resultadoPy) {
    System.out.println("Resultado Python: " + resultadoPy);
    System.out.println("Tiempo python: " + tiempoPy + " segundos");
}

/**
 * Muestra los resultados de la ejecución  en C.
 *
 * @param tiempoC el tiempo que tardó el programa en ejecutarse en segundos
 * @param resultadoC el resultado del programa
 */
public static void resultadosC(int tiempoC, int resultadoC) {
    System.out.println("Resultado c: " + resultadoC);
    System.out.println("Tiempo c: " + tiempoC + " segundos");
}

/**
 * Muestra la suma de los resultados de la ejecución de los dos programas.
 *
 * @param resultPy el resultado del programa en Python
 * @param resultC el resultado del programa en C
 */
public static void sumarResultados(int resultPy, int resultC) {
    System.out.println("Resultado total: " + resultPy + resultC);
}

/**
 * Calcula la diferencia de tiempo entre dos momentos en milisegundos.
 *
 * @param Comienzo el momento de inicio en milisegundos
 * @param Final el momento de fin en milisegundos
 * @return la diferencia de tiempo en segundos
 */
public static int devolverDiferencia(long Comienzo, long Final) {
    return (int) (Final - Comienzo) / 1000;
}

/**
 * Determina qué lenguaje de programación es más rápido en función de los tiempos de ejecución.
 *
 * @param tiempoPy el tiempo que tardó el programa en Python en ejecutarse en segundos
 * @param tiempoC el tiempo que tardó el programa en C en ejecutarse en segundos
 */
public static void lenguajeMasRapido(int tiempoPy, int tiempoC) {
    if (tiempoPy < tiempoC) {
        System.out.println("Python es más rápido.");
    } else if (tiempoPy > tiempoC) {
        System.out.println("C es más rápido.");
    } else {
        System.out.println("Sorprendentemente ambos lenguajes tardan lo mismo.");
    }
}

/**
 * Ejecuta un comando en la consola y devuelve el resultado como un entero.
 *
 * @param comando el comando a ejecutar
 * @return el resultado del comando como un entero
 * @throws Exception si ocurre un error al ejecutar el comando
 */
private static int ejecutarComandoYdevolverDato(String comando) throws Exception {
    Process process = Runtime.getRuntime().exec(comando);
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String linea = reader.readLine();
    process.waitFor();
    return Integer.parseInt(linea.trim());
}
}
