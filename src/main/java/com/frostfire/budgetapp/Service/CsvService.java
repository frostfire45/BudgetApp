package com.frostfire.budgetapp.Service;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CsvService {

    private String fileLoc;
    private List<Object> objList;
    private InputStream inputStream;
    private List<Field> fieldList;

    public CsvService(InputStream inputStream){
        this.inputStream = inputStream;
    }
    public CsvService(String fileLoc){
        this.fileLoc = fileLoc;
    }

    public void getFileStream() throws FileNotFoundException {
        File file = new File(fileLoc);
        inputStream = new FileInputStream(file);

    }
}
