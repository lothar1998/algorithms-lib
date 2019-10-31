package pl.kuglin.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort implements SortingAlgorithm<Integer> {
    @Override
    public void sort(Integer[] array) {

        if (array.length < 1)
            return;

        Integer[] b = new Integer[array.length];
        Integer[] c = new Integer[Collections.max(Arrays.asList(array)) + 1];

        Arrays.fill(c, 0);

        for (Integer integer : array)
            c[integer]++;

        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            b[c[array[i]] - 1] = array[i];
            c[array[i]]--;
        }

        System.arraycopy(b, 0, array, 0, b.length);
    }
}
