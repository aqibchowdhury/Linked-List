// Assignment #: 10 
//         Name: Aqib Chowdhury
//    StudentID: 1214879900
//  Lab Lecture: Mon/Wed 4:35-5:50
//  Description: The Assignment 10 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class Assignment10
{
   public static void main(String[] args)
   {
      char input1;
       String inputInfo = new String();
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
           System.out.print("What action would you like to perform?\n");
           line = stdin.readLine().trim();  //read a line
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
            {
             switch (input1)
              {
               case 'A':   //Add String
                  System.out.print("Please enter a string to add:\n");
                  String str1 = stdin.readLine().trim();
                  System.out.print("Please enter its index:\n");
                  int index = Integer.parseInt(stdin.readLine().trim());
                  try
                   {
                     list1.addElementAt(str1, index);
                   }
                  catch(IndexOutOfBoundsException ex)
                   {
                     System.out.print("The index is out of bounds\n");
                   }
                  break;
               case 'B':   //Add Some Strings
                  System.out.print("Please enter a string to add:\n");
                  String str2 = stdin.readLine().trim();
                  System.out.print("Please enter its index:\n");
                  int index2 = Integer.parseInt(stdin.readLine().trim());
                  System.out.print("Please specify how many times to add:\n");
                  int howMany = Integer.parseInt(stdin.readLine().trim());
                  try
                   {
                      list1.addSomeElementsAt(str2, index2, howMany);
                   }
                  catch(IndexOutOfBoundsException ex)
                   {
                      System.out.print("The index is out of bounds\n");
                   }
                      break;
               case 'C':   //Count a specific string
                  System.out.print("Please enter a string to count:\n");
                  String str3 = stdin.readLine().trim();
                  int count = list1.countHowMany(str3);
                  System.out.print("The string " + str3 + " appears " + count + " time(s)\n");
                 break;
               case 'G':   //Get a string at some index
                  System.out.print("Please enter an index:\n");
                  int index4 = Integer.parseInt(stdin.readLine().trim());
                  try
                    {
                        String str4 = list1.getElement(index4);
                        System.out.print("The string at the index " + index4 + ": " + str4 + "\n");
                    }
                   catch(IndexOutOfBoundsException ex)
                    {
                        System.out.print("The index is out of bounds\n");
                    }
                 break;
               case 'E':   //Check if the linked list is empty
                  boolean empty1 = list1.isEmpty();
                  if (empty1 == true)
                        System.out.print("The linked list is empty\n");
                  else
                        System.out.print("The linked list is not empty\n");
                  break;
               case 'F':   //Find the largest string and remove it
                  String largest = list1.findLargestAndRemove();
                  if (largest != null)
                        System.out.print("The largest string " + largest + " was removed\n");
                  else
                        System.out.print("There is no largest string\n");
                      break;
               case 'L':   //List Strings
                  System.out.print(list1.toString());
                  break;
               case 'Q':   //Quit
                  break;
               case 'R':  //Reverse Strings from End
                  System.out.print("Please enter a number of elements to reverse from the end:\n");
                  inputInfo = stdin.readLine().trim();
                  int howManyR = Integer.parseInt(inputInfo);
                  list1.reverseLastSome(howManyR);
                  break;
               case '?':   //Display Menu
                  printMenu();
                  break;
               default:
                  System.out.print("Unknown action\n");
                  break;
              }
           }
          else
           {
             System.out.print("Unknown action\n");
            }
          } while (input1 != 'Q' || line.length() != 1);
        }
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd String\n" +
                        "B\t\tAdd Strings\n" +
                        "C\t\tCount String\n" +
                        "G\t\tGet String\n" +
                        "E\t\tCheck Empty\n" +
                        "F\t\tFind Largest And Remove\n" +
                        "L\t\tList Strings\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tReverse Last Few Strings\n" +
                        "?\t\tDisplay Help\n\n");
    } //end of printMenu()
}