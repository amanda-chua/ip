public class Task {
    protected String description;
    protected boolean isDone;
    protected int status;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.status = 0;
    }

    public String getStatusIcon() {
        return (isDone ? "Y" : "N"); //return Y for Yes or N for No
    }

    public void markDone() {
        this.isDone = true;
        this.status = 1;
    }

    public String writeToFile() {
        return "Task|" + status + "|" + description;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

}