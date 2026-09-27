public abstract class Usuario implements Autenticavel {
    private String nome;
    private String cpf;
    private String telefone;
    private String senha;

    public Usuario(String nome, String cpf, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public boolean autenticar(String senhaFornecida) {
        return this.senha != null && this.senha.equals(senhaFornecida);
    }

    @Override
    public boolean autenticar(String cpfFornecido, String senhaFornecida) {
        return this.cpf != null && this.cpf.equals(cpfFornecido) && this.senha != null && this.senha.equals(senhaFornecida);
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
    }
}