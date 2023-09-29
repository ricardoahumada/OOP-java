package es.netmind.ejemplospatrones.builder.modelpackage;

public class AModelBuilder {
    private String aProperty;
    private Integer anotherProperty;

    public AModelBuilder() {
    }

    public AModelBuilder(String aP) {
        this.aProperty=aP;
    }

    public AModelBuilder setAProperty(String aProperty) {
        this.aProperty = aProperty;
        return this;
    }

    public AModelBuilder setAnotherProperty(Integer anotherProperty) {
        this.anotherProperty = anotherProperty;
        return this;
    }

    public AModel build() {
        return new AModel(aProperty, anotherProperty);
    }
}
