package anagram;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataLoader implements ServletContextListener {

    static final List<String> WORDS = new ArrayList<>();
    static int numberOfWords = 0;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            InputStream inputStream = DataLoader.class.getResourceAsStream("/english_words.txt");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                WORDS.add(line);
                numberOfWords++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(numberOfWords);
    }

    public static boolean isValidWord(String input) {
        return WORDS.contains(input);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("The Liberty server has stopped.");
    }

    public void contextInitialized() {
        try{
            InputStream inputStream = DataLoader.class.getResourceAsStream("/english_words.txt");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                WORDS.add(line);
                numberOfWords++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}