package tests.web.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ChooseClientCity {

    List<String> nameCities = new ArrayList<>();
    String nameCity;

    ClassLoader cl = ChooseClientCity.class.getClassLoader();

    public String getCityName() {
        try (InputStream is = cl.getResourceAsStream("test-data/city_name.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader((is), UTF_8))) {
            String stringNameCity;
            while ((stringNameCity = reader.readLine()) != null) {
                nameCities.add(stringNameCity);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        if (!nameCities.isEmpty()) {
            Random random = new Random();
            nameCity = nameCities.get(random.nextInt(nameCities.size()));
        } else {
            System.out.println("Файл пустой или не найден");
        }

        return nameCity;
    }
}
