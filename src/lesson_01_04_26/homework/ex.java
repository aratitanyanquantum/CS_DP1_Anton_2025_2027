package lesson_01_04_26.homework;
class Point {
    double x, y;
    static int count=0;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
        count++;
    }
    Point(Point p) {
        this(p.x,p.y);
        count++;
    }
    Point() {
        this(0,0);
        count++;
    }


    void printPoint(){
        System.out.println("Point: " + this.x + ", " + this.y);
    }

    void printEqual(Point p){
        if(this.x == p.x && this.y == p.y){
            System.out.println("Point: equal");
        }else{
            System.out.println("Point: not equal");
        }
    }
    static void printEqual(Point p1, Point p2){
        if(p1.x == p2.x && p1.y == p2.y){
            System.out.println("Point: equal");
        }else{
            System.out.println("Point: not equal");
        }
    }

    void quarterPoint(){
        if(this.x > 0 && this.y > 0){
            System.out.println("First quarter");
        }else if(this.x < 0 && this.y > 0){
            System.out.println("Second quarter");
        }else if(this.x > 0 && this.y < 0){
            System.out.println("Third quarter");
        }else{
            System.out.println("Fourth quarter");
        }
    }

    double distancePoint(Point p){
        return Math.sqrt(Math.abs(this.x - p.x)*Math.abs(this.x - p.x)  + Math.abs(this.y - p.y)*Math.abs(this.y - p.y));
    }
    static double distancePoint(Point p1, Point p2){
        return Math.sqrt(Math.abs(p1.x - p2.x)*Math.abs(p1.x - p2.x)  + Math.abs(p1.y - p2.y)*Math.abs(p1.y - p2.y));
    }

    Point bigpoint(){
        Point p = new Point(x*4,y*4);
        return p;
    }

    Point minDistance(Point pMass[]){
        Point pMin=new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Point p0=new Point(0,0);
        for(int i=0;i<pMass.length;i++){
            if(pMass[i].distancePoint(p0)<pMin.distancePoint(p0)){
                pMin=pMass[i];
            }
        }
        return pMin;
    }

    boolean sameLine(Point p){
        if(this.x == p.x || this.y == p.y){
            return true;
        }else{
            return false;
        }
    }

    double[] isTriangle(Point p1, Point p2){
        if(this.distancePoint(p1)<this.distancePoint(p2)+p1.distancePoint(p2) && this.distancePoint(p2)<this.distancePoint(p1)+p2.distancePoint(p1) && p1.distancePoint(p2)<this.distancePoint(p1)+this.distancePoint(p2)){
            return new double[]{this.distancePoint(p1),this.distancePoint(p2),p1.distancePoint(p2)};
        }
        else{
            return new double[]{0,0,0};
        }
    }

    double makeres(double[] f){
        double s = (f[0] + f[1] + f[2]) / 2.0;
        double area = Math.sqrt(s * (s - f[0]) * (s - f[1]) * (s - f[2]));
        return area;
    }


    Point midPoint(Point p){
        Point mid = new Point(0,0);
        mid.x = (p.x+this.x)/2;
        mid.y = (p.y+this.y)/2;
        return mid;
    }

    boolean inCirle(double rad, Point p){
        if(Math.abs(p.x-this.x)<rad && Math.abs(p.y-this.y)<rad){
            return true;
        }else{
            return false;
        }
    }

    Point line(Point[] p){
        int maxC=0;
        Point max=new Point(0,0);
        for(int i=0;i<p.length;i++){
            int count=0;
            for(int j=0;j<p.length;j++){
                if(p[i].sameLine(p[j])){
                    count++;
                }
            }
            if(count>maxC){
                maxC=count;
                max=p[i];
            }
        }
        return max;
    }

}

class Vector{
    Point start;
    Point end;
    Vector(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    void printVector(){
        System.out.println("Start:");
        start.printPoint();
        System.out.println("End:");
        end.printPoint();
    }

    double length(){
        return start.distancePoint(end);
    }

    boolean zugaher(Vector v){
        Point p1=new Point(-this.start.x+this.end.x,-this.start.y+this.end.y);
        Point p2=new Point(-v.start.x+v.end.x,-v.start.y+v.end.y);
        if(p1.x*p2.y-p1.y*p2.x==0){
            return true;
        }else{
            return false;
        }
    }

    double artadryal(Vector v){
        double x1=-this.start.x+this.end.x;
        double y1=-this.start.y+this.end.y;
        double x2=-v.start.x+v.end.x;
        double y2=-v.start.y+v.end.y;

        return x1*x2+y1*y2;
    }

    double degree(Vector v){
        double verev=this.artadryal(v);
        double erk1=this.length();
        double erk2=v.length();
        double s=Math.acos(verev/(erk1*erk2));
        return Math.toDegrees(s);

    }

    Point gumar(Vector v){
        double x1=-this.start.x+this.end.x;
        double y1=-this.start.y+this.end.y;
        double x2=-v.start.x+v.end.x;
        double y2=-v.start.y+v.end.y;

        return new Point(x1+x2,y1+y2);
    }

    void amena(Vector[] v){
        double maxC=0;
        Vector max=null;
        for(int i=0;i<v.length;i++){
            if(v[0].length()>maxC){
                max=v[0];
                maxC=v.length;
            }
        }
        max.printVector();
    }
}



public class ex {
    public static void main(String[] args) {
        Point p1 = new Point(2,2);
        Point p2 = new Point(8, 2);
        Point p3 = p1.bigpoint();
        Point p5 = new Point(5,6);
        // point 1,2,5 arena
        System.out.println(new Point().makeres(p1.isTriangle(p2, p5)));

        Point[] points = {p1,p2,p3};
        // Point p4=new Point().minDistance(points);

        // p4.printPoint();

        // p1.quarterPoint();
        // System.out.println(p1.distancePoint(p2));

//        Point circle=new Point(3,5);
//        double r=4;
//        System.out.println(p1.inCirle(r,circle));



        Point p6 = new Point(5, 10);
        Point p7 = new Point(12, 4);
        Point p8 = new Point(8, 10); // The winner
        Point p9 = new Point(8, 15);
        Point p10 = new Point(1, 10);
        Point p11 = new Point(3, 7);
        Point p12 = new Point(14, 2);


        Point[] uxix=new Point[]{p6,p7,p8,p9,p10,p11,p12};
        p6.line(uxix).printPoint();

        Point p13 = new Point(10, 10);
        Point p14 = new Point(12, 14); // Vector A: (2, 4)
        Point p15 = new Point(20, 20);
        Point p16 = new Point(21, 22); // Vector B: (1, 2)

        Vector v1 = new Vector(p13,p14);
        Vector v2 = new Vector(p15,p16);

        System.out.println(v1.zugaher(v2));


        System.out.println(v1.degree(v2));

        Vector[] vectors = {v1,v2};

        Vector v0=new Vector(new Point(0,0),new Point(0,0));
        v0.amena(vectors);
        System.out.println(Point.count);




    }
}
