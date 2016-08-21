package objetos;

/*
 * Dados do jogador do jogo.
 * 
 *  Aemith - 20.08.2016
 */

public class Jogador implements Comparable<Jogador> {
	private int score;
	private int tentativas;
	private String nome;
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTentativas() {
		return tentativas;
	}
	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int compareTo(Jogador g) {
		if(this.score > g.score){
			return -1;
		}
		if(this.score < g.score){
			return 1;
		}
		return 0;
	}
}
