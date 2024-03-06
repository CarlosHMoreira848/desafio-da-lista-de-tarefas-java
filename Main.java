import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		int opcao = -1;
		boolean condicao = true;
		Scanner entrada = new Scanner(System.in);
		ListaDeTarefas objeto = new ListaDeTarefas();
		ArrayList<Tarefa> historico = new ArrayList<Tarefa>();
		while(condicao) {
			System.out.println("BEM VINDO À LISTA DE TAREFAS!!! \n"
					+ "------------------------------- \n"
					+ "| MENU - DIGITE A SEGUIR:      |\n"
					+ "------------------------------- \n"					
					+ "| 1 - ADCIONAR TAREFA          |\n"
					+ "| 2 - REMOVER TAREFA           |\n"
					+ "| 3 - LISTAR TAREFAS           |\n"	
					+ "| 4 - LISTAR EM ALFABÉTICO     |\n"		
					+ "| 5 - LISTAR EM CRONOLÓGICO    |\n"	
					+ "------------------------------- \n"
					+ "| 0 - SAIR                     |\n"
					+ "------------------------------- ");
			opcao = entrada.nextInt();
			if(opcao == 0) {
				condicao = false;
				break;
			} else {
				historico = objeto.menuListaDeTarefas(opcao, historico);
			}
			
		}
	}
}
