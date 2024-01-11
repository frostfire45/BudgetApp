package com.frostfire.budgetapp.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;

public class CsvService {
    private final String fileLoc;
    private List<Object> objList;

    public CsvService(String fileLoc){
        this.fileLoc = fileLoc;
    }

    public void convertToObject(char delm,int numEnities,char endLine) {
        try {
            FileInputStream fs = new FileInputStream(fileLoc);

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
