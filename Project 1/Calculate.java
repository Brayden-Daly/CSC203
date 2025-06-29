

public class Calculate {

    //this method will be used to add both of the linked lists
    //if one of the linked lists is null, return the other linked list and vice versa
    public static LinkedList add(LinkedList num1, LinkedList num2) {
        BigNumArithmetic.padwithzeros(num1, num2);             //pad ll1 or ll2 with leading zeros to make them the same length and easier to operate with
        LinkedList summedll = new LinkedList(null);
        BigNumArithmetic.padwithzeros(num1, summedll);    //make the summedll full of zeros instead of nulls
        Node current1 = num1.head;
        Node current2 = num2.head;
        Node summedCurrent = summedll.head;    //current node (starting at head) of summation linked list


        while (current1 != null) //while both
        {
            //TODO: if adds to ten, add one to next node (Carry one), add two nodes, show linked list 3 linked lists: sum, l1, l2 .. l1 + l2 -> sum
            if (current1.getValue() + current2.getValue() >= 10 || summedCurrent.getValue() + current2.getValue() + current1.getValue() >= 10) {
                summedCurrent.setNextNode(new Node(1, null));
                summedCurrent.setValue((current1.getValue() + current2.getValue() + summedCurrent.getValue()) - 10);
                current2 = current2.getNextNode();
                current1 = current1.getNextNode();  //advance ll1 and ll2 and summedcurrent
                summedCurrent = summedCurrent.getNextNode();
                BigNumArithmetic.padwithzeros(num1, summedll);
            } else {
                summedCurrent.setNode(current1.getValue() + current2.getValue());   //set node value to current value + addition of next two values
                current2 = current2.getNextNode();
                current1 = current1.getNextNode();  //advance ll1 and ll2 and summedcurrent
                summedCurrent = summedCurrent.getNextNode();

            }
        }
        summedll.reverse();
        return summedll;
    }


        //takes in reversed linkedlist
    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        LinkedList maxlist;    //longer linkedlist
        LinkedList minlist;    //shorter linkedlist
        LinkedList sumoftwolinkedlists  = new LinkedList(null);
        LinkedList temporaryllfortenscarry = new LinkedList(null);
        LinkedList temporaryllforonescarry = new LinkedList(null);
        LinkedList tensaccum1 = new LinkedList(null);
        LinkedList onesaccum1 = new LinkedList(null);
        int countaccum = 1;
        int product = 0;            //keeps track of the product of each smaller multiplication
        double tenscarry = 0;      //keepts track of the tens value carried each multiplication
        int onescarry = 0;      //keepts track of the ones value carried each multiplication
        int tracker = 0;           //tracks multiplier for carried num

        //edgecase with zero
        if (num1.head.getValue() == 0 && num1.linkedlistlength() == 1)
        {
            return num1;
        }
        else if (num2.head.getValue() == 0 && num2.linkedlistlength() == 1)
        {
            return num2;
        }

        //get larger linked list of the two numbers
        if (num1.linkedlistlength() >= num2.linkedlistlength()) {
            maxlist = num1;
            minlist = num2;
        } else {
            maxlist = num2;
            minlist = num1;
        }

        Node maxcurr = maxlist.head;
        Node mincurr = minlist.head;

