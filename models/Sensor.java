package models;

public class Sensor {
    private String tipo;
    private String status;
    private String identificador;

    public Sensor(String tipo, String status, String identificador) {
        this.tipo = tipo;
        this.status = status;
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void mostrarDetalhes() {
        System.out.println("Identificador do Sensor: " + identificador);
        System.out.println("Tipo de Sensor: " + tipo);
        System.out.println("Status: " + status);
    }
}
