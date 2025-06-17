package com.seuusuario.agendamento;

import com.seuusuario.agendamento.entity.*;
import com.seuusuario.agendamento.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Profissional> profissionais = new ArrayList<>();
    private static final List<Servico> servicos = new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        ProfissionalService profissionalService = new ProfissionalService();
        ServicoService servicoService = new ServicoService();
        AgendamentoService agendamentoService = new AgendamentoService();

        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Profissional");
            System.out.println("3. Cadastrar Serviço");
            System.out.println("4. Fazer Agendamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, telefone, email);
                    clienteService.adicionarCliente(cliente, clientes);
                    clientes.add(cliente);
                }
                case 2 -> {
                    System.out.print("Nome do Profissional: ");
                    String nome = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = scanner.nextLine();

                    Profissional profissional = new Profissional(nome, especialidade);
                    profissionalService.adicionarProfissional(profissional, profissionais);
                    profissionais.add(profissional);
                }
                case 3 -> {
                    System.out.print("Nome do Serviço: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    Servico servico = new Servico(nome, preco);
                    servicoService.adicionarServico(servico);
                    servicos.add(servico);
                }
                case 4 -> {
                    if (clientes.isEmpty() || profissionais.isEmpty() || servicos.isEmpty()) {
                        System.out.println("Antes de agendar, cadastre ao menos um cliente, profissional e serviço.");
                        break;
                    }

                    System.out.println("Clientes:");
                    for (int i = 0; i < clientes.size(); i++)
                        System.out.println(i + ": " + clientes.get(i).getNome());

                    System.out.print("Escolha o cliente (índice): ");
                    int idxCliente = scanner.nextInt();

                    System.out.println("Profissionais:");
                    for (int i = 0; i < profissionais.size(); i++)
                        System.out.println(i + ": " + profissionais.get(i).getNome());

                    System.out.print("Escolha o profissional (índice): ");
                    int idxProfissional = scanner.nextInt();

                    System.out.println("Serviços:");
                    for (int i = 0; i < servicos.size(); i++)
                        System.out.println(i + ": " + servicos.get(i).getNome());

                    System.out.print("Escolha o serviço (índice): ");
                    int idxServico = scanner.nextInt();

                    Cliente cliente = clientes.get(idxCliente);
                    Profissional profissional = profissionais.get(idxProfissional);
                    Servico servico = servicos.get(idxServico);

                    Agendamento agendamento = new Agendamento(
                            cliente.getId(), profissional.getId(), servico.getId(), LocalDateTime.now());

                    agendamentoService.fazerAgendamento(agendamento, cliente, servico);
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
