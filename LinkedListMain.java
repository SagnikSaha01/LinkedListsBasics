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

LinkedList.java:
---------------
public class LinkedList {
   public Node head;
   public int listCount; 
   
   public LinkedList(int d){
       
       head = new Node (d);
       
   }
   public void show(){
       
       Node current = head;
      if(current == null){
         System.out.println("There is no list to display"); 
      }else{ 
          System.out.println("Here is your list");
       while (current.next != null){
           System.out.print(current.data + " --> ");
           current = current.next;
          
       }
       System.out.println(current.data);
      }
       
   } 
   
    public boolean insertSort(int d){
      Node current = head;    
      Node newNode = new Node (d);
    if(current == null || head.data >= newNode.data){
        newNode.next = head;
        head = newNode;
    }else{
        while(current.next != null && current.next.data < newNode.data ){
            current=current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
      return true;  
    }
    public int length(){
        int counter = 0;
        Node current = head;
        while(current != null){
            current = current.next;
            counter++;
            
        }
        return counter;
    }
    
    public boolean deleteVal(int d){
        Node current = head;
        Node previous = head;
        boolean isInList = false;
       if(current.data == d ){
           if(current.next != null){
           head = current.next;
           isInList = true;
           }else{
               isInList = true;
               head = null;
           }
       }else{
        while(current.next != null ){
            if(current.data == d || isInList == true){
             
                 isInList = true;
                current.data = current.next.data;
                
                }
                previous = current;
                 current = current.next;
            }
       }
       if(current.data == d){
           isInList = true;
       }
       if(isInList){
        previous.next = null;
       }
        return isInList;
    }
    public void pop(boolean dataStructure){
        Node current = head;
        Node previous = head;
        if(dataStructure){
            if(current.next == null){
               head = null; 
            }else{
            while(current.next != null){
               previous = current;
               current = current.next;
            }
            previous.next = null;
        }
        }else{
           if(current.next != null){
           head = current.next;
           }else{
               head = null;
           }
       }
        
        
    }
    public boolean push(int newData){
        Node end = new Node(newData);
        Node current = head;
        if(current == null){
         head = end;   
        }else{
        while(current.next != null){
            current = current.next;
        }
        current.next = end;
        }
        return true;
    } 
    
    public LinkedList reverse(){
        Node current = head;
        LinkedList reveresedList = null;
        if(current == null){
            System.out.println("No values to reverse");
        }else{
            reveresedList = new LinkedList(current.data);
        while(current.next != null){
            Node begin = new Node(current.next.data);
            begin.next = reveresedList.head;
            reveresedList.head = begin;

            current = current.next;
            
        }
    }
       return reveresedList;
    }
    
    public boolean checkList(int c){
         Node current = head;
         boolean isInList = false;
         int counter = 1;
         int place = 0;
         if(current == null){
             System.out.println("No list to check");
         }else{
          while(current != null){
            if(current.data == c && isInList == false){
                isInList = true;
                place = counter;
            }
            current = current.next;
            counter++;
          }
         }
          if(isInList){
          System.out.println("Your value is in spot: "+ place);
          }
        return isInList;
    }
    
    //add tail
  /* public boolean push(int newData){
        Node end = new Node(newData);
        Node current = head;
        if(current == null){
         head = end;   
        }else{
        while(current.next != null){
            current = current.next;
        }
        current.next = end;
        }
        return true;
    }  
    */
    /*  public boolean delHead(){
        
        Node temp = head;
        head =  temp.next;
        return true;
    }
    */
    /*   public boolean delEnd(){
        Node current = head;
        Node prev = head;
        while(current.next !=null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return true;
    }
    */
    
   /* public boolean addBegin(int d){
        
        Node begin = new Node(d);
        begin.next = head;
        head = begin;
        
        return true;
    }*/
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

