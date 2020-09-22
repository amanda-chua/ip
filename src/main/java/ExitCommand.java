/**
 * Handles the exit command.
 */
public class ExitCommand extends Command{

    public ExitCommand() {
        super();
        isExit = true;
    }

    /**
     * Calls Ui to print exit message.
     * @param t TaskList
     * @param u Ui
     * @param s Storage
     */
    @Override
    public void execute(TaskList t, Ui u, Storage s) {
        u.exitLine();
    }
}