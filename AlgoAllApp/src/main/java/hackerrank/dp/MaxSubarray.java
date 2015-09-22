package hackerrank.dp;

import java.util.Scanner;

public class MaxSubarray {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer t = reader.nextInt();
        Integer[][] a = new Integer[t][];
        for(Integer i=0;i<t;i++) {
            Integer n = reader.nextInt();
            a[i] = new Integer[n];
            for(Integer j=0;j<n;j++)
                a[i][j]=reader.nextInt();
        }

        for(Integer l=0;l<t;l++) {
            Integer tSum = 0;
            Integer maxSum = Integer.MIN_VALUE;
            //Integer tStIndex = 0;
            Integer maxNonContSum = a[l][0];
            maxNonContSum=0;
            boolean flAllNegative = false;
            if(a[l][0]<0) {
                flAllNegative = true;
                maxNonContSum = Integer.MIN_VALUE;
            }

            for(Integer i=0;i<a[l].length;i++) {
                if(a[l][i]<0 && flAllNegative==true && a[l][i]>maxNonContSum) {
                    maxNonContSum = a[l][i];
                } else if(a[l][i]>0 && maxNonContSum<0) {
                    maxNonContSum = a[l][i];
                    flAllNegative = false;
                } else if(a[l][i]>0) {
                    maxNonContSum += a[l][i];
                    flAllNegative = false;
                }

                tSum = tSum + a[l][i];
                if(tSum > maxSum) {
                    maxSum = tSum;
                }

                if(tSum < 0) {
                    tSum = 0;
                }
            }

            System.out.println(maxSum + " " + maxNonContSum);
        }

    }
}
