package classwork_15_05_26;

class Nodes {
    int key;      // value
    Node next;   // reference to next node

    Nodes() {}

    Nodes(int key) {
        this.key = key;
        this.next = null;
    }
}

class SingleList {
    private Node head;

    public SingleList() {
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

        return x;
    }

    public Node search(int k, String withoutwhilefirstcondition) {
        Node x = head;

        while (x.key!=0 && x.key != k) {
            x = x.next;
        }

        return x;
    }

    // LIST-INSERT(L, x)
    public void insert(Node x) {

        if (head != null) {
            x.next=head;
        }
        head = x;
    }

    // LIST-DELETE(L, x)
    public void delete() {
        this.head = this.head.next;
    }

    public void delete(Node y) {
        Node x = head;
        while (x.next!=y) {
            x = x.next;
        }
        x.next = x.next.next;
    }


    //working with stacks 10.2-2
    public Node pop(){
        Node x = head;
        delete();
        return x;
    }

    public void push(Node x) {
        x.next = head;
        head = x;

    }

    //working with queues 10.2-3
    public Node dequeue(){
        Node x = head;
        while(x.next!=null){
            x = x.next;
        }
        Node y=head;
        x=y;
        x=null;
        return y;


    }

    public void enqueue(Node x) {
        x.next = head;
        head = x;
    }
}

public class SingleLinkedLists {
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
