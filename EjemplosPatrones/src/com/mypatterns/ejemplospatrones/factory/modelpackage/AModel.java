package com.mypatterns.ejemplospatrones.factory.modelpackage;

public class AModel implements IModel{
    private String aProperty;
    private Integer anotherProperty;

    public AModel(String aProperty, Integer anotherProperty) {
        this.aProperty = aProperty;
        this.anotherProperty = anotherProperty;
    }

    public String getaProperty() {
        return aProperty;
    }

    public void setaProperty(String aProperty) {
        this.aProperty = aProperty;
    }

    public Integer getAnotherProperty() {
        return anotherProperty;
    }

    public void setAnotherProperty(Integer anotherProperty) {
        this.anotherProperty = anotherProperty;
    }

    @Override
    public String toString() {
        return "AModel{" +
                "aProperty='" + aProperty + '\'' +
                ", anotherProperty=" + anotherProperty +
                '}';
    }

    @Override
    public boolean contractMethod1() {
        System.out.println("Executing contractMethod1 in AModel");
        return false;
    }

    @Override
    public void contractMethod2() {
        System.out.println("Executing contractMethod2 in AModel");
    }
}
