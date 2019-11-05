package pl.kuglin.datastructure;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class HeapPriorityQueueTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int ARRAY_MAX_SIZE = 1000;
    private static final int MAX_ARRAY_VALUE = 1000;

    private Random random = new Random();

    @Test
    public void testInt() {

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            HeapPriorityQueue<Integer> queue = new HeapPriorityQueue<>();

            for (int j = 0; j < ARRAY_MAX_SIZE; j++) {
                int temp = random.nextInt(MAX_ARRAY_VALUE);
                queue.insert(temp, temp);
            }

            boolean isProperOrder = true;

            int previous = Integer.MAX_VALUE;

            while (queue.max() != null) {
                Integer temp = queue.extractMax();

                if (temp > previous)
                    isProperOrder = false;

                previous = temp;
            }

            assertTrue(isProperOrder);
        }
    }

}