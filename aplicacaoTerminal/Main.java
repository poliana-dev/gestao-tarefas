package aplicacaoTerminal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            int op = sc.nextInt();
            sc.nextLine(); // consumir \n

            switch (op) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Responsável: ");
                    String resp = sc.nextLine();
                    System.out.print("Prioridade (ALTA/MEDIA/BAIXA): ");
                    String pri = sc.nextLine();
                    System.out.print("Deadline (AAAA-MM-DD): ");
                    String dl = sc.nextLine();
                    LocalDate deadline = LocalDate.parse(dl);
                    Tasks t = new Tasks(titulo, desc, resp, pri, deadline);
                    manager.addTask(t);
                    System.out.println("Tarefa criada!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Tarefas ---");
                    List<Tasks> tasks = manager.listTasks();
                    for (Tasks task : tasks) {
                        System.out.printf("ID: %d | %s | %s | %s | %s | %s\n",
                                task.getId(), task.getTitulo(), task.getResponsavel(),
                                task.getPrioridade(), task.getDeadline(), task.getStatus());
                    }
                    break;

                case 3:
                    System.out.print("ID da tarefa a concluir: ");
                    int cid = sc.nextInt();
                    manager.concludeTask(cid);
                    System.out.println("Tarefa concluída!");
                    break;

                case 4:
                    System.out.print("ID da tarefa a remover: ");
                    int rid = sc.nextInt();
                    if (manager.removeTask(rid)) System.out.println("Removida com sucesso!");
                    else System.out.println("Tarefa não encontrada!");
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
