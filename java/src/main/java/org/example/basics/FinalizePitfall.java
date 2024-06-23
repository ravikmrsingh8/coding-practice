package org.example.basics;

import java.util.ArrayList;
import java.util.List;

public class FinalizePitfall {
    public static void main(String[] args) throws Exception {
        int count = 0;
        List<SuperHero> heros= new ArrayList<>();

        for(int i=0; i<1_000; i++) {
            SuperHero hero = new SuperHero(heros);
            count++;
        }
        Runtime.getRuntime().gc();
        Thread.sleep(5000);

        System.out.println(heros.size());

    }


    static class SuperHero {
        List<SuperHero> immortals;

        SuperHero(List<SuperHero> immortals) {
            this.immortals = immortals;
        }

        @Override
        public void finalize() {
            //System.out.println("finalize called");
            this.immortals.add(this);
        }
    }

}
