package com.karan.rain.graphics.entity;

import com.karan.rain.graphics.entity.mob.projectile.particle.Particle;
import com.karan.rain.level.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 1/14/2016.
 */
public class Spawner extends Entity{

    public enum Type {
        MOB, PARTICLE;
    }

    private Type type;

    public Spawner(int x,int y,Type type,int amount,Level level) {
        init(level);
        this.x = x;
        this.y = y;
        this.type = type;
        for(int i=0;i< amount;i++) {
            if(type == Type.PARTICLE) {
                level.add(new Particle(x,y,50));
            }
        }
    }
}
