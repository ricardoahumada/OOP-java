package com.mypatterns.ejemplospatrones.singleton;

public class MySingletonRepo {

    private static MySingletonRepo instance;

    private MySingletonRepo() {

    }

    public static MySingletonRepo getInstance() {
        if (instance == null) instance = new MySingletonRepo();
        return instance;
    }

    public boolean ASingletonBizzMethod(){
        System.out.println("Ejecutando ASingletonBizzMethod ...");
        return true;
    }

    public boolean AnotherSingletonBizzMethod(){
        System.out.println("Ejecutando AnotherSingletonBizzMethod ...");
        return true;
    }

}
