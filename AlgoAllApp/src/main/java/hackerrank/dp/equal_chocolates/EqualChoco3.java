package hackerrank.dp.equal_chocolates;


import java.util.Scanner;


public class EqualChoco3 {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        Integer t = 1;
        for(Integer x=0;x<t;x++) {
            Integer c[] = {1,5,5,10,10};
            Integer n = c.length;
            //Integer c[] = {2, 2, 3, 7};
            /*Integer c[] = new Integer[n];
            for(Integer y=0;y<n;y++)
                c[y]=in.nextInt();
            */

            Integer d[] = new Integer[n];
            Integer min = Integer.MAX_VALUE;
            Integer p = getSmallest(c);

            for(Integer r=p;r>=0 && r>p-5;r--) {
                Integer temp=0;
                for (Integer i = 0; i < c.length; i++) {
                    d[i] = c[i] - r;

                    if (d[i] != 0) {
                        temp += d[i] / 5 + (d[i] % 5) / 2 + (d[i] % 5) % 2;
                    }
                }

                if(temp<min)
                    min=temp;

            }

            System.out.println(min);
        }
    }

    private static Integer getSmallest(Integer a[]) {
        Integer small = Integer.MAX_VALUE;
        for(Integer i=0;i<a.length;i++) {
            if(a[i]<small)
                small = a[i];
        }
        return small;
    }

}
