// By Hitam Yadav

import java.util.ArrayList;

public class IDLList<E> { 
	private class Node<E> { // the inner private class
       E data; // data field
       Node<E>next; // data field
       Node<E> prev; // data field
       
       public Node(E elem) { // constructor that creates a node holding elem.
           data = elem;
           next = null;
           prev = null;
           
       }
     
       public Node (E elem, Node<E> prev, Node<E> next) { // a constructor that creates a node holding elem,with next as next and prev as prev.
           data = elem;
           this.prev = prev;
           this.next = next;
           
       }
       
	}
	
	public IDLList () { 
		head = null; // data field 1/4
		tail = null; // data field 2/4
	    size = 0; // data field 3/4 
	    indices = new ArrayList<Node<E>>(); // data field 4/4
	}
	
   private Node<E> head; // the start of the list
   private Node<E> tail; // the end of the list
   private int size; // the amount of nodes in the list
   private ArrayList<Node<E>> indices; // a list of references to nodes.
 
   public boolean add (int index, E elem) { // that adds elem at position index (counting from wherever head is). 
       if(index >= 0 && index <= size) {
           if(index == 0) { // insert at head 
        	   add(elem);
        	   
           }
           else if(index == size) { // insert at tail
               append(elem);
               
           }
           else {
        	   Node<E> test = indices.get(index);
               Node<E> node = new Node<E>(elem, test.prev, test);
               node.prev.next = node;
               test.prev = node;
               indices.add(index, node);
               indices.set(index-1, node.prev);
               indices.set(index+1, test);
               size++;
               
           }
          
           return true;
       }
       else {
    	   throw new ArrayIndexOutOfBoundsException("Array out of bounds");
       }
   }
  
   public boolean add(E elem) { // adds elem at the head
       Node<E> node = new Node<E>(elem, null, head);
       if(head == null) {
           tail = node;
           
       }
       else { 
          
           head.prev = node;
           indices.set(0, head);
           
       }
       head = node;
       indices.add(0, node);
       size++;
       return true;
       
   }

   public boolean append (E elem) { // adds elem as the new last element of the list
       Node<E> node = new Node<E>(elem, tail, null);
       tail.next = node;
       indices.set(size-1, tail);
       tail = node; 
       indices.add(node);
       size++;
       return true;
       
   }
 
   public E get (int index) { // returns the object at position index from the head
      if(index < size && index >= 0) {
    	  return indices.get(index).data;
    	  
      }
       else {
           throw new IndexOutOfBoundsException("List index is out of bounds.");
       }
   }

   public E getHead () { // returns object at the head
       if(size > 0 ) {
           return head.data;
           
       }
       else {
           throw new NullPointerException ("The List is empty");
       }
      
   }
  
   public E getLast () { // returns object at the tail
       if(size > 0) {
           return tail.data;
           
       }
       else {
           throw new NullPointerException("The List is empty");
       }
   }
  
   public int size() { // returns the list size
       return size;
       
   }
   
   public E remove() { // removes and returns the element at the head
       if(size > 0) {
           E data = head.data; 
           head = head.next; 
           size--;
           indices.remove(0); 
           if(head != null) {
               head.prev = null; 
               indices.set(0, head);
               
           }
           else {
               tail = null;
           }
           
           return data;
           
       }
       else {
           throw new NullPointerException("The List is empty");
       }
   }
  
   public E removeLast() { //removes and returns the element at the tail.
       if(size > 0) {
           E data = tail.data; 
           tail = tail.prev; 
           size--;
           indices.remove(size); 
          
           if(tail != null) {
               tail.next = null; 
               indices.set(size-1, tail); 
               
           }
           else {
               head = null;
           }
          
           return data;
           
       }
       else {
           throw new NullPointerException("The List is empty");
       }
   }

   public E removeAt(int index) { //removes and returns the element at the index index.
       if(index >= 0 && index < size) {
           if(index == 0) {
               return remove();
           }
           else if(index == size-1) {
               return removeLast(); 
           }
           else {
               Node<E> node = indices.get(index);
               indices.remove(index);
               indices.get(index).prev = node.prev;
               indices.get(index-1).next = node.next;
               node.next = null;
               node.prev = null;
               size--;
               return node.data;
               
           }
           
       }
       else {
           throw new IndexOutOfBoundsException("The List index out of bounds.");
       }
   }

   public boolean remove(E elem) { // removes the first occurrence of elem in the list and returns true. Return false if elem was not in the list
       Node<E> test = head;
       int test_index = 0; 
      
       while(test != null) {
           if(test.data.equals(elem)) {
               break;
           }
           test = test.next;
           test_index++;
       }
      
       if(test == null) {
           return false;
       }
       
       else {
           removeAt(test_index);
           return true;
           
       }
   }

   public String toString() { // presents a string representation of the list
       String str = ""; 
       Node<E> test = head; 
      
       while(test != null) {
           str += test.data.toString();
           if(test != tail) {
               str += " ";
           }
           test = test.next;
       }
      
       return str;
   }

}