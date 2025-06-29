import java.util.ArrayList;
import java.util.Map;

public class LinkedList {
    public Node head;  //making a head object for the LinkedList Class

    public LinkedList(Node head){  //constructing head object for LinkedList Class
        this.head = head;
    }

    //function to add a node to the linkedlist
    public void append(int value)
    {
        //create new node with value equal to value parameter and nextnode = to none
        Node new_node = new Node(value, null);
        if (head == null)
        {
            head = new_node;
        }
        else{
            Node current_node = head;
            while (current_node.getNextNode() != null)
            {
                current_node = current_node.getNextNode();
            }
            current_node.setNextNode(new_node);
        }
    }

    //this prints the linked lists values
    public void showlinkedlist()
    {
        if (head == null)
        {
            System.out.print(head);
        }
        else
        {
            Node current_node = head;
            while (current_node.getNextNode() != null)
            {
                System.out.print(current_node.getValue());
                System.out.print(" -> ");
                current_node = current_node.getNextNode();
            }
            System.out.println(current_node.getValue());

        }
    }

    //this method converts a linked list to a string represnting the evaluation of the operation
    public String linkedlisttostring(LinkedList ll)
    {
        String elementstring = "";
        ArrayList<Integer> numsinll = new ArrayList<>();     //converts nums in linkedlist to array of nums
        if (ll.head == null)
        {
            return "";
        }
        else                //if not null, go through linked list and append to array
        {
            Node current_node = ll.head;
            while (current_node.getNextNode() != null)
            {
                numsinll.add(current_node.getValue());
                current_node = current_node.getNextNode();
            }
            numsinll.add(current_node.getValue());

        }
        for (Integer element: numsinll)             //convert each integer in list to a string and concatonate strings to get a string of the sum
        {
            elementstring += element.toString();    //add element as a string to elementstring

        }

        return elementstring;
    }

    //this function takes in a linked list and returns an integer
    public Integer linkedlisttoint(LinkedList ll)
    {
        String str = ll.linkedlisttostring(ll);
        if (str == ""){
            return 0;
        }
        return Integer.parseInt(str);
    }


    public int linkedlistlength()
    {
        if (head == null)
        {
            return 0;
        }
        else
        {
            int count = 1;
            Node current_node = head;
            while (current_node.getNextNode() != null)
            {
                current_node = current_node.getNextNode();
                count ++;

            }
            return count;
        }

    }

    //this function reverses the linked list after padding it with zeros
    //helps make the two linked lists operated on the same size
    public void reverse()
    {
        Node previous_node = null;   // keeps track of the previous node
        Node current_node = head;
        Node next_node = null;      //create a node to hold the chain of broken off nodes
        while (current_node != null)
        {
            next_node = current_node.getNextNode();   //set the next node to the next node of the current node
            current_node.setNextNode(previous_node);    //make the null(previous node to current node) = to the next node of current (arrow of linkedlist reverses)
            previous_node = current_node;    //update linked list so that the previous node is the current node
            current_node = next_node;   //make the current node the next node that holds the remaining nodes of the linked list

        }
        head = previous_node;     //make head the last node of the linkedlist

    }

    //converts an integer value to  linked lists
    public LinkedList inttolinkedlist(Integer num) {

        String stringofnum = Integer.toString(num);
        ArrayList<String> stringofdigits = new ArrayList<>();
        LinkedList returnll = new LinkedList(null);

        //create array of char numbers in string to iterate through, then convert to int, then add to list
        char[] currentnumber = stringofnum.toCharArray();  // create an array of chars for each string (numbers in each number)
        for (int i = 0; i < currentnumber.length; i++){   //loop for each number in string
            String chartostring = String.valueOf(currentnumber[i]);  //convert characters to strings
            int stringtoint = Integer.valueOf(chartostring);   //make each subnumber an integer
            returnll.append(stringtoint);
        }
        return returnll;
    }

    //takes in reversed linked list and returns in same case (reversed)
    public void removeleadingzeros(LinkedList ll)
    {

        while (ll.head.getValue() == 0)
        {
            ll.head = ll.head.getNextNode();
        }
    }


}



