package lesson_02_04_26;
class Glan{
    static int count=0;

    static double pi=3.14;
    double height;
    double r;

    Glan(double height, double r){
        setHeight(height);
        setR(r);
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }


    double v(){
        return pi*height*r*r;
    }
    double sKoxm(){
        return 2*pi*r*height;
    }

    double s(){
        return sKoxm()+2*pi*r*r;
    }

    static boolean same(Glan g1,Glan g2){
        return g1.height == g2.height && g1.r == g2.r;
    }

    static Glan vol(Glan[] g){
        double[] vol = new double[g.length];
        for(int i=0;i<g.length;i++){
            vol[i] = g[i].v();
        }
        int min=0;
        for(int j=0;j<g.length;j++){
            if(vol[j]<vol[min]){
                min=j;
            }
        }
        vol[min]=0;
        min=0;
        for(int j=0;j<g.length;j++){
            if(vol[j]<vol[min]){
                min=j;
            }
        }
        return g[min];
    }

}
public class ex1 {
    public static void main(String[] args) {
        Glan g1 = new Glan(10.0, 5.0);
        Glan g2 = new Glan(10.0, 5.0);
        Glan g3 = new Glan(5.0, 2.0);
        Glan g4 = new Glan(15.0, 8.0);

        System.out.println("--- Testing Instance Methods ---");
        System.out.println("Cylinder 1 Volume (v): " + g1.v());
        System.out.println("Cylinder 1 Lateral Surface Area (sKoxm): " + g1.sKoxm());
        System.out.println("Cylinder 1 Total Surface Area (s): " + g1.s());


        System.out.println("\n--- Testing 'same' Method ---");
        System.out.println("Are g1 and g2 the same? " + Glan.same(g1, g2));
        System.out.println("Are g1 and g3 the same? " + Glan.same(g1, g3));


        System.out.println("\n--- Testing 'vol' Method (Array) ---");
        Glan[] cylinders = {g1, g3, g4};

        System.out.println("Volume of g1: " + g1.v());
        System.out.println("Volume of g3: " + g3.v());
        System.out.println("Volume of g4: " + g4.v());

        Glan result = Glan.vol(cylinders);
        System.out.println("The 'vol' method returned the cylinder with height: " + result.getHeight() + " and radius: " + result.getR() + " (Volume: " + result.v() + ")");
    }


}
