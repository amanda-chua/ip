import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles storage of tasks in File.
 */
public class Storage {
    protected static String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Creates new File if File does not exist then
     * loads Tasks into the TaskList using details from File.
     * @return ArrayList to be used to create a new TaskList.
     * @throws FileNotFoundException if File is not found.
     */
    public static ArrayList<Task> convertTextToTaskList() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File f = new File(filepath);
            f.createNewFile();
        } catch (IOException e) {
            Ui.showError(e.getMessage());
        }
        File f = new File(filepath);
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] taskInfo = input.split(" \\| ");
            Task convertedTask;
            String type = taskInfo[0];
            int status = Integer.parseInt(taskInfo[1]);
            String description = taskInfo[2];
            if (type.equals("T")) {
                convertedTask = new ToDo(description);
            } else {
                String time = taskInfo[3];
                if (type.equals("E")) {
                    convertedTask = new Event(description, time);
                } else {
                    convertedTask = new Deadline(description, time);
                }
            }
            if (status == 1) {
                convertedTask.markDone();
            }
            tasks.add(convertedTask);
        }
        return tasks;
    }

    /**
     * Writes data into the txt file whenever the task list changes
     * @param append Boolean to show if File can be appended
     * @param s task to be updated.
     * @param t TaskList.
     * @throws IOException if there is an error.
     */
    public static void writeTaskToFile(boolean append, String s, TaskList t) throws IOException {
        FileWriter fileWriter;
        if (!append) {
            fileWriter = new FileWriter(filepath);
            StringBuilder tasks = new StringBuilder();
            for (Task taskToAdd : t.taskList) {
                int status = taskToAdd.isDone ? 1 : 0;
                tasks.append(taskToAdd.getType()).append(" | ").append(status).append(" | ").append(taskToAdd.getFullDescription()).append("\n");
            }
            fileWriter.write(tasks.toString());
        } else {
            fileWriter = new FileWriter(filepath, true);
            fileWriter.append(s);
        }
        fileWriter.close();
    }
} 