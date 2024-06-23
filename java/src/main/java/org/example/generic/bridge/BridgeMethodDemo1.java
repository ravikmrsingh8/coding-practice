package org.example.generic.bridge;


import java.lang.reflect.Method;

interface UselessInterface<T> {

    public void print(T o);
}

class PurposelessClass implements UselessInterface<Integer> {

    @Override
    public void print(Integer t) {

    }

    // BRIDGE METHOD
    // Synthetic method inserted by compiler
    //public void print(Object t) {
    //    print((Integer)t); // <--- the method casts the received Object to Integer and calls the intended overridden method.
    //}
}


public class BridgeMethodDemo1 {
    public static void main( String args[] ) {
        for (Method m : PurposelessClass.class.getMethods())
            if (m.getName().equals("print"))
                System.out.println(m.toGenericString());
    }
}


