package es.netmind.simuladorcoches.modelos.ruedas;

public class Rueda {
    private long Diametro;

    public Rueda(long diametro) {
        Diametro = diametro;
    }

    public long getDiametro() {
        return Diametro;
    }

    public void setDiametro(long diametro) {
        Diametro = diametro;
    }

    @Override
    public String toString() {
        return "Rueda{" +
                "Diametro=" + Diametro +
                '}';
    }
}
