package com.hurnyak_yaroslav;

import java.io.Serializable;
import java.util.ArrayList;

public class Ser implements Serializable {
    ArrayList<Car> list;

    Ser(ArrayList<Car> list) {
        this.list = list;
    }

    public ArrayList<Car> getList() {
        return list;
    }
}
