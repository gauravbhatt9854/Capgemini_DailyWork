package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Component
public class WordCounter {

    @Autowired
    FileListProvider fileListProvider;
    String word;

    public WordCounter()
    {

    };

    public WordCounter(String word)
    {
        this.word = word;
    }

    @Autowired
    File file;

    public void setWord(String word)
    {
        this.word = word;
    }

    int getCountOfWordInFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";

        int count = 0;

        while((str = bufferedReader.readLine())!=null){
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            while(stringTokenizer.hasMoreTokens())
            {
                String strTemp = stringTokenizer.nextToken();
                if(strTemp.equals(word)) count++;
            }
        }

        bufferedReader.close();

        return count;
    }

    Map<String , Integer> resultOfWordCount() throws IOException {
        Map<String , Integer> map = new HashMap<>();
        List<String> listOfFiles = fileListProvider.getAllFiles();

        for(String path : listOfFiles)
        {
            int value = getCountOfWordInFile(path);
            map.put(path.replace(file.getAbsolutePath()+"\\src\\main\\java\\com\\project\\" , "") , value);
        }
        return map;
    }
}
