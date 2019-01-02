package com.hurnyak_yaroslav;

import java.io.Serializable;
import java.util.Scanner;

public class Car implements Comparable <Car>, Serializable {
    private String name;
    private int breakdown;      // 1L / 100 km
    private int maxSpeed;
    private int cost;
    private CarType body;


    Car() {
        breakdown = maxSpeed = cost = 0;
    }

    Car(String n, int a, int b, int c, CarType d) {
        name = new String(n);
        breakdown = a;
        maxSpeed = b;
        cost = c;
        body = d;
    }
//    public void add_new_car(){
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Name: ");
//        this.name = scan.nextLine();
//
//        System.out.print("\nBreakdown: ");
//        int num = scan.nextInt();
//        this.breakdown=num;
//        System.out.println("\nMax Speed: ");
//        num = scan.nextInt();
//        this.maxSpeed = num;
//        System.out.println("\nCost: ");
//        num = scan.nextInt();
//        this.cost=num;

 //   }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", breakdown=" + breakdown +
                ", maxSpeed=" + maxSpeed +
                ", cost=" + cost +
                ", body=" + body +
                '}';
    }

    public int getCost() {
        return cost;
    }

//    public int getBreakdown() {
//        return breakdown;
//    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car obj) {
        return this.breakdown-obj.breakdown;
    }
}
