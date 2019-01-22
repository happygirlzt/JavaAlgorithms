class LinkedList {

    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int v) {
            val = v;
        }
    }

    private ListNode dummy;
    private int size;

    public MyLinkedList() {
        dummy = new ListNode(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > size - 1) return -1;
        ListNode p = dummy;
        while (index-- > 0) {
            p = p.next;
        }

        return p.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        ListNode added = new ListNode(val);
        added.next = dummy.next;
        dummy.next = added;
        // showNode();
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        ListNode p = dummy;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            size++;
            ListNode p = dummy;
            while (index-- > 0) {
                p = p.next;
            }

            ListNode added = new ListNode(val);
            added.next = p.next;
            p.next = added;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size - 1) return;
        ListNode p = dummy;
        while (index-- > 0) {
            p = p.next;
        }

        ListNode post = p.next.next;
        p.next = post;
        size--;
    }

    public void showNode() {
        ListNode p = dummy;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
