package es.netmind.simuladorcoches.modelos.motores;

public class Combustion extends Motor {
    public Combustion(Integer id, Integer potencia) {
        super(id, potencia);
    }

    @Override
    public void arrancar() {
        System.out.println("Arrancando combustion");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando combustion");
    }

    @Override
    public void parar() {
        System.out.println("Parando combustion");
    }
}
