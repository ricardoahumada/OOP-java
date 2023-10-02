package es.netmind.simuladorcoches.ruedas;

public class Rueda {

    private Long diametro;

    public Rueda(long l) {
        this.diametro = l;
    }

    @Override
    public String toString() {
        return "Rueda{" +
                "diametro=" + diametro +
                '}';
    }

    public Long getDiametro() {
        return diametro;
    }

    public void setDiametro(Long diametro) {
        this.diametro = diametro;
    }
}
