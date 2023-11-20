package com.bbva.maquinacafe.modelos;

public class Capsula {
    // propiedades
    private int id;
    private String marca;
    private String tipo_cafe;
    private Empleado empleado;
    private double precio;
    private boolean estado;

    // constructores
    public Capsula() {
    }

    public Capsula(int id, String marca, String tipo_cafe) {
        this.id = id;
        this.marca = marca;
        this.tipo_cafe = tipo_cafe;

        this.calcular_precio();
    }

    // funcionalidades o métodos
    public boolean asociar_empleado(Empleado nuevoEmpleado) {
        if(nuevoEmpleado.validar()) {
            this.empleado = nuevoEmpleado;
            return true;
        }else{
            return false;
        }
    }

    public void asociar_tipo_cafe(String tipo) {
        this.tipo_cafe = tipo;
        this.calcular_precio();
    }

    public void asociar_tipo_cafe(String tipo, boolean validar) {
        this.tipo_cafe = tipo;
        this.calcular_precio();
    }

    private double calcular_peso_por_tipo() {
        if (this.tipo_cafe.equals("largo")) return 1.5;
        else return 1;
    }

    public double calcular_precio() {
        double p = calcular_peso_por_tipo();
        System.out.println("p: " + p);
        if (this.marca.equals("Nescafe")) this.precio = 6 * p;
        else this.precio = 3 * p;
        return this.precio;
    }

    public boolean consumir() {
        this.estado = true;
        return this.estado;
    }

    // getter y setter
    public int getId() {
        // consulta API para asignar id
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo_cafe() {
        return tipo_cafe;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public double getPrecio() {
        // control de verificacion
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
        this.calcular_precio();
    }

    @Override
    public String toString() {
        return "com.bbva.maquinacafe.modelos.Capsula{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", tipo_cafe='" + tipo_cafe + '\'' +
                ", empleado='" + empleado + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }
}
