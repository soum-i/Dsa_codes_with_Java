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
        Node1 head = new Node1(10);
        head.next = new Node1(20);
        head.next.prev = head;
        head.next.next = new Node1(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node1(40);
        head.next.next.next.prev = head.next.next;
        traversal1(head);

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


