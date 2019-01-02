package com.hurnyak_yaroslav;

import static com.hurnyak_yaroslav.Main.scan;
import static com.hurnyak_yaroslav.Main.taksopark;
import static com.hurnyak_yaroslav.OtherFunctions.fromTheFile;
import static com.hurnyak_yaroslav.OtherFunctions.getInfo;
import static com.hurnyak_yaroslav.OtherFunctions.toTheFile;

public class ConstantLoop {
    public static void loop(){
        while (true) {

            String answer = scan.nextLine();
//            System.out.println(
//                    "Введіть 1, якщо потрібно загрузити дані таксопарку;\n" +
//                            "Введіть 2, якщо потрібно додати автомобіль у таксопарк;\n" +
//                            "Введіть 3, якщо потрібно видалити автомобіль з таксопарку; \n" +
//                            "Введіть 4, якщо потрібно вивести автомобілі з потрібною швидкістю.\n" +
//                            "Введіть 5, якщо потрібно вивести всі автомобілі таксопарку;\n" +
//                            "Введіть 6, якщо потрібно відсортувати дані таксопарку;\n"+
//                            "Введіть 7, якщо бажаєте вийти."
//            );

            //    int N = scan.nextInt();
//            switch (N) {
//                case 1:
//                    FromTheFile();
//                    break;
//                case 2:
//                    Car car = new Car();
//                    car.add_new_car();
//                    taksopark.new_car(car);
//                    break;
//                case "delete":
//                    System.out.println("Введіть повну модель машини, яку хочете видалити з таксопарку: ");
//                    Scanner scan2 = new Scanner(System.in);
//                    String nameForRemove = scan2.nextLine();
//                    taksopark.RemoveCar(nameForRemove);
//                    break;
//                case 4:
//                    System.out.println("Введіть потрібну швидкість: ");
//                    Scanner scan3 = new Scanner(System.in);
//                    taksopark.get_cars_with_optimal_speed(taksopark.getList(),scan3.nextInt());
//                    taksopark.PrintSpeedList();
//                    break;
//                case 7:
//                    System.out.println("Введіть 1, якщо бажаєте зберегти зміни у таксопарку або 0, якщо не хочете цього робити:");
//                    int i = scan.nextInt();
//                    if (i == 1) {
//                        ToTheFile();
//                        return;
//                    } else return;
//
//                case 5:
//                    taksopark.get_all_cars();
//                    break;
//                case 6:
//                    taksopark.sort();
//                    break;
//                default:
//                    System.out.println("Неправильний ввід!");
//                    break;
//            }
            if (answer.matches("(?i)\\s*read\\s*")) {
                fromTheFile();
            } else if (answer.matches("addcar\\s+(?<name>\\w+)\\s+(?<breakdown>\\d+)\\s+(?<maxSpeed>\\d+)\\s+(?<cost>\\d+)\\s+(?<body>\\w+)")) {
                taksopark.newCar(answer);
            } else if (answer.matches("delete\\s+(?<id>\\d*)\\s*")) {
                taksopark.removeCar(answer);
            } else if (answer.matches("getfast\\s+(?<speed1>\\d+)\\s+(?<speed2>\\d*)")) {
                taksopark.getCarsWithOptimalSpeed(answer);
                taksopark.printSpeedList();

            } else if (answer.matches("(?i)\\s*getall\\s*")) {
                taksopark.getAllCars();

            }else if (answer.matches("(?i)\\s*getcost\\s*")) {
                System.out.println(taksopark.cost());
            }else if (answer.matches("(?i)\\s*sort\\s*")) {
                taksopark.sort1();
            }else if (answer.matches("(?i)\\s*sortr\\s*")) {
                taksopark.sort2();
            } else if (answer.matches("(?i)\\s*exit\\s*")){
                return;
            }else if (answer.matches("(?i)\\s*help\\s*")){
                getInfo();
            }else if (answer.matches("(?i)\\s*save\\s*")){
                toTheFile();
            }else{
                System.out.println("Wrong command!!!");
            }
        }
    }

}
