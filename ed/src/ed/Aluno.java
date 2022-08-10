package ed;

public class Aluno {
	private String nome;
	
	public Aluno(String nome) {
		this.nome = nome;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		Aluno outro = (Aluno) obj;//outro é o objeto sendo recebido, fiz o cast para garantir que será um aluno
		
		return outro.getNome().equals(this.nome);//comparando os nomes dos alunos
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
}
