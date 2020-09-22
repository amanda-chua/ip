/**
 * For creating Event objects.
 */
public class Event extends Task{
    protected String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    /**
     * Returns type of Task object.
     * @return task type.
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Returns text to File.
     * @return Event task information to File.
     */
    @Override
    public String getFullDescription() {
        return description + " | " + time;
    }

    /**
     * Returns format of output shown to user after adding task.
     * @return Event task information to be shown in list.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";
    }

}
