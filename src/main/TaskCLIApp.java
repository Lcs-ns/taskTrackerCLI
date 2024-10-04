import java.util.Scanner;
import com.google.gson.Gson;

public class TaskCLIApp {
    public static void main(String[] args) {
        Manager taskManager = new Manager();

        if (args.length < 1) {
            System.out.println("Usage: TaskCLIApp: <command> [arguments]");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp add <description>");
                    return;
                }
                taskManager.addTask(args[1]);
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
        taskManager.saveTasks();
    }
}