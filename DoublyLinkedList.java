import java.util.Scanner;

class Node1 {
    int data;
    Node1 prev;
    Node1 next;
    Node1(int d) {
        data = d;
        prev = next = null;
    }
};

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node1 head = new Node1(10);
        head.next = new Node1(20);
        head.next.prev = head;
        head.next.next = new Node1(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node1(40);
        head.next.next.next.prev = head.next.next;

        System.out.println("The default Linked List");
        traversal1(head);
        System.out.println();

        char ans = 'y';
        while(ans == 'y' || ans == 'Y') {
            System.out.println("Press a number to perform an operation.");
            System.out.println("1. Insertion at the front");
            System.out.println("2. Insertion at the end");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Element you wanna insert at the front: ");
                    head = insertAtFirst(head, sc.nextInt());
                    break;
                case 2:
                    System.out.print("Element you wanna insert at the end: ");
                    head = insertAtEnd(head, sc.nextInt());
                    break;
            }
            System.out.println("Updated Linked List");
            traversal1(head);
            System.out.println();
            System.out.print("Perform more operations?: ");
            ans = sc.next().charAt(0);
        }
    }

    static Node1 insertAtFirst(Node1 head, int n) {
        Node1 newNode = new Node1(n);
        newNode.next = head;
        if(head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    static Node1 insertAtEnd(Node1 head, int n) {
        Node1 newNode = new Node1(n);
        if(head == null) {
            head = newNode;
        }
        else {
            Node1 curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        return head;
    }
    static void traversal1(Node1 head) {
        Node1 temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            if(temp.next != null)
            {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
    }
}


