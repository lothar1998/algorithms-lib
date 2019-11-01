package pl.kuglin.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort implements SortingAlgorithm<Integer> {
    @Override
    public void sort(Integer[] array) {

        if (array.length < 1)
            return;

        int min = Collections.min(Arrays.asList(array));
        int max = Collections.max(Arrays.asList(array));

        Integer[] b = new Integer[array.length];
        Integer[] c = new Integer[max - min + 1];

        Arrays.fill(c, 0);

        for (Integer integer : array)
            c[integer - min]++;

        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            b[c[array[i] - min] - 1] = array[i];
            c[array[i] - min]--;
        }

        System.arraycopy(b, 0, array, 0, b.length);
    }

    @Override
    public void sort(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);

        sort(array);

        Collections.copy(list, Arrays.asList(array));
    }
}
