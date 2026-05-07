package com.laiszig;

import java.util.Scanner;

public class Main {

    static void main() {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter sentence or word: ");
        String characters = reader.nextLine().toLowerCase().trim().replaceAll("\\s+", "");

        char[] chars = new char[characters.length()];
        for (int i = 0; i < characters.length(); i++) {
            chars[i] = characters.charAt(i);
        }
        System.out.println(chars);

        boolean isEqual = true;

        int first = 0;
        int last = chars.length - 1;

        while (isEqual) {
            if (first >= last) {
                break;
            }

            isEqual = chars[first] == chars[last];
            first++;
            last--;
        }
        System.out.println(isEqual);
    }
}


//        List<Character> charList = new ArrayList<>();
//        for (int i = 0; i < characters.length(); i++) {
//            charList.add(characters.charAt(i));
//        }
//        System.out.println(charList);

//        boolean isEqual = true;
//
//        while (isEqual) {
//            if (charList.size() == 1){
//                break;
//            }
//
//            isEqual = charList.getFirst() == charList.getLast();
//            if (isEqual) {
//                charList.removeFirst();
//                charList.removeLast();
//            }
//
//        }
//        System.out.println(isEqual);