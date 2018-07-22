package apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import ArvoreAvl.*;
import ArvoreRN.*;
import Hashing.*;
import Tad.Tad;

public class Transacoes {
	private static ArvoreAVL arvoreAvl = new ArvoreAVL();
	// private static ArvRubroNegra arvoreRubroNegra = new ArvRubroNegra();
	private static HashingEncadeado hashing = new HashingEncadeado();
	private static RubroNegra arvoreRb = new RubroNegra();
	private static int passosRb;
	private static int passosAvl;
	private static int passosHash;

	public static int readArq() throws IOException {

		System.out.println("Informe o caminho do arquivo de entrada: ");
		String caminho = Ler.linha();

		File arquivo = new File(caminho);

		if (!arquivo.exists()) {
			System.err.println("verifique so o caminho passado é valido, para o programa seguir com a execução\n");
		} else {
			try {
				// a magica acontece aqui
				FileReader reader = new FileReader(arquivo);
				BufferedReader leitor = new BufferedReader(reader);
				String buffer;
				NoAvl teste;
				NoRN testeRb;
				String[] palavras;
				int i = 0;
				while ((buffer = leitor.readLine()) != null) {
					palavras = buffer.split(" ");
					i++;
					for (int j = 0; j < palavras.length; j++) {
						if (palavras[j].length() > 3) {
							teste = arvoreAvl.buscaPO(palavras[j]);
							if (teste != null) {
								if (!teste.getValor().getLinepos().contains(i)) {
									teste.getValor().getLinepos().add(i);
								}
							} else {
								Tad novo = new Tad(palavras[j], i);
								arvoreAvl.inserir(novo);
							}
							testeRb = arvoreRb.searchRN(palavras[j]);
							if (testeRb != null) {
								if (!testeRb.getElement().getLinepos().contains(i)) {
									testeRb.getElement().getLinepos().add(i);
								}
							} else {
								Tad novo = new Tad(palavras[j], i);
								arvoreRb.insertRN(novo);
							}
							Tad testeHash = hashing.busca(palavras[j]);
							if(testeHash!=null){
								if (!testeHash.getLinepos().contains(i)) {
									testeHash.getLinepos().add(i);
								}
							}
							else {
								Tad novo = new Tad(palavras[j], i);
								hashing.add(novo);
							}
						}
					}
				}
				leitor.close();
			} catch (IOException ex) {
				System.err.println("O programa se comportou de forma inesperada");
				return 0;
			}
		}
		return 1;
	}

	// imprime a aarvore avl em um arquivo
	public static void avlArq() {
		ArrayList<Tad> e = new ArrayList<Tad>();
		System.out.println("Informe onde deseja salvar o arquivo p/ imprimir a Avl: ");
		String caminho = Ler.linha();
		File arquivo = new File(caminho);
		if (!arquivo.exists()) {
			try {
				if (arquivo.createNewFile()) {
					PrintWriter pw = new PrintWriter(arquivo);
					Transacoes.converteAvlArray(arvoreAvl.getRaiz(), e);
					pw.println("***************IMPRESSÃO DA AVL*************\n\n");
					for (int i = 0; i < e.size(); i++) {
						pw.println("palavra : " + e.get(i).getPalavra());
						pw.println("linha do arquivo: " + e.get(i).getLinepos());
						pw.println("****************************\n\n");
					}
					System.out.println("Arquivo Gerado no destino expecificado!");
					pw.close();
				}
			} catch (IOException ex) {
				System.out.println("problema na criação do arquivo");
			}
		} else {
			arquivo.delete();
		}
	}

