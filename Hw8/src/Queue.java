public class Queue {
    private class Node {

        private Object data;
        private Node next;

        public Node(Object elem) {
            this.data = elem;
            this.next = null;
        }
    }

    protected Node head, tail;
    protected int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if ((head == null) && (tail == null) || this.size == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(Object elem) {
        Node node = new Node(elem);
        if (size == 0) {
            head = node;
        }
        else
            tail.next = node;

        tail = node;
        size++;
    }


    public Object front() throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.data;
    }

    public Object dequeue() throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        Object tmp = head.data;
        head = head.next;
        size--;

        if (size == 0)
            tail = null;
        return tmp;
    }

    public String toString() {
        String s = "";
        s += "(";
        if (!isEmpty()) {
            Node p = this.head;
            do {
                s += p.data;
                if (p != tail)
                    s += ", ";
                p = p.next;
            } while (p != null);
        }
        s += ")";
        return s;
    }

    class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String err) {
            super(err);
        }

    }
}
