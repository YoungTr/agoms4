package geek.beauty.queue;

public class ListQueue<Item> {

    private Node head;
    private Node tail;

    public void enqueue(Item item) {
        Node node = new Node(null, item);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public Item enqueue() {
        if (head == null) {
            return null;
        }

        Item item = head.item;
        head = head.next;
        // 处理边界
        if (head == null) {
            tail = null;
        }
        return item;
    }


    private class Node {
        Node next;
        Item item;

        public Node(Node next, Item item) {
            this.next = next;
            this.item = item;
        }
    }

}
