
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * NOTE THAT THIS FILE WILL NOT COMPILE UNTIL YOU HAVE COPIED OVER YOUR
 * EMISSION, COUNTRY, AND SECTOR CLASSES TO THE part2 DIRECTORY
 */
public class MyTests {

    /**
     * Tests the implementation of the Emission class.
     *
     * TO-DO: Examine this test case to know what you should name your public methods.
     *
     * @throws NoSuchMethodException
     */


    //////////////////////////////////////////////
    //get the operator in the line of text file//
    //////////////////////////////////////////////

    //get operator for 3rd line in textfile
    @Test
    public void getoperator() {
        String operator = "*";
        String operator1 = new String();

        FileProcessor.processFile("testfile.txt");
        operator1 = FileProcessor.getoperator(2);

        assertEquals(operator, operator1);

    }

    //get operator for 2nd line in textfile
    @Test
    public void getoperator1() {
        String operator = "^";
        String operator1 = new String();

        FileProcessor.processFile("testfile.txt");
        operator1 = FileProcessor.getoperator(1);

        assertEquals(operator, operator1);

    }

    //////////////////////////////////////////////
    //getfirst and second number from input file//
    //////////////////////////////////////////////

    //get first operation's numbers
    @Test
    public void getnums() {
        Map<String, ArrayList<Integer>> numbers = new HashMap<>();
        Map<String, ArrayList<Integer>> numbers1 = new HashMap<>();
        ArrayList<Integer>newlist1 = new ArrayList<>();
        ArrayList<Integer>newlist2 = new ArrayList<>();

        newlist1.add(1);
        newlist2.add(2);
        numbers.put("num2", newlist2);
        numbers.put("num1", newlist1);
        FileProcessor.processFile("testfile.txt");
        numbers1 = FileProcessor.getfirstandsecondnum(0);

        assertEquals(numbers1, numbers);
    }

    //////////////////////////////////////////////
    //getfirst and second number from input file//
    //////////////////////////////////////////////

    //get first operation's numbers
    @Test
    public void getnums1() {
        Map<String, ArrayList<Integer>> numbers = new HashMap<>();
        Map<String, ArrayList<Integer>> numbers1 = new HashMap<>();
        ArrayList<Integer>newlist1 = new ArrayList<>();
        ArrayList<Integer>newlist2 = new ArrayList<>();

        newlist1.add(2);
        newlist2.add(4);
        numbers.put("num2", newlist2);
        numbers.put("num1", newlist1);
        FileProcessor.processFile("testfile.txt");
        numbers1 = FileProcessor.getfirstandsecondnum(1);

        assertEquals(numbers1, numbers);



    }


    //get first operation's numbers when there are multiple digits in each number
    @Test
    public void getnums2() {
        Map<String, ArrayList<Integer>> numbers = new HashMap<>();
        Map<String, ArrayList<Integer>> numbers1 = new HashMap<>();
        ArrayList<Integer>newlist1 = new ArrayList<>();
        ArrayList<Integer>newlist2 = new ArrayList<>();

        newlist1.add(3);
        newlist1.add(3);
        newlist1.add(3);
        newlist2.add(5);
        newlist2.add(3);
        newlist2.add(6);
        newlist2.add(4);

        numbers.put("num2", newlist2);
        numbers.put("num1", newlist1);
        FileProcessor.processFile("testfile.txt");
        numbers1 = FileProcessor.getfirstandsecondnum(2);

        assertEquals(numbers1, numbers);



    }

    ///////////
    //append///
    //////////

    //append one int
    @Test
    public void appendtoll() {
        //input string
        LinkedList ll = new LinkedList(null);
        ll.append(1);


        LinkedList expected = new LinkedList(null);
        expected.append(1);


        assertTrue(linkedlistsequals(ll, expected));



    }

    //append mulitple ints
    @Test
    public void appendtoll1() {
        //input string
        LinkedList ll = new LinkedList(null);
        ll.append(1);
        ll.append(2);
        ll.append(5);
        ll.append(1);

        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(2);
        expected.append(5);
        expected.append(1);

        assertTrue(linkedlistsequals(ll, expected));

    }

    /////////////////////
    //linkedlist length//
    ////////////////////

