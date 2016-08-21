package objetos;

/*
 * Prêmio do jogo.
 * 
 *  Aemith - 20.08.2016
 */

public class Premio {
	private String nome;
	private int numero;
	private int pontos;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		return "Você ganhou uma medalha de " + nome + " e mais "+numero + " jogadas.";
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
