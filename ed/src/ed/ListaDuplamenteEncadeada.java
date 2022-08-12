package ed;

public class ListaDuplamenteEncadeada {
	private Celula primeira = null;//A celula sabe qual � a primeira posi��o ap�s ela
	private Celula ultima = null; // ponteiro para a �ltima posi��o da LinkedList
	private int totalElemetos = 0;

	public void adicionaNoComeco(Object elemento) {
		
		if(totalElemetos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova; // o ponteiro que nos diz qual � a primeira celula aponta para nova
			this.ultima = nova; // como a lista era vazia o ponteiro �ltima tamb�m aponta para nova.
		} else {
			//System.out.println(this.primeira.toString());
			Celula nova = new Celula(elemento, this.primeira);//o ponteiro que diz qual � a primeira aponta para a nova celula criada
			//A celula recebe o elemento "Paulo" e o ponteiro que aponta para "Mauricio", mauricio � o pr�ximo de Paulo
			this.primeira.setAnterior(nova);
			// this.primeira � mauricio, agora passamos o ponteiro anterior apontando para nova que � paulo
			this.primeira = nova;
			// e agora dizemos que o ponteiro que nos diz que � a primeira celula agora � nova, ou seja, paulo
			//System.out.println(this.primeira.toString());
			
		}
		
		this.totalElemetos++;//Vari�vel que guarda a quantidade de elementos da nossa LnkedList
		
	}
	
	public void adiciona(Object elemento) {
		if(this.totalElemetos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);// nova = jo�o
			this.ultima.setProximo(nova);// Jo�o agora � pr�ximo de mauricio
			nova.setAnterior(this.ultima);// o anterior de Jo�o agora � mauricio
			this.ultima = nova;// e agora a ultima celula � jo�o, o ponteiro ultima aponta para Jo�o
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
		Celula anterior = this.pegaCelula(posicao - 1);//anterior = paulo
		Celula proxima = anterior.getProximo();
		
		Celula nova = new Celula(elemento, anterior.getProximo());//pr�ximo de will � paulo
		nova.setAnterior(anterior);;//anterior de Will agora quem era o pr�ximo de paulo, ou seja, mauricio
		anterior.setProximo(nova);//o anterior de paulo agora � will
		proxima.setAnterior(nova);// e o pr�ximo de mauricio = anterior.getAnterior() � will
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
		if(posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == totalElemetos - 1) {
			this.removeDoFim();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula proxima = this.pegaCelula(posicao + 1);
			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);
			this.totalElemetos--;
		}
	}
	
	public int tamanho() {
		return this.totalElemetos;
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
	
	public void removeDoFim() {
		if(totalElemetos == 1) {
			this.removeDoComeco();
		} else {
			Celula penultima = this.ultima.getAnterior();// pegando a penultima celula
			penultima.setProximo(null);
			this.ultima = penultima;
			this.totalElemetos--;
		}
		
	}
	
	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			} else {
				atual = atual.getProximo();
			}
		}
		return false;
	}
}
