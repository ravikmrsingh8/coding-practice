package org.example.org.example.quiz.gotcha;

/***
 * static methods are inherited in Java, but they are not overridden.
 * Subclasses have access to static methods from their superclass,
 * but redeclaring a static method with the same signature in the subclass creates a new method that hides the superclass method.
 */


class Language {

    static String lang = "base language";

    static protected void printLanguage() {
        System.out.println(lang);
    }

    protected Language sayHello() {
        System.out.println("----");
        return this;
    }
}

class Spanish extends Language {

    static String lang = "Spanish";

    //static protected void printLanguage() {
    //    System.out.println(lang);
    //}

    protected Language sayHello() {
        System.out.println("Ola!");
        return this;
    }
}

public class InheritenceGotcha {
    public static void main(String[] args) {
        Spanish.printLanguage();
    }
}
