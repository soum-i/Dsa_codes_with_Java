public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traversal(head);
    }

    public static void traversal(Node head) {
        while(head != null) {
            System.out.print(head.data);
            if(head.next != null){
                System.out.print("~>");
            }
            head = head.next;
        }
    }
}

class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

