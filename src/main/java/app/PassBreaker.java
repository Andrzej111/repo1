package app;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PassBreaker {

    public void passBreaker(String password){
        String pass = null;
        BigInteger counter =  BigInteger.ZERO;
        long start = System.nanoTime();

        while (true){
            pass = RandomStringUtils.randomAlphabetic(password.length());
            counter = counter.add(BigInteger.ONE); //zwiększamy counter o 1
            if(pass.equalsIgnoreCase(password)){
                break;
            }
            /*System.out.println(pass + " | "+ counter);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
        long stop= System.nanoTime();
        double elapsedTime = (double)(stop - start)/1000000000;
        double convert = TimeUnit.MILLISECONDS.convert((stop - start), TimeUnit.NANOSECONDS);
        System.out.println("BROKEN " +counter + " | "+ elapsedTime + "  " + convert);
    }
}
