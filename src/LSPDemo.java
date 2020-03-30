// Liskov Substitution Principle
// You should be able to substitute a sub-class for a base class.


public class LSPDemo {
    // the useIt method violate the LSP when the rectangle is a square
    static void useIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);
        // area = width * 10;
        System.out.println(
                "expected area of "+ (width *10)+
                        ", however got " + r.getArea()
        );
    }

    public static void main(String[] args) {
        /** Below example is a violation of the Liskov Substitution Principle */
        Rectangle rc = new Rectangle(2,3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        useIt(sq);
        /** voilation ends */
    }
}

class Rectangle{
    protected int width, height;

    public Rectangle(){

    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "width= " + width +
                ", height= " +height +
                "}";
    }

    /** fix step 1 the violation: get rid of the square class
     * and add a method to check if the rectangle is a square**/
    public boolean isSquare(){
        return width == height;
    }
}
// fix step 2
class  RectangleFactory{
    public static Rectangle newRectangle(int width, int height){
        return  new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side){
        return  new Rectangle(side, side);
    }
}

class Square extends  Rectangle{
    public Square(){

    }

    public Square(int size){
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}