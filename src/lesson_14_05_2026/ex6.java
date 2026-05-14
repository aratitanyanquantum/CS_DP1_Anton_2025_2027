package lesson_14_05_2026;

class Stack{
    int[] stack=new int[10];
    int topindex=-1;
    public boolean isEmpty() {
        if(topindex ==-1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if(topindex == stack.length-1)
            return true;
        else{
            return false;
        }
    }
    public void push(int value) {
        if (isFull())
            System.out.println("Stack overflow!");
        else {
            topindex++;
            stack[topindex] = value;
        }
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            topindex--;
            return stack[topindex];
        }
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }else  {
            return stack[topindex];
        }
    }
}

class Queueue{
    Stack stack=new Stack();

    public void FirstOut() {
        Stack stack1=new Stack();

        while(!stack.isEmpty()){
            stack.push(stack.pop());
        }
        stack1.pop();
        while(!stack1.isEmpty()){
            stack.push(stack.pop());
        }

    }

}


public class ex6 {


}
