package es.netmind.simuladorcoches.modelos.motores;

public class Electrico extends Motor{
    public Electrico(Integer id, Integer potencia) {
        super(id, potencia);
    }

    @Override
    public void arrancar() {
        System.out.println("Arrancando eléctrico");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando eléctrico");
    }

    @Override
    public void parar() {
        System.out.println("Parando eléctrico");
    }
}
