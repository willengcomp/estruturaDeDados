package ed;

public class VetorTeste {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Jo�o");
		Aluno a2 = new Aluno("Jos�");
		
		Vetor lista = new Vetor();
		
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		System.out.println(lista.tamanho());
		lista.adiciona(a2);
		System.out.println(lista.tamanho());
		
		System.out.println(lista.contem(a1));
		
		System.out.println(lista);
		
		Aluno a3 = new Aluno("Danilo");
		System.out.println(lista.contem(a3));
		
		lista.adiciona(1, a3);//adicionando o aluno danilo na posi��o 1 do array
		System.out.println(lista);
		lista.remove(1);
		System.out.println(lista);
		for (int i = 0; i < 300; i++) {
			Aluno y = new Aluno("Jo�o " + i); 
			lista.adiciona(y);
		}
		System.out.println(lista);
//		Aluno x = lista.pega(150);
//		System.out.println(x);
	}

}
