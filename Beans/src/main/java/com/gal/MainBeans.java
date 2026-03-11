package com.gal;

import com.gal.algo.MyCalc;
import com.gal.algo.PasswordHasher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

public class MainBeans {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.gal");
        System.out.println("next command will create beans");
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