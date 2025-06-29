import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class AStarPathingStrategy implements PathingStrategy{

    @Override
    public List<Point> computePath(Point start, Point end, Predicate<Point> canPassThrough, BiPredicate<Point, Point> withinReach, Function<Point, Stream<Point>> potentialNeighbors) {
        Node startnode = new Node(start, 0, abs(start.x - end.x) + abs(start.y - end.y), null);
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparing(Node::getF));            //created open and closed lists
        HashSet<Point> closedList = new HashSet<>();
        List<Point> ll1 = new ArrayList<>();

        openList.add(startnode);
        Node current = openList.peek();                             //get first node in the priority queue


        while(!openList.isEmpty() && !withinReach.test(current.getCurrentposition(), end)){
            Node newcurrent = current;
            AtomicBoolean checked = new AtomicBoolean(false);
            potentialNeighbors.apply(current.getCurrentposition())      //apply to potential neighbors
                    .filter(canPassThrough)                             //check which neighbors you can pass through
                    .filter(neighbor -> !closedList.contains(neighbor)) //make sure neighbor is not in closed list already
                    .map(p -> new Node(p, newcurrent.getG() + 1, abs(p.x - newcurrent.getCurrentposition().x) + abs(p.y - newcurrent.getCurrentposition().y), newcurrent))                     //
                    .forEach(n -> {

                        for (Node element: openList) //checks if the neighbor node is in the open list
                        {
                            if (n.getCurrentposition().equals(element.getCurrentposition()))        //if the node is in the open list, set the checked variable to new
                            {
                                checked.set(true);
                            }
                        }
                        if (openList.removeIf(p -> p.getCurrentposition().equals(n.getCurrentposition()) && n.getF() < p.getF()) || !checked.get()) { //if it is not in the open list and f value of new is less than f value of original

                            openList.add(n);            //if it is not in the openlist, or it is in t
                        }
                        checked.set(false);
                    }
                    );     //add the number to open list if it should go into open list
                closedList.add(current.getCurrentposition());
                openList.remove(current);
                if (openList.peek() != null)
                {
                    current = openList.peek();
                }
        }

        // go through open list and add to list until node value is null
        if (withinReach.test(current.getCurrentposition(), end)){
            current = openList.peek();
            while(current.getPreviousnode() != null)
            {
                ll1.add(0, current.getCurrentposition());       //removes most priority node from priority queue and adds to linked list
                current = current.getPreviousnode();
            }
        }

        return ll1;
    }
}
