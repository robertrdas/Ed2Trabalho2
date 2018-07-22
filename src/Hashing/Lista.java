package Hashing;
import Tad.Tad;
import apps.Transacoes;

public class Lista {
	private SllNode primeira;
	private SllNode Ultima;
	private int totalDeElementos;
	
	public static void mp(){
		
	}
	
	public void addNoComeco(Tad elemento){
		SllNode nova = new SllNode(this.primeira,elemento);
		this.primeira = nova;
		
		if(this.totalDeElementos == 0){
			this.Ultima = nova;
		}
		this.totalDeElementos ++;
	}
	
	public void add(Tad elemento){
		if(this.totalDeElementos == 0){
			this.addNoComeco(elemento);
		}else{
			SllNode nova = new SllNode(elemento);
			this.Ultima.setProx(nova);
			this.Ultima = nova;
			this.totalDeElementos++;
		}
	}
	public Tad buscaLista(String key){
		SllNode atual = this.primeira;
		while(atual!=null){
			Transacoes.passosHash();
			if(atual.getElm().getPalavra().compareToIgnoreCase(key)==0){
				return atual.getElm();
			}
			atual = atual.getProx();
		}
		return null;
	}

	public SllNode getPrimeira() {
		return primeira;
	}

	public void setPrimeira(SllNode primeira) {
		this.primeira = primeira;
	}

	public SllNode getUltima() {
		return Ultima;
	}

	public void setUltima(SllNode ultima) {
		Ultima = ultima;
	}

	public int getTotalDeElementos() {
		return totalDeElementos;
	}

	public void setTotalDeElementos(int totalDeElementos) {
		this.totalDeElementos = totalDeElementos;
	}
	
}
