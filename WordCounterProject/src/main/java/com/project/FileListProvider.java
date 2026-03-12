package com.project;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
public class FileListProvider {
    public List<String> getAllFiles() {
        File file = new File("src/main/java/com/project");
        File[] files = file.listFiles();
        return  Arrays.stream(files).map(x-> x.getAbsolutePath())
                .filter(x-> x.endsWith(".txt")).peek(x-> System.out.println()).toList();
    }
}
