package org.prog.excpetions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    private final static boolean errorIsPresent = true;

    //TODO: run this, debug this, play with this

    public static void main(String[] args) {
        try {
            readFile_1();
        } catch (RuntimeException runtimeException){
            System.out.println("Runtime happens");
        }
        System.out.println("this is post error");
    }

    public static void readFile_1() {
        try {
            readFile_2();
        } catch (Throwable e) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(e);
        } finally {
            System.out.println("this block will always work!");
        }
    }

    public static void readFile_2() throws FileNotFoundException {
        readFile_3();
    }

    public static void readFile_3() throws FileNotFoundException {
        if (errorIsPresent) {
            FileReader fileReader = new FileReader("users.xls");
        } else {
            System.out.println("no error occurs");
        }
    }

    private static void runtimeError() {
        throw new RuntimeException("Exception message");
    }
}
