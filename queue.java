import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = input.nextInt();
        Queue_operations object = new Queue_operations(n);
        System.out.println("Enter " + n + " elements" );
        for(int i = 0; i < n; i++) {
            object.enqueue(input.nextInt());
        }
        object.display();
        object.dequeue();
        System.out.println("-------after deQueue operation-------");
        object.display();
    }
}

class Queue_operations {
    int arr[];
    int front = 0, rear = 0, capacity, size = 0;
    Queue_operations (int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    void enqueue(int x) {
        if (size == capacity) {
            System.out.println("overflow");
            return;
        }
        else {
            arr[rear] = x;
            rear = rear + 1;
            size = size + 1;
        }
    }

    int dequeue () {
        if(size == 0) {
            System.out.println("Underflow");
            return -1;
        }
        else{
            int removed = arr[front];
            front = front + 1;
            size = size - 1;
            return removed;
        }
    }

    void display() {
        System.out.println("The array");
        for(int i = front; i<rear; i++ ) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
