package ed;

public class TestaListaEncadeada {

	public static void main(String[] args) {
//		ListaEncadeada lista = new ListaEncadeada();
//		
//		System.out.println(lista);
//		lista.adicionaNoComeco("Mauricio");//uma String � um Object
//		System.out.println(lista);
//		lista.adicionaNoComeco("Paulo");
//		System.out.println(lista);
//		lista.adicionaNoComeco("Guilherme");
//		System.out.println(lista);
//		lista.adiciona("Marcelo");//adicionando marcelo ao final da lista
//		System.out.println(lista);
//		lista.adiciona("Will");
//		System.out.println(lista);
//		lista.adiciona(2, "Gabriel");
//		System.out.println(lista);
//		
//		Object x = lista.pega(2);
//		System.out.println(x);
//		System.out.println(lista.tamanho());	
//		
//		lista.removeDoComeco();
//		System.out.println(lista);
//		System.out.println(lista.tamanho());		
		
		
		ListaDuplamenteEncadeada listaDupla = new ListaDuplamenteEncadeada();
		
		System.out.println(listaDupla);
		listaDupla.adicionaNoComeco("Mauricio");//uma String � um Object
		System.out.println(listaDupla);
		listaDupla.adicionaNoComeco("Paulo");
		System.out.println(listaDupla);
		listaDupla.adiciona("Jo�o");
		//listaDupla.remove(1);
		System.out.println(listaDupla);
		listaDupla.adiciona(1,"Will");
		System.out.println(listaDupla);
		listaDupla.removeDoFim();
		System.out.println(listaDupla);
		//listaDupla.remove(0);
		System.out.println(listaDupla.contem("Will"));
		System.out.println(listaDupla.contem("Luciana"));
		
		
		
	}
	//https://github.com/willengcomp/estruturaDeDados.git
}
