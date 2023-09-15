package com.nguyenninh.letterfrequency.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Separation {
    private String text;

    public Separation(String text) {
        this.text = text;
    }

    private void checkInput() {
        File file = new File(text);
        if (file.isFile()) {
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    text += sc.nextLine();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Map<Character, Integer> separa() {
        Map<Character, Integer> map = new HashMap<>();
        checkInput();
        for (int i = 0; i < text.length(); i++) {
            if (" ".equals(text.charAt(i)+"") || "\n".equals(text.charAt(i)+"")) continue;
            map.compute(text.charAt(i), (key, oldValue) -> (oldValue == null) ? 1 : oldValue + 1);
        }
        return map;
    }

    public List<Entity> converList(Map<Character, Integer> mapChar) {
        List<Entity> dataList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : mapChar.entrySet()) {
            dataList.add(new Entity(entry.getKey(), entry.getValue()));
        }
        return dataList;
    }

}
