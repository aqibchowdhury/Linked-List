// Assignment #: 10 
//         Name: Aqib Chowdhury
//    StudentID: 1214879900
//  Lab Lecture: Mon/Wed 4:35-5:50
//  Description: A linked list is a sequence of nodes with efficient
// 				 element insertion and removal.
// 				 This class contains a subset of the methods of the
//				 standard java.util.LinkedList class.
import java.util.NoSuchElementException;

import javax.swing.text.html.parser.Element;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   /*********************************************************
   Add your methods here
   *********************************************************/
   
   //Method to print output in string format
   public String toString() {
	   String str = "{ ";
	   if(first == null) {
		   return "{ }";
	   }
	   Node element = first;
	   //loop to add spaces between objects
	   while (element != null) {
		   str += element.data.toString() + " ";
		   element = element.next;
	   }
	   return str + "}\n";
   }
   
   //Method to check if list is empty
   public boolean isEmpty() {
	   if(first == null) {
		   return true;
	   }
	   return false;
   }
   
   //Method to add element at specified index
   public void addElementAt(Object element, int index) {
	   try {
		   LinkedListIterator list = new LinkedListIterator();
		   //if index is 0, add element to the beginning
		   if(index==0) {
			   addFirst(element);
			   return;
		   }
		   //if index is somewhere else, add element there
		   else {
			   for(int i=0; i<index; i++) {
				   list.next();
			   }
			   list.add(element);
		   }
	   }catch(IndexOutOfBoundsException e) {

	   }
   }
   
   //Method to add multiple elements at specified index
   public void addSomeElementsAt(Object element, int index, int howMany) {
	   try {
		   LinkedListIterator list = new LinkedListIterator();
		   for(int j = 0; j < index; j++) {
			   list.next();
		   }
		   //loop to add element howMany times
		   for(int i = 0; i <= howMany - 1; i++) {
			   list.add(element);
		   }
	   }catch(IndexOutOfBoundsException e) {
		   
	   }
   }
   
   //Method to get element at specified index
   public String getElement(int index) {
	   try {
		   //return first element
		   if(index==0) {
			   return "" + first.data;
		   }
		   //return specified element
		   else {
			   Node element = first;
			   int i = 0;
			   while(element != null && i < index) {
				   i++;
				   element = element.next;
			   }
			   if(element != null) {
				   return "" + element.data;
			   }
		   }

	   }catch(IndexOutOfBoundsException e) {
		   
	   }
	return "" + first.data;
   }
   
   //Method to find largest element and remove it
   public String findLargestAndRemove() {
	   ListIterator list = listIterator();
	   String i = "";
	   //if the list is empty, return null
	   if(isEmpty())
		   return null;
	   else {
		   while(list.hasNext()) {
			   String comp = "";
			   comp = list.next().toString();
			   if(0 < comp.compareTo(i)) {
				   i = comp;
			   }
		   }
		   list = this.listIterator();
		   while(list.hasNext()) {
			   if(list.next().toString().equals(i))
				   list.remove();
		   }
		   return i;
	   }
   }
   
   //Method to count how many of an element there are
   public int countHowMany(Object element) {
	   int count = 0;
	   //loop to find the same object
	   for(Node search = first; search != null; search = search.next) {
		   if(element.equals(search.data)) {
			   count++;
		   }
	   }
	   return count;
   }
   
   //Method to reverse howMany elements
   public void reverseLastSome(int howMany) {
	   Node i = null;
	   Node element = null;
	   if(isEmpty())
		   return;
	   while(true) {
		   element = first.next;
		   first.next = i;
		   i = first;
		   if(element == null) {
			   return;
		   }
		   first = element;
		   howMany--;
	   }

	   
	   }
   
   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class