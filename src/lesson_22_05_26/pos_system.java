package lesson_22_05_26;

class Cart{

}
class CartNode {
    private Cart myCart;
    private CartNode next;

    public CartNode(Cart aCart)
    {
        this.myCart = aCart;
        this.next = null;
    }
    public Cart getCart(){ return this.myCart; }
    public CartNode getNext(){ return this.next; }
    public void setNext(CartNode nextNode)
    {
        this.next = nextNode;
    }
}

class POSlist{
    //classes POSlist and POSline are connected


    private String id;
    private boolean active;
    private Cart[] line;
    private CartNode head;
    static int count=0;

    POSlist(){

    }

    public Cart leaveList(int n){
        int count=0;
        CartNode temp=head;
        while(count<n+1){
            count++;
            temp=temp.getNext();

        }
        Cart sout=temp.getNext().getCart();
        temp.setNext(temp.getNext().getNext());
        return sout;

    }

    public Cart removeFirst(){
        if(head==null){
            return null;
        }else{
            Cart temp=head.getCart();
            head=head.getNext();
            return temp;
        }
    }

    public void addLast(Cart c){
        if(head==null){
            head=new CartNode(c);
        }
        CartNode temp=new CartNode(c);
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(temp.getNext());
    }

    public POSlist(String id, boolean active){
        this.id = id;
        this.active = active;
    }

    public Cart getLine(int n){
        return line[n];
    }



    public String getId(){
        return id;
    }
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active=active;
    }
    public void setId(String id){
        this.id = id;
    }

    public void joinLine(Cart newCart){
        for(int i=0;i<line.length;i++){
            if(line[i]==null){
                line[i]=newCart;
            }
            break;
        }
        count++;
    }

    public void checkoutCart(){
        if(line[0]==null){
            System.out.println("There is no cart");
        }else{
        for(int i=0;i<line.length;i++){
            if(line[i]==null){
                line[i-1]=null;
            }
        }}
    }

    public Cart leaveLine(int n){
        Cart c=line[n];
        for(int i=n;i<line.length-1;i++){
            line[i]=line[i+1];
        }
        return c;
    }

    public void split(POSlist p){
        for(int i=1;i<POSlist.count;i+=2){
            this.joinLine(p.leaveLine(i));
        }
    }




}

class POSsystem{
    POSlist[] pos=new POSlist[10];
    static int count=0;

}



public class pos_system {
    public static void main() {
        POSlist p1 = new POSlist("1",true);

        //14e
        for(int i=0;i<20;i++){
            p1.joinLine(new Cart());
        }

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        Cart cart4 = new Cart();
        Cart cart5 = new Cart();


        POSlist queueList = new POSlist();
        queueList.addLast(cart2);
        queueList.addLast(cart1);
        queueList.addLast(cart4);
        queueList.removeFirst();
        queueList.addLast(cart5);
        queueList.addLast(cart3);
        queueList.removeFirst();

    }
}