        while (mincurr != null) {
            //add tracker amount of zeros to linkedlistformultiplication
            //loop through ll2
                while (maxcurr != null) {
                    //get product of two node values
                    //get ones value and tens value of product
                    //get mult answer without tens value
                    //accumulate carried values
                    //add tens carry to one linked list
                    //append mult product to another linked list
                    //add linked lists
                    //reset tens carry
                    //reset ones carry
                    product = maxcurr.getValue() * mincurr.getValue();
                    tenscarry =  Math.floor(product / 10);
                    onescarry = (product % 10);


                    temporaryllfortenscarry.append((int) tenscarry);
                    temporaryllforonescarry.append(onescarry);
                    //add zeros to tens carry
                    for (int i = 0; i < countaccum; i++)
                    {
                        temporaryllfortenscarry.append(0);
                    }
                    for (int o = 0; o < countaccum - 1; o++)
                    {
                        temporaryllforonescarry.append(0);
                    }
                    for (int j = 0; j < tracker; j++)
                    {
                        temporaryllfortenscarry.append(0);
                        temporaryllforonescarry.append(0);
                    }

                    //reverse linked list for adding
                    temporaryllforonescarry.reverse();
                    temporaryllfortenscarry.reverse();

                    //accumulate tens carry and ones carry in linked list
                    //reverse adding linked lists after
                    tensaccum1 = add(temporaryllfortenscarry,  tensaccum1);
                    onesaccum1 = add(temporaryllforonescarry, onesaccum1);
                    tensaccum1.reverse();
                    onesaccum1.reverse();

                    //iterate to next node
                    maxcurr = maxcurr.getNextNode();
                    countaccum ++;
                    temporaryllforonescarry = new LinkedList(null);
                    temporaryllfortenscarry = new LinkedList(null);

                }

            countaccum = 1;
            maxcurr = maxlist.head;             //reset maxlist
            mincurr = mincurr.getNextNode();
            sumoftwolinkedlists = add(tensaccum1, onesaccum1);
            sumoftwolinkedlists.reverse();
            tracker ++;

        }
        sumoftwolinkedlists.reverse();
        sumoftwolinkedlists.removeleadingzeros(sumoftwolinkedlists);
        sumoftwolinkedlists.reverse();
        sumoftwolinkedlists.reverse();
        return sumoftwolinkedlists;
    }


    //ll1 ^ ll2
    //1. square ll1
    //2. check if ll2 is even or odd (check first value of ll2 since ll2 is reversed
    //3. if even (since n can fit in an int value, divide by 2) to get the exponent value
    //3b. loop the division amt and multiply the squared value by itself over and over
    //reverse the linked list after mulitplying each time since input of mult. function requires linked lists to be reversed
    //3c. return the end value
    //4. if odd, do the same thing as even, but subtract by 1 before dividing by two

    public static LinkedList exponent(LinkedList ll1, LinkedList ll2)
    {
        ll2.reverse();
        int ll2toint = ll2.linkedlisttoint(ll2);        //get exponent value (will fit in int)
        int even = ll2toint / 2;
        int odd = (ll2toint - 1) / 2;
        LinkedList squared = multiply(ll1, ll1);
        squared.reverse();
        LinkedList accumulator = new LinkedList(new Node(1, null));
        if (ll2toint == 0)
        {
            LinkedList templl = new LinkedList(new Node(1, null));
            return templl;
        }
        if (ll2toint % 2 == 0)                          //check if even
        {
            for (int i = 0; i < even; i++)
            {
                accumulator = multiply(squared, accumulator);        //get squared value
                accumulator.reverse();                   //reverse linkedlist so can multiply

            }
        }
        else
        {
            for (int i = 0; i < odd; i++)
            {
                accumulator = multiply(squared, accumulator);        //get squared value
                accumulator.reverse();                   //reverse linkedlist so can multiply

            }
            accumulator = multiply(accumulator, ll1);
            accumulator.reverse();
        }
        accumulator.reverse();
        return accumulator;

    }

}


