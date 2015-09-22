package hackerrank.dp.khapsack;

import java.util.Scanner;

public class Knapsack2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer tests = in.nextInt();

        for(Integer t=0;t<tests;t++) {
            Integer n = in.nextInt();
            Integer sum = in.nextInt();
            Integer a[] = new Integer[n];
            for(Integer x=0;x<n;x++)
                a[x]=in.nextInt();

            Integer c[] = new Integer[sum+1];
            c[0] = 1;

            Integer lastSum = 0;

            for(Integer i=1;i<sum+1;i++) {
                for(Integer j=0;j<a.length;j++) {
                    if(i<a[j])
                        c[i]=0;
                    else if(c[i-a[j]]>0){
                        lastSum = i;
                        c[i]=1;
                        break;
                    } else {
                        c[i]=0;
                    }
                }
            }

            System.out.println(lastSum);
        }

    }
}
