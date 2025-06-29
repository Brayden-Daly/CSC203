/**
 * An action that can be taken by an entity
 */
public final class Animation implements Action {
    private final Entity entity;
    private final int repeatCount;

    public Animation(Entity entity, int repeatCount) {
        this.entity = entity;
        this.repeatCount = repeatCount;
    }

    public void executeAction(EventScheduler scheduler) {
        this.entity.nextImage();

        if (this.entity instanceof Scheduler) {
            if (this.repeatCount != 1) {
                scheduler.scheduleEvent(this.entity, new Animation(this.entity, Math.max(this.repeatCount - 1, 0)), ((Scheduler) this.entity).getAnimationPeriod());
            }
        }
    }

}
