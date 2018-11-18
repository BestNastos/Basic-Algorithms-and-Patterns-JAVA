package ForGit;

import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;

public class MultiplicationException extends ArithmeticException {

    public MultiplicationException() throws IOException{
        super("MultiplicationException in this context is not allowed");
    }

    public void method()throws IOException{}

    @Override
    public String toString() {
        return "MyException to string";
    }
}

class A extends MultiplicationException {

    public A()throws Exception{
    }

    @Override
    public void method()throws EOFException {}
}
