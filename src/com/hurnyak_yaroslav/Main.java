/*
Таксопарк. Визначити ієрархію легкових автомобілів. Створити таксопарк.
Підрахувати вартість автопарку. Здійснити сортування автомобілів парку за
витратою пального. Знайти автомобіль в компанії, що відповідає заданому
діапазону параметрів швидкості.
 */

/*
зробити менюшку, для роботи з програмою. створити вічний цикл для організації роботи. потрібно після роботи з програмою додати запис у файл
і зчитування з нього при запуску програми(перед тим запитати користувача)
 */


package com.hurnyak_yaroslav;


import java.util.Scanner;

public class Main {
   public static Taksopark taksopark = new Taksopark();
   static Scanner scan = new Scanner(System.in);

   public static void main(String[] args) throws Exception {
       System.out.println("Welcome to the program!!!\n");
      // ConstantLoop.loop();
       MyGraphics.draw();

   }
}




