package ed;

public class ListaEncadeada {
	
	private Celula primeira = null;//A celula sabe qual � a primeira posi��o ap�s ela
	private Celula ultima = null; // ponteiro para a �ltima posi��o da LinkedList
	private int totalElemetos = 0;

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
//		System.out.println(nova.toString());
		this.primeira = nova;// a vari�vel primeira sempre aponta para o endere�o da nova celula inserida
//		System.out.println("primeira -> eu aponto para: " + nova);//para quem aponta a primeira
		if(totalElemetos == 0) {
			//se a lista est� vazia o ponteiro para o �ltimo ser� igual o ponteiro para o primeiro
			this.ultima = this.primeira;
		}
		this.totalElemetos++;//Vari�vel que guarda a quantidade de elementos da nossa LnkedList
		
	}
	
	public void adiciona(Object elemento) {
		if(this.totalElemetos == 0) {
			this.adiciona(elemento);
		} else {
			Celula nova = new Celula(elemento, null);//nova celula com o ponteiro do pr�ximo como null
//			System.out.println(nova.toString());
			this.ultima.setProximo(nova);//agora o ponteiro �ltimo aponta para a refer�ncia nova, dizendo que ela a pr�xima da lista, esse passo � necess�rio pois a vari�vel pr�xima estava apontando para a celula anterior
//			System.out.println(this.ultima.toString());
			this.ultima = nova;// aqui estamos apontando para o endere�o da nova celula
//			System.out.println("ultima -> eu aponto para: " + nova);
			this.totalElemetos++;
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalElemetos;
	}
	
	private Celula pegaCelula(int posicao) {//met�do que busca uma celula na LinkedList, O(n)
		if(!posicaoOcupada(posicao)){
			throw new IllegalArgumentException("Posi��o inexistente");
		}
		Celula atual = primeira;
		for(int i = 0; i < posicao; i++) {//for para percorrer nossos ponteiros, come�ando pelo endere�o apontado pelo ponteiro primeira
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
		Celula anterior = this.pegaCelula(posicao - 1);//anterior agora est� apontando para a celula anterior a posi��o que quermos inserir a nova celula
//		System.out.println("Anterior :" + anterior.toString());
		Celula nova = new Celula(elemento, anterior.getProximo());// agora celula inserida vai pegar o pr�ximo da posicao anteior
//		System.out.println("Sou a celula nova: "+nova.toString());
		anterior.setProximo(nova);// e agora o pr�ximo do anterio � a celula que foi inserida
//		System.out.println("pr�ximo do anterior "+ anterior.getProximo().toString());
//		System.out.println("pr�ximo da nova celula: "+ nova.getProximo().toString());
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
		Celula atual = primeira;// a Celula atual recebe agora o endere�o que o ponteiro primeira aponta, ou seja, o endere�o da �ltima c�lula da LinkedList
		StringBuilder builder = new StringBuilder("[");//construtor de string
		for (int i = 0; i < totalElemetos; i++) {
			if(totalElemetos != i+1) { //esse IF � s� para que n�o tenhamos uma "," ap�s o �ltimo elemento.
			builder.append(atual.getElemento()); //getElemento � um met�do herdado da classe Object
			builder.append(",");			
			} else {
				builder.append(atual.getElemento());
			}
			atual = atual.getProximo();//faz o ponteiro atual receber a marca��o da celula que diz eu sou o pr�ximo elemento da LinkedList
		}
		builder.append("]");
		return builder.toString();
	}
}
