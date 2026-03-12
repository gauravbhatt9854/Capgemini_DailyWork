package com.gal.xml;

import jakarta.annotation.PostConstruct;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Xml {
    String filename;
    int randomNum;

    public Xml()
    {

    }

    public Xml(String filename , int randomNum)
    {
        this.filename = filename;
        this.randomNum =randomNum;
        System.out.printf("xml constructor running");
    }

    @PostConstruct
    public void postConstructor()
    {
        System.out.println("this is post constructor of xml file");
    }


    public static void main(String[] args) {

        ClassPathXmlApplicationContext
                classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("beans.xml");


    }
}
