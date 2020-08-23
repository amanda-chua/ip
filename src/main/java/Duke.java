import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();

        System.out.println("Hello! I'm Duke");
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
            else {
                Task newTask = new Task(line);
                System.out.println("added: " + line);
                tasks.add(newTask);

            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
