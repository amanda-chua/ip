/**
 * Abstract Command class for Command objects.
 */
public abstract class Command {
    protected static boolean isExit;

    public Command() {
        isExit = false;
    }

    /**
     * For Commands execution.
     * @param t TaskList
     * @param u Ui
     * @param s Storage
     */
    public abstract void execute(TaskList t, Ui u, Storage s);

    public static boolean isExit() {
        return isExit;
    }
}