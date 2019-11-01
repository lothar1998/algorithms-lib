package pl.kuglin.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Bucket sort implementation
 * Algorithm should be used only for uniformly distributed double values from range [0,1)
 */
@SuppressWarnings({"ExplicitArrayFilling", "unchecked"})
public class BucketSort implements SortingAlgorithm<Double> {


    @Override
    public void sort(Double[] array) {

        int n = array.length;

        SortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        LinkedList<Double>[] buckets = new LinkedList[n];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();

        for (Double value : array)
            (buckets[(int) Math.floor(n * value)]).add(value);

        for (LinkedList<Double> singleBucket : buckets)
            insertionSort.sort(singleBucket);

        int i = 0;

        for (LinkedList<Double> singleBucket : buckets)
            for (Double value : singleBucket)
                array[i++] = value;
    }

    @Override
    public void sort(List<Double> list) {

        int n = list.size();

        SortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        LinkedList<Double>[] buckets = new LinkedList[n];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();

        for (Double value : list)
            buckets[(int) Math.floor(n * value)].add(value);

        for (LinkedList<Double> singleBucket : buckets)
            insertionSort.sort(singleBucket);

        int i = 0;

        for (LinkedList<Double> singleBucket : buckets)
            for (Double value : singleBucket)
                list.set(i++, value);
    }

}
