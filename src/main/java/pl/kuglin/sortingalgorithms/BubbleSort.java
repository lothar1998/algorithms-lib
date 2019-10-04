package pl.kuglin.sortingalgorithms;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = array.length - 1; j > i; j--)
                if (array[j].compareTo(array[j - 1]) < 0)
                    swap(array, j, j - 1);
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
