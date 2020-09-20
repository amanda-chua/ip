import java.io.IOException;

public class AddCommand extends Command {
    protected static String cmd;
    protected static String details;

    public AddCommand(String s, String d) {
        cmd = s;
        details = d;
    }

    @Override
    public void execute(TaskList t, Ui u, Storage s) {
        Task task = new Task("null");
        if (cmd.equals("todo")) {
            task = new ToDo(details);
            t.taskList.add(task);
        } else if (cmd.equals("deadline")) {
            String date = details.split("/by ")[1];
            String description = details.split("/by ")[0];
            task = new Deadline(description, date);
            t.taskList.add(task);
        } else if (cmd.equals("event")) {
            String time = details.split("/at ")[1];
            String description = details.split("/at ")[0];
            task = new Event(description, time);
            t.taskList.add(task);
        }

        try {
            String text = task.getType() + " | 0 | " + task.getFullDescription() + "\n";
            s.writeTaskToFile(true, text, t);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        u.addOutput(task.toString(), t.taskList.size());
    }

}