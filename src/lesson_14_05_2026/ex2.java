package lesson_14_05_2026;


import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] mainStack=new int[10];
        int top1=-1;
        int top2=mainStack.length;


        //when we add x element in first array
        int x=input.nextInt();
        if(top1==top2-1){
            System.out.println("Overflow");
        }else{
            top1++;
            mainStack[top1]=x;
        }
    }
}
