import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class ListaDeTarefas {
	Scanner entrada = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	String tarefaParaExecutar;
	
	public ArrayList<Tarefa> menuListaDeTarefas(int opcaoMain, ArrayList lista) throws ParseException {
		switch(opcaoMain) {
		case 1:
			addTarefa(lista);
			break;
		case 2:
			removeTarefa(lista);
			break;
		case 3:
			listarTarefas(lista);
			break;
		case 4:
			listarAlfabetico(lista);
			break;
		case 5:
			listarCronologico(lista);
			break;
		}
		return lista;
	}
	
	private ArrayList<Tarefa> addTarefa(ArrayList<Tarefa> lista) throws ParseException {
		Tarefa objetoTarefa = new Tarefa(null, null, null, null);
		//Preenche os dados da nova tarefa
		System.out.println("***|VOCÊ ESCOLHEU ADCIONAR TAREFA!|***");
		System.out.println("Digite o nome da tarefa: ");
		entrada.next();
		tarefaParaExecutar = entrada.nextLine();
		objetoTarefa.setNome(tarefaParaExecutar);
		System.out.println("Digite a descrição da tarefa: ");
		entrada.next();
		objetoTarefa.setDescricao(entrada.nextLine());
		System.out.println("Digite a data que deseja realizar a tarefa (dd/MM/yyyy): ");
		Date dataFormatada = sdf.parse(entrada.next());
		objetoTarefa.setHorarioDeExecutar(dataFormatada);
		objetoTarefa.setHorarioDeRegistro(LocalTime.now());
		// Verifica se a tarefa ja existe
		boolean jaExiste = false;
		for(int i=0; i < lista.size(); i++) {
			if(tarefaParaExecutar.equals(lista.get(i).getNome())) {
				jaExiste = true;
			} else {
				jaExiste = false;
			}
		}
		// Se não existe popula a lista caso contrário popula.
		if(jaExiste == false) {
			lista.add(objetoTarefa);
		} else {
			System.out.println("Essa tarefa já existe! Tente adcionar outra!");
		}
		return lista;
	}
	
	private ArrayList<Tarefa> removeTarefa(ArrayList<Tarefa> lista) {
		// Recebe o nome da tarefa que será removida
		System.out.println("Digite o nome da tarefa que deseja remover: ");
		entrada.next();
		String tarefaRemovida = entrada.nextLine();
		// Verifica se a tarefa existe
		boolean verificarSeExiste = false;
		int posicaoDaTarefa = 0;
		for(int i=0; i < lista.size(); i++) {
			if(tarefaParaExecutar.equals(lista.get(i).getNome())) {
				verificarSeExiste = true;
				posicaoDaTarefa = i;
			} else {
				verificarSeExiste = false;
			}
		}
		// Remove a tarefa se ela existe
		if(verificarSeExiste == true) {
			System.out.println("Tem certeza que deseja remover " + tarefaRemovida + "? \n Digite (s) ou (n) para SIM ou NÃO: ");
			char certeza = entrada.next().charAt(0);
			if(certeza == 's') {
				lista.remove(lista.get(posicaoDaTarefa));
				System.out.println("Tarefa " + tarefaRemovida + " foi removida!");
			}
		// Se ela não existe o programa informa isso ao usuário.	
		} else {
			System.out.println("Essa tarefa já existe! Tente adcionar outra!");
		}
		return lista;
	}
	private void listarTarefas(ArrayList<Tarefa> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
	public void listarAlfabetico(ArrayList<Tarefa> lista) {
		ArrayList<Tarefa> copiaLista = new ArrayList<>(lista);
		Collections.sort(copiaLista, Comparator.comparing(Tarefa::getNome));
		listarTarefas(copiaLista);
		
	}
	public void listarCronologico(ArrayList<Tarefa> lista) {
		ArrayList<Tarefa> copiaLista1 = new ArrayList<>(lista);
		Collections.sort(copiaLista1, Comparator.comparing(Tarefa::getHorarioDeExecutar));
		listarTarefas(copiaLista1);
	}
}
