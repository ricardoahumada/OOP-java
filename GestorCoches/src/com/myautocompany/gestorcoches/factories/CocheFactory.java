package com.myautocompany.gestorcoches.factories;

import com.myautocompany.gestorcoches.modelos.*;
import es.netmind.gestorcoches.modelos.*;

import java.util.HashMap;

public class CocheFactory {

    public static ICoche crear(String tipo, HashMap<String, Object> params) {

        if (tipo.equals("deportivo"))
            return new Deportivo((String) params.get("marca"), (String) params.get("tipo"), (Integer) params.get("velocidad"), (Boolean) params.get("turbo"));

        else if (tipo.equals("suv"))
            return new SUV((String) params.get("marca"), (String) params.get("tipo"), (Integer) params.get("velocidad"), (Integer) params.get("cambios"));

        else if (tipo.equals("familiar"))
            return new Familiar((String) params.get("marca"), (String) params.get("tipo"), (Integer) params.get("velocidad"), (Integer) params.get("asientos"));

        else if (tipo.equals("limo"))
            return new Limusina((String) params.get("marca"), (String) params.get("tipo"), (Integer) params.get("velocidad"), (Integer) params.get("ejes"));

        else return null;

    }

}
