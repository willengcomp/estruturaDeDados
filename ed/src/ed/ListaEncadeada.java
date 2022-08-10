package ed;

public class ListaEncadeada {
	
	private Celula primeira = null;//A celula sabe qual é a primeira posição após ela
	private Celula ultima = null; // ponteiro para a última posição da LinkedList
	private int totalElemetos = 0;

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
//		System.out.println(nova.toString());
		this.primeira = nova;// a variável primeira sempre aponta para o endereço da nova celula inserida
//		System.out.println("primeira -> eu aponto para: " + nova);//para quem aponta a primeira
		if(totalElemetos == 0) {
			//se a lista está vazia o ponteiro para o último será igual o ponteiro para o primeiro
			this.ultima = this.primeira;
		}
		this.totalElemetos++;//Variável que guarda a quantidade de elementos da nossa LnkedList
		
	}
	
	public void adiciona(Object elemento) {
		if(this.totalElemetos == 0) {
			this.adiciona(elemento);
		} else {
			Celula nova = new Celula(elemento, null);//nova celula com o ponteiro do próximo como null
//			System.out.println(nova.toString());
			this.ultima.setProximo(nova);//agora o ponteiro último aponta para a referência nova, dizendo que ela a próxima da lista, esse passo é necessário pois a variável próxima estava apontando para a celula anterior
//			System.out.println(this.ultima.toString());
			this.ultima = nova;// aqui estamos apontando para o endereço da nova celula
//			System.out.println("ultima -> eu aponto para: " + nova);
			this.totalElemetos++;
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalElemetos;
	}
	
	private Celula pegaCelula(int posicao) {//metódo que busca uma celula na LinkedList, O(n)
		if(!posicaoOcupada(posicao)){
			throw new IllegalArgumentException("Posição inexistente");
		}
		Celula atual = primeira;
		for(int i = 0; i < posicao; i++) {//for para percorrer nossos ponteiros, começando pelo endereço apontado pelo ponteiro primeira
			atual = atual.getProximo(); 
		}
		return atual;
		
	}
	
	public void adiciona(int posicao, Object elemento) {
		if(posicao == 0) {
			adicionaNoComeco(elemento);
		} else if(posicao == this.totalElemetos) {
			adiciona(elemento);
		} else {
		Celula anterior = this.pegaCelula(posicao - 1);//anterior agora está apontando para a celula anterior a posição que quermos inserir a nova celula
//		System.out.println("Anterior :" + anterior.toString());
		Celula nova = new Celula(elemento, anterior.getProximo());// agora celula inserida vai pegar o próximo da posicao anteior
//		System.out.println("Sou a celula nova: "+nova.toString());
		anterior.setProximo(nova);// e agora o próximo do anterio é a celula que foi inserida
//		System.out.println("próximo do anterior "+ anterior.getProximo().toString());
//		System.out.println("próximo da nova celula: "+ nova.getProximo().toString());
		this.totalElemetos++;
		}
		
	}
	
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void removeDoComeco() {
		if(totalElemetos == 0) {
			throw new IllegalArgumentException();
		}
		
		this.primeira = this.primeira.getProximo();
		this.totalElemetos--;
		
		if(totalElemetos == 0) {
			this.ultima = null;
		}
	}
	
	public void remove(int posicao) {
		
	}
	
	public int tamanho() {
		return this.totalElemetos;
	}
	
	public boolean contem(Object o) {
		return false;
	}
	
	@Override
	public String toString() {
		if(this.totalElemetos == 0) {
			return "[]";
		}
		Celula atual = primeira;// a Celula atual recebe agora o endereço que o ponteiro primeira aponta, ou seja, o endereço da última célula da LinkedList
		StringBuilder builder = new StringBuilder("[");//construtor de string
		for (int i = 0; i < totalElemetos; i++) {
			if(totalElemetos != i+1) { //esse IF é só para que não tenhamos uma "," após o último elemento.
			builder.append(atual.getElemento()); //getElemento é um metódo herdado da classe Object
			builder.append(",");			
			} else {
				builder.append(atual.getElemento());
			}
			atual = atual.getProximo();//faz o ponteiro atual receber a marcação da celula que diz eu sou o próximo elemento da LinkedList
		}
		builder.append("]");
		return builder.toString();
	}
}
