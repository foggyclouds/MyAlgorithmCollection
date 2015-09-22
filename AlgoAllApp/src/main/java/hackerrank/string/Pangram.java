package hackerrank.string;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by RoySh on 9/22/2015.
 */
public class Pangram {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        //String s = "The quick brown fox jumps over the lazy dog";
        char c[] = s.toCharArray();
        Map<Character,Boolean> m = new HashMap<>();

        for(int i =0;i<c.length;i++) {
            if(Character.isLetter(c[i]))
                m.put(Character.toLowerCase(c[i]),true);
        }

        //System.out.println(m.keySet().size());

        if(m.keySet().size()==26)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}
