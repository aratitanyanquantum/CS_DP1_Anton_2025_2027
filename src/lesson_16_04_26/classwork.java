package lesson_16_04_26;
class Employees{
    String name;

}
class Programmer extends Employees{
    String name;
    void setName(){
        this.name="Programmer";
        super.name="Employee";
    }
    void printNames(){
        System.out.println("Name: "+this.name);
        System.out.println("Super Name: "+super.name);
    }
}



public class classwork {
    public static void main(String[] args) {
        Programmer p = new Programmer();
        p.setName();
        p.printNames();


    }

}
