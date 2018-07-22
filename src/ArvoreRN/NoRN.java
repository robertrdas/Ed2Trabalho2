package ArvoreRN;
import Tad.Tad;

public class NoRN {
	private Tad element;
	private NoRN pai, esquerdo, direito;
	private boolean cor;

	public NoRN(){}

	public NoRN(Tad element){
        this.element = element;
    }

	public NoRN(Tad element, NoRN esquerdo, NoRN direito){
        this.element = element;
        this.esquerdo = esquerdo;
        this.direito = direito;
        this.cor = false;
    }

	//encapsulamento
	public Tad getElement() {
		return element;
	}

	public void setElement(Tad element) {
		this.element = element;
	}

	

	public NoRN getPai() {
		return pai;
	}

	public void setPai(NoRN pai) {
		this.pai = pai;
	}

	public NoRN getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NoRN esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoRN getDireito() {
		return direito;
	}

	public void setDireito(NoRN direito) {
		this.direito = direito;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}
}
