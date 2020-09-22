/**
 * For creating objects to do.
 */
public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns type of Task object.
     * @return task type.
     */
    @Override
    public String getType() {
        return "T";
    }

    /**
     * Returns format of output shown to user after adding task.
     * @return task information to be shown in list.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
