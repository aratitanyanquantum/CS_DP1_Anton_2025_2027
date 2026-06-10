package lesson_02_04_26;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a1=input.nextLong();
        long a2=input.nextLong();
        String function=input.next();
        if(function.equals("+")){
            System.out.println(a1+a2);
        }else if(function.equals("-")){
            System.out.println(a1-a2);
        }else if(function.equals("*")){
            System.out.println(a1*a2);
        }else if(function.equals("/")){
            System.out.println(a1/a2);
        }
    }
}
