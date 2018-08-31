package DataStructures;

// Java program to implement a stack using two queues

import java.util.LinkedList;
import java.util.Queue;

public class Stackby2queues {
    public static Queue<Integer> q1 = new LinkedList<>();
    public static Queue<Integer> q2 = new LinkedList<>();

    public static int curr_size;

    public Stackby2queues(){
        curr_size = 0;
    }

    public static void pop() {
        if (q1.isEmpty()) {
            return;
        }

        // leave one element in q1 and
        // push others in q2
        while(q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // remove the only left element
        // from q1
        q1.remove();
        curr_size--;

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public static void push(int x) {
        q1.add(x);
        curr_size++;
    }

    public static int top() {
        if (q1.isEmpty())
            return -1;

        while(q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // last pushed element
        int temp = q1.peek();

        // to empty the auxiliary queue after
        // last operation
        q1.remove();

        // push last element to q2
        q2.add(temp);

        // swap the two queues names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    public int size() {
        return curr_size;
    }
}
