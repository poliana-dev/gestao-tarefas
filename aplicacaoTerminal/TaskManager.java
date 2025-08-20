package aplicacaoTerminal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Tasks> tasks = new ArrayList<>();

    // Metodos
    public void addTask(Tasks task) {
        tasks.add(task);
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    // "achar"/procure tarefa pelo id
    public Tasks findTask(int id) {
        Optional<Tasks> t = tasks.stream().filter(task -> task.getId() == id).findFirst();
        return t.orElse(null);
    }

    public void concludeTask(int id) {
        Tasks t = findTask(id);
        if (t != null) t.setStatus("CONCLUIDA");
    }

    public List<Tasks> listTasks() {
        return tasks;
    }

    public List<Tasks> listTasksByStatus(String status) {
        List<Tasks> filtered = new ArrayList<>();
        for (Tasks t : tasks) {
            if (t.getStatus().equalsIgnoreCase(status)) filtered.add(t); // verifica o status ignorando letras maiusculas ou minusculas
        }
        return filtered;
    }
}
