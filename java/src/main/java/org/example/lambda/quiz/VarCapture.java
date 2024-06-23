package org.example.lambda.quiz;





interface Work {
    void work();
}

class LambdaVariableCapture {

    private static String staticVar = "static variable";
    private String instVar = "instance variable";

    public Work captureVariables() {

        int i = 0;
        Work w = () -> {
            // int i; declaring i would result in compile error.

            String instVar = "lambda variable";
            System.out.println("i = " + i);
            System.out.println(staticVar);
            System.out.println(this.instVar);
            System.out.println(instVar);

            // Let's check what is this pointing to
            System.out.println(this.getClass());
        };

        staticVar = "changed static var";
        instVar = "changed instance var";

        return w;
    }
}


public class VarCapture {
    public static void main( String args[] ) {
        Work w = (new LambdaVariableCapture()).captureVariables();
        w.work();
    }
}
