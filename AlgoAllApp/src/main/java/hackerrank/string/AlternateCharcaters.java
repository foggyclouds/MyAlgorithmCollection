package hackerrank.string;

import java.util.Scanner;

public class AlternateCharcaters {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer tests = Integer.parseInt(reader.nextLine());
        for(Integer t=0;t<tests;t++) {
            String s = reader.nextLine();
            char c[] = s.toCharArray();
            Integer d = 0;
            for (Integer i = 1; i < c.length; i++) {
                if (c[i-1] == c[i])
                    d++;
            }

            System.out.println(d);
        }
    }
}
