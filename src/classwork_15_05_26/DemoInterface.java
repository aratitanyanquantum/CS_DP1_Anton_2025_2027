package classwork_15_05_26;

interface AnimalFunc{
    void speed();
}

class Cat implements AnimalFunc{

    public void speed(){
        System.out.println("50");
    }

}
class Dog implements AnimalFunc{
    public void speed(){
        System.out.println("60");
    }
}



public class DemoInterface {
    public static void main(String[] args) {
        AnimalFunc animal = new Dog();
        animal.speed();
        animal=new Cat();
        animal.speed();
    }

}
