package Hashing;

import Tad.Tad;

public class HashingEncadeado {
	/*
	 * tabela hashing com encadeamento externo, cada posi��o equivale a uma
	 * letra do alfabeto. E cada posi��o possui a referencia para uma lista
	 * linear simplesmente encadeada
	 */
	private Lista[] HTable = new Lista[26];

	// construtor

	public HashingEncadeado() {
		for (int i = 0; i < this.HTable.length; i++) {
			this.HTable[i] = new Lista();
		}
	}

	/*
	 * fun��o hashing que calcula onde a palavra sera inseria levando em
	 * considera��o o primeiro caractere
	 */
	private int funcaoHash(String palavra) {
		return palavra.toLowerCase().charAt(0) % 26;
	}

	public void add(Tad vlr) {
		/* calcula a posi��o atraves da fun��o de hashing */
		int pos = funcaoHash(vlr.getPalavra());
		HTable[pos].add(vlr);
	}

	// busca todas as ocorrencias
	public Tad busca(String palavra) {
		int pos = funcaoHash(palavra);
		return this.HTable[pos].buscaLista(palavra);
	}

	public Lista[] getHTable() {
		return HTable;
	}

}
