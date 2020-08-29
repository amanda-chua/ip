import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();

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

        line = in.nextLine();
        while(!line.equals("bye")) {
            if(line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<tasks.size(); i++) {
                    System.out.println((i+1) + "." + tasks.get(i));
                }
            }
            else if(line.startsWith("done")) {
                int taskNo = Integer.parseInt(line.substring(5));
                Task chosenTask = tasks.get(taskNo-1);
                chosenTask.markDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" " + chosenTask);
            }
            else if(line.startsWith("todo")){
                Task toDo = new ToDo(line.replace("todo ", ""));
                tasks.add(toDo);
                printTask(toDo, tasks);
            }
            else if(line.startsWith("deadline")){
                String date = line.split("/")[1];
                String description = line.split("/")[0].replace("deadline ", "");
                Task taskDeadline = new Deadline(description, date);
                tasks.add(taskDeadline);
                printTask(taskDeadline, tasks);
            }
            else if(line.startsWith("event")){
                String time = line.split("/")[1];
                String description = line.split("/")[0].replace("deadline ", "");
                Task taskEvent = new Event(description, time);
                tasks.add(taskEvent);
                printTask(taskEvent, tasks);
            }
            else {
                Task newTask = new Task(line);
                System.out.println("added: " + line);
                tasks.add(newTask);
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(logoEnd);
    }

    public static void printTask(Task taskType,  ArrayList<Task> tasks){
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + taskType);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
