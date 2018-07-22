package Tad;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * classe que guarda a palavra lida do arquivo e a linha de sua ocorrencia
 */
public class Tad {
	private String palavra;
	
	private ArrayList<Integer> linepos = new ArrayList<Integer>();
	
	public Tad(){}
	/* contrutor */
	public Tad(String palavra, int linepos) {
		this.palavra = palavra;
		this.linepos.add(linepos);
	}

	/* encapsulamento */
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public ArrayList<Integer> getLinepos() {
		return linepos;
	}
	
	public String lineString(){
		String line = "linhas das ocorrencias: ";
		Iterator<Integer> it = linepos.iterator();
		while(it.hasNext()){
			line = line + it.next().toString();
			line = line + "-";
		}
		return line.substring(0,line.length()-1);
	}

}
