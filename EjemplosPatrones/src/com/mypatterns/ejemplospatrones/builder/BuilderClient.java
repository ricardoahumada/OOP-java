package com.mypatterns.ejemplospatrones.builder;

import com.mypatterns.ejemplospatrones.builder.modelpackage.AModel;
import com.mypatterns.ejemplospatrones.builder.modelpackage.AModelBuilder;

public class BuilderClient {
    public static void main(String[] args) {
        System.out.println("Usando un builder");
        System.out.println("-----------------------------------");

        AModel anObject = new AModelBuilder().setAProperty("Hola").setAnotherProperty(23).build();
        System.out.println(anObject);

        AModel anotherObject = new AModelBuilder().setAnotherProperty(45).build();
        System.out.println(anotherObject);

        AModelBuilder mBuilder = new AModelBuilder();
        mBuilder.setAProperty("email");
        mBuilder.setAnotherProperty(23);

        AModel aModelObj = mBuilder.build();

    }
}
