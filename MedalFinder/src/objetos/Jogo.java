package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Mec�nica principal do jogo e interface de texto.
 * 
 *  Aemith - 20.08.2016
 */

public class Jogo { 
	private static int quantidadeJogadasInicial = 5;
	private  int quantidadePremios = 3;
	private  int premiosGanhos = 0;
	private  List<Jogada> listaJogadas = new ArrayList<Jogada>();
	private  Sala jogo;
	private  int largura;
	private  int altura;
	private  Jogador player;
	private  Scanner s = new Scanner(System.in);
	
	private void ganhou(){
		premiosGanhos++;
	}
	
	public void rodar(){
		System.out.println("PROCURE O PR�MIO!");
		System.out.println("Vers�o 2008");
		System.out.println();
		
		requerirNome();
		
		gerarPremios();
		
		System.out.println("Um pr�mio foi escondido com sucesso.");
		System.out.println("Voc� tem "+quantidadeJogadasInicial+" chances para encontrar o pr�mio escondido.");
		System.out.println("Encontre-o em uma sala de tamanho 10 x 10");
		
		do{
			fazerJogada();
		}while(premiosGanhos < quantidadePremios && player.getTentativas() > 0);
		//Ranking
		System.out.println("Verificando sua posi��o no ranking!");
		Ranking r = new Ranking();
		r.adicionaJogador(player);
		System.out.println(r);
		r.gravaListaSalva();
		
	}


	private void requerirNome() {
		player = new Jogador();
		System.out.println("Por favor digite seu nome:");
		player.setNome(s.nextLine());
		player.setScore(0);
		player.setTentativas(quantidadeJogadasInicial);
	}

	private void fazerJogada() {
		System.out.println("Voc� tem "+player.getTentativas()+" tentativas e fez "+player.getScore()+" pontos at� agora.");
		entradaTeclado();
		
		//Verifica se essa jogada j� foi efetuada
		boolean valida = false;
		if(listaJogadas.size() > 0){
			boolean encontrou = false;
			for(Jogada j:listaJogadas){
				if(j.getAltura() == altura && j.getLargura() == largura)
					encontrou = true;
			}
			valida = (!encontrou);
		}else
			valida = true;
		
		
		if(valida){
			listaJogadas.add(jogo.resultadoJogada(largura, altura));
			
			if(jogo.resultadoJogada(largura, altura).isSucesso()){
				System.out.println(jogo.getObjeto(largura, altura));
				player.setScore(player.getScore()+jogo.getObjeto(largura, altura).getPontos());
				player.setTentativas(player.getTentativas()+jogo.getObjeto(largura, altura).getNumero());
				ganhou();
			}
			else{
				System.out.println("Que pena! N�o conseguiu");
				System.out.println("Segue uma dica:");
				System.out.println(jogo.resultadoJogada(largura, altura).getDica());
				player.setTentativas(player.getTentativas()-1);
				player.setScore(player.getScore()+jogo.resultadoJogada(largura, altura).getPontos());
				
			}		
		}else{
			System.out.println("Jogada j� executada! Por favor tente outra!");
		}
	}



	private  void entradaTeclado() {
		System.out.println("Digite uma posi��o entre 1 - 10 para verificar.");
		System.out.println("Largura:");
		largura = s.nextInt();
		System.out.println("Altura:");
		altura = s.nextInt();
		if(largura == 0 || altura == 0){
			System.out.println("N�o � poss�vel utilizar valores zerados. Por favor, tente novamente.");
			entradaTeclado();
		}
		else if(largura >= 1 && largura <= 10 && altura >= 1 && altura <= 10){
			largura--;
			altura--;
		}
		else{
			System.out.println("O valor digitado � inv�lido. Por favor verifique e tente novamente.");
			entradaTeclado();
		}
	}


	private  void gerarPremios() {
		jogo = new Sala(10,10);
		Premio ouro = new Premio();
		ouro.setNome("Ouro");
		ouro.setNumero(10);
		ouro.setPontos(1000);
		jogo.addObjeto(ouro);
		Premio prata = new Premio();
		prata.setNome("Prata");
		prata.setNumero(5);
		prata.setPontos(500);
		jogo.addObjeto(prata);
		Premio bronze = new Premio();
		bronze.setNome("Bronze");
		bronze.setNumero(2);
		bronze.setPontos(250);
		jogo.addObjeto(bronze);
	}

}
