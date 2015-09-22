package hackerrank.dp.candies;

import java.util.Scanner;

/**
 * Created by RoySh on 9/16/2015.
 */
public class Candies {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer n = reader.nextInt();

        Integer[] r = new Integer[n];
        Integer[] v = new Integer[n];

        for(Integer i=0;i<n;i++) {
            r[i] = reader.nextInt();
            v[i] = 1;
        }

        Integer lastRating = 0;
        Integer lastIncInd = -1;
        Integer lastValueAss = -1;

        for(Integer i=0;i<r.length;i++) {
            if(r[i]>lastValueAss) {
                v[i] = lastRating + 1;
                lastRating = v[i];
                lastValueAss = r[i];
                lastIncInd = i;
            } else if(r[i]<lastValueAss) {
                if(lastRating>1) {
                    v[i] = 1;
                    lastRating = v[i];
                    lastValueAss = r[i];
                } else if(lastRating==1) {
                    v[i] = 1;
                    for(Integer j=i-1;j>lastIncInd-1;j--) {
                        v[j] = v[j-1]+1;
                    }
                    //v[i] = v[i-1]-1;
                    lastRating = v[i];
                }
            } else if(r[i]==lastValueAss) {
                v[i] = 1;
                lastIncInd = -1;
            }
        }

        Integer sum = 0;
        for(Integer i=0;i<r.length;i++) {
            sum+=v[i];
            System.out.print(v[i] + ",");
        }

        //System.out.println("");
        System.out.println(sum);
    }
}
