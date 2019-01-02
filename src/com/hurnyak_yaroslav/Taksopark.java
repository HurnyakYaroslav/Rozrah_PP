package com.hurnyak_yaroslav;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Taksopark implements Serializable {

    private ArrayList<Car> list;
    private ArrayList<Car> cars_with_optimal_speed; //просто вивести списком потрібні автомобілі

    Taksopark() {
        list = new ArrayList<Car>();
        cars_with_optimal_speed = new ArrayList<Car>();
    }

    Taksopark(ArrayList<Car> list1) {
        this.setList(list1);

    }


    public void newCar(String answer) {
        String REGEX = "addcar\\s+(?<name>\\w+)\\s+(?<breakdown>\\d+)\\s+(?<maxSpeed>\\d+)\\s+(?<cost>\\d+)\\s+(?<body>\\w+)";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(answer);
        String name = null;
        CarType d=null;
        Integer a = null, b = null, c = null;

        if (matcher.find()) {
            name = matcher.group("name");
            a = Integer.parseInt(matcher.group("breakdown"));
            b = Integer.parseInt(matcher.group("maxSpeed"));
            c = Integer.parseInt(matcher.group("cost"));
            d = CarType.valueOf(matcher.group("body"));
        }
        Car e = new Car(name, a, b, c, d);
        list.add(e);
    }


    public int cost() {
        int S = 0;
        for (int i = 0; i < list.size(); i++) {
            S += list.get(i).getCost();
        }
        return S;
    }

    public void sort1() {

        list.sort(Car::compareTo);

    }

    public void sort2() {

        list.sort(Car::compareTo);
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            final Car tmp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, tmp);
        }
    }

    public void getCarsWithOptimalSpeed(String answer) {
        String REGEX = "getfast\\s+(?<speed1>\\d+)\\s+(?<speed2>\\d*)";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(answer);

        int speed1 = 0, speed2 = 0;
        if (matcher.find()) {
            speed1 = Integer.parseInt(matcher.group("speed1"));
            speed2 = Integer.parseInt(matcher.group("speed2"));
        }

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getMaxSpeed() > speed1 && list.get(j).getMaxSpeed() < speed2) {
                cars_with_optimal_speed.add(list.get(j));
            }
        }
    }

    public void setList(ArrayList<Car> list) {
        this.list = list;
    }

    public ArrayList<Car> getList() {
        return list;
    }

    public ArrayList<Car> getSpeedList() {
        return cars_with_optimal_speed;

    }

    public void printSpeedList() {
        for (int j = 0; j < cars_with_optimal_speed.size(); j++) {
            System.out.println(cars_with_optimal_speed.get(j) + "\n");
        }
    }

    public void getAllCars() {
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j) + "\tid = " + j + "\n");
        }
    }

    public int removeCar(String answer) {
        int id = -1;
        String REGEX = "delete\\s+(?<id>\\d*)\\s*";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(answer);
        if (matcher.find()) {
            id = Integer.parseInt(matcher.group("id"));
        }
//       ListIterator<Car> li =  list.listIterator();
//        while(li.hasNext()){
//            if(name.equals(li.previous().getName())){
//                li.hasPrevious();
//                li.remove();
//                return 1;
//            }
//
//        }
//        for (int j = 0; j < list.size(); j++) {
//            if (list.get(j).getName().equals(name)) list.remove(j);
//        }
        list.remove(id);
        return 0;
    }
}
