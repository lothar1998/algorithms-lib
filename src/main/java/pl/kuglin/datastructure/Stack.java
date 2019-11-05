package pl.kuglin.datastructure;

public class Stack<T> {

    private int stackSize = 100;
    private int additionalSize = 100;

    private Object[] array;
    private int top = -1;

    public Stack() {
        array = new Object[stackSize];
    }

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        array = new Object[stackSize];
    }

    public Stack(int stackSize, int additionalSize) {
        this.stackSize = stackSize;
        this.additionalSize = additionalSize;
        array = new Object[stackSize];
    }

    public void push(T element) {
        if (++top >= stackSize)
            reallocate();

        array[top] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (!isEmpty())
            return (T) (array[top--]);
        return null;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    private void reallocate() {
        Object[] temp = new Object[stackSize];
        System.arraycopy(array, 0, temp, 0, stackSize);
        stackSize += additionalSize;
        array = new Object[stackSize];
        System.arraycopy(temp, 0, array, 0, stackSize - additionalSize);
    }
}
