package tests.web.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChooseClientCity {

    List<String> nameCities = new ArrayList<String>();
    String nameCity;

    public String getCityName () {
        try(BufferedReader reader = new BufferedReader(new FileReader("test-data/city_name.txt"))) {
            String stringNameCity;
            while ((stringNameCity = reader.readLine()) != null) {
                nameCities.add(stringNameCity);
            }
        } catch (IOException e) {
                System.err.println("Ошибка чтения файла: " + e.getMessage());
        };

        if (!nameCities.isEmpty()) {
            Random random = new Random();
            nameCity = nameCities.get(random.nextInt(nameCities.size()));
        } else {
            System.out.println("Файл пустой или не найден");
        }

        return nameCity;
    }
}
