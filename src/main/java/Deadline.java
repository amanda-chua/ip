/**
 * For creating Deadline objects.
 */
public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns type of Task object.
     * @return task type.
     */
    @Override
    public String getType() {
        return "D";
    }

    /**
     * Returns text to File.
     * @return Deadline task information to File.
     */
    @Override
    public String getFullDescription() {
        return description + " | " + by;
    }

    /**
     * Returns format of output shown to user after adding task.
     * @return Deadline task information to be shown in list.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
