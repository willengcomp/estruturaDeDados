package ed;

import java.util.Arrays;

public class Vetor {
	private Aluno[] alunos = new Aluno[100];//inicializando um Array de alunos com 100 posi��es
	private int totalAlunos = 0;//vari�vel utilizada para apontar o qual ser� o espa�o vazio no array
	
	public void adiciona(Aluno aluno) {
		this.garanteEspaco();
		//met�do para adicionar um novo aluno no Array alunos
//		for(int i = 0; i < alunos.length; i++ ) {
//			if(alunos[i] == null) {
//				alunos[i] = aluno;
//				break;
//				//este algoritmo com o for tem perfomance O de (n) n�o � bom, pois n � o tamanho da lista
//			}
//		}
		this.alunos[totalAlunos] = aluno;
 
		totalAlunos++;// essa solu��o � O de 1 constante
	}
	
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalAlunos;
	}
	
	private void garanteEspaco() {
		//met�do para redimensionar o Array caso ele fique cheio
		if(totalAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length * 2];//dobrar o tamanho do novo array � uma boa pr�tica
			for (int i = 0; i < alunos.length; i++) {
				novoArray[i] = alunos[i];
			}
			this.alunos = novoArray;// fazendo que agora o ponteiro que apontava para o array alunos aponte para nosso novoArray
		}
	}
	
	
	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posi��o Invalida");
		}
		//adiciona um novo aluno em qualquer lugar do array alunos
		for(int i = totalAlunos - 1 ; i >= posicao ; i-=1) {
			alunos[i+1] = alunos[i];
		}//esse la�o for � utilizado para deslocar os alunos atuais para a direita do array alunos
		alunos[posicao] = aluno;
		totalAlunos++;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalAlunos;
	}
	
	
	public Aluno pega(int posicao) {
		//met�do para pegar um aluno do array alunos dada a posi��o desejada
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posi��o Invalida");
		}
		
		return alunos[posicao];
	}
	
	public void remove(int posicao) {
		//met�do para remover um aluno do array alunos dada uma posi��o
		for (int i = posicao; i < this.totalAlunos -1; i++) {
			this.alunos[i] = this.alunos[i+1];
		}
		totalAlunos--;
		this.alunos[totalAlunos] = null;
		
	}
	
	public boolean contem(Aluno aluno) {
		//met�do que descobre se o aluno est� no array alunos
		for(int i = 0; i < totalAlunos; i++ ) {
			if(aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		//retorna o tamanho do array alunos
		return totalAlunos;//a vari�vel totalAlunos tamb�m nos diz a quantidade atual que temos de alunos	
	}
	
	@Override
	public String toString() {
		//o Arrays.toString() pega todos os elementos do vetor e chama o seu toString
		return Arrays.toString(alunos);
	}
	
}
