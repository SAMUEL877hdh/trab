import java.util.Scanner;
import javax.swing.JOptionPane;

public class prueba {
    private int numero, suma, creador, repeticion;
    private int[] arreglo;

    public prueba() {
        arreglo = new int[1];
        repeticion = 0;
        numero = 0;
        suma = 0;
        creador = 0;
    }

    public int ingresar() {
        Scanner scanner = new Scanner(System.in);
        if (repeticion == 0) {
            System.out.println("Ingrese número o letra para salir:");
            repeticion++;
        } else {
            System.out.println("");
        }

        if (scanner.hasNextInt()) {
            numero = scanner.nextInt();
            return numero;
        } else {
            scanner.close(); // Cerrar Scanner
            return -1;
        }
    }

    public boolean esPrimo(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public void mostrar() {
        if (esPrimo(numero)) {
            System.out.println("El numero " + numero + " es primo");
            if (creador >= arreglo.length) {
                int[] temp = new int[arreglo.length * 2];
                System.arraycopy(arreglo, 0, temp, 0, arreglo.length);
                arreglo = temp;
            }
            arreglo[creador++] = numero;
        } else {
            System.out.println("El numero " + numero + " no es primo");
        }
    }

    public void mostrarArregloPrimos() {
        System.out.println("Arreglo de números primos:");
        for (int i = 0; i < creador; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        prueba prueba = new prueba();
        int numeroIngresado;

        do {
            numeroIngresado = prueba.ingresar();
            if (numeroIngresado >= 0)
                prueba.mostrar();
        } while (numeroIngresado >= 0);
        prueba.mostrarArregloPrimos();
    }
}

