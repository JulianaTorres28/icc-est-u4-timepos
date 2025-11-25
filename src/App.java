import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) throws Exception {

        // long inicio_millis = System.currentTimeMillis();

        // long inicio = System.nanoTime();
        // for (int i = 0; i < 100000; i++) {
        // String s = "Numero: " + i;
        // System.out.println(s);
        // }

        // long fin = System.nanoTime();
        // System.out.println("Tiempo transcurrido: " + (fin - inicio) + "
        // nanosegundos.");
        // System.out.println("Tiempo transcurrido: " + (fin - inicio) / 1_000_000_000.0
        // + " segundos.");// divide y da respuesta en decimal
        // System.out.println("Tiempo transcurrido: " + (fin - inicio) / 1000000000L + "
        // segundos.");// L es long, por eso redondea

        // Results result = new Results(
        // 1,
        // "Imprimir 100000 numeros",
        // (fin - inicio) / 1_000_000_000.0);
        // System.out.println(result);

        int[] originalArray = generate(100000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array50000 = new int[50000];
        System.arraycopy(originalArray, 0, array50000, 0, 50000);

        int[] array10000 = new int[10000];
        System.arraycopy(originalArray, 0, array10000, 0, 10000);

        int[] array100000 = new int[100000];
        System.arraycopy(originalArray, 0, array100000, 0, 100000);

        int[] array250000 = new int[25000];
        System.arraycopy(originalArray, 0, array250000, 0, 25000);

        int[][] arrays = { array1000, array10000, array250000, array50000, array100000, originalArray};
        SortMethods sorter = new SortMethods();

        for (int[] array : arrays) {
            int size = array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortBubble(array);
                return null;
            };
            Results result = BenchMarking.medir_tiempo(funCallable, size, "Bubble Sort");
            System.out.println(result);

        }

    }

    public static void funcion1() {
        for (int i = 0; i < 100000; i++) {
            String s = "Numero " + i;
            System.out.println(s);
        }
    }

    public static int[] generate(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = (int) (Math.random() * 10000);
        }
        return numeros;
    }

}
