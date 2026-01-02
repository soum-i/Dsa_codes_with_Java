import java.util.Scanner;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        traversal(head);
        System.out.println();

        System.out.print("Element to be added at the first: ");
        int input = sc.nextInt();
        head = insertAtFront(head, input);

        System.out.println("The New Array");
        traversal(head);

        System.out.println();
        System.out.print("Element to be added at the end: ");
        int end = sc.nextInt();
        head = insertAtEnd(head, end);

        System.out.println("the new array");
        traversal(head);
        System.out.println();

        System.out.print("add element to a specific position(value, position): ");
        int value = sc.nextInt();
        int pos = sc.nextInt();
        head = insertAtPos(head, pos, value);

        System.out.println("the new array");
        traversal(head);
        System.out.println();
    }

    //function for adding a new node at index 0
    static Node insertAtFront(Node head, int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        return newNode;
    }

    //function for adding a new node at the end
    static Node insertAtEnd(Node head, int n) {
        Node newNode = new Node(n);
        if(head == null) {
            return newNode;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return head;
    }

    //function to add a new node at a specific position
    static Node insertAtPos(Node head, int pos, int n) {
        Node curr = head;
        for(int i  = 1; i < pos-1 && curr != null; i++) {
            curr = curr.next;
        }
        if(curr == null) {
            return head;
        }
        Node newNode = new Node(n);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    //function to traverse the linked list
    public static void traversal(Node head) {
        while(head != null) {
            System.out.print(head.data);
            if(head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}

//structure of a single node
class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

