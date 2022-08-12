package ed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Conjunto {
	
	private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>(); // � mais perfom�tico usar um ArrayList pois estamos sempre usando o met�do get passando o indice, e no Array esse m�todo tem custo computacional constante
	
	public Conjunto() {
		for (int i = 0; i < 26; i++) {
			tabela.add(new LinkedList<String>());
		}
	}
	
	public void remove(String palavra) {
		if(contem(palavra)) {
			int indice = calculaIndiceDaPalavra(palavra);
			List lista = tabela.get(indice);
			lista.remove(palavra);
		}
	}
	
	public void adiciona(String palavra) {
		if(!contem(palavra)){
			int indice = calculaIndiceDaPalavra(palavra);
			List lista = tabela.get(indice);//passo a posi��o de acordo com o calculo do �ndice
			lista.add(palavra);
		}
	}

	private boolean contem(String palavra) {
		int indice = calculaIndiceDaPalavra(palavra);
		return tabela.get(indice).contains(palavra);//diminui meu range de busca, agora s� verifica se a palavra esta dentro da lista de acordo com sua letra inicial
	}

	private int calculaIndiceDaPalavra(String palavra) {
		return palavra.toLowerCase().charAt(0)%26;// fun��o de espalhamento, o resto da divis�o vai ser um n�mero sempre entre 0 e 25, ou seja, um valor para cada letra do alfabeto
	}
	
	@Override
	public String toString() {
		
		return tabela.toString();
	}
}
