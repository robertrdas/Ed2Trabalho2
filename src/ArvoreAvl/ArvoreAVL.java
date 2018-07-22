package ArvoreAvl;

import Tad.Tad;
import apps.Transacoes;

public class ArvoreAVL {

	protected NoAvl raiz;

	public void inserir(Tad valor) {
		NoAvl n = new NoAvl(valor);
		inserirAvl(this.raiz, n);
	}

	private void inserirAvl(NoAvl aComparar, NoAvl aInserir) {
		if (aComparar == null) {

			this.raiz = aInserir;

		} else {
			if (aInserir.getValor().getPalavra().compareToIgnoreCase(aComparar.getValor().getPalavra()) < 0) {
				if (aComparar.getEsquerdo() == null) {
					aComparar.setEsquerdo(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
				} else {

					inserirAvl(aComparar.getEsquerdo(), aInserir);

				}

			} else if (aInserir.getValor().getPalavra().compareToIgnoreCase(aComparar.getValor().getPalavra()) > 0) {

				if (aComparar.getDireito() == null) {
					aComparar.setDireito(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
				} else {

					inserirAvl(aComparar.getDireito(), aInserir);

				}
			}
		}

	}

	private void verificarBalanceamento(NoAvl atual) {
		setBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {
			if (altura(atual.getEsquerdo().getEsquerdo()) >= altura(atual.getEsquerdo().getDireito())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}
		} else if (balanceamento == 2) {
			if (altura(atual.getDireito().getDireito()) >= altura(atual.getDireito().getEsquerdo())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
	}

	private NoAvl rotacaoEsquerda(NoAvl inicial) {

		NoAvl direita = inicial.getDireito();
		direita.setPai(inicial.getPai());

		inicial.setDireito(direita.getEsquerdo());

		if (inicial.getDireito() != null) {
			inicial.getDireito().setPai(inicial);
		}

		direita.setEsquerdo(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireito() == inicial) {
				direita.getPai().setDireito(direita);

			} else if (direita.getPai().getEsquerdo() == inicial) {
				direita.getPai().setEsquerdo(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}

	private NoAvl rotacaoDireita(NoAvl inicial) {

		NoAvl esquerda = inicial.getEsquerdo();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerdo(esquerda.getDireito());

		if (inicial.getEsquerdo() != null) {
			inicial.getEsquerdo().setPai(inicial);
		}

		esquerda.setDireito(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireito() == inicial) {
				esquerda.getPai().setDireito(esquerda);

			} else if (esquerda.getPai().getEsquerdo() == inicial) {
				esquerda.getPai().setEsquerdo(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

	private NoAvl duplaRotacaoEsquerdaDireita(NoAvl inicial) {
		inicial.setEsquerdo(rotacaoEsquerda(inicial.getEsquerdo()));
		return rotacaoDireita(inicial);
	}

	private NoAvl duplaRotacaoDireitaEsquerda(NoAvl inicial) {
		inicial.setDireito(rotacaoDireita(inicial.getDireito()));
		return rotacaoEsquerda(inicial);
	}

	private int altura(NoAvl atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerdo() == null && atual.getDireito() == null) {
			return 0;

		} else if (atual.getEsquerdo() == null) {
			return 1 + altura(atual.getDireito());

		} else if (atual.getDireito() == null) {
			return 1 + altura(atual.getEsquerdo());

		} else {
			return 1 + Math.max(altura(atual.getEsquerdo()), altura(atual.getDireito()));
		}
	}

	private void setBalanceamento(NoAvl no) {
		no.setBalanceamento(altura(no.getDireito()) - altura(no.getEsquerdo()));
	}

	public NoAvl buscaPO(String key) {
		NoAvl atual = this.getRaiz();
		while (atual != null) {
			// verifica se é igual
			if (atual.getValor().getPalavra().compareToIgnoreCase(key)!=0) {
				Transacoes.passosAVL();
				// verifica se é menor
				if (atual.getValor().getPalavra().compareToIgnoreCase(key) > 0) {
					atual = atual.getEsquerdo(); // Vai para esquerda
				} else {
					atual = atual.getDireito(); // Vai para direita
				}
			} else {
				Transacoes.passosAVL();
				break;
			}
		}
		// Verifica se não encontrou
		if (atual == null) {
			return null;
		} else {
			// Retorna o elemento encontrado
			return atual;
		}
	}

	/*
	 * public NoAvl teste(NoAvl no, String key) { int stat;
	 * 
	 * if (no != null) { stat = cmp(key, no.getValor().getPalavra()); if (stat
	 * == 0) { return no; } else if (stat < 0) { return teste(no.getEsquerdo(),
	 * key); } else { return teste(no.getDireito(), key); } }
	 * 
	 * return null; }
	 * 
	 * private int cmp(String key, String palavraNo) {
	 * 
	 * if (key.compareTo(palavraNo) == 0) { return 0; } else if
	 * (key.compareTo(palavraNo) > 0) { return 1; } else if
	 * (key.compareTo(palavraNo) < 0) { return -1; } return 0; }
	 */

	public NoAvl getRaiz() {
		return raiz;
	}
}
