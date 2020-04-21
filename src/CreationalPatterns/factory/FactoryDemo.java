package CreationalPatterns.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        Point polarPoint = Point.Factory.newPolarPoint(2, 3);
    }
}
/*
enum CoordinateSystem{
    CARTESIAN,
    POLAR
}*/
 class Point{
    private double x, y;

   /* // when public ugly and generate some javadoc which is uglier.
    private Point(double a, double b, CoordinateSystem cs){

        switch (cs){
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
                break;
        }
    }
*/
    // make it private to force the user to use the static method
    private Point(double rho, double theta){
        x = rho * Math.cos(theta);
        y = rho * Math.sin(theta);
    }

    static class Factory{

        public static Point newCartesianPoint(double x, double y){
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }
}
