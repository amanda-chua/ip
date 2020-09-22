import java.io.IOException;

/**
 * Handles the done command.
 */
public class DoneCommand extends Command {
    protected static int done;

    public DoneCommand(int d) {
        done = d;
    }

    /**
     * Marks a task as done from the taskList and
     * calls Ui to print done message.
     * @param t TaskList
     * @param u Ui
     * @param s Storage
     */
    @Override
    public void execute(TaskList t, Ui u, Storage s) {
        Task task = t.taskList.get(done);
        task.markDone();
        try {
            s.writeTaskToFile(false, "", t);
        } catch (IOException e) {
            u.showError(e.getMessage());
        }
        u.doneOutput(task.toString());
    }
}