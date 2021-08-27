//By Hitam Yadav
public class IDLListTest {
      
   public static void main(String[] args) {
       IDLList list = new IDLList();
      
//       MAIN TEST ------------------------
       
       list.add(0, 1);
       list.add(0, 2);
       list.add(1, 3);
       list.add(1, 4);
       list.add(2, 5);
       
       System.out.println("Size "+list.size());
       System.out.println(list);
      
       System.out.println("index 1: "+list.get(1) + " Head: "+list.getHead() + " tail: " + list.getLast());
//      
       System.out.println("Remove index 1: "+list.removeAt(1));
       System.out.println("Size: "+list.size());
       System.out.println(list);
//      
       System.out.println("Remove 2: "+list.remove(2));
       System.out.println("Size: "+list.size());
       System.out.println(list);
//      
       System.out.println("Remove 6: "+list.remove(6));
       System.out.println("Size: "+list.size());
       System.out.println(list);
//      
       System.out.println("Remove: "+list.remove());
       System.out.println("Size: "+list.size());
       System.out.println(list);
//      
       System.out.println("Remove Last: "+list.removeLast());
       System.out.println("Size: "+list.size());
       System.out.println(list);
       
//       error handling
       
//      list.add(1,17);
//      list.add(-1,2);
//      list.get(2);
//        list.getHead();
//        list.getLast();
//        list.remove();
//        list.removeLast();
//        list.add("hitam");
//        System.out.println(list.toString());
//        list.removeAt(1);

   }

}