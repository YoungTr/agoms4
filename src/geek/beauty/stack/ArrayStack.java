package geek.beauty.stack;

public class ArrayStack {
    private final String[] items;
    private final int N;
    private int size;

    public ArrayStack(int n) {
        N = n;
        items = new String[n];
    }

    public boolean push(String item) {
        if (size >= N) return false;
        items[size] = item;
        size++;
        return true;
    }

    public String pop() {
        if (size == 0) return null;
        String item = items[size - 1];
        size--;
        return item;
    }
}
