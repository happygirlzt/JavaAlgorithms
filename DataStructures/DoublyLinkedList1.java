class DoublyLinkedList {
    class Node {
        Node prev;
        Node next;
        int val;
        public Node(int v) {
            val = v;
        }
    }

    Node head;
    Node tail;

    public DoublyLinkedLits() {
        head = null;
        tail = null;
    }
    // Operation 0: Insert at the first
    public void insertHead(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    // Opertaion 1: Insert after a given node
    public void insertAfter(Node preNode, int data) {
        Node newNode = new Node(data);

        if (preNode == null) return;
        newNode.next = preNode.next;
        newNode.prev = preNode;
        preNode.next = newNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Operation 2: Insert at the end
    public void insertTail(int data) {
        Node newNode = new Node(data);

        Node last = head;

        newNode.next = null;
        // the linked list is empty
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }
}
