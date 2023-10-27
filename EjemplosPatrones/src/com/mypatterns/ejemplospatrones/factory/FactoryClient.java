package com.mypatterns.ejemplospatrones.factory;

import com.mypatterns.ejemplospatrones.factory.modelpackage.IModel;
import com.mypatterns.ejemplospatrones.factory.modelpackage.MyFactory;

import java.util.HashMap;

public class FactoryClient {
    public static void main(String[] args) {
        System.out.println("Usando un factory");
        System.out.println("-----------------------------------");

        try {
            System.out.println("... Creando objeto de tipo AModel");
            /*Definimos parámetros*/
            HashMap<String, Object> paramsForAnObjectOfTypeAModel = new HashMap<>();
            paramsForAnObjectOfTypeAModel.put("aProperty", "Hola a model");
            paramsForAnObjectOfTypeAModel.put("anotherProperty", 23);
            /*Pedimos al factory que cree el objeto*/
            IModel anObjectOfTypeAModel = MyFactory.create("amodel", paramsForAnObjectOfTypeAModel);
            anObjectOfTypeAModel.contractMethod1();
            anObjectOfTypeAModel.contractMethod2();

            System.out.println("... Creando objeto de tipo AnotherModel");
            /*Definimos parámetros*/
            HashMap<String, Object> paramsForAnObjectOfTypeAnotherModel = new HashMap<>();
            paramsForAnObjectOfTypeAnotherModel.put("firstProperty", new Boolean(true));
            paramsForAnObjectOfTypeAnotherModel.put("secondProperty", "Hola another model");
            IModel anObjectOfTypeAnotherModel = MyFactory.create("anothermodel", paramsForAnObjectOfTypeAnotherModel);
            anObjectOfTypeAnotherModel.contractMethod1();
            anObjectOfTypeAnotherModel.contractMethod2();
        } catch (Exception e) {
            System.out.println("Ooops hubo un error: " + e.getMessage());
            System.out.println("Revisa los parámetros que pasas a los objetos!!!");
            e.printStackTrace();
        }

    }
}
