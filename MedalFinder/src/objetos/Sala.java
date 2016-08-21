package objetos;

/* 
 * Sala onde as medalhas estarão escondidas.
 * 
 * Leticia Sena - 20.08.2016
 */
public class Sala {
	private int larguraTotal;
	private int alturaTotal;
	private int largura;//sorteada
	private int altura;//sorteada
	private Espaco[][] sala;
	
	public Sala(int largura,int altura){
		this.alturaTotal = altura;
		this.larguraTotal = largura;
		this.sala = new Espaco[largura][altura];
	}
	
	public Jogada resultadoJogada(int largura,int altura){
		Jogada efetuada = new Jogada();
		efetuada.setAltura(altura);
		efetuada.setLargura(largura);
		try{
			efetuada.setSucesso(sala[largura][altura].getPossuiObjeto());
		}catch(Exception e){
			efetuada.setSucesso(false);
		}
	
		int darDicaLargura = this.largura - largura;
		int darDicaAltura = this.altura - altura;
		int pontos;
		if(darDicaLargura >= -3 && darDicaLargura <= 3 && darDicaAltura >= -3  && darDicaAltura <= 3) {
			efetuada.setDica("Está quente!");
			int valorPontos = darDicaLargura - darDicaAltura;
			valorPontos = (valorPontos <0)?valorPontos*-1:valorPontos;
			pontos = 10*valorPontos;
		}
		else {
			efetuada.setDica("Está frio!");
			pontos = 0;
		}
		
		
		efetuada.setPontos(pontos);
		return efetuada;
	}
	
	public void addObjeto(Premio o){
		//random do espaço que vai receber
		int largura = -1;
		int altura = -1;
		do{
			double sorte = Math.random()*100;
			largura = (int)sorte;
			sorte = Math.random()*100;
			altura =  (int)sorte;
			
			if(largura >= this.larguraTotal)
				largura = -1;
			if(altura >= this.alturaTotal)
				altura = -1;
			
			//Verifica se já existe objeto nessa altura e largura
			try{
				if(sala[largura][altura].getPossuiObjeto()){
					largura = -1;
					altura = -1;
				}
			}catch(Exception e){}
			
		}while(largura < 0 || altura < 0);
		this.altura = altura;
		this.largura = largura;
		Espaco e = new Espaco();
		e.setObjeto(o);
		this.sala[largura][altura] = e;
	}
	
	public Premio getObjeto(int largura,int altura){
		return this.sala[largura][altura].getObjeto();
	}
	
	public String descreveEspaco(int largura,int altura){
		return this.sala[largura][altura].toString();
	}
}
