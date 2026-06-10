package lesson_10_04_26;

import java.util.Random;
import java.util.ArrayList;

class UniversalArray{
    Random r= new Random();
    private int size;
    private int[] arrayUniv;

    public int getSize() {
        return size;

    }
    public void setSize(int size) {
        this.size = size;
    }
    public int[] getArrayUniv() {
        return arrayUniv;
    }
    public void setArrayUniv(int[] arrayUniv) {
        this.arrayUniv = arrayUniv;
    }

    UniversalArray(int size, int[] arrayUniv) {
        setSize(size);
        arrayUniv=new int[size];
        setArrayUniv(arrayUniv);
    }


    void initArray(UniversalArray array){
        size=array.getSize();
        int[] arr=getArrayUniv();
        for(int i=0;i<size;i++){
            arr[i]= r.nextInt(1,21);
        }
    }

    void printArray(UniversalArray array){
        for(int i=0;i<size;i++){
            System.out.print(array.getArrayUniv()[i]+" ");
        }
    }

    int getMax() {
        int max = arrayUniv[0]; // Start with the first element
        for (int i = 1; i < size; i++) {
            if (arrayUniv[i] > max) max = arrayUniv[i];
        }
        return max;
    }

    int getMin() {
        int min = arrayUniv[0]; // Start with the first element
        for (int i = 1; i < size; i++) {
            if (arrayUniv[i] < min) min = arrayUniv[i];
        }
        return min;
    }

    public boolean simetric() {
        for (int i = 0; i < size / 2; i++) {
            if (arrayUniv[i] != arrayUniv[size - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arrayUniv[j] > arrayUniv[j + 1]) {
                    int temp = arrayUniv[j];
                    arrayUniv[j] = arrayUniv[j + 1];
                    arrayUniv[j + 1] = temp;
                }
            }
        }
    }

    void selectionSort(UniversalArray array){
        for(int i=0;i<array.getSize();i++){
            for(int j=0;j<array.getSize();j++){
                if(array.getArrayUniv()[i]<array.getArrayUniv()[j]){
                    int temp=array.getArrayUniv()[i];
                    array.getArrayUniv()[i]=array.getArrayUniv()[j];
                    array.getArrayUniv()[j]=temp;
                }
            }
        }
    }

    void mergeSort(UniversalArray array){
        for(int i=0;i<array.getSize();i++){
            for(int j=0;j<array.getSize();j++){
                if(array.getArrayUniv()[i]<array.getArrayUniv()[j]){
                    int temp=array.getArrayUniv()[i];
                    array.getArrayUniv()[i]=array.getArrayUniv()[j];
                    array.getArrayUniv()[j]=temp;
                }
            }
        }
    }

    boolean isThere(UniversalArray array, int n){
        for(int i=0;i<array.getSize();i++){
            if(array.getArrayUniv()[i]==n){
                return true;
            }
        }
        return false;
    }

    int mostCommon(UniversalArray array){
        array.mergeSort(array);
        int count=0;
        int maxcount=0;
        for(int i=1;i<array.getSize();i++){
            if(array.getArrayUniv()[i]==array.getArrayUniv()[i-1]){
                count++;
            }else{
                if(count>maxcount){
                    maxcount=count;
                }
            }

        }
        return maxcount;
    }

    void addElement(int n) {
        if (size == arrayUniv.length) {
            arrayUniv = java.util.Arrays.copyOf(arrayUniv, arrayUniv.length * 2);
        }
        arrayUniv[size] = n; // Add element to the end [cite: 12]
        size++;
    }

    void delete(UniversalArray array){
        for(int i=array.getSize()-1;i>=0;i--){
            if(array.getArrayUniv()[i]!=0){
                int[] arr=array.getArrayUniv();
                arr[i]=0;
                array.setArrayUniv(arr);
                size--;
                break;
            }
        }

    }

    static void biggest(UniversalArray[] array){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i].getMax());
        }
    }
}

public class exe {
    public static void main(String[] args) {
        System.out.println("--- Testing univArray1 ---");
        UniversalArray univArray1 = new UniversalArray(8, new int[8]);

        // Your init and print methods require the object itself as a parameter
        univArray1.initArray(univArray1);
        System.out.print("Array 1: ");
        univArray1.printArray(univArray1);
        System.out.println(); // New line for clean formatting

        // 2. Test Min/Max
        // These don't take parameters in your class, so we just call them
        System.out.println("Max: " + univArray1.getMax());
        System.out.println("Min: " + univArray1.getMin());

        // 3. Test Membership and Palindrome
        // Using your exact method names: isThere and simetric
        System.out.println("Contains 10? " + univArray1.isThere(univArray1, 10));
        System.out.println("Is Palindrome (Simetric)? " + univArray1.simetric());

        // 4. Test Sorting
        univArray1.bubbleSort();
        System.out.print("Sorted Array 1: ");
        univArray1.printArray(univArray1);
        System.out.println();

        // 5. Test Add/Delete
        univArray1.addElement(100);
        System.out.print("After adding 100: ");
        univArray1.printArray(univArray1);
        System.out.println();

        univArray1.delete(univArray1);
        System.out.print("After deleting: ");
        univArray1.printArray(univArray1);
        System.out.println();

        // 6. Testing 'biggest'
        System.out.println("\n--- Testing Biggest Array ---");
        UniversalArray ua2 = new UniversalArray(3, new int[3]);
        ua2.initArray(ua2);

        UniversalArray ua3 = new UniversalArray(5, new int[5]);
        ua3.initArray(ua3);

        // Your biggest() method requires an array of UniversalArray objects, not an ArrayList
        UniversalArray[] arrayCollection = {univArray1, ua2, ua3};
        System.out.println("Max values of all arrays:");
        UniversalArray.biggest(arrayCollection);
    }
}
