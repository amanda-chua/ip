import java.io.IOException;

public class DeleteCommand extends Command {
    protected static int delete;

    public DeleteCommand(int d) {
        delete = d;
    }

    @Override
    public void execute(TaskList t, Ui u, Storage s) {
        Task task = t.taskList.get(delete);
        t.taskList.remove(delete);
        try {
            s.writeTaskToFile(false, "", t);
        } catch (IOException e) {
            u.showError(e.getMessage());
        }
        u.deleteOutput(task.toString(), t.taskList.size());
    }
}