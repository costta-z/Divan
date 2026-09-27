public class Paciente extends Usuario {
    private String contatoEmergencia;

    public Paciente(String nome, String cpf, String telefone, String senha, String contatoEmergencia) {
        super(nome, cpf, telefone, senha);
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Contato de Emergência: " + contatoEmergencia);
    }
}