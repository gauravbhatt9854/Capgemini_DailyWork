package com.gal.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserVerifier {


//    injection by type of class
//    @Autowired
//    OtpGenerator otpGenerator;


//    these 2 are injection by name
    @Autowired
    OtpGenerator fourDigitOtpGenerator;

    @Autowired
    OtpGenerator sixDigitOtpGenerator;


//    UserVerifier(OtpGenerator otpGenerator)
//    {
//        this.otpGenerator = otpGenerator;
//    }

    public void verifyUser()
    {
        String otp = fourDigitOtpGenerator.getOtp();
        if(otp!=null) System.out.printf("user verified :  " + otp);
        else System.out.printf("verification failed");

//        System.out.println(otpGenerator);
        System.out.println(fourDigitOtpGenerator);
        System.out.println(sixDigitOtpGenerator);
    }

}
