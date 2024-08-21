package com.frostfire.budgetapp.Service;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvService {
    private final String fileLoc;
    private List<Object> objList;
    private InputStream inputStream;
    public CsvService(String fileLoc){
        this.fileLoc = fileLoc;
    }

    public void createStream(){

    }
    public void getFileStream() throws FileNotFoundException {
        File file = new File(fileLoc);
        inputStream = new FileInputStream(file);
    }/*
    public <T> List<T> convertToObject(char delm,int numEnities,char endLine)
            throws IOException {
        List<T> tObjList = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)) {
            String line;

            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }


        ) }


        //tObjList.add(Arrays.stream(reader.readLine().split(",");

    }*/
}
