package pl.kuglin.algorithm;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.kuglin.Utilities;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class RadixSortTest {

    private static final int MAX_RAND_VALUE = 10; //maximum 10, because we have only 10 digits in decimal system
    private static final int NUMBER_OF_OBJECTS = 1000;

    private static RadixSort<A> radixSort;
    private static List<A> list;
    private static Comparator<A> A;
    private static Comparator<A> B;
    private static Comparator<A> C;
    private static Random random;

    @BeforeClass
    public static void setUpBeforeAll() {

        radixSort = new RadixSort<>();
        random = new Random();

        list = new LinkedList<>();

        A = Comparator.comparing(o -> o.getA());
        B = Comparator.comparing(o -> o.getB());
        C = Comparator.comparing(o -> o.getC());
    }

    private Integer getSharedValue(A obj, Order order) {
        String text = "";
        switch (order) {
            case ABC:
                text = String.valueOf(obj.getA()) + obj.getB() + obj.getC();
                break;
            case ACB:
                text = String.valueOf(obj.getA()) + obj.getC() + obj.getB();
                break;
            case BAC:
                text = String.valueOf(obj.getB()) + obj.getA() + obj.getC();
                break;
            case BCA:
                text = String.valueOf(obj.getB()) + obj.getC() + obj.getA();
                break;
            case CAB:
                text = String.valueOf(obj.getC()) + obj.getA() + obj.getB();
                break;
            case CBA:
                text = String.valueOf(obj.getC()) + obj.getB() + obj.getA();
                break;
        }

        return Integer.valueOf(text);
    }

    private boolean isProperlyOrdered(Order order) {
        boolean isProperOrder = true;

        Integer actualItem;
        Integer previousItem;

        for (int i = 1; i < list.size(); i++) {
            actualItem = getSharedValue(list.get(i), order);
            previousItem = getSharedValue(list.get(i - 1), order);
            if (actualItem < previousItem)
                isProperOrder = false;
        }

        return isProperOrder;
    }

    @Before
    public void setUp() {
        list.clear();

        for (int i = 0; i < NUMBER_OF_OBJECTS; i++) {
            A obj = new A(random.nextInt(MAX_RAND_VALUE), random.nextInt(MAX_RAND_VALUE), random.nextInt(MAX_RAND_VALUE));
            list.add(obj);
        }
    }

    @Test
    public void orderABC() {
        Utilities.sort(radixSort, list, C, B, A);
        assertTrue(isProperlyOrdered(Order.ABC));
    }

    @Test
    public void orderACB() {
        Utilities.sort(radixSort, list, B, C, A);
        assertTrue(isProperlyOrdered(Order.ACB));
    }

    @Test
    public void orderCAB() {
        Utilities.sort(radixSort, list, B, A, C);
        assertTrue(isProperlyOrdered(Order.CAB));
    }

    @Test
    public void orderCBA() {
        Utilities.sort(radixSort, list, A, B, C);
        assertTrue(isProperlyOrdered(Order.CBA));
    }

    @Test
    public void orderBCA() {
        Utilities.sort(radixSort, list, A, C, B);
        assertTrue(isProperlyOrdered(Order.BCA));
    }

    @Test
    public void orderBAC() {
        Utilities.sort(radixSort, list, C, A, B);
        assertTrue(isProperlyOrdered(Order.BAC));
    }

    enum Order {
        ABC,
        ACB,
        CAB,
        CBA,
        BCA,
        BAC
    }

    static class A {
        private Integer a;
        private Integer b;
        private Integer c;

        A(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Integer getA() {
            return a;
        }

        Integer getB() {
            return b;
        }

        Integer getC() {
            return c;
        }
    }
}