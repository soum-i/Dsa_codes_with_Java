import java.util.Scanner;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("The Linked List");
        traversal(head);
        System.out.println();

        System.out.print("Do you want to perform any operation(y/n): ");
        char ans = sc.next().charAt(0);

        while (ans == 'y' || ans == 'Y') {
            System.out.println("\nPress a number to perform that operation");
            System.out.println("1. Insert At First");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert At Any Position");
            System.out.println("4. Delete The First Node");
            System.out.println("5. Delete the last Node");
            System.out.println("6. Delete a node from any position");
            System.out.println("7. Search any number");

            int newAns = sc.nextInt();
            boolean listChanged = true;
            switch (newAns) {
                case 1:
                    System.out.print("Element to be added at the first: ");
                    head = insertAtFront(head, sc.nextInt());
                    break;

                case 2:
                    System.out.print("Element to be added at the end: ");
                    head = insertAtEnd(head, sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value and position: ");
                    int value = sc.nextInt();
                    int pos = sc.nextInt();
                    head = insertAtPos(head, pos, value);
                    break;

                case 4:
                    head = deleteHead(head);
                    break;

                case 5:
                    head = deleteLast(head);
                    break;

                case 6:
                    System.out.println("Enter the position: ");
                    int position = sc.nextInt();
                    head = deletePos(head, position);
                    break;

                case 7:
                    System.out.print("Search any number: ");
                    int key = sc.nextInt();
                    int result = search(head, key);

                    if (result == -1) {
                        System.out.println("Number not found!");
                    } else {
                        System.out.println("Number found at index: " + result);
                    }
                    listChanged = false;
                    break;
            }

            if (listChanged) {
                System.out.println("Updated Linked List:");
                traversal(head);
                System.out.println();
            }
            System.out.print("Do you want to perform another operation? (y/n): ");
            ans = sc.next().charAt(0);
        }
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

    //function to delete the head
    static Node deleteHead(Node head) {
        if(head == null)
            return null;
        Node temp = head;
        head = head.next;
        temp = null;
        return head;
    }

    //function to delete the last node
    static Node deleteLast(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    //function to delete a node from any position
    static Node deletePos(Node head, int pos) {
        Node temp = head;

        if(pos == 1) {
            head = temp.next;
            return head;
        }
        Node prev = null;
        for(int i = 1; i < pos; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }

    //function to search
    static int search(Node head, int n) {
        int pos = 1;
        for(Node curr = head; curr != null; curr=curr.next) {
            if(curr.data == n) {
                return pos;
            }
            pos++;
        }
        return -1;
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

