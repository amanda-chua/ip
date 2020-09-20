import java.util.Scanner;

public class Ui {
    protected static Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public static void showWelcome() {
        String logoStart = "       _____________       \n"
                + "      /             \\     \n"
                + "  \\  /    >      <   \\  /\n"
                + "   \\|         *       |/ \n"
                + "     \\               /   \n"
                + "      \\_____________/    \n"
                + "         ^^     ^^        \n";
        System.out.println("Hello! I'm Duke");
        System.out.println(logoStart);
        System.out.println("What can I do for you?");
    }

    public static void showLine() {
        System.out.println("---------------------------------------------------------------------");
    }

    public static void showError(String s) {
        System.out.println(s);
    }

    public static String readCommand() {
        return sc.nextLine();
    }

    public static void showLoadingError() {
        System.out.println("File not found.");
    }

    public static void doneOutput(String str) {
        System.out.println("Nice! I've marked this task as done:\n " + str);
    }

    public static void deleteOutput(String str, int size) {
        System.out.println("Noted. I've removed this task: \n   " + str);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public static void addOutput(String str, int size) {
        System.out.println("Got it. I've added this task:\n " + str);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Now you have " + size + " tasks in the list!");
    }

    public static void list(TaskList tl) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tl.taskList.size(); i++) {
            System.out.println((i+1) + ". " + tl.taskList.get(i).toString());
        }
    }

    public static void exitLine() {
        String logoEnd = "       _____________       \n"
                + "      /             \\     \n"
                + "     /    x      x   \\   \n"
                + "  /\\|         ~       |/\\ \n"
                + "     \\               /   \n"
                + "   ~  \\_____________/    \n"
                + "  ~      ^^     ^^        \n";
        System.out.println(logoEnd);
        System.out.println("Bye. Hope to see you again soon!");
    }
}