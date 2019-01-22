/**
 * Created on 16 Oct 2018 by happygirlzt
 *
 * Implement of bag ADT
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private ListNode<Item> first;
    private int n;

    private static class ListNode<Item> {
        private Item item;
        private ListNode<Item> next;
    }

    /**
     * Initialize
     */
    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    /**
     * Add a new item before the first
     */
    public void add(Item item) {
        ListNode<Item> dummy = first;
        first = new ListNode<Item>();
        first.item = item;
        first.next = dummy;
        n++;
    }

    public class ListIterator<Item> implements Iterator<Item> {
        private ListNode<Item> cur;

        public ListIterator(ListNode<Item> first) {
            cur = first;
        }

        public boolean hasNext() {
            return cur != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = cur.item;
            cur = cur.next;
            return item;
        }
    }
}
