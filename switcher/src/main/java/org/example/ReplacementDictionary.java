package org.example;

import java.util.HashMap;
import java.util.Map;

public class ReplacementDictionary {
    private final Map<String, String> replacements = new HashMap<>();

    public ReplacementDictionary() {
        initializeReplacements();
    }

    private void initializeReplacements() {
        replacements.put("ключ1", "авто");
        replacements.put("ключ2", "мото");
        replacements.put("ключ3", "телефон");
        replacements.put("ключ4", "Москва");
        replacements.put("ключ5", "Ветер");
        replacements.put("ключ6", "замена6");
        replacements.put("ключ7", "Ахтунг");
        replacements.put("ключ8", "замена8");
        replacements.put("ключ9", "замена9");
        replacements.put("ключ10", "замена10");
        replacements.put("ключ99", "замена99");
        replacements.put("ключ100", "замена100");
    }

    public Map<String, String> getReplacements() {
        return replacements;
    }
}
