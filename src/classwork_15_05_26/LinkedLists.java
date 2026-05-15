package classwork_15_05_26;

class Node {
    int key;      // value
    Node next;   // reference to next node
    Node prev;   // reference to previous node

    Node() {}

    Node(int key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Traverse and print all nodes
    public void traverse() {
        Node x = head;

        while (x != null) {
            System.out.print(x.key + " ");
            x = x.next;
        }

        System.out.println();
    }

    // LIST-SEARCH(L, k)
    public Node search(int k) {
        Node x = head;

        while (x != null && x.key != k) {
            x = x.next;
        }

        return x; // returns null if not found
    }

    // LIST-INSERT(L, x)
    public void insert(Node x) {
        x.next = head;

        if (head != null) {
            head.prev = x;
        }

        head = x;
        x.prev = null;
    }

    // LIST-DELETE(L, x)
    public void delete(Node x) {
        if (x == null) {
            return;
        }

        if (x.prev != null) {
            x.prev.next = x.next;
        } else {
            head = x.next;
        }

        if (x.next != null) {
            x.next.prev = x.prev;
        }
    }

    // Delete by key
    public void deleteByKey(int k) {
        Node x = search(k);
        delete(x);
    }
}

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(new Node(10));
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.insert(new Node(40));

        list.traverse(); // 40 30 20 10

        Node found = list.search(20);

        if (found != null) {
            System.out.println("Found: " + found.key);
        } else {
            System.out.println("Not found");
        }

        list.deleteByKey(30);

        list.traverse(); // 40 20 10
    }
}