package com.seuusuario.agendamento.menu;

import com.seuusuario.agendamento.entity.*;
import com.seuusuario.agendamento.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuConsole implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Sistema de Agendamento ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Profissional");
            System.out.println("3 - Cadastrar Serviço");
            System.out.println("4 - Criar Agendamento");
            System.out.println("5 - Listar Agendamentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarProfissional();
                    break;
                case 3:
                    cadastrarServico();
                    break;
                case 4:
                    criarAgendamento();
                    break;
                case 5:
                    listarAgendamentos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        clienteRepository.save(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarProfissional() {
        System.out.print("Nome do Profissional: ");
        String nome = scanner.nextLine();

        Profissional profissional = new Profissional();
        profissional.setNome(nome);

        profissionalRepository.save(profissional);
        System.out.println("Profissional cadastrado com sucesso!");
    }

    private void cadastrarServico() {
        System.out.print("Nome do Serviço: ");
        String nome = scanner.nextLine();

        Servico servico = new Servico();
        servico.setNome(nome);

        servicoRepository.save(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }

    private void criarAgendamento() {
        System.out.println("\n--- Criar Agendamento ---");

        System.out.print("ID do Cliente: ");
        Long clienteId = Long.parseLong(scanner.nextLine());
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);

        System.out.print("ID do Profissional: ");
        Long profissionalId = Long.parseLong(scanner.nextLine());
        Optional<Profissional> profissionalOpt = profissionalRepository.findById(profissionalId);

        System.out.print("ID do Serviço: ");
        Long servicoId = Long.parseLong(scanner.nextLine());
        Optional<Servico> servicoOpt = servicoRepository.findById(servicoId);

        if (clienteOpt.isPresent() && profissionalOpt.isPresent() && servicoOpt.isPresent()) {
            Agendamento agendamento = new Agendamento();
            agendamento.setCliente(clienteOpt.get());
            agendamento.setProfissional(profissionalOpt.get());
            agendamento.setServico(servicoOpt.get());
            agendamento.setDataHora(LocalDateTime.now());

            agendamentoRepository.save(agendamento);
            System.out.println("Agendamento criado com sucesso!");
        } else {
            System.out.println("ID inválido para Cliente, Profissional ou Serviço!");
        }
    }

    private void listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        System.out.println("\n--- Lista de Agendamentos ---");
        for (Agendamento a : agendamentos) {
            System.out.println("ID: " + a.getId() +
                    " | Cliente: " + a.getCliente().getNome() +
                    " | Profissional: " + a.getProfissional().getNome() +
                    " | Serviço: " + a.getServico().getNome() +
                    " | Data/Hora: " + a.getDataHora());
        }
    }
}
