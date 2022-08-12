package ed;

import java.util.LinkedList;
import java.util.List;

public class Fila {
	private List<String> alunos = new LinkedList<>();
	
	public void adiciona(String nome) {
		alunos.add(nome);
	}
	public void remove() {
		alunos.remove(0);
	}
	
	public boolean vazia() {
		return alunos.isEmpty();
	}
	@Override
	public String toString() {
		return alunos.toString();
	}
}
