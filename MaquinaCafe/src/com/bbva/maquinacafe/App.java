package com.bbva.maquinacafe;

import com.bbva.maquinacafe.modelos.*;
import com.bbva.maquinacafe.modelos.tazacafe.Corto;
import com.bbva.maquinacafe.modelos.tazacafe.Largo;
import com.bbva.maquinacafe.modelos.tazacafe.TazaCafe;

public class App {

    public static void main1(String[] args) {
        System.out.println("MAQUINA DE CAFÉ");

        System.out.println("-------------------CAPSULAS---------");

        Capsula c1 = new Capsula(1, "Nescafe", "largo");
        System.out.println("c1: " + c1);

        Capsula c2 = new Capsula();
        Capsula c3;
        Capsula c4 = null;

        c1.setId(2);

        // c1.tipo_cafe = "expresso";
        // c1.precio = 6.0;
        // c1.calcular_precio();


        // c1.marca = "Nescafe";
        c1.setMarca("Bonka");


        // c1.estado = false;

        // c1.marca = "Bonka";
        System.out.println("c1: " + c1);

        c3 = c1;

        c1.setMarca("Milka");
        System.out.println("c3: " + c3);
        c3.setMarca("Cacao");
        System.out.println("c1: " + c1);

        System.out.println("c2: " + c2);

        System.out.println("c4: " + c4);


        System.out.println("-------------------EMPLEADOS---------");

        Empleado juan = new Empleado("Juan", 1, "j@j.com", "dev");
        System.out.println("juan: " + juan);
        System.out.println("valido: " + juan.validar());
        juan.setDni("12345678V");


        System.out.println("DNI: " + juan.getDni());

        juan.setNombre("Jonh");

        c1.asociar_empleado(juan);

        System.out.println("c1: " + c1);


        String s1 = "un texto";
        String s2 = s1;
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        s1 = "otro texto";
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

    }

    public static void main(String[] args) {
        TazaCafe unaTaza = new TazaCafe(1, 100, "Fab SL", false);
        System.out.println("unaTaza: " + unaTaza);
        unaTaza.prepararTaza();
        unaTaza.servirTaza();

        System.out.println("----------------------");

        Largo unLargo = new Largo(2, 200, "Fab SL", false, 30);
        System.out.println("unLargo: " + unLargo);
        unLargo.prepararTaza();
        unLargo.servirTaza();

        System.out.println("----------------------");

        Corto unCorto = new Corto(3, 50, "Fab SL", false, 10);
        System.out.println("unCorto: " + unCorto);
        unCorto.prepararTaza();
        unCorto.servirTaza();

    }

}
