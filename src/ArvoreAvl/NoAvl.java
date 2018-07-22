package ArvoreAvl;
import Tad.Tad;

public class NoAvl {
	private NoAvl esquerdo;  //filho esquerdo
	private NoAvl direito; //filho direito
	private NoAvl pai; //pai
	private Tad valor;
	private int balanceamento; // indice de balanceamento
	
	public NoAvl(){}
	public NoAvl(Tad valor){
		setEsquerdo(null);setDireito(null);setPai(null);
		setBalanceamento(0);
		this.valor = valor;
		
	}

	//encapsulamento
	public Tad getValor() {
		return valor;
	}

	public void setValor(Tad valor) {
		this.valor = valor;
	}
	
	public NoAvl getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NoAvl esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoAvl getDireito() {
		return direito;
	}

	public void setDireito(NoAvl direito) {
		this.direito = direito;
	}

	public NoAvl getPai() {
		return pai;
	}

	public void setPai(NoAvl pai) {
		this.pai = pai;
	}

	

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}
	
}
