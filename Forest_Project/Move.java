import java.util.ArrayList;
import java.util.List;

public interface Move extends Execute{
    boolean moveEntity(WorldModel world, Entity target, EventScheduler scheduler);

    default
    Point nextPositionEntity(WorldModel world, Point destPos){
        Point newPos;

        AStarPathingStrategy newstrategy = new AStarPathingStrategy();    //create a new pathing strategy
        List<Point> pathforentity = newstrategy.computePath(this.getPosition(),
                                                            destPos,
                                                            point -> world.withinBounds(point) &&
                                                                    !(world.isOccupied(point) && world.getOccupancyCell(point).getClass() != Stump.class),
                                                            (point, point2) -> ((point.x == point2.x + 1 && point.y == point2.y)
                                                                    || (point.x == point2.x - 1 && point.y == point2.y)
                                                                    || (point.y == point2.y - 1 && point.x == point2.x)
                                                                    || (point.y == point2.y + 1 && point.x == point2.x)),
                                                            PathingStrategy.CARDINAL_NEIGHBORS);


        if (pathforentity.isEmpty() || pathforentity == null) {
            newPos =  this.getPosition();
        }
        else{
            newPos = pathforentity.get(0);
        }

        return newPos;

    }

}



