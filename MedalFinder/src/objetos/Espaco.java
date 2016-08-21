package objetos;

/*
 * Espaço onde pode ou não ser guardada as medalhas. 
 * 
 *  Aemith - 20.08.2016
 */


public class Espaco {
	private boolean verificado;
	private boolean possuiObjeto;
	private Premio objeto;
	
	public Espaco(){
		this.verificado = false;
		this.possuiObjeto = false;
	}
	
	public void setObjeto(Premio objeto){
		this.possuiObjeto = true;
		this.objeto = objeto;
	}
	
	public Premio getObjeto(){
		return objeto;
	}
	
	public boolean getPossuiObjeto(){
		return possuiObjeto;
	}
	
	public void setVerificado(){
		this.verificado = true;
	}
	
	public boolean getFoiVerificado(){
		return verificado;
	}
	
	public String toString(){
		if(possuiObjeto)
			return "Existe um objeto " + objeto + " neste espaço.";
		else
			return "Não existe objeto neste espaço.";
	}
}
