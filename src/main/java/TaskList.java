import java.util.ArrayList;

/**
 * Handles storing Tasks in an ArrayList.
 */
public class TaskList {
    protected static ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> l) {
        this.taskList = l;
    }

    public ArrayList<Task> contains(String keyword) {
        ArrayList<Task> result = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.description.contains(keyword)) {
                result.add(task);
            }
        }
        return result;
    }
}