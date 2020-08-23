import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<String>();

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        line = in.nextLine();

        while (!line.equals("bye")) {
            if (line.equals("list")) {
                for(int i=0; i<tasks.size(); i++){
                    System.out.println((i+1) + "." + tasks.get(i));
                }
            }
            else {
                System.out.println("added: " + line);
                tasks.add(line);

            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");

    }
}
