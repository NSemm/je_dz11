package com.k7;

public class Logic {


    public void wordCount(MyMap<String, Number> map, String string) {
        for (String s : getSplit(string)) {
            map.put(s.toLowerCase(), 0);
        }
        for (MyMap.Pair<String, Number> pair : map.pairSet()) {
            for (String s : getSplit(string)) {
                if (pair.getKey().equals(s.toLowerCase())) {
                    pair.setValue((int) pair.getValue() + 1);
                }
            }
            System.out.println(pair.getKey() + " ==> " + pair.getValue());
        }
    }

    private static String[] getSplit(String string) {
        return string.split("([,.!?])?(\\s)");
    }
}
