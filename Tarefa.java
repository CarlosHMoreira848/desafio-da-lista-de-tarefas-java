import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


public class Tarefa {
	private String nome;
	private String descricao;
	private LocalTime horarioDeRegistro;
	private Date horarioDeExecutar;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
	
	public Tarefa(String nome, String descricao, LocalTime horarioDeRegistro, Date horarioDeExecutar) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.horarioDeRegistro = horarioDeRegistro;
		this.horarioDeExecutar = horarioDeExecutar;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalTime getHorarioDeRegistro() {
		return horarioDeRegistro;
	}
	public void setHorarioDeRegistro(LocalTime horarioDeRegistro) {
		this.horarioDeRegistro = horarioDeRegistro;
	}
	public Date getHorarioDeExecutar() {
		return horarioDeExecutar;
	}
	public void setHorarioDeExecutar(Date horarioDeExecutar) {
		this.horarioDeExecutar = horarioDeExecutar;
	}
	@Override
	public String toString() {
		return "Tarefa = Nome " + getNome() + ", às " + getHorarioDeRegistro() + ", para fazer em: " + getHorarioDeExecutar();
	}
}
