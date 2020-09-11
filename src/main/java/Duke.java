import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void printTask(Task taskType,  ArrayList<Task> tasks){
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + taskType);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Now you have " + tasks.size() + " tasks in the list!\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        String logoStart = "       _____________       \n"
                + "      /             \\     \n"
                + "  \\  /    >      <   \\  /\n"
                + "   \\|         *       |/ \n"
                + "     \\               /   \n"
                + "      \\_____________/    \n"
                + "         ^^     ^^        \n";
        String logoEnd = "       _____________       \n"
                + "      /             \\     \n"
                + "     /    x      x   \\   \n"
                + "  /\\|         ~       |/\\ \n"
                + "     \\               /   \n"
                + "   ~  \\_____________/    \n"
                + "  ~      ^^     ^^        \n";
        System.out.println("Hello! I'm Duke");
        System.out.println(logoStart);
        System.out.println("What can I do for you?");

        while(!in.hasNext("bye")) {
            String line = in.nextLine();
            try {
                if (line.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                } else if (line.startsWith("done")) {
                    int taskNo = Integer.parseInt(line.substring(5));
                    Task chosenTask = tasks.get(taskNo - 1);
                    chosenTask.markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(" " + chosenTask);
                } else if (line.startsWith("todo")) {
                    int noOfWords = 0;
                    for (String description : line.split(" ")) {
                        noOfWords++;
                    }
                    if (noOfWords > 1) {
                        Task toDo = new ToDo(line.replace("todo ", ""));
                        tasks.add(toDo);
                        printTask(toDo, tasks);
                    } else {
                        System.out.println("-------------------------------------------------------------------\n" +
                                "☹ OOPS!!! The description of a todo cannot be empty.\n" +
                                "-------------------------------------------------------------------\n");
                    }
                } else if (line.startsWith("deadline")) {
                    try {
                        String deadline = line.split(" ", 2)[1];
                        try {
                            String date = deadline.split("/")[1];
                            String description = deadline.split("/")[0].replace(" ", "");
                            Task taskDeadline = new Deadline(description, date);
                            tasks.add(taskDeadline);
                            printTask(taskDeadline, tasks);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new DukeException("-------------------------------------------------------------------\n" +
                                    "☹ OOPS!!! The deadline date cannot be empty.\n" +
                                    "-------------------------------------------------------------------\n");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new DukeException("-------------------------------------------------------------------\n" +
                                "☹ OOPS!!! The deadline description cannot be empty.\n" +
                                "-------------------------------------------------------------------\n");
                    }
                } else if (line.startsWith("event")) {
                    try {
                        String event = line.split(" ", 2)[1];
                        try {
                            String time = event.split("/")[1];
                            String description = event.split("/")[0].replace(" ", "");
                            Task taskEvent = new Event(description, time);
                            tasks.add(taskEvent);
                            printTask(taskEvent, tasks);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new DukeException("-------------------------------------------------------------------\n" +
                                    "☹ OOPS!!! The event time cannot be empty.\n" +
                                    "-------------------------------------------------------------------\n");
                        }
                    } catch(ArrayIndexOutOfBoundsException e) {
                            throw new DukeException("-------------------------------------------------------------------\n" +
                                    "☹ OOPS!!! The event description cannot be empty.\n" +
                                    "-------------------------------------------------------------------\n");
                    }
                } else {
                    throw new DukeException("-------------------------------------------------------------------\n" +
                            "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                            "-------------------------------------------------------------------\n");
                }
            } catch(DukeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(logoEnd);
    }

}
