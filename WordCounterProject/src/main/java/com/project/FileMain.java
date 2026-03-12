package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class FileMain {
    @Autowired
    WordCounter wordCounter;

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();

        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("beans.xml");

        Str str = classPathXmlApplicationContext.getBean(Str.class);

        annotationConfigApplicationContext.scan("com.project");
        annotationConfigApplicationContext.refresh();

        FileMain fileMain = annotationConfigApplicationContext.getBean(FileMain.class);
        fileMain.wordCounter.setWord(str.getWord());
        Map<String , Integer> map = fileMain.wordCounter.resultOfWordCount();
        System.out.println(map);
    }
}
