package org.example.basics;

public class LocalClassDemo {
    int outerClassVal = 10;
    public static void main(String[] args) {
        LocalClassDemo demo = new LocalClassDemo();
        demo.someMethod();
        System.out.println(demo.outerClassVal);
    }


    public void someMethod() {

        String name = "mainClass";

        // Declare our local class
        class LocalClass {
            String myName = "superFineLocalClass";

            public LocalClass(String name) {
                this.myName = name;
            }

            public void print() {
                System.out.println("My name is " + myName + " and I am enclosed by " + name);
                System.out.println("Outerclass var" + outerClassVal);

                //name = "Boo!"; Not compile as it needs to be final or effectively final
                outerClassVal = 20;
                System.out.println("OuterclassVar "+ outerClassVal);
            }
        }


        LocalClass lc1 = new LocalClass("test");
        LocalClass lc2 = new LocalClass("rest");

        lc1.print();
        lc2.print();
        outerClassVal = 30;

    }


}
