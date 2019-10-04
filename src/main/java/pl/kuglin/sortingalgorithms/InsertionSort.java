package pl.kuglin.sortingalgorithms;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        if (array.length < 2)
            return;

        T key;
        int i;

        for (int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;

            while (i >= 0 && array[i].compareTo(key) > 0) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
    }
}
