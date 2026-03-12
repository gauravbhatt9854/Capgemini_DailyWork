package com.gal;

import com.gal.algo.MyCalc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainBeans {
    public static void main(String[] args) {

//        this line create and empty contaier also called ioc conatainer -> inversion of control ->
//        manual object creation to spring creating and managing object

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        scan inside com.gal and all subpackagees of it so find  all the beans ->
//        identify annotations like component , service etc

        context.scan("com.gal");
        System.out.println("next command will create beans");

//        it refresh the container , Inject the dependency where asked or required
        context.refresh();
        System.out.println("beans are created");

//        PasswordHasher bean = context.getBean(PasswordHasher.class);
//        PasswordHasher bean2 = context.getBean(PasswordHasher.class);
//
//        System.out.println(bean);
//        System.out.println(bean2);
//
//        System.out.println( bean.hash("hello"));
//        Object bean5 =  context.getBean("getCalc");
//        Object bean6 =  context.getBean("myCalc");

        Object bean10 = context.getBean(MyCalc.class);
        System.out.println(bean10);

        Object bean12 =context.getBean("calcBean1");
        System.out.println(bean12);


        Object bean13 =context.getBean("calcBean2");
        System.out.println(bean13);


        Object bean11 = context.getBean("beanStr");
        System.out.println(bean11);


        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);


        
    }
}