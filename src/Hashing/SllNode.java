package Hashing;
import Tad.Tad;
/*
 * estrutura do na da lista simplesmente encadeada
 * 
 */
public class SllNode {
	private Tad elm; 
	private SllNode prox; // referencia do proximo da lista

	//construtores
	public SllNode(SllNode prox,Tad elm){
		this.prox = prox;
		this.elm = elm;
	}
	public SllNode(Tad elm){
		this.elm = elm;
	}
	
	//encapsulamento
	public Tad getElm() {
		return elm;
	}
	public void setElm(Tad elm) {
		this.elm = elm;
	}
	public SllNode getProx() {
		return prox;
	}
	public void setProx(SllNode prox) {
		this.prox = prox;
	}
	
}