//  FAILED MULT ATTEMPT 1
//
//    //multiply longer linked list by each element in shorter linked list  --> templinkedlist
//    //accumulate temporary linked list
//    //loop through longer linked list with while loop, keep iteration of shorter linkedlist to add that many zeros to temp linked list
//    public static LinkedList multiply(LinkedList num1, LinkedList num2)
//    {
//        LinkedList maxlist;    //longer linkedlist
//        LinkedList minlist;    //shorter linkedlist
//        LinkedList tempmult = new LinkedList(null);    //first multiplication ll
//        LinkedList multaccum = new LinkedList(null);    //second multiplication ll
//        LinkedList carryaccum = new LinkedList(null);       //accumulator for the carried values
//        LinkedList tempcarry = new LinkedList(null);
//        int tracker = 0;
//        double carryvalue = 0;
//
//
//        if (num1.linkedlistlength() >= num2.linkedlistlength())
//        {
//            maxlist = num1;
//            minlist = num2;
//        }
//        else{
//            maxlist = num2;
//            minlist = num1;
//        }
//        Node maxcurr = maxlist.head;
//        Node mincurr = minlist.head;
//        BigNumArithmetic.padwithzeros(tempmult, maxlist);
//        BigNumArithmetic.padwithzeros(carryaccum, maxlist);
//        Node tempnode = tempmult.head;
//        Node carrynode = carryaccum.head;
//        Node tempcarrynode = tempcarry.head;
//
//
//
//        //loop through and multiply current node two by each node in node 1
//        for (int i = 0; i < minlist.linkedlistlength(); i++)
//        {
//            tempmult.showlinkedlist();
//            for (int j = 0; j < i; j++){            // add i amount of zeros in the front of templist
//                tempnode = tempnode.getNextNode();
//                tempmult.append(0);
//
//            }
//            while (maxcurr != null)     //iterate through large number multiplying by one digit of small num
//            {
//                if (maxcurr.getValue() * mincurr.getValue() >= 10)   //if muliplication is less than ten
//                {
//                    //get value (then get carried value to add to the end)
//                    //append carry value and zero so its carryvalue -> 0 in linkedlist (factor of ten
//                    //reverse linked list
//                    //accumulate carried value
//                    //add carried accumulation to multiplication
//                    carryvalue = Math.floor((mincurr.getValue() * maxcurr.getValue()) / 10);
//                    tempcarry.append((int) carryvalue);
//                    for (int j = 0; j <= tracker; j++){            // add i amount of zeros in the front of tempcarry
//                        tempcarry.append(0);
//                    }
//                    int onesremainder = (mincurr.getValue() * maxcurr.getValue()) - (int) carryvalue * 10;
//                    tempcarry.reverse();
//                    tempcarry.showlinkedlist();
//                    carryaccum = add(carryaccum, tempcarry);
//                    carryaccum.reverse();
//                    //now we have accumulated the most current multiplication carry
//                    carryaccum.showlinkedlist();
//                    tempcarry = new LinkedList(null);
//                    BigNumArithmetic.padwithzeros(tempcarry, maxlist);
//                    tempcarry.showlinkedlist();
//
//                    tempnode.setValue(onesremainder);   //make the multiplication result append to mult 1
//                    tempnode = tempnode.getNextNode();     //move mult1 to next node
//                    tempmult.showlinkedlist();
//                    maxcurr = maxcurr.getNextNode();
//
//                    tracker ++;
//
//                }
//                else {
//                    tempnode.setValue(mincurr.getValue() * maxcurr.getValue());   //make the multiplication result append to mult 1
//                    tempnode = tempnode.getNextNode();     //move mult1 to next node
//                    tempmult.showlinkedlist();
//                    maxcurr = maxcurr.getNextNode();
//                }
//            }
//            maxcurr= maxlist.head;  //restart maxcurr linkedlist
//            multaccum = add(multaccum, tempmult);  //accumulate to multaccum
//            multaccum.reverse();
//            multaccum = add(multaccum, carryaccum);
//            multaccum.reverse();
//            tempmult = new LinkedList(null);
//            BigNumArithmetic.padwithzeros(tempmult, maxlist);
//            tempnode = tempmult.head;
//            mincurr = mincurr.getNextNode();
//        }
//        multaccum.reverse();
//        return multaccum;
//
//    }
//}


//FAILED MULT ATTEMPT 2

