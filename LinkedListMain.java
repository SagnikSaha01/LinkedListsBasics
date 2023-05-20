MyProgram.java:
---------------
import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
       Scanner in = new Scanner (System.in); 
       System.out.println("Choose an option:");
       int selected= 0;
       int input = 0;
       int counter = 1;
       LinkedList myList = null;
       while(selected != 5){
       System.out.println("1 = Insert Value, 2 = Delete value, 3 = Display List, 4 = Display Length, 5 = Quit");
       selected = in.nextInt();
       if(selected == 1){
           System.out.println("Please enter your value");
           input = in.nextInt();
          if(counter == 1){
            myList = new LinkedList(input); 
              counter++;
          } else{
              myList.insertSort(input);
          }
          System.out.println("Your value was added to the list");
       }else if(selected == 2){
          System.out.println("Enter the value you wish to delete"); 
           int val = in.nextInt();
         if(myList.deleteVal(val)){
             System.out.println("Sucessfully deleted your value");
             
         }else{
             System.out.println("Your value is not in the list");
         }
           
       }else if (selected == 3){
           if(counter == 1){
               
               System.out.println("There is no list to display");
           }else{
               myList.show();
           }
           
       }else if(selected == 4){
           if(counter == 1){
               
               System.out.println("The list has a length of: 0");
           }else{
               
               System.out.println("The list has a length of: " + myList.length());
           }
           
       }else if(selected != 5){
           System.out.println("That is not an option, please try again");
       }

      }
      
     
      
      
      
      
    }
}



Node.java:
---------
public class Node {
   
   int data;
   Node next = null;
   public Node(int d){
       
       data = d;
   }
}

