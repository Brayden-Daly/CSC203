
public abstract class Scheduler implements Entity {

    private final double actionPeriod;
    private final double animationPeriod;

    public Scheduler(double actionPeriod, double animationPeriod) {
        this.actionPeriod = actionPeriod;
        this.animationPeriod = animationPeriod;
    }
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
                scheduler.scheduleEvent(this, new Activity(this, world, imageStore), this.actionPeriod);
                scheduler.scheduleEvent(this, new Animation(this, 0), getAnimationPeriod());
    }

    public double getAnimationPeriod() {
        return this.animationPeriod;
    }
}
