package ed;

public class Celula {
	private Object elemento;
	private Celula proximo; //pr�ximo � a vari�lve que faz que a celul� anterio saiba qual ser� a pr�xima celula ap�s ela
	private Celula anterior;//ponteiro do Tipo Celula para apontar para a celula anterior 
	
	
	public Celula(Object elemento) {
		this(elemento, null);	
	}
	
	public Celula(Object elemento, Celula proximo) {//ctrl + 3 � o atalho de busca
		//Construtor para criar uma celula
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Eu sou a celula: " + elemento + "\n";
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	public Object getElemento() {
		return elemento;
	}
	
	public Celula getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
	
}
