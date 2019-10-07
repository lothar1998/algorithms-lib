package pl.kuglin.arrayalghoritms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubarrayTest {

    @Test
    public void findMaximumSubarray() {
        Double[] arr = {2.0, 5.0, -3.0, -2.0, 4.0, 3.0, -8.0, 1.0};
        MaxSubarray.Result maximumSubarray = MaxSubarray.findMaximumSubarray(arr, 0, arr.length - 1);
        assertEquals(0, maximumSubarray.getLow());
        assertEquals(5, maximumSubarray.getHigh());
        assertEquals(9.0, maximumSubarray.getSum(), 0);
    }
}