    //linkedlist with length greater than 1
    @Test
    public void lllength() {
        //input string
        LinkedList ll = new LinkedList(null);
        int linkedlistlength = 0;
        ll.append(1);
        ll.append(2);
        ll.append(5);
        ll.append(1);

        int expected = 4;

        assertEquals(ll.linkedlistlength(), expected);

    }


    //linkedlist with length of 1
    @Test
    public void lllength1() {
        //input string
        LinkedList ll = new LinkedList(null);
        int linkedlistlength = 0;
        ll.append(1);
        int expected = 1;

        assertEquals(ll.linkedlistlength(), expected);

    }

    //linkedlist with no appends (length of 0)
    @Test
    public void lllength2() {
        //input string
        LinkedList ll = new LinkedList(null);
        int linkedlistlength = 0;
        int expected = 0;

        assertEquals(ll.linkedlistlength(), expected);

    }

    ///////////
    //reverse//
    //////////

    //reverse with multiple elements
    @Test
    public void reverse() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);

        ll1.reverse();

        LinkedList expected = new LinkedList(null);
        expected.append(3);
        expected.append(2);
        expected.append(1);

        assertTrue(linkedlistsequals(ll1, expected));

    }

    ////////////////////////
    //remove leading zeros//
    ///////////////////////

    //remove multiple leading zeros
    @Test
    public void removeleadzeros() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(0);
        ll1.append(0);
        ll1.append(0);
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);

        ll1.removeleadingzeros(ll1);
        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(2);
        expected.append(3);

        assertTrue(linkedlistsequals(ll1, expected));

    }

    //no leading zeros
    @Test
    public void removeleadzeros1() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);

        ll1.removeleadingzeros(ll1);
        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(2);
        expected.append(3);

        assertTrue(linkedlistsequals(ll1, expected));

    }



    //reverse with one element
    @Test
    public void reverse1() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.reverse();

        LinkedList expected = new LinkedList(null);
        expected.append(1);

        assertTrue(linkedlistsequals(ll1, expected));

    }

    //reverse with no elements
    @Test
    public void reverse2() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.reverse();

        LinkedList expected = new LinkedList(null);

        assertTrue(linkedlistsequals(ll1, expected));

    }

    ////////////////////////
    //hashvaltolinkedlist//
    ///////////////////////

    //convert hash table value to linked list
    @Test
    public void hashvaltolinkedlist() {
        Map<String, ArrayList<Integer>> hashofnums = new HashMap<>();    //now should have hashmap of two nums for each operation
        ArrayList<Integer> ls = new ArrayList<>();
        LinkedList newll = new LinkedList(null);
        LinkedList newll1 = new LinkedList(null);

        ls.add(1);
        ls.add(2);
        ls.add(3);
        hashofnums.put("num1", ls);

        newll = BigNumArithmetic.hashvaltolinkedlist(hashofnums, "num1");

        //append to linkedlists

        newll1.append(1);
        newll1.append(2);
        newll1.append(3);

        assertTrue(linkedlistsequals(newll1, newll1));

    }

    //hash table with longer array
    @Test
    public void hashvaltolinkedlist1() {
        Map<String, ArrayList<Integer>> hashofnums = new HashMap<>();    //now should have hashmap of two nums for each operation
        ArrayList<Integer> ls = new ArrayList<>();
        LinkedList newll = new LinkedList(null);
        LinkedList newll1 = new LinkedList(null);

        hashofnums.put("num1", ls);

        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(0);
        ls.add(0);
        ls.add(4);
        ls.add(0);
        ls.add(0);
        ls.add(0);
        newll = BigNumArithmetic.hashvaltolinkedlist(hashofnums, "num1");

        //append to linkedlists
        newll1.append(1);
        newll1.append(2);
        newll1.append(3);
        newll1.append(0);
        newll1.append(0);
        newll1.append(4);
        newll1.append(0);
        newll1.append(0);
        newll1.append(0);


        assertTrue(linkedlistsequals(newll, newll1));

    }

    //hash table where the value is an empty array
    @Test
    public void hashvaltolinkedlist2() {
        Map<String, ArrayList<Integer>> hashofnums = new HashMap<>();    //now should have hashmap of two nums for each operation
        ArrayList<Integer> ls = new ArrayList<>();
        LinkedList newll = new LinkedList(null);
        LinkedList newll1 = new LinkedList(null);

        hashofnums.put("num1", ls);

        newll = BigNumArithmetic.hashvaltolinkedlist(hashofnums, "num1");

        //append to linkedlists


        assertTrue(linkedlistsequals(newll, newll1));

    }

    ////////////////////////
    //padding with zeros//
    ///////////////////////

    //remove multiple leading zeros
    @Test
    public void padwithzeros() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists

        ll1.append(1);
        ll1.append(2);
        ll1.append(3);

        ll2.append(1);

        BigNumArithmetic.padwithzeros(ll1, ll2);
        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(2);
        expected.append(3);
        expected.append(0);
        expected.append(0);
        expected.append(0);

        assertTrue(linkedlistsequals(ll2, expected));

    }

    ///////
    //add//     //good
    ///////

    //checks two triple digit nums add correctly
    @Test
    public void add() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);

        ll2.append(1);
        ll2.append(1);
        ll2.append(1);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.add(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(2);
        expected.append(3);
        expected.append(4);

        assertTrue(linkedlistsequals(result, expected));



    }

    //large number check
    @Test
    public void add1() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(2);
        ll1.append(4);
        ll1.append(5);
        ll1.append(2);
        ll1.append(1);
        ll1.append(5);

        ll2.append(9);
        ll2.append(9);
        ll2.append(3);
        ll2.append(7);
        ll2.append(1);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.add(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(3);
        expected.append(4);
        expected.append(4);
        expected.append(5);
        expected.append(8);
        expected.append(6);

        assertTrue(linkedlistsequals(result, expected));



    }

    //make sure 0 + 0 returns 0
    @Test
    public void add2() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(0);


        ll2.append(0);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.add(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(0);


        assertTrue(linkedlistsequals(result, expected));



    }

    //another really large number check
    @Test
    public void add3() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);

        //append to linkedlists
        ll1.append(2);
        ll1.append(4);
        ll1.append(5);
        ll1.append(2);
        ll1.append(7);
        ll1.append(5);
        ll1.append(7);
        ll1.append(7);
        ll1.append(7);
        ll1.append(7);
        ll1.append(5);

        ll2.append(9);
        ll2.append(9);
        ll2.append(8);
        ll2.append(7);
        ll2.append(1);
        ll2.append(9);
        ll2.append(9);
        ll2.append(3);
        ll2.append(7);
        ll2.append(1);
        ll2.append(9);
        ll2.append(9);
        ll2.append(3);
        ll2.append(7);
        ll2.append(1);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.add(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(9);
        expected.append(9);
        expected.append(8);
        expected.append(7);
        expected.append(4);
        expected.append(4);
        expected.append(4);
        expected.append(6);
        expected.append(4);
        expected.append(7);
        expected.append(7);
        expected.append(7);
        expected.append(1);
        expected.append(4);
        expected.append(6);

        assertTrue(linkedlistsequals(result, expected));



    }

