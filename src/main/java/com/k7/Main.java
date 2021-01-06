package com.k7;


public class Main {
    public static void main(String[] args) {
        MyMap<String, Number> map = new MyMap<>();
        String string = "Я иду по парку, иду один и. вижу иду как! по воде иду я, пробегает луч солнца. ";
        Logic logic = new Logic();
        logic.wordCount(map, string);
    }


}

