/**
 * For creating Task objects.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns done status of Task.
     * @return done status of Task.
     */
    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    public void markDone() {
        this.isDone = true;
    }

    /**
     * Returns Task type.
     * @return null Task type.
     */
    public String getType() {
        return "null";
    }

    /**
     * Returns Task description.
     * @return description of task.
     */
    public String getFullDescription() {
        return description;
    }

    /**
     * Returns format of output shown to user after adding task.
     * @return task information to be shown in list.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

}