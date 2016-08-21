package objetos;

/*
 * Estrutura para ordenar as jogadas do jogador.
 * 
 *  Aemith - 20.08.2016
 */

public class Jogada {
	private int largura;
	private int altura;
	private boolean sucesso;
	private String dica;
	private int pontos;
	
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public String toString(){
		return largura + "x" + altura;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
