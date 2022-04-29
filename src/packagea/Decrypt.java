package packagea;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Decrypt {
    public static String removePadFromString(String inputString) {
        StringBuilder sb = new StringBuilder();
        sb.append(inputString);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
                i--;
            }
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
        latters.put('J', 'b');
        latters.put('A', 'j');
        latters.put('Z', 'a');
        latters.put('B', 'z');
        latters.put('F', 'e');
        latters.put('G', 'f');
        latters.put('E', 'g');
        if(latters.get(x) == null)
        {
            return x;
        } else {
            return latters.get(x);
        }
    };
    public static List<Character> deCoding(List<Character> list) {
        return list.stream()
                .map(Decrypt::charSwap)
                .collect(Collectors.toList());
    }

    public static String listToString(List<Character> list) {
        String string = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return string;
    }
    public static List<Character> arrToList(char[] arr) {
        Character[] charArrBoxed = new String(arr).chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        List<Character> list = Arrays.asList(charArrBoxed);
        return list;
    }
    public static String Decrypt(String s){
        return removePadFromString(listToString(deCoding(arrToList(splitString((s)).toCharArray())))).toLowerCase();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Upisi : ");
        String s = input.nextLine();
        System.out.println(removePadFromString(listToString(deCoding(arrToList(splitString((s)).toCharArray())))).toLowerCase());
    }
}