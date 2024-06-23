package org.example.basics;


public class Initialization {
    class SpecialPerson {


        String fullName = init();
        String name = "batman"; 

        public SpecialPerson() {
            System.out.println("Constructor Called");
            name = "superMan";
        }

        private String init() {
            System.out.println("Init called");
            System.out.println("Name " + name);
            return name;
        }

        public void print() {
            System.out.println(fullName);
        }
    }

        public static void main(String[] args) {
            SpecialPerson person = new Initialization().new SpecialPerson();
            person.print();
        }
}
