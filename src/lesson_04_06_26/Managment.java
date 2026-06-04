package lesson_04_06_26;

import java.util.LinkedList;

// ==========================================
// 1. BRAND CLASS
// ==========================================
class Brand {

    private String brandName; // eg Safesun
    private float brandPrice; // price of the product of this brand

    public Brand(String brandName, float brandPrice) {
        this.brandName = brandName;
        this.brandPrice = brandPrice;
    }

    public float getBrandPrice() {
        return brandPrice;
    }
    // all accessor and mutator methods are present but not shown
}

// ==========================================
// 2. PRODUCT CLASS
// ==========================================
class Product {

    private String prodCode; // eg X123
    private String prodType; // eg Sunscreen
    private String prodDescription; // about the product
    private Brand prodBrand; // an object of type Brand
    private int prodSale; // number of units sold

    // Constructor code missing
    Product(String prodCode, String prodType, String prodDescription, Brand prodBrand, int prodSale) {
        this.prodCode = prodCode;
        this.prodType = prodType;
        this.prodDescription = prodDescription;
        this.prodBrand = prodBrand;
        this.prodSale = prodSale;
    }

    public int getProdSale() {
        return prodSale;
    }

    public Brand getProdBrand() {
        return prodBrand;
    }

    public String getProdDescription() {
        return prodDescription;
    }
    // all accessor and mutator methods are present but not shown
}

// ==========================================
// 3. PRODUCT MANAGEMENT CLASS
// ==========================================
class ProductManagement {

    private Product[] allProducts=new Product[25];

    public void sortProducts(){
        int n=allProducts.length;

        for(int i=0;i<n-1;i++){
            int maxIndex=i;

            for(int j=i+1;j<n;j++){
                if(allProducts[j]!=null && allProducts[maxIndex]!=null) {
                    if(allProducts[j].getProdSale()>allProducts[maxIndex].getProdSale()){
                        maxIndex=j;
                    }
                }

            }

            Product temp=allProducts[maxIndex];
            allProducts[maxIndex]=allProducts[i];
            allProducts[i]=temp;
        }


    }


}

// ==========================================
// 4. INVOICE CLASS
// ==========================================
class Invoice {

    private String invoiceID; // identifies a unique invoice
    private static Product[] products = new Product[20]; // list of products purchased
    private static int[] prodQuantity = new int[20]; // number of items of a particular product purchased
    private boolean qualifiesForDiscount; // default value is false
    private int numOfProducts; // how many products in this invoice

    // constructor is defined, code not shown
    Invoice(){
        this.numOfProducts = 0;
        this.qualifiesForDiscount = false;
    }

    public String getInvoiceID() {
        return invoiceID;
    }
    // all accessor and mutator methods are present but not shown

    public void addProduct(Product product, int quantity) {
        products[numOfProducts] = product;
        prodQuantity[numOfProducts] = quantity;
        numOfProducts++;
    }

    public void setQualifiesForDiscount() {
        float value=0;
        for(int i=0;i<numOfProducts;i++) {
            value+=products[i].getProdBrand().getBrandPrice()*prodQuantity[i];
        }

        if(value>3000){
            qualifiesForDiscount = true;
        }
        // if total value of purchases is more than 3000,
        // qualifiesForDiscount value is set to true
        // code missing
    }


}

// ==========================================
// 5. SUPPLIER CLASS
// ==========================================
class Supplier {

    private String supplierName;
    private String supplierCountry;
    private String[] productNames = new String[10];

    public Supplier(String supplierName, String supplierCountry, String[] productNames) {
        this.supplierName = supplierName;
        this.supplierCountry = supplierCountry;
        this.productNames = productNames;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }
    // all accessor and mutator methods are present but not shown

    public void displayData() {
        System.out.println("Supplier: " + supplierName + ", Country: " + supplierCountry);
    }
}

// ==========================================
// 6. SUPPLIER MANAGER CLASS
// ==========================================
class SupplierManager {

    LinkedList<Supplier> supplierList;

    public SupplierManager() {
        supplierList = new LinkedList<>();
    }

    public void addSupplier(Supplier newSupplier) {
        // code missing
        supplierList.add(newSupplier);
    }

    public void displayList() {
        // code missing
        for(int i=0;i<supplierList.size();i++) {
            supplierList.get(i).displayData();
        }
    }

    public static int countOfSuppliers(LinkedList<Supplier> supplierList, String country, int n) {
        // code missing
        if(n==0){
            return 0;
        }

        if(supplierList.get(n-1).getSupplierCountry().equals(country)){
            return 1+countOfSuppliers(supplierList,country,n-1);
        }else{
            return countOfSuppliers(supplierList,country,n-1);
        }
         // Added temporary return statement to allow compilation
    }
}

public class Managment {
    public static void main(String[] args) {
        Brand b1 = new Brand("Safesun", 2.17f);
    }
}