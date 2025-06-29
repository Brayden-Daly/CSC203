public class Node {

    private Point currentposition;
    private int g;
    private int h;
    private Node previousnode;

    public Node(Point currentposition, int g, int h, Node previousnode){
        this.currentposition = currentposition;
        this.g = g;
        this.h = h;
        this.previousnode = previousnode;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getF() {return this.g + this.h;}

    public Node getPreviousnode() {
        return previousnode;
    }

    public Point getCurrentposition() {
        return currentposition;
    }
}
