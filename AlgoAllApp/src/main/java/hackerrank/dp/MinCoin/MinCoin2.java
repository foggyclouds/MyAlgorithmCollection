package hackerrank.dp.MinCoin;

/**
 * Created by RoySh on 9/17/2015.
 */
public class MinCoin2 {

    public static void main(String[] args) {
        Integer c[] = {2,1,3};
        Integer s = 4;
        Integer n = c.length;
        Integer m[][] = new Integer[n+1][s+1];

        for(Integer j=0;j<s+1;j++)
            m[0][j] = 0;

        for(Integer i=0;i<n+1;i++)
            m[i][0] = 0;

        for(Integer i=1;i<s+1;i++) {
            for(Integer j=0;j<n;j++) {
                System.out.println("i="+i+",j="+j+",c[j]="+c[j]);
                if(i<c[j])
                    m[j+1][i] = m[j][i];
                else {
                    m[j+1][i] = 1 + m[j+1][i-c[j]];
                    if(m[j+1][i]>m[j][i] && m[j][i]!=0)
                        m[j+1][i] = m[j][i];
                }

                System.out.println("          m[" + (j + 1) + "][" + i + "]=" + m[j+1][i]);
            }
        }


    }
}
