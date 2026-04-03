package lesson_02_04_26;
class Glan{
    static int count=0;

    static double pi=3.14;
    double height;
    double r;


    Glan(double height,double r){
        this.height=height;
        this.r=r;
        count++;
    }
    Glan(){
        this(1,1);
        count++;
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


}
