import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null;

        while (true) {
            System.out.println("\n===== Divan =====");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Escolher tipo de usuário");
            System.out.println("3. Mostrar dados cadastrados");
            System.out.println("4. Fazer login (Autenticar)");
            System.out.println("5. Consultar dados do usuário");
            System.out.println("6. Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    System.out.println("\n1. Paciente");
                    System.out.println("2. Psicólogo");
                    System.out.print("Tipo: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Contato de Emergência: ");
                        String contato = sc.nextLine();
                        usuario = new Paciente(nome, cpf, telefone, senha, contato);
                        System.out.println("\nPaciente cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("CRP: ");
                        String crp = sc.nextLine();

                        System.out.print("Endereço da Clínica: ");
                        String endereco = sc.nextLine();

                        usuario = new Psicologo(nome, cpf, telefone, senha, crp, endereco);
                        System.out.println("\nPsicólogo cadastrado com sucesso!");
                    } else {
                        System.out.println("\nTipo inválido.");
                    }
                    break;

                case 2:
                    System.out.println();
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.println("Tipo atual: " + usuario.getClass().getSimpleName());
                    }
                    break;

                case 3:
                    System.out.println();
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        usuario.mostrarDados();
                    }
                    break;

                case 4:
                    System.out.println();
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.print("Informe o CPF para login: ");
                        String cpfTeste = sc.nextLine();

                        System.out.print("Informe a senha para login: ");
                        String senhaTeste = sc.nextLine();

                        if (usuario.autenticar(cpfTeste, senhaTeste)) {
                            System.out.println("\nLogin efetuado com sucesso!");
                        } else {
                            System.out.println("\nCPF ou senha incorretos.");
                        }
                    }
                    break;

                case 5:
                    System.out.println();
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Nome: " + usuario.getNome());
                        System.out.println("CPF: " + usuario.getCpf());
                        System.out.println("Tipo: " + usuario.getClass().getSimpleName());
                    }
                    break;

                case 6:
                    System.out.println("\nPrograma encerrado.");
                    sc.close();
                    return;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }
}