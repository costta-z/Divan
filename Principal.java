import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("\n==== DIVAN ====");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Ver tipos de usuários cadastrados");
            System.out.println("3. Mostrar todos os dados cadastrados");
            System.out.println("4. Fazer Login");
            System.out.println("5. Consultar dados básicos dos usuários");
            System.out.println("6. Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nEscolha o seu perfil:");
                    System.out.println("1. Sou paciente");
                    System.out.println("2. Sou psicólogo");
                    System.out.print("Tipo: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo != 1 && tipo != 2) {
                        System.out.println("\nTipo inválido. Tente novamente.");
                        break;
                    }

                    System.out.print("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.print("\nCPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("\nTelefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("\nSenha: ");
                    String senha = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("\nContato de Emergência: ");
                        String contato = sc.nextLine();
                        usuarios.add(new Paciente(nome, cpf, telefone, senha, contato));
                        System.out.println("\nPaciente cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("\nCRP: ");
                        String crp = sc.nextLine();

                        System.out.print("\nEndereço da Clínica: ");
                        String endereco = sc.nextLine();

                        usuarios.add(new Psicologo(nome, cpf, telefone, senha, crp, endereco));
                        System.out.println("\nPsicólogo cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println();
                    if (usuarios.isEmpty()) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.println("Tipos de usuários cadastrados:");
                        for (Usuario u : usuarios) {
                            System.out.println("- " + u.getNome() + " é " + u.getClass().getSimpleName());
                        }
                    }
                    break;

                case 3:
                    System.out.println();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("--- DADOS DE TODOS OS USUÁRIOS ---");
                        for (Usuario u : usuarios) {
                            u.mostrarDados();
                            System.out.println("----------------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Escolha o perfil para login:");
                        System.out.println("1. Paciente");
                        System.out.println("2. Psicólogo");
                        System.out.print("Opção: ");
                        int tipoLogin = sc.nextInt();
                        sc.nextLine();

                        if (tipoLogin != 1 && tipoLogin != 2) {
                            System.out.println("\nTipo de perfil inválido.");
                            break;
                        }

                        Usuario usuarioLogado = null;

                        if (tipoLogin == 1) {
                            System.out.print("Informe o CPF para login: ");
                            String cpfTeste = sc.nextLine();

                            System.out.print("Informe a senha para login: ");
                            String senhaTeste = sc.nextLine();

                            for (Usuario u : usuarios) {
                                if (u instanceof Paciente && u.autenticar(cpfTeste, senhaTeste)) {
                                    usuarioLogado = u;
                                    break;
                                }
                            }
                        } else {
                            System.out.print("Informe o CRP para login: ");
                            String crpTeste = sc.nextLine();

                            System.out.print("Informe a senha para login: ");
                            String senhaTeste = sc.nextLine();

                            for (Usuario u : usuarios) {
                                if (u instanceof Psicologo) {
                                    Psicologo p = (Psicologo) u;
                                    if (p.getCrp().equalsIgnoreCase(crpTeste) && p.getSenha().equals(senhaTeste)) {
                                        usuarioLogado = p;
                                        break;
                                    }
                                }
                            }
                        }

                        if (usuarioLogado != null) {
                            System.out.println("\nLogin efetuado com sucesso!");

                            boolean logado = true;
                            while (logado) {
                                System.out.println("\n===== Área do " + usuarioLogado.getClass().getSimpleName() + " =====");
                                System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
                                System.out.println("1. Questionários");
                                System.out.println("2. Chat");
                                System.out.println("3. Agendar Consultas");
                                System.out.println("4. Sair");
                                System.out.print("Escolha uma opção: ");

                                int opcaoSessao = sc.nextInt();
                                sc.nextLine();

                                switch (opcaoSessao) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        System.out.println("\n[Em desenvolvimento...]");
                                        break;
                                    case 4:
                                        System.out.println("\nLogout efetuado. Voltando ao menu principal...");
                                        logado = false;
                                        break;
                                    default:
                                        System.out.println("\nOpção inválida.");
                                }
                            }
                        } else {
                            System.out.println("\nCredenciais incorretas ou perfil não encontrado.");
                        }
                    }
                    break;

                case 5:
                    System.out.println();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("--- LISTA DE USUÁRIOS ---");
                        for (Usuario u : usuarios) {
                            System.out.println("Nome: " + u.getNome() + " | CPF: " + u.getCpf() + " | Tipo: " + u.getClass().getSimpleName());
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nPrograma encerrado.");
                    sc.close();
                    return;

                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }
        }
    }
}