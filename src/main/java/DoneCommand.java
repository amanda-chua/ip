import java.io.IOException;

public class DoneCommand extends Command {
    protected static int done;

    public DoneCommand(int d) {
        done = d;
    }

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