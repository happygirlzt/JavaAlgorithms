class DoublyLinkedList {
    Node head;
    Node tail;
    int len;

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int v) {
            val = v;
        }
    }

    public MyLinkedList() {
        len = 0;
        head = null;
        tail = null;
    }

    // Adding a node at the front of the list
    public void addAtHead(int val) {
        Node buff = head;
        head = new Node(val);
        if (tail == null) {
            tail = head;
        } else {
            head.next = buff;
            buff.prev = head;
        }
        len++;
    }

    // Add a node of val after
    public void addAtIndex(int index, int val) {
        Node cur = head;
        if (index == len) {
            addAtTail(val);
            return;
        } else if (index == 0) {
            addAtHead(val);
            return;
        } else if (index < len / 2) {
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
        } else if (index < len) {
            cur = tail;
            for (int i = len - 1; i >= index; i--) {
                cur = cur.prev;
            }
        } else {
            return;
        }

        Node ins = new Node(val);
        ins.next = cur.next;
        ins.prev = cur;
        cur.next.prev = ins;
        cur.next = ins;
        len++;
    }

    public void addAtTail(int val) {
        if (tail != null) {
            tail.next = new Node(val);
            tail.next.prev = tail;
            tail = tail.next;
        } else {
            tail = new Node(val);
            head = tail;
        }
        len++;
    }

    public int get(int index) {
        if (index < 0 || index >= len) {
            return -1;
        }

        Node cur = head;
        if (index < len / 2) {
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = len - 2; i >= index; i--) {
                cur = cur.prev;
            }
        }

        return cur.val;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) {
            return;
        }

        if (len == 1) {
            tail = null;
            head = null;
            len--;
            return;
        }

        if (index == 0) {
            head = head.next;
            len--;
            return;
        }

        if (index == len - 1) {
            tail = tail.prev;
            len--;
            return;
        }

        Node cur = head;
        if (index < len / 2) {
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = len - 2; i >= index; i--) {
                cur = cur.prev;
            }
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        len--;
    }
}
