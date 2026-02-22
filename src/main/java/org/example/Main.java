package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        Patio patio = new Patio();

        Veiculo veiculo = new Veiculo("Chevrolet", "Onix", 2015, "Prata", 45000);
        Carro carro = new Carro("Chevrolet", "Onix", 2015, "Prata", 45000,5,"Flex",200);
        Moto moto = new Moto("Kawasaky","Ninja 900",2019,"Verde",55000,900,true,"Head");
        Monociclo mono = new Monociclo("Kingsong", "KS-14D PRO", 2021, "Preto", 6324.0,30.0, 40.0, 800.0);
        Pessoa pessoa = new Pessoa("Leonardo", 52, "Rua 1 n123", "1138325599", "leo@email.com", 192, 98.4);
        Venda venda = new Venda(carro, pessoa, 50000, LocalDateTime.now());
        Venda venda2 = new Venda(mono, pessoa, 6324.05, LocalDateTime.now());
        clientes.add(pessoa);


        patio.addVeiculo(carro);
        patio.addVeiculo(mono);
        patio.addVeiculo(moto);

        vendas.add(venda);
        vendas.add(venda2);


        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do{
            try{
                System.out.println("### Menu Concessionaria ###");
                System.out.println("1 - Mostrar Veiculos");
                System.out.println("2 - Comprar Veiculo");
                System.out.println("3 - Vender Veiculo");
                System.out.println("4 - Cadastrar um cliente");
                System.out.println("5 - Mostrar clientes");
                System.out.println("6 - Gerar relatorio");
                System.out.println("7 - Sugestão por Biotipo");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (escolha) {
                    case 1:
                        patio.exibirVeiculosNoPatio();
                        break;
                    case 2:
                        comprarVeiculo(scanner, patio);
                        break;
                    case 3:
                        venderVeiculo(scanner, patio);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        mostrarClientes();
                        break;
                    case 6:
                        gerarRelatorio();
                        break;
                    case 7:
                        sugerirVeiculoPorBiotipo(scanner, patio);
                        break;
                    case 0:
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                }
            }catch (InputMismatchException e){
                System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Erro desconhecido: "+e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void comprarVeiculo(Scanner scanner, Patio patio) {
        try{
            System.out.println("### Compra de Veiculo ###");
            int escolha;

            System.out.println("Qual novo veiculo deseja cadastrar?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Monociclo");
            System.out.println("0 - Voltar ao menu");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 3) {
                throw new InputMismatchException();
            }
            while (escolha != 0) {
                System.out.print("Digite a marca do veículo: ");
                String marca = scanner.nextLine();

                System.out.print("Digite o modelo do veículo: ");
                String modelo = scanner.nextLine();

                System.out.print("Digite o ano do veículo: ");
                int ano = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite a cor do veículo: ");
                String cor = scanner.nextLine();

                System.out.print("Digite o preço do veículo: ");
                double preco = scanner.nextDouble();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o numero de portas veículo: ");
                        int nPortar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite o tipo de combustivel: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.print("Digite a capacidade do porta malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();
                        scanner.nextLine();

                        Carro carro = new Carro(marca, modelo, ano, cor, preco, nPortar, tipoCombustivel, capacidadePortaMalas);
                        patio.addVeiculo(carro);


                        System.out.println("Carro modelo: "+modelo+", cadastrado com sucesso!");
                        escolha = 0;
                        break;

                    case 2:
                        System.out.print("Digite as cilindradas do veiculo: ");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("O veiculo possui partida eletrica? S - sim, N - não");
                        String partida = scanner.nextLine();
                        boolean partidaEletrica;
                        if(partida == "S" || partida == "s"){
                            partidaEletrica = true;
                        }else{
                            partidaEletrica = false;
                        }

                        System.out.print("Digite a categoria do veiculo: ");
                        String categoria = scanner.nextLine();

                        Moto moto = new Moto(marca, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                        patio.addVeiculo(moto);
                        System.out.println("moto modelo: "+modelo+", cadastrada com sucesso!");
                        escolha = 0;
                        break;

                    case 3:
                        System.out.print("Digite a velocidade maxima do monociclo: ");
                        Double velocidadeMaxima = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite a autonimoa do Mono em Km: ");
                        Double autonomiaKm = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite a capacidade em Watts do mono: ");
                        Double powerInWatts = scanner.nextDouble();
                        scanner.nextLine();

                        Monociclo monociclo = new Monociclo(marca, modelo, ano, cor, preco, velocidadeMaxima, autonomiaKm, powerInWatts);
                        patio.addVeiculo(monociclo);
                        System.out.println("monociclo modelo: "+modelo+", cadastrado com sucesso!");
                        escolha = 0;
                    break;


                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                        break;
                }
            }

        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void venderVeiculo(Scanner scanner, Patio patio) {
        try {
            if (clientes.isEmpty() || patio.getVeiculos().isEmpty()) {
                if (clientes.isEmpty()) {
                    System.out.println("Não há clientes na base de dados!");
                }
                if (patio.getVeiculos().isEmpty()) {
                    System.out.println("Não há veículos disponíveis para vendas!");
                }
            } else {

                mostrarClientes();
                System.out.print("Selecione o cliente: ");
                Pessoa comprador = clientes.get(scanner.nextInt() - 1);
                scanner.nextLine();

                System.out.print("Informe o valor da venda: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                patio.exibirVeiculosNoPatio();
                System.out.print("Informe o número do veículo que deseja vender: ");
                int indiceVeiculo = scanner.nextInt() - 1;
                scanner.nextLine();

                Veiculo veiculoParaVenda = patio.getVeiculos().get(indiceVeiculo);

                Venda novaVenda = new Venda(veiculoParaVenda, comprador, valor, LocalDateTime.now());
                vendas.add(novaVenda);

                patio.removeVeiculo(veiculoParaVenda);

                System.out.println("Venda de " + veiculoParaVenda.getModelo() + " executada com sucesso!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido. Certifique-se de escolher uma opção correta!");
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void mostrarClientes() {
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de Clientes ###");
            int x = 1;
            for (Pessoa cliente : clientes) {
                System.out.println(x+" - "+cliente.getNome()+" - "+cliente.getTelefone());
                x++;
            }
        }else{
            System.out.println("Nenhuma cliente foi encontrado!");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try{
            System.out.println("### Cadastro de Cliente ###");

            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.println("Digite um telefone para contato do cliente: ");
            String telefone = scanner.nextLine();

            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            System.out.println("Digite a altura do cliente: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println("O cliente: "+nome+", foi cadastrado com sucesso!");
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada invalida. Certifique-se de inserir os dados corretamente!");
        }catch (Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }

    private static void sugerirVeiculoPorBiotipo(Scanner scanner, Patio patio) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para análise.");
            return;
        }

        mostrarClientes(); // Método já existente na Main [3]
        System.out.print("Selecione o número do cliente para a sugestão: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < clientes.size()) {
            Pessoa p = clientes.get(index);
            double altura = p.getAltura();
            double peso = p.getPeso();

            System.out.println("\n--- Sugestão para " + p.getNome() + " ---");
            System.out.println("Perfil: " + altura + "cm e " + peso + "kg.");

            // Lógica de sugestão baseada em biotipo
            if (altura > 185 || peso > 100) {
                // Biotipo Grande: Foco em conforto e espaço interno
                System.out.println("Recomendação: CARRO.");
                System.out.println("Motivo: Pelo seu porte físico, um carro oferece melhor ergonomia e espaço.");
                patio.mostrarCarros(); // [4]
            }
            else if (altura >= 165 && altura <= 185) {
                // Biotipo Médio: Versatilidade
                System.out.println("Recomendação: MOTO.");
                System.out.println("Motivo: Sua estatura é ideal para o equilíbrio e alcance dos comandos em motocicletas.");
                patio.mostrarMotos(); // [5]
            }
            else {
                // Biotipo Pequeno: Foco em agilidade e baixo centro de gravidade
                System.out.println("Recomendação: MONOCICLO.");
                System.out.println("Motivo: Pela sua estatura e peso, um monociclo elétrico oferece excelente manobrabilidade.");
                patio.mostrarMonociclos(); // [6]
            }
        } else {
            System.out.println("Cliente inválido.");
        }
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
        }else{
            System.out.println("### Relatorio de vendas ###");
            System.out.println();
            for (Venda venda : vendas) {
                System.out.println("Data: "+ venda.getDataVenda());
                System.out.println("Veiculo: "+venda.getVeiculo().getModelo()+" - "+venda.getVeiculo().getAno());
                System.out.println("Comprador: "+venda.getComprador().getNome()+" - "+venda.getComprador().getTelefone());
                System.out.println("Valor da venda: R$"+venda.getValor());
                System.out.println("----------------------------------------------------------------");
                System.out.println();
            }
        }
    }
}
