package DataStructures;

/*
  Java program to implement a queue by 2 stacks

  empty()
  peek()
  pop()
  push(e item)
 */


import java.util.*;

public class Queueby2Stacks {
    // Initiate two stacks
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static int curr_size;

    public Queueby2Stacks() {
        curr_size = 0;
    }

    public static void push(int x) {
        s1.push(x);
        curr_size++;
    }

    public static int pop() {
        if(s1.empty() && s2.empty()) {
            System.out.println("Q is empty.");
            System.exit(0);
        }
        // Move elements from s1 to s2 only if
        // s2 is empty.
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }

        int y = s2.pop();
        curr_size--;
        return y;
    }

    public static int size() {
        return curr_size;
    }
}
