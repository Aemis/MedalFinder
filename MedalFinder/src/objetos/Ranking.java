package objetos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * Ranking do jogo, com salvamento e manutenção da lista de jogadores.
 * 
 *  Aemith - 20.08.2016
 */

public class Ranking {
	private Date data;
	private List<Jogador> lista;
	private File arquivoSalvo = new File("jogadores.txt");
	
	public Ranking(){
		data = new Date();
		lista = new ArrayList<Jogador>();
		abrirListaSalva();
	}
	
	public void adicionaJogador(Jogador j){
		lista.add(j);
	}
	
	private void abrirListaSalva(){
		try {
			if(!arquivoSalvo.exists()){
				arquivoSalvo.createNewFile();
				return;
			}
			BufferedReader br = new BufferedReader(new FileReader(arquivoSalvo.getAbsoluteFile()));
			String conteudo, nome;
			int score;
			conteudo = br.readLine();
			while(conteudo != null){
				Jogador g = new Jogador();
				String[] recupera = conteudo.split(",");
				nome = recupera[0];
				score = Integer.parseInt(recupera[1]);
				g.setNome(nome);
				g.setScore(score);
				this.adicionaJogador(g);
				conteudo = br.readLine();
			}
			br.close();
		} catch (IOException e) {
				System.out.println("Falha ao criar arquivo de jogadores.");
		}
	}

	
	public void gravaListaSalva(){
		try {
			if(!arquivoSalvo.exists()){
				arquivoSalvo.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSalvo.getAbsoluteFile()));
			String conteudo;
			for(Jogador j:lista){
				conteudo = j.getNome() + "," + j.getScore();
				bw.write(conteudo);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
				System.out.println("Falha ao criar arquivo de jogadores.");
		}
	}
	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String resultado = "RANKING DE JOGADORES EFETUADO EM "+sdf.format(data)+"\n";
		resultado += "------------------------------------\n";
		resultado += "POSIÇÃO - NOME - SCORE\n";
		resultado += "------------------------------------\n";
		Collections.sort(lista);
		int posicao = 1;
		for(Jogador g:lista){
			resultado += posicao + " - " + g.getNome().toUpperCase() + " - " + g.getScore() +"\n";
			posicao++;
			if(posicao == 11){
				break;
			}
		}
		return resultado;
	}
}
