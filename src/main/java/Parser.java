public class Parser {

    public static Command parse(String input) throws DukeException {
        String[] array = input.split(" ", 2);
        String cmd = array[0];
        int noOfWords = array.length;
        Command c = null;
        boolean addTaskCmd = cmd.equals("todo") || cmd.equals("event") || cmd.equals("deadline");

        if (!cmd.equals("todo") && !cmd.equals("deadline") && !cmd.equals("event") && !cmd.equals("bye") && !cmd.equals("list") && !cmd.equals("done") && !cmd.equals("delete") && !cmd.equals("find")) {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        } else if ((addTaskCmd || cmd.equals("find")) && (noOfWords == 1)) {
                throw new DukeException("☹ OOPS!!! The " + cmd + " description cannot be empty.\n");
        } else {
            if (cmd.equals("event") && !input.contains("/at")) {
                throw new DukeException("☹ OOPS!!! The " + cmd + " time cannot be empty.\n");
            } else if (cmd.equals("deadline") && !input.contains("/by")) {
                throw new DukeException("☹ OOPS!!! The " + cmd + " date cannot be empty.\n");
            }
        }

        if (cmd.equals("done")) {
            int taskNo = Integer.parseInt(input.substring(5));
            c = new DoneCommand(taskNo- 1);
        } else if (addTaskCmd) {
            c = new AddCommand(cmd, array[1].trim());
        } else if (cmd.equals("delete")) {
            int taskNo = Integer.parseInt(input.substring(7));
            c = new DeleteCommand(taskNo- 1);
        } else if (cmd.equals("list")) {
            c = new ListCommand();
        } else if (cmd.equals("find")) {
            c = new FindCommand(array[1].trim());
        } else {
            if (cmd.equals("bye")) {
                c = new ExitCommand();
            }
        }
        return c;
    }
}