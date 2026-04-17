package lesson_16_04_26;
class Flight {


    private String flightName;
    private int capacity;
    private Ticket[] tickets;
    private int ticketsSold=0;
    public Flight (String flightName,int capacity){
        this.flightName=flightName;
        this.capacity = capacity;
        tickets=new Ticket[capacity];
    }
    public void addTicket(Ticket ticket){
        if(ticketsSold<capacity){
            tickets[ticketsSold++]=ticket;
        }else{
            System.out.println("Not enough places");
        }
    }
    public void removeTicket(Ticket ticket){
        int index=-1;
        for(int i=0;i<ticketsSold;i++) {
            if (tickets[i]==ticket) {
                index=i;
                break;
            }
        }

        if(index==-1) {
            System.out.println("Ticket not found");
        }else{

            for(int i=index;i<ticketsSold-1;i++) {
                tickets[i]=tickets[i+1];
            }
            ticketsSold--;
        }
    }

    public int getSeatsAvailable(){
        return capacity-ticketsSold;
    }

    public void printPassengerList(){
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]!=null){
                System.out.println(tickets[i].getName());
            }
        }
    }


}
class Ticket{
    private String name;
    public Ticket(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FlightDemo {
    public static void main(String[] args) {
        Flight cx619 = new Flight("CX 619", 280); // Cathay - HKG-SIN
        Flight aa6914 = new Flight("AA 6914", 266);
// American - JFK-LHR
        Flight ek89 = new Flight("EK 89", 354); // Emirates - DBX-GVA
        Ticket jordan = new Ticket("Jordan Deckard");
        cx619.addTicket(new Ticket("Taylor Ripley"));
        cx619.addTicket(jordan);
        cx619.addTicket(new Ticket("Casey Neo"));
        aa6914.addTicket(new Ticket("Cameron Quaid"));
        aa6914.addTicket(new Ticket("Phoenix Andor"));
        cx619.printPassengerList();
        System.out.println(cx619.getSeatsAvailable());
        cx619.removeTicket(jordan);
        cx619.printPassengerList();
        System.out.println(cx619.getSeatsAvailable());



    }
}
