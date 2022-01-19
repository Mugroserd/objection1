package com.company;

import java.util.Random;

public class Toy {
    public String name;
    public int durability;
    public boolean isBroken; // Сломана ли игрушка
    public int playTime; // Время, которое Дуся будет играть с игрушкой (за один раз)

    private final Random r = new Random();

    public Toy(String newName, int newDurability) {
        this.name = newName;
        this.durability = newDurability;
        this.isBroken = false;
        this.playTime = r.nextInt(10);
    }

    public void play() {
        System.out.println("Дуся играет с игрушкой " + playTime + " минут.");
        if (durability > playTime) {
            durability = durability - playTime;
        }
        else {
            durability = 0;
            isBroken = true;
        }
    }
}
