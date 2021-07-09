package geek.beauty.queue;

public class ArrayQueue {
    private String[] items;
    private final int N;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(int n) {
        N = n;
        items = new String[n];
    }

    public boolean enqueue(String item) {
        if (size() < N) {
            if (tail == N) {
                tail = 0;
            }
            items[tail++] = item;
            size++;
            return true;
        }

        return false;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        String val = items[head];
        head++;
        if (head == N) {
            head = 0;
        }
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return items.length;
    }

}
