package hackerrank.dp.red_john;

import java.util.Scanner;

public class RedJohn {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Long t = reader.nextLong();

        for(Integer k=0;k<t;k++) {
            Long n = reader.nextLong();

            Long c = 1L;
            if (n % 4L == 0)
                c++;

            Long x = 4L;
            while (x < n) {
                Long d = n-x + x/4L;
                Long f = nCr(d,x/4);
                c = c + f;
                x = x + 4L;
            }

            Long p = c - 1;

            for (Integer i = 2; i < c + 1; i++) {
                for (Integer j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        p--;
                        break;
                    }
                }
            }

            System.out.println(p);
        }
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
