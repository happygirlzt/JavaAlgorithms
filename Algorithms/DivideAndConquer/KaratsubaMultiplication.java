/**
 * Integer Multiplication
 *
 * Created on 21 Jan 2019 by happygirlzt
 *
 */

import java.math.BigInteger;
import java.util.Random;

public class KaratsubaMultiplication {
    private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);

        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N).add(bd.shiftLeft(2 * N)));
    }

    public static void main(String[] args) {
        long start, stop, elapsed;
        Random random = new Random();
        int N = 8888;
        BigInteger a = new BigInteger(N, random);
        System.out.println("=====================================================================");
        System.out.println("a is " + a.toString());
        BigInteger b = new BigInteger(N, random);
        System.out.println("b is " + b.toString());

        start = System.currentTimeMillis();
        System.out.println("Starting...");
        BigInteger c = karatsuba(a, b);
        stop = System.currentTimeMillis();
        System.out.println("Stopped");
        System.out.println("Time used by Karatsuba " + (stop - start));

        start  = System.currentTimeMillis();
        BigInteger d = a.multiply(b);
        stop = System.currentTimeMillis();
        System.out.println("Time used " + (stop - start));

        System.out.println(c.equals(d));
    }
}
