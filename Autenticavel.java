public interface Autenticavel {
    boolean autenticar(String senha);
    boolean autenticar(String cpf, String senha);
}