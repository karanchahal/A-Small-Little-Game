package com.karan.rain.graphics.entity.spawner;

import com.karan.rain.graphics.entity.mob.projectile.particle.Particle;
import com.karan.rain.level.Level;

/**
 * Created by Lenovo on 1/15/2016.
 */
public class ParticleSpawner extends Spawner {

    private int life;

    public ParticleSpawner(int x, int y, int life, int amount, Level level) {
        super(x, y, Type.PARTICLE, amount, level);
        this.life = life;
        for(int i=0;i< amount;i++) {
            level.add(new Particle(x,y,life));
        }
    }
}
