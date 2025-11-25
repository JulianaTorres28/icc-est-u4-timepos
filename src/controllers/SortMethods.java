package controllers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortMethods {

    public void sortBubble(int[] numeros){
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] < numeros[j]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
    }

   public void sortBubbleAvan(int[] numeros){
    int[] cp = Arrays.copyOf(numeros, numeros.length);

    for (int i = 0; i < cp.length; i++) {
        boolean swapped = false;
        for (int j = 1; j < cp.length - 1 - i; j++) {
            if (cp[j] < cp[j+1]) {
                int temp = cp[j];
                cp[j] = cp[j+1];
                cp[j+1] = temp;
                swapped = true;
            }
        }
    }
   }
}
