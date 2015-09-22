package hackerrank.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by RoySh on 9/13/2015.
 */
public class FibModified {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer a = reader.nextInt();
        Integer b = reader.nextInt();
        Integer n = reader.nextInt();

        HashMap<Integer,BigInteger> memo = new HashMap<>();
        memo.put(1, new BigInteger(a.toString()));
        memo.put(2, new BigInteger(b.toString()));
        for(int i=3;i<(n+1);i++) {
            BigInteger t1 = memo.get(i - 1);
            BigInteger t2 = memo.get(i - 2);
            memo.put(i, t1.multiply(t1).add(t2));
        }

        System.out.println(memo.get(n).toString());

    }
}
