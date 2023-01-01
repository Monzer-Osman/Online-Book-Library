package com.BookStore.bookstore.utils;
import com.BookStore.bookstore.Models.Author;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class readDataFromFile {

    public void readDataFromCsvFile(){
        String fileName = "C:\\Users\\Monzer Osman\\Documents\\coding\\java\\SpringBoot\\bookstore\\bookstore\\src\\main\\java\\com\\BookStore\\bookstore\\ExtrnalData\\authors_data.csv";
        BufferedReader reader = null;
        Author author;
        String line;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){
                if(line.indexOf(',') != -1) {
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
