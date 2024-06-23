package org.example.org.example.quiz;

public class InterfaceAndDefaultMethod1 {
    public static void main(String[] args) {
        Bilingual1 b = new Bilingual1();
        b.converse();
    }
}

class Persian {

    protected void whatsUp() {
        System.out.println("che khabar?");
    }
}

interface AlienLanguage {

    default void whatsup(){
        System.out.println("yada yadda, more yadda yaddda");
    }
}

class Bilingual1 extends Persian implements AlienLanguage {

    public void converse() {
        whatsUp();
    }

}