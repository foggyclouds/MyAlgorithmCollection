package hackerrank.string;

import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer tests = reader.nextInt();
        for(Integer j=0;j<tests;j++) {
            //String str = "acxza";
            String str = reader.next();
            char[] a = str.toCharArray();
            Integer n = str.length();

            boolean funny = true;
            for (int i = 1; i < n; i++) {
                if (Math.abs(a[i - 1] - a[i]) != Math.abs(a[n - i] - a[n - i - 1])) {
                    //System.out.println(a[i-1]-a[i]);
                    funny = false;
                    break;
                }
            }

            System.out.println(funny?"Funny":"Not Funny");
        }
    }
}
