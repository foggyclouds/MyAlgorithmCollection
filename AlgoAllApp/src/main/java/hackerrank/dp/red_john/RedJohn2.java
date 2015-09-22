package hackerrank.dp.red_john;

import java.util.Scanner;

public class RedJohn2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //Integer t = reader.nextInt();

        Long n = 38L;

        Long c = 1L;
        if (n % 4 == 0 && (n/4)%4==0) {
            System.out.println("hit");
            c++;
        }

        Long x = 4L;
        while (x < n) {
            //c = c + (x - 4) + (n - x + 4) / 4;
            //c = c + fact(n)/(fact(x-4)*fact((n-x)/4));
            Long d = n-x + x/4L;
            //Long f = fact(d)/(fact(n-x)*fact(x/4L));
            Long f = nCr(d,x/4);
            c = c + f;
            //System.out.println("x="+x+",c="+c+",d="+d+",f="+f);
            x = x + 4L;
        }

        //System.out.println(c);

        //c = 31421L;
        Long p = c - 1;

        for (Integer i = 2; i < c + 1; i++) {
            for (Integer j = 2; j <= Math.sqrt(i); j++) {
                //System.out.println("i="+i+",j="+j);
                if (i % j == 0) {
                    p--;
                    break;
                }
            }
        }

        System.out.println(p);
    }

    static private Long fact(Long n) {
        if(n==1L)
            return 1L;
        Long f = 1L;
        for(Long i=2L;i<n+1;i++) {
            f = f*i;
        }
        return f;
    }

    static private Long nCr(Long n, Long r) {
        if(r > n-r)
            r = n-r;

        Long f = 1L;
        for(Long i=n;i>n-r;i--) {
            f = f * i;
        }

        f = f / fact(r);

        return f;
    }
}
