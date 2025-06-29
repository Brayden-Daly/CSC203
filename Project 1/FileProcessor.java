import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileProcessor {

    //create an array to hold all the non-blank lines in the command-line argument
    private static ArrayList<String> listofCommandLineArgs = new ArrayList<>();


    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine().replace(" ", "");   // take out spaces
                // TODO: Process each line of the input file, handling blank 
                // lines and spacing differences as appropriate
                line = line.replace(" ", "");
                if (!line.isEmpty())   // if there is not a blank line add to the array of command arguments
                {
                    listofCommandLineArgs.add(line);
                }
                else{
                    continue;                 //continue goes to next iteration of loop if the line is empty
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    //method that returns a list of command line arguments (operations inputted by the user)
    public static ArrayList<String> cleanedlistofargs()
    {
        return listofCommandLineArgs;     //return the list of command line arguments
    }

    //method that returns a list numbers that represents the number before the operand
    //this method converts the operation into an array strings seperated by an X
    //
    //These array of arrays will be used to put the two numbers into a linked list in backwards order
    //1. GET OPERATION OF FILE (input iteration number related to operation into function)
    //2. Turn the operation into an array of strings (Seperated by operator) -> strings are the two numbers
    //3. turn each string (number) into a character array (of subnumbers) and input those two chararrays into Hashmap
    //4. return hashmap
    public static Map<String, ArrayList<Integer>> getfirstandsecondnum(int iteration)
    {
        Map<String, ArrayList<Integer>> numbers = new HashMap<>();

        //get the string at the iteration of the array
        String operation1string = listofCommandLineArgs.get(iteration);
        String[] arrayofstrings = operation1string.split("[+*^]");  //create an array of strings for each number
        int counter = 1;   //initialize counter for hasmap key
        for (String elements: arrayofstrings)     // loop through the strings (one string per each number)
        {
            ArrayList<Integer> seperatedstrings= new ArrayList<>();
            //create array of char numbers in string to iterate through, then convert to int, then add to list
            char[] currentnumber = elements.toCharArray();  // create an array of chars for each string (numbers in each number)
            for (int i = 0; i < currentnumber.length; i++){   //loop for each number in string
                String chartostring = String.valueOf(currentnumber[i]);  //convert characters to strings
                int stringtoint = Integer.valueOf(chartostring);   //make each subnumber an integer
                seperatedstrings.add(stringtoint);   //add integer to array that goes into hashmap
            }
            numbers.put("num" + counter, seperatedstrings);   //put array of numbers into hashmap at designated key
            counter ++;   //accumulate to counter
        }



        return numbers;
    }


        // this function gets the operator on the operation line
    public static String getoperator(int iteration)
    {
            String operation1string = listofCommandLineArgs.get(iteration);
            String[] arrayofstrings1 = operation1string.split("[+]");
            String[] arrayofstrings2 = operation1string.split("[*]");
            String[] arrayofstrings3 = operation1string.split("\\^");
            String operator = "";

            if (arrayofstrings1.length == 2)
            {
                operator = "+";
            }
            else if (arrayofstrings2.length == 2)
            {
                operator =  "*";
            }
            else if (arrayofstrings3.length == 2)
            {
                operator =   "^";
            }
            return operator;
    }


        // this function turns a list of integers into a string representing that number
    public static String listinttostring(ArrayList<Integer> ls)
    {
        ArrayList<String> newlist = new ArrayList<>();
        for (Integer element: ls)
        {
            String newelement = element.toString();
            newlist.add(newelement);
        }
        String newstring = String.join("", newlist);
        return newstring;
    }




}
