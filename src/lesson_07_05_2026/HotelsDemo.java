package lesson_07_05_2026;

import java.util.LinkedList;

class Room{
    int roomNumber;
    int beds;
    double price;
    boolean empty;


}

class Client {
    private int customerID;
    private String name;
    private Dates arrive;
    private Dates leave;
    private Room bedroom;
    public Client(int id, String c, Dates dateIn, Dates dateOut, Room r)
    { setCustomerID(id);
        setName(c);
        setArrive(dateIn);
        setLeave(dateOut);
        setBedroom(r);
    }
    public void setCustomerID(int id) {customerID = id;}
    public void setName(String c) {name = c;}
    public void setArrive(Dates dateIn) {arrive = dateIn;}
    public void setLeave(Dates dateOut) {leave = dateOut;}
    public void setBedroom(Room r) {bedroom = r;}
    public int getCustomerID() {return customerID;}
    public String getName() {return name;}
    public Dates getArrive() {return arrive;}
    public Dates getLeave() {return leave;}
    public Room getBedroom() {return bedroom;}
    public void bill() {
        double money=bedroom.price*Dates.StayDays(leave,arrive);
        System.out.println(name);
        System.out.println(bedroom.roomNumber);
        System.out.println(arrive);
        System.out.println(leave);
        System.out.println(Dates.StayDays(arrive,leave));
        System.out.println(money);
    }


}
class Dates {
    private int day;
    private int month;
    private int year;
    public Dates(int day, int month, int year)
    { this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}
    public static int StayDays(Dates x, Dates y) {
         // method that calculates the number of nights between x and y
        return 0;
    }
}

class GClient extends Client {
    String GroupName;
    GClient(int id, String c, Dates dateIn, Dates dateOut, Room r, String g){
        super(id,c,dateIn,dateOut,r);
        GroupName = g;
    }
}


class Group {
    private String name; // name of group
    private int number; // number of rooms allocated to the group
    public Group(String name, int number)
    {
        this.name = name;
        this.number = number;
    }
    public String getName() {return name;}
    public int getNumber() {return number;}
    int[] gRooms = new int[number];
    // array to hold room numbers allocated to the group
    public double bill(int[] gRooms) {
        double sum = 0;
        for (int i = 0; i <gRooms.length; i++) {
            sum+=HotelsDemo.allRooms[gRooms[i]-1].price;

        }
        System.out.println(sum);
        return sum;
    }
}





public class HotelsDemo {
    public static Room[] allRooms = new Room[50];

    public static void main(String[] args) {
        for (int i = 0; i < allRooms.length; i++) {
            allRooms[i] = new Room();
        }


        for (int i = 0; i < allRooms.length; i++) {
            if (allRooms[i].beds == 2 && allRooms[i].empty == true) {
                System.out.println(allRooms[i].roomNumber);
            }
        }


    }
}
