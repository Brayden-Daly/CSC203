
public interface Transform extends Entity, Execute {
    boolean transformEntity(WorldModel world, EventScheduler scheduler, ImageStore imageStore);

}
