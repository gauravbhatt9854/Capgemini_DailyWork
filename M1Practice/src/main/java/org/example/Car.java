package org.example;

import com.exception.UserDefinedCompileTimeException;
import com.exception.UserDefinedRuntimeException;

public class Car {

    static void method1()
    {
        boolean a = true;
        if(a) throw new UserDefinedRuntimeException("i m run time exception");
        else System.out.println("i am method1 ");
    }

    static void method2() throws Exception
    {
        boolean a = true;
        if(a) throw new UserDefinedCompileTimeException("i m run compile time exception");
        else System.out.println("i am method2");
    }


    public static void main(String[] args) throws Exception {

//        method1();
        method2();
    }
}
