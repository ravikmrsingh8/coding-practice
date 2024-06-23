package org.example.basics;



interface IFoo {
    static void bar() {
        System.out.println("IFoo");
    }
}

class CFoo implements IFoo {
    static void bar() {
        System.out.println("CFoo");
    }
}

public class InterfaceWithStaticMethod {

    public static void main(String[] args) {
        System.out.println("Hello World");
        IFoo foo = new CFoo();
        IFoo.bar();

        //foo.bar() compiler error
    }

}

