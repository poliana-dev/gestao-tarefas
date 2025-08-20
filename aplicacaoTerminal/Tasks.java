package aplicacaoTerminal;
import java.time.LocalDate;

public class Tasks {
    private static int counter = 1;

    // atributos
    private int id;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade; // "ALTA", "MEDIA", "BAIXA"
    private LocalDate deadline;
    private String status = "EM_ANDAMENTO"; // ou "CONCLUIDA"

    public Tasks(String titulo, String descricao, String responsavel, String prioridade, LocalDate deadline) {
        this.id = counter++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.deadline = deadline;
    }

    // Metodos GET
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getResponsavel() { return responsavel; }
    public String getPrioridade() { return prioridade; }
    public LocalDate getDeadline() { return deadline; }
    public String getStatus() { return status; }

    // Metodos SET
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public void setStatus(String status) { this.status = status; }
}
