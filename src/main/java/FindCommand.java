public class FindCommand extends Command {
    protected static String keyword;

    public FindCommand(String s) {
        keyword = s;
    }

    @Override
    public void execute(TaskList t, Ui u, Storage s) {
        u.findMatchMessage(t.contains(keyword));
    }
}