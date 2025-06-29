import java.util.ArrayList;
import java.util.Map;

import static java.lang.Math.abs;

public class BigNumArithmetic {

    private ArrayList<String> afteroperations = new ArrayList<>();  // create an array to store finished operations


    /**
     * The entry point of the program.
     *
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
       LinkedList ll1 = new LinkedList(null);  //create new linkedlist instance in the method
        LinkedList ll2 = new LinkedList(null);  //create new linkedlist instance in the method
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Expected exactly 1 argument: a file name.");
        }
        String filePath = args[0];
        FileProcessor.processFile(filePath);
        ArrayList<String> cleanedarguments = FileProcessor.cleanedlistofargs(); //cleans the spaces and blank lines from inputs
        int lencleanedargs = cleanedarguments.size();  //get length of cleaned arguments
        LinkedList answer = Calculate.add(ll1,ll2);
        for (int i = 0; i < lencleanedargs; i++) {    //iterate through operations and do them one by one then add to array and print (need index in order to use getfirstandsecondnum)
            //TODO: put each number into a linked list then add and reverse the order of array
            //get operation and use firstandsecondnum to get hashmap of that opertion's numbers
            Map<String, ArrayList<Integer>> hashofnums = FileProcessor.getfirstandsecondnum(i);    //now should have hashmap of two nums for each operation
            String operator = FileProcessor.getoperator(i);  //get the operator
            ArrayList<Integer> str1 = hashofnums.get("num1");   //get first num
            ArrayList<Integer> str2 = hashofnums.get("num2");    //get first num
            ll1 = hashvaltolinkedlist(hashofnums, "num1");  //convert hashmap of two lists (numbers in operation) to reversed linked lists of numbers (operation nums)
            ll2 = hashvaltolinkedlist(hashofnums, "num2");  //convert hashmap of two lists (numbers in operation) to reversed linked lists of numbers (operation nums)
            ll1.reverse();          //reverse ll1 and ll2
            ll2.reverse();
            if (operator == "+")
            {
                answer = Calculate.add(ll1,ll2);
            }
            else if (operator == "*")
            {
                answer = Calculate.multiply(ll1,ll2);
            }
            else
            {
                answer = Calculate.exponent(ll1,ll2);
            }
            String strofanswer  = answer.linkedlisttostring(answer);      //string of the answer of added/mult/exp linkedlist operation
            String returnstr1 = FileProcessor.listinttostring(str1);
            String returnstr2 = FileProcessor.listinttostring(str2);

            System.out.print(returnstr1 + " " + operator + " " +  returnstr2 + " = " + strofanswer + "\n");



        }


    }


    //this function takes in the list from the hasmap (as well as the key string) and returns a linked list of the values in the list
    public static LinkedList hashvaltolinkedlist(Map<String, ArrayList<Integer>> hashofnums, String str){   //NOT FINISHED
        //loop through the list and append to linked list in reversed order
        LinkedList LL = new LinkedList(null);  //create new linkedlist instance in the method
        for (int element: hashofnums.get(str))
        {
            LL.append(element);
        }
        return LL;
    }

    //if num1 and num2 not the same lengths, pad with zeros until they are equal in amount of nodes
    //should make looping through linked lists easier in operations method
    public static void padwithzeros(LinkedList num1, LinkedList num2)
    {
        int diff = abs(num1.linkedlistlength() - num2.linkedlistlength());  // get difference in lengths for for loops
        if (num1.linkedlistlength() != num2.linkedlistlength())   // if they have different amounts of digits
        {
            if (num1.linkedlistlength() > num2.linkedlistlength()){
                for (int i = 0 ; i < diff; i++)
                {
                    num2.append(0);
                }
            }
            else{
                for (int i = 0 ; i < diff; i++)
                {
                    num1.append(0);
                }
            }
        }
    }

    //if num1 and num2 not the same lengths, pad with zeros until they are equal in amount of nodes
    //should make looping through linked lists easier in operations method
    public static void padwithones(LinkedList num1, LinkedList num2)
    {
        int diff = abs(num1.linkedlistlength() - num2.linkedlistlength());  // get difference in lengths for for loops
        if (num1.linkedlistlength() != num2.linkedlistlength())   // if they have different amounts of digits
        {
            if (num1.linkedlistlength() > num2.linkedlistlength()){
                for (int i = 0 ; i < diff; i++)
                {
                    num2.append(1);
                }
            }
            else{
                for (int i = 0 ; i < diff; i++)
                {
                    num1.append(1);
                }
            }
        }
    }




}




