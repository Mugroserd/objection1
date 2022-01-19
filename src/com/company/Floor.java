package com.company;

import java.util.Random;

public class Floor {
    private Toy[] toysArray;
    public int toysAmt;

    public Floor(Toy[] toysArray) {
        this.toysArray = toysArray;
        toysAmt = toysArray.length;
    }

    public void session(int a){
        Random r = new Random();

        for(int i = 0; i < a; i++) {
            int sumTime = 0; // Переменная для суммы времени игры
            // Место для одной игровой сессии Дуси
            for (int b = 0; b < r.nextInt(toysAmt) + 1; b++) {
                Toy tempToy = toysArray[r.nextInt(toysAmt)];
                while (tempToy.isBroken){
                    System.out.println("Дуся попробовала поиграть с игрушкой \"" + tempToy.name + "\", но она уже сломана.");
                    if(areAllToysBroken(toysArray)){
                        System.out.println("Дуся..");
                        System.exit(0);
                    }
                    tempToy = toysArray[r.nextInt(toysAmt)];
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
