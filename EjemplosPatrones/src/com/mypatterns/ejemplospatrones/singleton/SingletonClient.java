package com.mypatterns.ejemplospatrones.singleton;

public class SingletonClient {
    public static void main(String[] args) {
        System.out.println("Usando un singleton");
        System.out.println("-----------------------------------");

        MySingletonRepo aRepo = MySingletonRepo.getInstance();

        aRepo.ASingletonBizzMethod();
        aRepo.AnotherSingletonBizzMethod();

    }
}
