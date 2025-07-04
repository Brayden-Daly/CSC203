import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
public class AstarTest {
    @Test
    public void testastar() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(1, 0);
        Point end = new Point(1, 2);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(1, 1));
        assertEquals(expected, path);
    }


    @Test
    public void testastar1() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(1, 0);
        Point end = new Point(2, 2);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(1, 1), new Point(2, 1));
        assertEquals(expected, path);
    }


    @Test
    public void testastar2() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, false },
                { true, true, true }
        };
        Point start = new Point(1, 0);
        Point end = new Point(2, 2);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(1, 1), new Point(1, 2));
        assertEquals(expected, path);
    }


    @Test
    public void testastar3() {
        boolean[][] grid = {
                { true, true, true, true},
                { false, false, false, true },
                { true, true, true, true },
                { true, true, false, true }


        };
        Point start = new Point(1, 0);
        Point end = new Point(1, 3);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(2, 0), new Point(3, 0), new Point(3, 1), new Point(3, 2), new Point(2, 2), new Point(1, 2));
        assertEquals(expected, path);
    }


    @Test
    public void testastar4() {
        boolean[][] grid = {
                { true, true, true, true},
                { true, false, false, true },
                { true, true, true, true },
                { false, true, false, true }


        };
        Point start = new Point(1, 0);
        Point end = new Point(1, 3);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2));
        assertEquals(expected, path);
    }

    @Test
    public void testastar5() {
        boolean[][] grid = {
                { true, false, false, false, true, true},
                { true, false, true, true, true, false},
                { true, true, true, false, true, true},
                { false, false, false, false, false, true},
                { true, true, true, true, true, true},
                { true, true, false, false, false, true},


        };
        Point start = new Point(1, 5);
        Point end = new Point(0, 0);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(1, 4), new Point(2, 4), new Point(3, 4), new Point(4, 4), new Point(5, 4), new Point(5, 3), new Point(5, 2), new Point(4, 2), new Point(4, 1), new Point(3, 1), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(0, 2), new Point(0, 1));
        assertEquals(expected, path);


    }

    @Test
    public void testastar6() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(1, 1);
        Point end = new Point(2, 1);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of();
        assertEquals(expected, path);
    }

    @Test
    public void testastar7() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(1, 1);
        Point end = new Point(1, 1);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(1,2));
        assertEquals(expected, path);
    }


    @Test
    public void testastar8() {
        boolean[][] grid = {
                { true, false, false },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);
        PathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start, end,
                p -> withinBounds(p, grid) && grid[p.y][p.x], // canPassThrough
                (p1, p2) -> p1.adjacent(p2), // withinReach
                PathingStrategy.CARDINAL_NEIGHBORS // potentialNeighbors
        );
        List<Point> expected = List.of(new Point(0,1), new Point(1, 1), new Point(2,1));
        assertEquals(expected, path);
    }
//    @Test
//// Write more tests including obstacles and other edge cases.
///*
//* Properties of a correct a-star path. You don't know how your PriorityQueue
//will behave
//* regarding equally-good nodes. So instead checking the exact path returned,
//you could
//* instead check that the path has the following properties.
//*
//* 1. path length
//* 2. path starts at the start point and ends at the goal
//* 3. path actually contains contiguous nodes
//*/
//// // property based testing
//    private static boolean isValidPath(List<Point> path, int expectedLength, Point start, Point end) {
//// check that path contains exactly the expected number of steps
//        if (path.size() != expectedLength) {
//            return false;
//        }
//// The path's first step should be next to start
//        if (!path.isEmpty() && !start.adjacent(path.get(0))) {
//            return false;
//        }
//// The path's last step should be next to the target
//        if (!path.isEmpty() && !end.adjacent(path.get(path.size() - 1))) {
//            return false;
//        }
//// The path should contain a series of adjacent nodes
//        Point prev = null;
//        for (Point current : path) {
//            if (prev != null && !current.adjacent(prev)) {
//                return false;
//            }
//            prev = current;
//        }
//        return true;
//    }
    private static boolean withinBounds(Point p, boolean[][] grid) {
        return p.y >= 0 && p.y < grid.length &&
                p.x >= 0 && p.x < grid[0].length;
    }
}
