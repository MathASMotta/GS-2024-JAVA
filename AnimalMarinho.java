public class AnimalMarinho {
    private String nome;
    private String genero;
    private String especie;
    private String unidadeTratamento;
    private String estadoSaude;

    public AnimalMarinho(String nome, String genero, String especie, String unidadeTratamento, String estadoSaude) {
        this.nome = nome;
        this.genero = genero;
        this.especie = especie;
        this.unidadeTratamento = unidadeTratamento;
        this.estadoSaude = estadoSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getUnidadeTratamento() {
        return unidadeTratamento;
    }

    public void setUnidadeTratamento(String unidadeTratamento) {
        this.unidadeTratamento = unidadeTratamento;
    }

    public String getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(String estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Espécie: " + especie);
        System.out.println("Unidade de Tratamento: " + unidadeTratamento);
        System.out.println("Estado de Saúde: " + estadoSaude);
    }
}
