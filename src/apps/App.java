package apps;

import java.io.IOException;

public class App {

	public static void main(String[] agvs) throws IOException {
		int resPrincipal, resSub1, resSub2;
		String buscar;
		int testeDeSegunranca = Transacoes.readArq();
		/* testa se teve algum problema com o caminho do arquivo passado, enquanto
		 * não for passado um caminho valido o programa não prossegue
		 */
		while (testeDeSegunranca == 0) {
			testeDeSegunranca = Transacoes.readArq();
		}
		System.out.println("**********************************");
		System.out.println("Dados do arquivo foram carregados!");
		System.out.println("**********************************\n\n");
		do {
			Menus.menuPrincipal();
			resPrincipal = Ler.inteiro();
			switch (resPrincipal) {
			case 1:
				// buscar palavra
				System.out.println("Qual palavra desejas buscar?: ");
				buscar = Ler.linha();

				Menus.subMenu1();
				resSub1 = Ler.inteiro();
				switch (resSub1) {
				case 1:
					// buscar no hashing
					System.out.println("\n****************************\n\n");
					Transacoes.buscarHashing(buscar);
					System.out.println("\n****************************\n\n");
					break;
				case 2:
					
					System.out.println("\n****************************\n\n");
					Transacoes.buscaAvl(buscar);
					System.out.println("\n****************************\n\n");
					break;
				case 3:
					// buscar na rubro negra
					System.out.println("\n****************************\n\n");
					Transacoes.buscarRb(buscar);
					System.out.println("\n****************************\n\n");
					//falta concertar o bug da rubro negra
					break;
				case 4:
					// buscar nos tres
					System.out.println("\n***************HASHING*****************\n\n");
					Transacoes.buscarHashing(buscar);
					System.out.println("\n****************AVL********************\n\n");
					Transacoes.buscaAvl(buscar);
					System.out.println("\n*************RUBRO NEGRA***************\n\n");
					Transacoes.buscarRb(buscar);
					break;
				case 0:
					// sair
					break;
				default:
					System.err.println("tente novamente!");
					break;
				}

				break;
			case 2:
				// imprimir
				Menus.subMenu2();
				resSub2 = Ler.inteiro();
				switch (resSub2) {
				case 1:
					// hashing
					Transacoes.hashingArq();
					break;
				case 2:
					// imprime a arvore avl em um arquivo
					Transacoes.avlArq();
					break;
				case 3:
					// rubro negra
					Transacoes.RubroNegraArq();
					//falta concertar a rubro negra
					break;
				case 4:
					// os tres
					Transacoes.hashingArq();
					Transacoes.avlArq();
					Transacoes.RubroNegraArq();
					//falta imprimir a rubro negra
					break;
				case 0:
					System.out.println("Até mais!");
					break;
				default:
					System.err.println("tente novamente!");
					break;
				}
				break;
			case 0:
				System.out.println("Obrigdo e até mais!");
				break;
			default:
				System.err.println("Comando não reconhecido!");
				break;

			}

		} while (resPrincipal != 0);

	}

}
