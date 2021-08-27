public class CallRectangle {
   public static void main(String[] args) {
      Rectangle myRectangle = new Rectangle();

      myRectangle.setSize(1, 1);
      if (myRectangle.getArea() != 2) {
         System.out.println("FAILED getArea() for 1, 1");
      }
      if (myRectangle.getPerimeter() != 4) {
         System.out.println("FAILED getPerimeter() for 1, 1");
      }

      myRectangle.setSize(2, 3);
      if (myRectangle.getArea() != 8) {
         System.out.println("FAILED getArea() for 2, 3");
      }
      if (myRectangle.getPerimeter() != 12) {
         System.out.println("FAILED getPerimeter() for 2, 3");
      }
   }
}