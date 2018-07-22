package ArvoreRN;

import Tad.Tad;
import apps.Transacoes;

public class RubroNegra {
	private NoRN raiz; // Raiz da arvore
	private NoRN nil; // No nulo

	public RubroNegra() {
		this.nil = new NoRN();
		this.raiz = this.nil;
	}

	// Função que rotaciona o no para esquerda
	private void leftRotate(NoRN x) {
		// Pega o elemento a direita do no x
		NoRN y = x.getDireito();
		// Insere o elemento à esquerda de y a direita de x
		x.setDireito(y.getEsquerdo());
		// O elemento a esquerda de y sera filho de x
		y.getEsquerdo().setPai(x);
		// O y vira filho do pai de x
		y.setPai(x.getPai());
		// Verifica se x é raiz
		if (x.getPai().equals(getNil())) {
			setRaiz(y); // O y vira raiz
		} else {
			// Verifica se x é filho a esquerda
			if (x.equals(x.getPai().getEsquerdo())) {
				// O y vira filho do pai de x a esquerda
				x.getPai().setEsquerdo(y);
			} else {
				// O y vira filho do pai de x a direita
				x.getPai().setDireito(y);
			}
		}
		// Insere o elemento x à esquerda de y
		y.setEsquerdo(x);
		// O x vira filho de y
		x.setPai(y);
	}

	// Função que rotaciona o no para direita
	private void rightRotate(NoRN x) {
		// Pega o elemento a esquerda do no x
		NoRN y = x.getEsquerdo();
		// Insere o elemento à direita de y a esquerda de x
		x.setEsquerdo(y.getDireito());
		// O elemento a direita de y sera filho de x
		y.getDireito().setPai(x);
		// O y vira filho do pai de x
		y.setPai(x.getPai());
		// Verifica se x é raiz
		if (x.getPai().equals(getNil())) {
			// O y vira raiz
			setRaiz(y);
		} else {
			// Verifica se x é filho a direita
			if (x.equals(x.getPai().getDireito())) {
				// O y vira filho do pai de x a direita
				x.getPai().setDireito(y);
			} else {
				// O y vira filho do pai de x a esquerda
				x.getPai().setEsquerdo(y);
			}
		}
		// Insere o elemento x à direita de y
		y.setDireito(x);
		// O x vira filho de y
		x.setPai(y);
	}

	// Função que insere o Word na arvore
	public void insertRN(Tad Word) {
		// Novo no a ser inserido
		NoRN z = new NoRN(Word);
		// No que guadar a folha que ira ser pai do novo no
		NoRN y = getNil();
		// No que ira percorrer a arvore
		NoRN x = getRaiz();
		// Enquanto não terminar a arvore
		while (!x.equals(getNil())) {
			y = x; // Guarda o no valido
			if (z.getElement().getPalavra().compareTo(x.getElement().getPalavra()) < 0) {
				// Vai para esquerda
				x = x.getEsquerdo();
			} else {
				// Vai para direita
				x = x.getDireito();
			}
		}
		// O novo no vira filho da folha
		z.setPai(y);
		// Verifica se a arvore estava vazia
		if (y.equals(getNil())) {
			// O novo no passa a ser raiz
			setRaiz(z);
		} else {
			// verifica se novo no é menor que a folha
			if (z.getElement().getPalavra().compareTo(y.getElement().getPalavra()) < 0) {
				// Insere o novo no a esquerda da folha
				y.setEsquerdo(z);
			} else {
				// Insere o novo no a direita da folha
				y.setDireito(z);
			}
		}
		// O novo no não tem filhos a esquerda
		z.setEsquerdo(getNil());
		// O novo no não tem filhos a direita
		z.setDireito(getNil());
		// O novo no é vermelho
		z.setCor(true);
		// Chamada a função que normaliza a arvore
		insertFixupRN(z);
	}

	// Função que normaliza a arvore na regiao onde o no foi inserido
	private void insertFixupRN(NoRN z) {
		NoRN y;
		while (z.getPai().isCor()) { // Enquanto o pai do no z for vermelho
			// verifica se o pai de z é filho a esquerda
			if (z.getPai().equals(z.getPai().getPai().getEsquerdo())) {
				y = z.getPai().getPai().getDireito(); // Pega o tio de z
				if (y.isCor()) { // Verifica se o tio é vermelho
					z.getPai().setCor(false); // Pai de z fica preto
					y.setCor(false); // O tio fica preto
					z.getPai().getPai().setCor(true); // O avo fica vermelho
					z = z.getPai().getPai(); // Z recebe o avo
				} else {
					// verifica se z é filho a direita
					if (z.equals(z.getPai().getDireito())) {
						z = z.getPai(); // Z recebe o pai
						leftRotate(z); // Rotaciona z para esquerda
					}
					// O pai de z vira preto
					z.getPai().setCor(false);
					// o avo de z vira vermelho
					z.getPai().getPai().setCor(true);
					// rotaciona o avo de z para a direit
					rightRotate(z.getPai().getPai());
				}
				// verifica se o pai de z é o filho a direita
			} else if (z.getPai().equals(z.getPai().getPai().getDireito())) {
				y = z.getPai().getPai().getEsquerdo(); // Pega o tio de z
				if (y.isCor()) { // Verifica se o tio é vermelho
					z.getPai().setCor(false); // Pai de z fica preto
					y.setCor(false); // O tio fica preto
					z.getPai().getPai().setCor(true); // O avo fica vermelho
					z = z.getPai().getPai(); // Z recebe o avo
				} else {
					// Verifica se z é filho a esquerda
					if (z.equals(z.getPai().getEsquerdo())) {
						z = z.getPai(); // Z recebe o pai
						rightRotate(z); // Rotaciona z para direita
					}
					z.getPai().setCor(false); // O pai de z vira preto
					// o avo de z vira preto
					z.getPai().getPai().setCor(true);
					// Rotaciona o avo de z para direita
					leftRotate(z.getPai().getPai());
				}
			}
		}
		getRaiz().setCor(false); // A raiz vira preta
	}

	public NoRN searchRN(String element) {
		NoRN atual = getRaiz(); // No que ira percorrer
		while (!atual.equals(getNil())) { // Enquanto não for null
			// verifica se é igual
			if (atual.getElement().getPalavra().compareToIgnoreCase(element)!=0) {
				Transacoes.passosRb();
				// verifica se é menor
				if (atual.getElement().getPalavra().compareToIgnoreCase(element) > 0) {
					atual = atual.getEsquerdo(); // Vai para esquerda
				} else {
					atual = atual.getDireito(); // Vai para direita
				}
			} else {
				Transacoes.passosRb();
				break;
			}
		}
		// Verifica se não encontrou
		if (atual.equals(getNil())) {
			return null;
		} else {
			// Retorna o elemento encontrado
			return atual;
		}
	}

	// encapsulamento
	public NoRN getRaiz() {
		return raiz;
	}

	public void setRaiz(NoRN raiz) {
		this.raiz = raiz;
	}

	public NoRN getNil() {
		return nil;
	}

	public void setNil(NoRN nil) {
		this.nil = nil;
	}
}
