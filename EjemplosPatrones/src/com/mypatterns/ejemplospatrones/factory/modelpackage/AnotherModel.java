package com.mypatterns.ejemplospatrones.factory.modelpackage;

public class AnotherModel implements IModel{
    private Boolean firstProperty;
    private String secondProperty;

    public AnotherModel(Boolean firstProperty, String secondProperty) {
        this.firstProperty = firstProperty;
        this.secondProperty = secondProperty;
    }

    public Boolean getFirstProperty() {
        return firstProperty;
    }

    public void setFirstProperty(Boolean firstProperty) {
        this.firstProperty = firstProperty;
    }

    public String getSecondProperty() {
        return secondProperty;
    }

    public void setSecondProperty(String secondProperty) {
        this.secondProperty = secondProperty;
    }

    @Override
    public String toString() {
        return "AnotherModel{" +
                "firstProperty=" + firstProperty +
                ", secondProperty='" + secondProperty + '\'' +
                '}';
    }

    @Override
    public boolean contractMethod1() {
        System.out.println("Executing contractMethod1 in AnotherModel");
        return false;
    }

    @Override
    public void contractMethod2() {
        System.out.println("Executing contractMethod2 in AnotherModel");
    }
}
