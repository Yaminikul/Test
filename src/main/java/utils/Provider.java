package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Provider {

    @org.testng.annotations.DataProvider(name = "users")
    public Object[][] createUser(){

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader("src/main/resources/input/user.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<List<String>> input = new ArrayList<>();
        String[] nextRecord;

        while (true) {
            List<String> temp = new ArrayList<>();
            try {
                if (!((nextRecord = csvReader.readNext()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            for (String cell : nextRecord) {
                temp.add(cell);
            }
            input.add(temp);
        }

        Object[][] obj = new Object[input.size()][input.get(input.size() - 1).size()];

        for (int i=0; i< input.size(); i++){
            for (int j=0; j<input.get(i).size(); j++){
                obj[i][j] = input.get(i).get(j);
            }
        }

        return obj;
    }
}