//        //takes in reversed linkedlist
//    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
//        LinkedList maxlist;    //longer linkedlist
//        LinkedList minlist;    //shorter linkedlist
//        LinkedList linkedlistformultiplication = new LinkedList(null);      //linked list after multiplying
//        LinkedList linkedlistforcarriedvalue = new LinkedList(null);        //linked list after accumulating carried values
//        LinkedList finalaccumlinkedlist = new LinkedList(null);
//        LinkedList sumoftwolinkedlists  = new LinkedList(null);
//        int product = 0;            //keeps track of the product of each smaller multiplication
//        double tenscarry = 0;      //keepts track of the tens value carried each multiplication
//        int onescarry = 0;      //keepts track of the ones value carried each multiplication
//        int tracker = 0;           //tracks multiplier for carried num
//        int onesaccum = 0;            //tracks how many 0s you input for the ones part of multiplication
//        double tensaccum = 0.0;
//        int carrycounter = 10;
//        double smallnumcounter = 1;
//        int finaltenscarry = 0;
//
//
//
//        if (num1.linkedlistlength() >= num2.linkedlistlength()) {
//            maxlist = num1;
//            minlist = num2;
//        } else {
//            maxlist = num2;
//            minlist = num1;
//        }
//
//        Node maxcurr = maxlist.head;
//        Node mincurr = minlist.head;
//
//        while (mincurr != null) {
//            //add tracker amount of zeros to linkedlistformultiplication
//            //loop through ll2
//
//
//                while (maxcurr != null) {
//                    //get product of two node values
//                    //get ones value and tens value of product
//                    //get mult answer without tens value
//                    //accumulate carried values
//                    //add tens carry to one linked list
//                    //append mult product to another linked list
//                    //add linked lists
//                    //reset tens carry
//                    //reset ones carry
//                    product = maxcurr.getValue() * mincurr.getValue();
//                    tenscarry = Math.floor(product / 10);
//                    onescarry = (product % 10) * (carrycounter / 10) * (int) smallnumcounter;
//                    finaltenscarry = (int) tenscarry * carrycounter * (int) smallnumcounter ;
//
//
////                    System.out.println(onescarry);
////                    System.out.println(finaltenscarry);
//
//
//
//                    tensaccum = (finaltenscarry + tensaccum);
//                    onesaccum = (onesaccum + onescarry);
//
////                    System.out.println(tensaccum);
////                    System.out.println(onesaccum);
//
//
//                    maxcurr = maxcurr.getNextNode();
//                    carrycounter = carrycounter * 10;
//
//                    linkedlistforcarriedvalue = linkedlistforcarriedvalue.inttolinkedlist((int) tensaccum);
//                    linkedlistformultiplication = linkedlistformultiplication.inttolinkedlist((int) onesaccum);
//
//
//                }
//                linkedlistforcarriedvalue.reverse();
//                linkedlistformultiplication.reverse();
//                maxcurr = maxlist.head;             //reset maxlist
////                linkedlistformultiplication.showlinkedlist();
////                linkedlistforcarriedvalue.showlinkedlist();
//                mincurr = mincurr.getNextNode();
//                sumoftwolinkedlists = add(linkedlistforcarriedvalue, linkedlistformultiplication);
//                sumoftwolinkedlists.reverse();
////                sumoftwolinkedlists.showlinkedlist();
//                finalaccumlinkedlist = add(sumoftwolinkedlists, finalaccumlinkedlist);
//                finalaccumlinkedlist.reverse();
//                carrycounter = 10;      //reset carrycounter
//                tensaccum = 0.0;        //reset tens counter
//                onesaccum = 0;
//                tracker ++;
//                smallnumcounter = Math.pow(10, tracker);
//
//        }
////            linkedlistformultiplication.showlinkedlist();
//
//
//
//        finalaccumlinkedlist.reverse();
//        return finalaccumlinkedlist;
//    }
