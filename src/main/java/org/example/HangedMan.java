package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangedMan {
    private final List<String> words = List.of("ziemia" , "kręgosłup" , "butelka" , "książka" , "komputer" , "prosta");
    private String word;
    private char[] userWord;
    private int lives = 3;


    void play(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        char letter;

        word = words.get(random.nextInt(words.size()));
        userWord = new char[word.length()];
        Arrays.fill(userWord , '_');

        System.out.println("Witaj w grze \"Wisielec\"! ");

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Liczba żyć: " + lives);
            System.out.println("Proszę podać literę: ");

            letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
        }

        if (lives == 0){
            System.out.println("Nie udało się! Słowem do odgadnięcia było: " + word);
        } else {
            System.out.println("Gratulacje! Odgatnięte słowo to: " + word);
        }

        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter){
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter){
            System.out.println("Nie ma takiej litery!");
            lives--;
        }
    }

    private boolean gameEnded(){
        return lives == 0 || word.equals(String.valueOf(userWord));
    }

}
