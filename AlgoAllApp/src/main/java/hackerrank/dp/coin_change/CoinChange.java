package hackerrank.dp.coin_change;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    Integer[] c ;
    Map<Key,Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        CoinChange cc = new CoinChange();
        Integer n = reader.nextInt();
        Integer m = reader.nextInt();
        Integer[] a = new Integer[m];
        for(Integer i=0;i<m;i++)
            a[i]=reader.nextInt();
        long start = System.nanoTime();
        System.out.println(cc.getArrangement(a, 0, m-1, n));
        double d = (System.nanoTime()-start)/1000;
        System.out.println("Time - "+d);
    }

    /*private Integer getMaxArrangement(Integer c1, Integer c2, Integer n) {
        Integer q1 = n/c1;
        Integer c = 0;
        for(Integer i=0;i<q1+1;i++) {
            if((n-i*c1)%c2==0)
                c++;
        }

        return c;
    }*/

    private Integer getArrangement(Integer[] a, Integer i, Integer m, Integer n) {
        //System.out.println("getArrangement("+a[i]+","+a[m]+","+n+")");
        System.out.println("getArrangement("+i+","+m+","+n+")");

        Key k = new Key(i,m,n);
        if(memo.get(k)!=null) {
            System.out.println("--> In Memo");
            return memo.get(k);
        }

        Integer q = n/a[i];
        Integer c = 0;
        if(i+1==m) {
            //System.out.println("getArrangement("+a[i]+","+a[m]+","+n+")");
            for(Integer l=0;l<q+1;l++) {
                if((n-l*a[i])%a[m]==0)
                    c++;
            }
            memo.put(new Key(i,m,n),c);
            return c;
        }
        for(Integer l=0;l<q+1;l++) {
            c+=getArrangement(a, i+1, m, n-l*a[i]);
        }

        memo.put(new Key(i,m,n),c);
        return c;
    }
}


class Key {
    Integer st,end,sum;

    public Key(Integer st, Integer end, Integer sum) {
        this.st = st;
        this.end = end;
        this.sum = sum;
    }

    public Integer getSt() {
        return st;
    }

    public void setSt(Integer st) {
        this.st = st;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return 31*st+32*end+33*sum;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        Key k = (Key)obj;
        if(k.getSt()==st && k.getEnd()==end && k.getSum()==sum)
            return true;
        else
            return false;
    }
}
