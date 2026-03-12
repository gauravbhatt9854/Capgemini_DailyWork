package com.gal.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserMain {

    @Autowired
    UserVerifier userVerifier;

//    public UserMain(UserVerifier userVerifier)
//    {
//        this.userVerifier = userVerifier;
//    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext
                annotationConfigApplicationContext  =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.gal");
        annotationConfigApplicationContext.refresh();

        UserMain userMain = annotationConfigApplicationContext.getBean(UserMain.class);
        userMain.userVerifier.verifyUser();
    }
}