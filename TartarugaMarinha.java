public class TartarugaMarinha extends AnimalMarinho {
    private static final String HABITAT = "Praias de água doce";
    private static final String AMEACAS = "Lixo nos rios";
    private static final String STATUS_PRESERVACAO = "Risco de extinção";

    public TartarugaMarinha(String nome, String genero, String unidadeTratamento, String estadoSaude) {
        super(nome, genero, "Tartaruga Marinha", unidadeTratamento, estadoSaude);
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Habitat: " + HABITAT);
        System.out.println("Ameaças: " + AMEACAS);
        System.out.println("Status de Preservação: " + STATUS_PRESERVACAO);
    }
}
