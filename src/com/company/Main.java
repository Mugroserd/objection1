package com.company;

import java.util.Random;
import java.util.Scanner;
//
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество игрушек которое хотите добавить: ");
        int toysAmount = in.nextInt();
        Toy[] toysArray = new Toy[toysAmount];

        for (int i = 0; i < toysAmount; i++) {
            System.out.println("Введите имя игрушки и её прочность: ");
            toysArray[i] = new Toy(in.next(), in.nextInt()); // Место для ввода имени и прочности игрушки
        }
        Floor flo = new Floor(toysArray);
        flo.session(4);
    }
}
