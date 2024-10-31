package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {
    private final ReplacementDictionary dictionary;

    public FileProcessor(ReplacementDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void processFile(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
             FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = replaceExactWords(line, dictionary.getReplacements());
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл " + outputFile + " успешно создан!");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке файла: " + e.getMessage());
        }
    }

    private String replaceExactWords(String text, Map<String, String> replacements) {
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            String regex = "\\b" + Pattern.quote(entry.getKey()) + "\\b";
            text = text.replaceAll(regex, Matcher.quoteReplacement(entry.getValue()));
        }
        return text;
    }
}
