package lesson_07_05_2026;

import java.util.function.DoubleToIntFunction;

abstract class Monster{

    public static final int ICE_MONSTER_TYPE=1;
    public static final int WATER_MONSTER_TYPE=2;
    public static final int FIRE_MONSTER_TYPE=3;

    public String name="Unknown";
    public int health=100;
    public int strength=10;
    public int mondterType=0;

    public Monster(String name, int health, int mondterType){
        this.name=name;
        this.health=health;
        this.mondterType=mondterType;
    }

    private static int rollDice(){
        return new java.util.Random().nextInt(12)+1;
    }

    public static void output(String message){
        System.out.println(message);
    }

    public void attack(Monster defender){
        int damage=rollDice();
        defender.health-=damage;

        if(defender.health>0){
            output(defender.name);
            output(damage+"");
            output(defender.health+"");
        }else{
            defender.health=0;
            output(defender.name+" must leave game");
        }


    }

    void ability1_Heal(Monster defender){
        defender.health+=10;
    }

    abstract void ability2(Monster defender);

    abstract void ability3(Monster defender);
}


abstract class WaterMonster extends Monster{
    public WaterMonster(String name){
        super(name,25,Monster.WATER_MONSTER_TYPE);
    }
    void ability2(Monster defender){
        System.out.println("PUT OUT FIRE!");
    };
    abstract void ability3(Monster defender);
}


abstract class FireMonster extends Monster{
    public FireMonster(String name){
        super(name,40,Monster.FIRE_MONSTER_TYPE);
    }
    void ability2(Monster defender){
        System.out.println("HEAT WATER!");
    };
    abstract void ability3(Monster defender);
}


class Arena{
    public Monster[] monsters=new Monster[10];
    int monsterCount=0;
    public void addMonster(Monster m){
        if(monsterCount==10){
            System.out.println("Place is full");
        }else{
            boolean found=false;
            for(int i=0;i<monsterCount;i++){
                if(monsters[monsterCount]==m){
                    found=true;
                }
            }
            if(!found){
                monsters[monsterCount+1]=m;
                monsterCount++;
            }
        }

    }
    public void removeMonster(Monster m){
        for(int i=0;i<monsterCount;i++){
            if(monsters[i]==m){
                for(int j=i+1;j<monsterCount;j++){
                    monsters[j-1]=monsters[j];
                }
            }
        }
        monsterCount--;
    }
    public void doOneOnOneBattle(Monster A,Monster B){
        while(A.health>0 && B.health>0){
            A.attack(B);
            System.out.println(A.name+" attacked "+B.name);
            B.attack(A);
            System.out.println(B.name+" attacked "+A.name);
        }
        if(A.health> B.health){
            Monster.output(A.name+" WINS!");
        }else if(B.health> A.health){
            Monster.output(B.name+" WINS!");
        }else{
            Monster.output("IT IS A DRAW!");
        }

    }

}

class Squishy extends WaterMonster{

    public Squishy(String name) {
        super(name);
    }

    @Override
    void ability3(Monster defender) {
        System.out.println("CLEANING");
    }
}

class Splashy extends WaterMonster{

    public Splashy(String name) {
        super(name);
    }

    @Override
    void ability3(Monster defender) {
        System.out.println("SOAKING!");
    }
}

class Flamey extends FireMonster{

    public Flamey(String name) {
        super(name);
    }

    @Override
    void ability3(Monster defender) {
        System.out.println("BURNING");
    }
}






public class MonstersDemo {
    public static void main(String[] args) {


        Flamey fl1 =new Flamey("Flamey 107");
        Squishy sq1=new Squishy("Squishy 222");
        Splashy sp1=new Splashy("Splashy 999");

        sq1.ability3(fl1);
        sp1.ability3(sp1);
    }
}
