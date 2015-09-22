package hackerrank.dp.SamSubstring;

import java.util.Scanner;

public class SamSubstring2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String val = reader.next();
        char[] c = val.toCharArray();
        //Integer a[] = {1,6,7,8};
        Integer n = c.length;
        Integer a[] = new Integer[n];
        for(Integer i=0;i<n;i++) {
            a[i] = Character.getNumericValue(new Character(c[i]));
            System.out.println(a[i]);
        }

        System.out.println("n="+n);
        Double dp[] = new Double[n];
        dp[n-1]=new Double(a[n-1]);
        System.out.println("i="+(n-1)+","+dp[n-1]);

        Double suff[] = new Double[n];
        suff[0]=1d;
        for(Integer i=1;i<n;i++) {
            suff[i]=suff[i-1]+Math.pow(10,i);
            System.out.println("suff-"+suff[i]);
        }

        for(Integer i=n-2;i>-1;i--) {
            if(i==n-2)
                dp[i] = a[i]*11 + dp[i+1]*2;
            else {
                dp[i] = a[i]*suff[n-i-1] + dp[i+1]*2 - dp[i+2];
            }
            System.out.println("i="+i+","+dp[i].intValue());
        }

        Double d = dp[0]%(10e9d+7);
        System.out.println(d.intValue());
    }
}
