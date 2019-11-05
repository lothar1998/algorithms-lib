package pl.kuglin.algorithm;

import java.util.Random;

import static pl.kuglin.Utilities.swap;

/**
 * select i minimum element from array
 * algorithm permutes array
 */
public class ArrayElementSelection {

    private static Random random = new Random();

    private ArrayElementSelection() {
    }

    public static <T extends Comparable<T>> T partitionSelect(T[] array, int p, int r, int i) {
        if (p == r)
            return array[p];

        int q = randomizedPartition(array, p, r);

        int k = q - p + 1;

        if (k == i)
            return array[q];
        else if (i < k)
            return partitionSelect(array, p, q - 1, i);
        else
            return partitionSelect(array, q + 1, r, i - k);
    }

    private static <T extends Comparable<T>> int randomizedPartition(T[] array, int p, int r) {
        swap(array, r, random.nextInt((r - p) + 1) + p);
        return partition(array, p, r);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int p, int r) {
        T x = array[r];

        int i = p - 1;

        for (int j = p; j < r; j++)
            if (array[j].compareTo(x) < 0)
                swap(array, ++i, j);

        swap(array, i + 1, r);

        return i + 1;
    }
}
