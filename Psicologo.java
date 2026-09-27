public class Psicologo extends Usuario {
    private String crp;
    private String enderecoClinica;

    public Psicologo(String nome, String cpf, String telefone, String senha, String crp, String enderecoClinica) {
        super(nome, cpf, telefone, senha);
        this.crp = crp;
        this.enderecoClinica = enderecoClinica;
    }

    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }

    public String getEnderecoClinica() { return enderecoClinica; }
    public void setEnderecoClinica(String enderecoClinica) { this.enderecoClinica = enderecoClinica; }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("CRP: " + crp);
        System.out.println("Endereço da Clínica: " + enderecoClinica);
    }
}