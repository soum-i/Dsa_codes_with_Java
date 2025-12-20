import java.util.Scanner;

public class stack {
    public static void main(String[] args) {
        myStack st = new myStack(4);

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Popped: " + st.pop());
        System.out.println("Top element: " + st.peek());
        System.out.println("Is stack empty: " + (st.isEmpty() ? "Yes" : "No"));
        System.out.println("Is stack full: " + (st.isFull() ? "Yes" : "No"));
    }
}
class myStack {
    private int[] arr;
    private int capacity;
    private int top;

    public myStack(int cap) {
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if(top == capacity - 1) {
            System.out.println("Stack Overflow.");
        }
        top = top +1;
        arr[top] = x;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity -1;
    }
}

