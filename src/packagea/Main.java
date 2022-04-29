package packagea;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static String padToString(String inputString) {
        int reminder = inputString.length() % 8;
        int res = 8 - reminder;
        if (inputString.length() % 8 == 0) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(inputString);
        int lengthNeeded = inputString.length() + res;
        while (sb.length() < lengthNeeded) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static String splitString(String s){
        StringBuilder sb = new StringBuilder();
        int beginIndex = 0;
        for(int i = 1; i <= s.length(); i++){
            if(i % 8 == 0){
                sb.append(swapString(s.substring(beginIndex,i)));
                beginIndex = i;
            }
        }
        return sb.toString();
    }
    public static String swapString(String s){
        String s2 = "";
        String s3 = "";
        if(s.length() % 2 == 0){
            int mid = s.length() / 2;
            s2 = s.substring(0,mid);
            s3 = s.substring(mid,8);
        }
        return s = s3 + s2;

    }
    public static Character charSwap(Character x){
        // Secret
        HashMap<Character, Character> latters = new HashMap<Character, Character>();
        latters.put('b', 'j');
        latters.put('j', 'a');
        latters.put('a', 'z');
        latters.put('z', 'b');
        latters.put('e', 'f');
        latters.put('f', 'g');
        latters.put('g', 'e');

        if(latters.get(x) == null)
        {
            return x;
        } else {
            return latters.get(x);
        }
    };
    public static List<Character> encoding(List<Character> list) {
        return list.stream()
                .map(Main::charSwap)
                .collect(Collectors.toList());
    }

    public static String listToString(List<Character> list) {
        String string = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return string;
    }

    /*public static String listToStringForLoop(List<Character> list) {
       String s = "";
       for(int i = 0; i < list.toArray().length; i++) {
           s += list.get(i).toString();
       }
       return s;
    }*/

    public static List<Character> arrToList(char[] arr) {
        Character[] charArrBoxed = new String(arr).chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        List<Character> list = Arrays.asList(charArrBoxed);
        return list;
    }
    public static String encodingAll(String s){
       return listToString(
                encoding(
                        arrToList(
                                splitString(
                                        padToString(s)).toCharArray()))).toUpperCase();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type message here : ");
        String s = input.nextLine();
        System.out.println(encodingAll(s));
    }

}

