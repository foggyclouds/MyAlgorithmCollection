package hackerrank.dp.BricksGame;

import java.util.Arrays;

/**
 * Created by RoySh on 9/18/2015.
 */
public class BricksGame {

    public static void main(String[] args) {
        Integer a[] = {5,6,8,9,2,4};
        //Integer stack[] = {5,6,8};

        Integer opt[] = {1,2,3};
        Integer n = a.length;
        Integer meSum = 0;
        Integer lastIndex = -1;

        for(Integer i=0;i<n;i++) {
            if(n-i<4) {
                meSum += a[i];
            } else {
                Integer temp = Integer.MIN_VALUE;

                /*if(i+1<n) {
                    temp = a[i] - a[i + 1];
                    lastIndex = i+1;
                    System.out.println(temp);
                }
                if(i+2<n && temp>a[i] - a[i+1] - a[i+2]) {
                    temp = temp>a[i] - a[i+1] - a[i+2]?temp:a[i] - a[i+1] - a[i+2];
                    System.out.println(temp);
                    lastIndex = i+2;
                }
                if(i+3<n && temp > a[i] - a[i + 1] - a[i + 2] - a[i + 3] ) {
                    temp = temp > a[i] - a[i + 1] - a[i + 2] - a[i + 3] ? temp : a[i] - a[i + 1] - a[i + 2] - a[i + 3];
                    lastIndex = i+3;
                    System.out.println(temp);
                }*/

                Integer tMeSum = 0;

                for(Integer x=0;x<3;x++) {
                    for(Integer y=0;y<3;y++) {
                        Integer p = x, q = y;

                        while(p<x+1) {
                            tMeSum += a[i+p];
                            p++;
                        }

                        q = p;

                        while(q<y+1) {
                            tMeSum -= a[i+q];
                            q++;
                        }

                        System.out.println("temp-"+temp+",tMeSum-"+tMeSum);

                        if(temp<tMeSum) {
                            temp = tMeSum;
                            lastIndex = q;
                        }
                    }
                    System.out.println(temp);
                }


                i = lastIndex-1;
                System.out.println("lastIndex = "+lastIndex);

            }
        }

        System.out.println(meSum);
    }
}
