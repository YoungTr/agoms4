package geek.beauty.stack;

public class ListStack<Item> {

    private Node top;

    public void push(Item item) {
        Node node = new Node(null, item);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    public Item pop() {
        if (top == null) {
            return null;
        }

        Node item = top;
        top = top.next;
        return item.item;
    }

    public void clear() {
        top.next = null;
        top = null;
    }

    private class Node {
        Node next;
        Item item;

        public Node() {
        }

        public Node(Node next, Item item) {
            this.next = next;
            this.item = item;
        }
    }
}