/////////////////////////////////////
    //Linked List to String//               //good
    //////////////////////////////////

    //make sure it works with one node
    @Test
    public void linkedlisttostring() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(0);


        String output = ll1.linkedlisttostring(ll1);

        String result = "0";
        assertEquals(result, output);

    }

    //make sure it works with multiple nodes
    @Test
    public void linkedlisttostring1() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);
        ll1.append(4);
        ll1.append(5);
        ll1.append(6);
        ll1.append(7);
        ll1.append(8);
        ll1.append(9);
        ll1.append(0);


        String output = ll1.linkedlisttostring(ll1);

        String result = "1234567890";
        assertEquals(result, output);

    }

    //null linkedlist returns empty string
    @Test
    public void linkedlisttostring3() {
        //input string
        LinkedList ll1 = new LinkedList(null);




        String output = ll1.linkedlisttostring(ll1);

        String result = "";
        assertEquals(result, output);

    }

    /////////////////////////
    //linkedlist to integer//       //good
    /////////////////////////

    //make sure it works with multiple nodes
    @Test
    public void linkedlisttoint() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(1);
        ll1.append(2);
        ll1.append(3);
        ll1.append(4);
        ll1.append(5);
        ll1.append(6);
        ll1.append(7);
        ll1.append(8);
        ll1.append(9);
        ll1.append(0);


        Integer output = ll1.linkedlisttoint(ll1);

        Integer result = 1234567890;
        assertEquals(result, output);

    }

    //another check with two nodes
    @Test
    public void linkedlisttoint1() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(9);
        ll1.append(8);



        Integer output = ll1.linkedlisttoint(ll1);

        Integer result = 98;
        assertEquals(result, output);

    }

    //make sure it works with one node (only head)

    @Test
    public void linkedlisttoint2() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        //append to linkedlists
        ll1.append(9);



        Integer output = ll1.linkedlisttoint(ll1);

        Integer result = 9;
        assertEquals(result, output);

    }

    // make sure if it is an empty linked list it returns 0
    @Test
    public void linkedlisttoint3() {
        //input string
        LinkedList ll1 = new LinkedList(null);

        Integer output = ll1.linkedlisttoint(ll1);

        Integer result = 0;
        assertEquals(result, output);

    }


    ////////////
    //Multiply//
    ///////////


    @Test
    public void multiply() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(3);
        ll1.append(0);
        ll1.append(9);
        ll1.append(4);
        ll1.append(5);
        ll1.append(8);
        ll1.append(3);
        ll1.append(0);
        ll1.append(2);
        ll1.append(9);
        ll1.append(4);
        ll1.append(8);
        ll1.append(5);
        ll1.append(9);
        ll1.append(0);

        ll2.append(1);
        ll2.append(2);
        ll2.append(2);
        ll2.append(3);
        ll2.append(3);
        ll2.append(3);
        ll2.append(4);
        ll2.append(4);
        ll2.append(4);
        ll2.append(4);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.multiply(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(3);
        expected.append(7);
        expected.append(8);
        expected.append(5);
        expected.append(7);
        expected.append(1);
        expected.append(0);
        expected.append(0);
        expected.append(1);
        expected.append(1);
        expected.append(5);
        expected.append(0);
        expected.append(7);
        expected.append(1);
        expected.append(6);
        expected.append(4);
        expected.append(6);
        expected.append(8);
        expected.append(4);
        expected.append(3);
        expected.append(7);
        expected.append(0);
        expected.append(4);
        expected.append(9);
        expected.append(1);
        expected.append(7);
        expected.append(4);
        expected.append(5);
        expected.append(0);


        assertTrue(linkedlistsequals(result, expected));

    }

    @Test
    public void multiply1() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);
        ll1.append(1);

        ll2.append(1);
        ll2.append(2);
        ll2.append(2);
        ll2.append(3);
        ll2.append(3);
        ll2.append(3);
        ll2.append(4);
        ll2.append(4);
        ll2.append(4);
        ll2.append(4);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);
        ll2.append(5);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.multiply(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(3);
        expected.append(5);
        expected.append(9);
        expected.append(2);
        expected.append(6);
        expected.append(0);
        expected.append(4);
        expected.append(2);
        expected.append(5);
        expected.append(9);
        expected.append(1);
        expected.append(3);
        expected.append(5);
        expected.append(0);
        expected.append(6);
        expected.append(1);
        expected.append(7);
        expected.append(1);
        expected.append(6);
        expected.append(0);
        expected.append(5);



        assertTrue(linkedlistsequals(result, expected));

    }

    @Test
    public void multiply3() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(1);
        ll1.append(7);
        ll1.append(9);
        ll1.append(0);


        ll2.append(0);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.multiply(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(0);



        assertTrue(linkedlistsequals(result, expected));

    }

    @Test
    public void multiply4() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(0);

        ll2.append(1);
        ll2.append(0);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.multiply(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(0);



        assertTrue(linkedlistsequals(result, expected));

    }

    @Test
    public void multiply5() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(2);
        ll1.append(5);


        ll2.append(5);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.multiply(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(1);
        expected.append(2);
        expected.append(5);




        assertTrue(linkedlistsequals(result, expected));

    }


    //////////////
    //exponent////
    //////////////


    //num1 length > num2
    @Test
    public void exponent() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(2);
        ll1.append(5);


        ll2.append(5);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.exponent(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(9);
        expected.append(7);
        expected.append(6);
        expected.append(5);
        expected.append(6);
        expected.append(2);
        expected.append(5);

        assertTrue(linkedlistsequals(result, expected));

    }

    //Large exponent
    @Test
    public void exponent1() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(9);
        ll1.append(8);


        ll2.append(5);
        ll2.append(3);

        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.exponent(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(3);
        expected.append(4);
        expected.append(2);
        expected.append(7);
        expected.append(5);
        expected.append(3);
        expected.append(5);
        expected.append(8);
        expected.append(9);
        expected.append(5);
        expected.append(4);
        expected.append(0);
        expected.append(5);
        expected.append(5);
        expected.append(3);
        expected.append(8);
        expected.append(8);
        expected.append(4);
        expected.append(8);
        expected.append(4);
        expected.append(6);
        expected.append(0);
        expected.append(7);
        expected.append(0);
        expected.append(6);
        expected.append(5);
        expected.append(2);
        expected.append(3);
        expected.append(5);
        expected.append(1);
        expected.append(8);
        expected.append(8);
        expected.append(4);
        expected.append(8);
        expected.append(0);
        expected.append(6);
        expected.append(4);
        expected.append(9);
        expected.append(5);
        expected.append(3);
        expected.append(3);
        expected.append(1);
        expected.append(0);
        expected.append(3);
        expected.append(3);
        expected.append(6);
        expected.append(8);
        expected.append(0);
        expected.append(8);
        expected.append(9);
        expected.append(8);
        expected.append(8);
        expected.append(4);
        expected.append(2);
        expected.append(5);
        expected.append(9);
        expected.append(2);
        expected.append(1);
        expected.append(4);
        expected.append(0);
        expected.append(5);
        expected.append(7);
        expected.append(6);
        expected.append(2);
        expected.append(6);
        expected.append(8);
        expected.append(2);
        expected.append(8);
        expected.append(9);
        expected.append(0);
        expected.append(6);
        expected.append(7);
        expected.append(6);
        expected.append(4);
        expected.append(3);
        expected.append(1);
        expected.append(4);
        expected.append(2);
        expected.append(3);
        expected.append(2);
        expected.append(9);
        expected.append(4);
        expected.append(8);
        expected.append(5);
        expected.append(0);
        expected.append(7);
        expected.append(2);
        expected.append(7);
        expected.append(2);
        expected.append(6);
        expected.append(3);
        expected.append(9);
        expected.append(5);
        expected.append(8);
        expected.append(5);
        expected.append(1);
        expected.append(2);
        expected.append(9);
        expected.append(1);
        expected.append(5);
        expected.append(4);
        expected.append(4);
        expected.append(7);
        expected.append(8);
        expected.append(0);
        expected.append(8);
        assertTrue(linkedlistsequals(result, expected));

    }


    //if exponent is 1
    @Test
    public void exponent3() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(2);
        ll1.append(5);


        ll2.append(0);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.exponent(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(1);


        assertTrue(linkedlistsequals(result, expected));

    }

    //if number is 0 return 0
    @Test
    public void exponent4() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(0);


        ll2.append(2);


        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.exponent(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(0);


        assertTrue(linkedlistsequals(result, expected));

    }

    //number is one (answer should be 1)
    @Test
    public void exponent5() {
        //input string
        LinkedList ll1 = new LinkedList(null);
        LinkedList ll2 = new LinkedList(null);


        //append to linkedlists
        ll1.append(1);


        ll2.append(2);
        ll2.append(2);
        ll2.append(2);



        ll1.reverse();
        ll2.reverse();

        LinkedList result = Calculate.exponent(ll1, ll2);

        LinkedList expected = new LinkedList(null);
        expected.append(1);


        assertTrue(linkedlistsequals(result, expected));

    }



    //seperate helper function to test if linked lists are the same after operation
    public boolean linkedlistsequals(LinkedList ll1, LinkedList ll2) {
        Node current1 = ll1.head;
        Node current2 = ll2.head;

        while (current1 != null)
        {
            if (current1.getValue() != current2.getValue()){
                return false;
            }
            else{
                current1 = current2.getNextNode();
                current2 = current2.getNextNode();
            }
        }
        return true;
}



}
