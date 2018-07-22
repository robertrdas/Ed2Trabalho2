package apps;

public class Menus {
	public static void menuPrincipal(){
        System.out.println("\tO que desejas?:");
        System.out.println("1. Buscar palavra no indice.");
        System.out.println("2. Imprimir indice.");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
    }
	public static void subMenu1(){
        System.out.println("\tEm qual indice desesjas buscar?:");
        System.out.println("1. Buscar no Hashing.");
        System.out.println("2. Buscar na AVL.");
        System.out.println("3. Buscar na Rubro Negra.");
        System.out.println("4. Buscar nos três indices.");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
    }
	public static void subMenu2(){
        System.out.println("\tQual indice desejas imprimir?:");
        System.out.println("1. Tabela Hashing.");
        System.out.println("2. Arvore AVL.");
        System.out.println("3. Arvore Rubro Negra.");
        System.out.println("4. Os três indices.");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
    }
	
}
