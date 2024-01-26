import java.util.Scanner;

public class Supermercado {

    Scanner scanner = new Scanner(System.in);
    int escolha = 0, contglobal = 0, contvendas = 0;
    String[] produtos = {"Feijão", "Arroz", "Macarrão", "Café", "Tapioca"};
    double[] preco = {2.25, 1.75, 2.35, 2.15, 2.45};
    int[] estoque = {40, 45, 60, 48, 50};
    double caixa;

    String[] clientes = new String[10];

    public void login() {
        String nome;
        int senha;
        int cont = 0;
        do {
            System.out.println("---------SUPERMERCADO.com---------");
            System.out.print("Informe o seu nome: \n  >");
            nome = scanner.next();
            System.out.print("Informe a sua senha: \n  >");
            senha = scanner.nextInt();

            if (nome.equals("admin") && senha == 123) {
                cont = 1;
                System.out.println("-----]BEM-VINDO[-----");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            } else {
                System.out.println("-----]Nome ou Senha incorreta[-----");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
            }
        } while (cont == 0);
    }

    public void menu() {
        int cont = 0;
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        do {
            System.out.println("--SUPERMERCADO.com--");
            System.out.println("---------Menu-------");
            System.out.println("1- Mostrar Produtos em Estoque");
            System.out.println("2- Mostrar Clientes");
            System.out.println("3- Cadastrar Novo Cliente");
            System.out.println("4- Mostrar Dinheiro em Caixa");
            System.out.println("5- Vender Produtos");
            System.out.println("6- Limpar Tela");
            System.out.println("7- Sair");
            System.out.println("--------------------");
            System.out.print("(1 a 7)>> ");
            escolha = scanner.nextInt();
            if (escolha > 7 || escolha < 1) {
                System.out.println("Número inválido");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
            } else {
                cont = 1;
            }
        } while (cont == 0);
    }

    public void mostrarProduto() {
        int escolha1;
        do {
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
            int cont = 1;
            for (int i = 0; i < produtos.length; i++) {
                String precoFormatado = String.format("%.2f", preco[i]);
                System.out.println("ID: " + cont + " | Produto:" + produtos[i] + " | Preço: R$" + precoFormatado + " | Quantidade em estoque: " + estoque[i]);
                cont++;
            }
            for (int i = 0; i < 12; i++) {
                System.out.println();
            }
            System.out.println("Para voltar ao Menu digite 0");
            escolha1 = scanner.nextInt();
        } while (escolha1 != 0);
    }

    public void mostrarClientes() {
        int escolha1;
        do {
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
            System.out.println("---------Clientes-------");
            int cont = 1;
            for (int i = 0; i < clientes.length; i++) {
                System.out.println("ID: " + cont + " | Cliente: " + clientes[i]);
                cont++;
            }
            System.out.println("Para voltar ao Menu digite 0");
            escolha1 = scanner.nextInt();
        } while (escolha1 != 0);
    }

    public void cadastrarCliente() {
        String clientenovo, realmante;
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println("Digite o nome do cliente:");
        System.out.print(">");
        clientenovo = scanner.next();
        System.out.println("Deseja realmente adicionar esse cliente?(sim/nao)");
        System.out.print(">");
        realmante = scanner.next();

        if (realmante.equals("sim")) {
            clientes[contglobal] = clientenovo;
            contglobal++;
            System.out.println("Cliente cadastrado com sucesso");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        } else {
            System.out.println("Cliente não cadastrado");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void mostrarCaixa() {
        int escolha1;
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        do {
            if (contvendas == 0) {
                System.out.println("------CAIXA------");
                System.out.println("-----R$0.00------");
                System.out.println("-----------------");
            } else {
                String caixaFormatado = String.format("%.2f", caixa);
                System.out.println("------CAIXA------");
                System.out.println("-----R$" + caixaFormatado + "------");
                System.out.println("-----------------");
            }
            System.out.println("Para voltar ao Menu digite 0");
            escolha1 = scanner.nextInt();
        } while (escolha1 != 0);
    }

    public void venderprodutos() {
        int id, idcliente, escolha1 = 1, quantidade;
        double soma;
        String escolha2;
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        do {
            System.out.println("Digite o id do cliente");
            System.out.print(">");
            idcliente = scanner.nextInt();
            System.out.println("Digite o id do produto");
            System.out.print(">");
            id = scanner.nextInt();
            System.out.println("Digite a quantidade que deseja comprar");
            System.out.print(">");
            quantidade = scanner.nextInt();
            soma = preco[id-1] * quantidade;
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
            System.out.println("Produto: " + produtos[id-1]);
            System.out.println("------------------------");
            String precoFormatado = String.format("%.2f", preco[id-1]);
            System.out.println("Valor unitário: R$" + precoFormatado);
            System.out.println("------------------------");
            String somaFormatada = String.format("%.2f", soma);
            System.out.println("Valor a pagar: R$" + somaFormatada);
            System.out.println("------------------------");
            System.out.println("Deseja finalizar o pedido?(sim/nao)");
            System.out.print(">");
            escolha2 = scanner.next();

            if (estoque[id-1] < quantidade) {
                System.out.println("Não temos estoque o suficiente para completar a sua compra");
                System.out.println("Estoque restante: " + estoque[id-1]);
                System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                System.out.print(">");
                escolha1 = scanner.nextInt();
                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }
            } else {
                if (escolha2.equals("sim")) {
                    caixa += soma;
                    estoque[id-1] = estoque[id-1] - quantidade;
                    System.out.println("Obrigado pela preferência " + clientes[idcliente - 1]);
                    contvendas++;
                    System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                    System.out.print(">");
                    escolha1 = scanner.nextInt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }
                } else {
                    System.out.println("Compra cancelada");
                    System.out.println("Digite 0 para voltar para o menu ou 1 para realizar outra compra:");
                    System.out.print(">");
                    escolha1 = scanner.nextInt();
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }
                }
            }
        } while (escolha1 != 0);
    }

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.login();
        do {
            supermercado.menu();
            switch (supermercado.escolha) {
                case 1:
                    supermercado.mostrarProduto();
                    break;
                case 2:
                    supermercado.mostrarClientes();
                    break;
                case 3:
                    supermercado.cadastrarCliente();
                    break;
                case 4:
                    supermercado.mostrarCaixa();
                    break;
                case 5:
                    supermercado.venderprodutos();
                    break;
                case 6:
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }
                    break;
            }
        } while (supermercado.escolha != 7);
    }
}
