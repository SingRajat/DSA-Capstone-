import java.util.*;

public class Anagram {
    public static boolean TwoStringAnagram(String s, String t){
        if(s.length()!=t.length())return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
    public static void main(String[] args) {
        String s = "silent";
        String t = "listen";
        System.out.println(TwoStringAnagram(s,t));
    }
}