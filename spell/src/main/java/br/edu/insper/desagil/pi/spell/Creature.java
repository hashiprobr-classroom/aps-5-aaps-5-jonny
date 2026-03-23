package br.edu.insper.desagil.pi.spell;

import java.util.Map;

public class Creature extends ColorCard {
    private int power;
    private int health;
    private Player target;

    public Creature(String image, String description, int color, Map<Boolean, Integer> cost) {
        super(image, description, color, cost);
        this.power = 0;
        this.health = 0;
        this.target = null;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {return health;}

    public void bind(Player player) {
        if (target != null) {
            throw new IllegalStateException("already binded");
        }
        target = player;
    }

    public void addPower(int power) {
        this.power += clip(power);
    }

    public void addHealth(int health) {
        this.health += clip(health);
    }

    private int clip(int value) {
        if (value < 1) {
            return 1;
        }
        if (value > 10) {
            return 10;
        }
        return value;
    }
}
