import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Manager {
    private final Path FILE_PATH = Path.of("tasks.json");
    private List<Task> tasks;

    public Manager() {
        this.tasks = loadTasks();
    }

    private  List<Task> loadTasks(){
        if (!File.exists(FILE_PATH)){
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskList = jsonContent.replace("[", "")
                    .replace("]", "")
                    .split("},");
            for (Strig taskJson : taskList){
                if (!taskJson.endsWith("}")){
                    taskJson = taskJson + "}";
                    stored_tasks.add(Task.fromJson(taskJson));
                } else {
                    stored_tasks.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOExeption e) {
            e.printStackTrace();
        }
        return stored_tasks;
    }

    public void saveTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();
        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTask(String description){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentExeption("Task with ID " + id + " not found"));
        task.updateDescription(new_description);
    }
    public void upadteTask(String description){}
    public void deleteTask(String description){}

    public void listTasks(String type){
        for (Task task: tasks) {
            String status = task.getStatus().toString().strip();
        }
    }

    public Optional<Task> findTask(String id){
        return tasks.stream().filter((task) -> task.getId() == Integer.parseInt(id)).findFirst();
    }
}