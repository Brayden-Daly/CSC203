public class Node {

    private int value;   //value of object in linkedlist
    private Node nextNode;   //nextnode object in linkedlist

    public Node(int value, Node nextNode)
    {
        this.value = value;
        this.nextNode = nextNode;
    }

    //getter method for getting value of node
    public int getValue() {
        return value;
    }

    //set the value of the current node

    public void setValue(int valueofnode)
    {
        this.value = valueofnode;
    }

    // getter method for getting next node
    public Node getNextNode() {
        return nextNode;
    }

    // setter method for getting next node
    public void setNextNode(Node node) {
        nextNode = node;
    }

    // setter method for getting next node
    public void setNode(int val) {
         value += val;
    }
}
