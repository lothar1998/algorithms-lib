package pl.kuglin.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private static final int STACK_SIZE = 100;

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());

        for (Integer i = 0; i < STACK_SIZE; i++)
            stack.push(i);

        assertFalse(stack.isEmpty());

        for (Integer i = STACK_SIZE - 1; i >= 0; i--)
            assertEquals(i, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackWithGivenSize() {
        Stack<Integer> stack = new Stack<>(2);

        assertTrue(stack.isEmpty());

        for (Integer i = 0; i < STACK_SIZE; i++)
            stack.push(i);

        assertFalse(stack.isEmpty());

        for (Integer i = STACK_SIZE - 1; i >= 0; i--)
            assertEquals(i, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackWithGivenSizeAndAdditionalSize() {
        Stack<Integer> stack = new Stack<>(2, 5);

        assertTrue(stack.isEmpty());

        for (Integer i = 0; i < STACK_SIZE; i++)
            stack.push(i);

        assertFalse(stack.isEmpty());

        for (Integer i = STACK_SIZE - 1; i >= 0; i--)
            assertEquals(i, stack.pop());

        assertTrue(stack.isEmpty());
    }
}