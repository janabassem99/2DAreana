package com.example.battle_graphics;

public class Weapon {

    private String name;
    private int damage;
    private double projectileSpeed;
    private long cooldown;

    public Weapon(String name, int damage, double projectilespeed, Long cooldown){
        this.name=name;
        this.damage=damage;
        this.projectileSpeed=projectilespeed;
        this.cooldown=cooldown;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getProjectileSpeed() {
        return projectileSpeed;
    }

    public long getCooldown() {
        return cooldown;
    }
}