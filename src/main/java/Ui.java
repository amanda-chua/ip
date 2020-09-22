import java.util.Scanner;

/**
 * Handles user interface of Duke.
 */
public class Ui {
    protected static Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Prints welcome message.
     */
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

    /**
     * Prints out the divider that is to be used for each output
     */
    public static void showLine() {
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Prints out the errorMessage directly
     * @param s String to be printed
     */
    public static void showError(String s) {
        System.out.println(s);
    }

    /**
     * Reads user input
     * @return the user input
     */
    public static String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints out the error message
     */
    public static void showLoadingError() {
        System.out.println("File not found.");
    }

    /**
     * Prints message when a task is marked done.
     * @param str String representing Task marked done.
     */
    public static void doneOutput(String str) {
        System.out.println("Nice! I've marked this task as done:\n " + str);
    }

    /**
     * Prints message when a task is deleted.
     * @param str String representing Task deleted.
     * @param size integer representing remaining size of the TaskList.
     */
    public static void deleteOutput(String str, int size) {
        System.out.println("Noted. I've removed this task: \n   " + str);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Prints message when a task is added.
     * @param str String representing Task added.
     * @param size integer representing size of the TaskList.
     */
    public static void addOutput(String str, int size) {
        System.out.println("Got it. I've added this task:\n " + str);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Now you have " + size + " tasks in the list!");
    }

    /**
     * Prints the list of all Tasks in the TaskList.
     * @param tl Current TaskList.
     */
    public static void list(TaskList tl) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tl.taskList.size(); i++) {
            System.out.println((i+1) + ". " + tl.taskList.get(i).toString());
        }
    }

    /**
     * Prints exit message.
     */
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