	public static void hashingArq() {
		System.out.println("Informe onde deseja salvar o arquivo p/ imprimir o hashing: ");
		String caminho = Ler.linha();
		File arquivo1 = new File(caminho);
		if (!arquivo1.exists()) {
			try {
				if (arquivo1.createNewFile()) {
					PrintWriter pw = new PrintWriter(arquivo1);
					pw.println("***************IMPRESSÃO DO HASHING*************\n\n");
					for (int i = 0; i < hashing.getHTable().length; i++) {
						SllNode atual = hashing.getHTable()[i].getPrimeira();
						while (atual != null) {
							pw.println("palavra : " + atual.getElm().getPalavra());
							pw.println("linha do arquivo: " + atual.getElm().getLinepos());
							pw.println("****************************\n\n");
							atual = atual.getProx();
						}
					}
					System.out.println("Arquivo Gerado no destino expecificado!");
					pw.close();
				}
			} catch (IOException ex) {
				System.out.println("problema na criação do arquivo");
			}
		} else {
			arquivo1.delete();
		}
	}

	public static void RubroNegraArq() {
		ArrayList<Tad> e = new ArrayList<Tad>();
		System.out.println("Informe onde deseja salvar o arquivo p/ imprimir a Rubro Negra: ");
		String caminho = Ler.linha();
		File arquivo = new File(caminho);
		if (!arquivo.exists()) {
			try {
				if (arquivo.createNewFile()) {
					PrintWriter pw = new PrintWriter(arquivo);
					Transacoes.converteRbArray(arvoreRb.getRaiz(), e);
					pw.println("***************IMPRESSÃO DA RUBRO NEGRA*************\n\n");
					for (int i = 0; i < e.size(); i++) {
						pw.println("palavra : " + e.get(i).getPalavra());
						pw.println("linha do arquivo: " + e.get(i).getLinepos());
						pw.println("****************************\n\n");
					}
					System.out.println("Arquivo Gerado no destino expecificado!");
					pw.close();
				}
			} catch (IOException ex) {
				System.out.println("problema na criação do arquivo");
			}
		} else {
			arquivo.delete();
		}
	}

	// busca somente a primeira ocorrencia na arvore
	public static void buscarRb(String key) {
		passosRb = 0;
		NoRN retorno = arvoreRb.searchRN(key);
		if (retorno != null) {
			System.out.println("palavra encontrada em " + passosRb + " passos!");
			System.out.println("palavra : " + retorno.getElement().getPalavra() + "\nlinha do arquivo: "
					+ retorno.getElement().lineString());
		} else {
			System.out.println("palavra não encontrada");
		}
	}

	// busca somente a primeira ocorrencia na arvore
	public static void buscaAvl(String key) {
		passosAvl = 0;
		NoAvl retorno = arvoreAvl.buscaPO(key);
		if (retorno != null) {
			System.out.println("palavra encontrada em " + passosAvl + " passos!");
			System.out.println("palavra : " + retorno.getValor().getPalavra() + "\nlinha do arquivo: "
					+ retorno.getValor().lineString());
		} else {
			System.out.println("palavra não encontrada");
		}
	}

	public static void buscarHashing(String key) {
		passosHash = 0;
		Tad retorno = hashing.busca(key);
		if (retorno != null) {
			System.out.println("palavra encontrada em " + passosHash + " passos!");
			System.out.println("palavra : " + retorno.getPalavra() + "\nlinha do arquivo: " + retorno.lineString());
		}else{
			System.out.println("Palavra não consta no hash!");
		}

	}

	// converte a arvore avl em um arraylist para facilitar a escrita no arquivo
	private static void converteAvlArray(NoAvl no, ArrayList<Tad> e) {
		if (no != null) {
			converteAvlArray(no.getEsquerdo(), e);
			e.add(no.getValor());
			converteAvlArray(no.getDireito(), e);
		}
	}

	// converte a arvore Rubro negra em um arraylist para facilitar a escrita no
	// arquivo
	private static void converteRbArray(NoRN no, ArrayList<Tad> e) {
		if (no != arvoreRb.getNil()) {
			converteRbArray(no.getEsquerdo(), e);
			e.add(no.getElement());
			converteRbArray(no.getDireito(), e);
		}
	}

	public static void passosRb() {
		passosRb++;
	}

	public static void passosAVL() {
		passosAvl++;
	}

	public static void passosHash() {
		passosHash++;
	}

	public static int getpassosHash() {
		return passosHash;
	}
}
