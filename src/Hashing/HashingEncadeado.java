package Hashing;

import Tad.Tad;

public class HashingEncadeado {
	/*
	 * tabela hashing com encadeamento externo, cada posição equivale a uma
	 * letra do alfabeto. E cada posição possui a referencia para uma lista
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
	 * função hashing que calcula onde a palavra sera inseria levando em
	 * consideração o primeiro caractere
	 */
	private int funcaoHash(String palavra) {
		return palavra.toLowerCase().charAt(0) % 26;
	}

	public void add(Tad vlr) {
		/* calcula a posição atraves da função de hashing */
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
