package com.mypatterns.ejemplospatrones.builder.modelpackage;
public class AModel {
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


}
