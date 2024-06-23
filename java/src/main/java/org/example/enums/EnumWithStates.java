package org.example.enums;



enum SuperHero {

    SuperMan(20, 80) {
        String superPower() {
            return "Fly";
        }
    },
    IronMan(30, 75) {
        String superPower() {
            return "Technology";
        }
    },
    Hulk(28, 200) {
        String superPower() {
            return "Strength";
        }
    };

    final int age;
    final double weight;

    abstract String superPower();

    SuperHero(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }


    public double getWeight() {
        return weight;
    }

}
public class EnumWithStates {
    public static void main(String[] args) {
        SuperHero hero = SuperHero.Hulk;
        System.out.println(hero);
        System.out.println("Hulk Weight " + hero.getWeight());
        System.out.println(hero.superPower());
    }
}
