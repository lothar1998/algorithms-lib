package pl.kuglin.datastructure;

import java.util.LinkedList;

public class HeapPriorityQueue<T> {

    private LinkedList<Entry> queue;

    public HeapPriorityQueue() {
        queue = new LinkedList<>();
    }

    public T max() {
        if (!queue.isEmpty())
            return queue.get(0).getObject();
        else
            return null;
    }

    public T extractMax() {
        if (queue.isEmpty())
            return null;

        Entry max = queue.get(0);
        queue.set(0, queue.get(queue.size() - 1));
        queue.removeLast();
        maxHeap(0);
        return max.getObject();
    }

    public void insert(T obj, int key) {
        Entry temp = new Entry(Integer.MIN_VALUE, obj);
        queue.add(temp);
        increaseKey(queue.size() - 1, key);
    }

    public void increaseKey(int i, int key) {
        if (key >= queue.get(i).getPriority()) {

            Entry temp = queue.get(i);

            while (i > 0 && queue.get(parent(i)).getPriority() < key) {
                queue.set(i, queue.get(parent(i)));
                i = parent(i);
            }

            temp.setPriority(key);
            queue.set(i, temp);
        }
    }

    private void maxHeap(int i) {
        int l = left(i);
        int r = right(i);

        int largest;

        if (l < queue.size() && queue.get(l).getPriority() > queue.get(i).getPriority())
            largest = l;
        else
            largest = i;

        if (r < queue.size() && queue.get(r).getPriority() > queue.get(largest).getPriority())
            largest = r;

        if (largest != i) {
            swap(i, largest);
            maxHeap(largest);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        Entry temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        for (int i = 0; i < queue.size() - 1; i++) {
            builder.append(queue.get(i).toString());
            builder.append(", ");
        }

        builder.append(queue.get(queue.size() - 1).toString());

        builder.append("]");

        return builder.toString();
    }

    private class Entry {
        private int priority;
        private T object;

        Entry(int priority, T object) {
            this.priority = priority;
            this.object = object;
        }

        int getPriority() {
            return priority;
        }

        void setPriority(int priority) {
            this.priority = priority;
        }

        T getObject() {
            return object;
        }

        @Override
        public String toString() {
            return "{" + priority + ", " + object.toString() + "}";
        }
    }
}
