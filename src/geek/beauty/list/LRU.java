package geek.beauty.list;


public class LRU<Item> {
    private final int capacity;
    private final Node head;
    private int size;

    public LRU(int n) {
        capacity = n;
        head = new Node();
    }

    public void put(Item item) {
        Node preNode = findPreNode(item);
        if (preNode != null) {
            // 存在，删除原来节点
            deleteElemOptim(preNode);
        } else {
            // 不存在
            if (size >= capacity) {
                // 删除未节点
                deleteElemAtEnd();
            }
        }
        // 头部插入
        insertElemAtBegin(item);
    }

    private void insertElemAtBegin(Item item) {
        Node next = head.next;
        Node node = new Node(next, item);
        head.next = node;
    }

    private void deleteElemAtEnd() {
        Node cur = head;
        // 空列表直接返回
        if (cur.next == null) {
            return;
        }
        // 找到倒数第二个
        while (cur.next.next != null) {
            cur = cur.next;
        }

        cur.next = null;
        size--;
    }

    private Node findPreNode(Item item) {
        Node node = head;
        while (node.next != null) {
            if (item.equals(node.next.item)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    /**
     * 删除后一个节点
     *
     * @param preNode node
     */
    public void deleteElemOptim(Node preNode) {
        Node next = preNode.next;
        preNode.next = next.next;
        size--;
    }


    private class Node {
        private Node next;
        private Item item;

        public Node() {
        }

        public Node(Node next, Item item) {
            this.next = next;
            this.item = item;
        }
    }
}
