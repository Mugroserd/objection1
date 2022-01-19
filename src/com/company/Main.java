package com.company;

import java.util.Random;
import java.util.Scanner;
//
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Введите количество игрушек которое хотите добавить: ");
        int toysAmount = in.nextInt();
        Toy[] toysArray = new Toy[toysAmount];

        for(int i = 0; i<toysAmount; i++){
            System.out.println("Введите имя игрушки и её прочность: ");
            toysArray[i] = new Toy(in.next(),in.nextInt()); // Место для ввода имени и прочности игрушки
        }

        for(int i = 0; i < 5; i++) {
            int sumTime = 0; // Переменная для суммы времени игры
            // Место для одной игровой сессии Дуси
            for (int a = 0; a < r.nextInt(toysAmount) + 1; a++) {
                Toy tempToy = toysArray[r.nextInt(toysAmount)];
                while (tempToy.isBroken){
                    System.out.println("Дуся попробовала поиграть с игрушкой \"" + tempToy.name + "\", но она уже сломана.");
                    if(areAllToysBroken(toysArray)){
                        System.out.println("Дуся..");
                        System.exit(0);
                    }
                    tempToy = toysArray[r.nextInt(toysAmount)];
                }
                System.out.println("Игра в процессбе...жертва: " + tempToy.name);
                tempToy.play();
                sumTime += tempToy.playTime;
            }
            System.out.println("Шшш, Дуся отдыхает, она поиграла " + sumTime + " минут...");
        }

        for (Toy ttoy:toysArray)
            if (ttoy.isBroken)
                System.out.println("Пала в нечестном бою: \"" + ttoy.name + "\"");
    }

    public static boolean areAllToysBroken(Toy[] toysArray) {
        int brokenToys = 0;
        for (Toy gtoy:toysArray)
            if(gtoy.isBroken) brokenToys++;
        return toysArray.length == brokenToys;
    }
}
