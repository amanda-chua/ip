public abstract class Command {
    protected static boolean isExit;

    public Command() {
        isExit = false;
    }

    public abstract void execute(TaskList t, Ui u, Storage s);

    public static boolean isExit() {
        return isExit;
    }
}