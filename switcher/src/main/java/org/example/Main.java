package org.example;

public class Main {
    public static void main(String[] args) {

        //Нужно указать абсолютный путь, скорее всего можно поменять, не стал заморачиваться
        String inputFile = "C:\\projects\\switcher\\src\\main\\resources\\input.scd";
        String outputFile = "C:\\projects\\switcher\\src\\main\\resources\\output.cid";

        ReplacementDictionary dictionary = new ReplacementDictionary();
        FileProcessor processor = new FileProcessor(dictionary);
        processor.processFile(inputFile, outputFile);
    }
}