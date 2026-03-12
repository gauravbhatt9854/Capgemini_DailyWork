package com.project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class FileConfigs {

    @Bean
    File getCurrDir()
    {
        return  new File("");
    }
}
