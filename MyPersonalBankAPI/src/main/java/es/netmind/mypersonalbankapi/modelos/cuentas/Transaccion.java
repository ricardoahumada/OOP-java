package es.netmind.mypersonalbankapi.modelos.cuentas;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double importe;
    private LocalDate fecha;

    public Transaccion(Integer id, Double importe, LocalDate fecha) {
        this.id = id;
        this.importe = importe;
        this.fecha = fecha;
    }

    public boolean validar() {
        if (importe == 0) return false;
        else if (this.fecha.isAfter(LocalDate.now())) return false;
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", importe=" + importe +
                ", fecha=" + fecha +
                '}';
    }
}
