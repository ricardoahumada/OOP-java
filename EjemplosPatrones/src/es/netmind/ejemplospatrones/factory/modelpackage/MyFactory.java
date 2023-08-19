package es.netmind.ejemplospatrones.factory.modelpackage;

import java.util.HashMap;

public class MyFactory {

    public static IModel create(String type, HashMap params) throws Exception {
        switch (type) {
            case "amodel":
                String prop1 = (String) params.get("aProperty");
                Integer prop2 = (Integer) params.get("anotherProperty");
                return new AModel(prop1, prop2);
            case "anothermodel":
                Boolean firstProp = (Boolean) params.get("firstProperty");
                String secondProp = (String) params.get("secondProperty");
                return new AnotherModel(firstProp, secondProp);
            default:
                return null;
        }
    }

}
