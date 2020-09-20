public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    public void markDone() {
        this.isDone = true;
    }

    public String getType() {
        return "null";
    }

    public String getFullDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

}