package com.cats;

import java.util.List;

public class CatService {

    public static String concatCats(List<Cat> cats) {
        String acum = "";

        for (Cat cat : cats) {
            acum = acum.concat(cat.getName()).concat(":");
        }

        return acum;
    }

}
