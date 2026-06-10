package lesson_14_05_2026;

class Queueuye{
    int[] q=new int[10];
    int head=-1;
    int tail=0;


    public boolean isEmpty(){
        return head==tail-1;
    }
    public boolean isFull(){
        if(tail==q.length && head==0){
            return true;
        }else if(tail==head){
            return true;
        }else{
            return false;
        }
    }
    public void enqueue(int x) {
        if(isFull()){
            System.out.println("Overflow");
        }else{
            q[tail] = x;
            if (tail == q.length - 1) {
                tail = 0;
            } else {
                tail = tail + 1;
            }
        }


    }

    public int dequeue() {
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }else{
            int x = q[head];
            if (head == q.length - 1) {
                head = 0;
            } else {
                head = head + 1;
            }
            return x;
        }

    }
}

class Stacked{
    int[] stack=new int[10];

    public void pop() {

    }
}






public class ex7 {



}
