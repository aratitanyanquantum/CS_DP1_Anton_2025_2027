package classwork_15_05_26;


class Payment {
    private FoodItem[] fi = new FoodItem[100];
    private int fiCount;
    private static double foodTax = 0.2;

    private DrinkItem[] di = new DrinkItem[100];
    private int diCount;
    private static double drinkTax = 0.1;

    public Payment() {
        fiCount = 0;
        diCount = 0;
    }


    public int getFiCount() {
        return fiCount;
    }

    public int getDiCount() {
        return diCount;
    }

    public FoodItem getFi(int x) {
        return fi[x];
    }

    public DrinkItem getDi(int x) {
        return di[x];
    }

    public static double getFoodTax() {
        return foodTax;
    }

    public static void setFoodTax(double tax) {
        foodTax = tax;
    }

    public static double getDrinkTax() {
        return drinkTax;
    }

    public static void setDrinkTax(double tax) {
        drinkTax = tax;
    }




    public void addFoodItem(FoodItem item) {
        if(fiCount<100){
            fi[fiCount]=item;
            fiCount++;
        }
    }

    public void addDrinkItem(DrinkItem item) {
        if (diCount < 100) {
            di[diCount] = item;
            diCount++;
        }
    }

    public static double findPrice(Item[] pl, String c) {
        for(int i=0;i<pl.length;i++){
            if(pl[i].getCode().equals(c)){
                return pl[i].getPrice();
            }
        }
        return 0;
    }

    public double calculateBill(Item[] pl) {
        double finalBill = 0.0;
        for(int i=0;i<pl.length;i++){
            finalBill += pl[i].getPrice();
        }
        return finalBill;
    }
}

class Item {
    private String code; // item code
    private String name; // item name
    private double price; // unit price before tax





    public String getCode() {
        return code;
    }

    public void setCode(String c) {
        code = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }


}




class FoodItem {
    private String itemCode;
    private int quantity;

    public FoodItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemCode(String x) {
        itemCode = x;
    }

    public void setQuantity(int y) {
        quantity = y;
    }
}

class DrinkItem {

    private String itemCode;
    private int quantity;

    public DrinkItem(String x, int y) {
        itemCode = x;
        quantity = y;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemCode(String x) {
        itemCode = x;
    }

    public void setQuantity(int y) {
        quantity = y;
    }
}



public class RestaurantDemo {
    public static Payment[] tables = new Payment[50];
    public static Item[] pl = new Item[200];
    public static LinkedList priceLL = new LinkedList();


    static void changePrice(LinkedList priceLL) {

    }
    public static void main(String[] args) {


        System.out.println(tables[40].getDiCount());
        System.out.println(tables[2].getDi(2));

    }
}
