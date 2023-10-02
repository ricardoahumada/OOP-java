package com.netmind;

import com.netmind.modelos.Coche;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Coche unCoche = new Coche(1, "Renault", 130.0, 200);
        System.out.println( "Coche" + unCoche);
    }
}
