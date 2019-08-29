package pl.akademiakodu.projects;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PassBreaker {

    public void tryToBreakPassword(String password, ShowLog showLog, int slowRun){
        String pass = null;
        BigInteger counter =  BigInteger.ZERO;//przypisanie zera do BigInteger
        long start = System.nanoTime();

        while (true){
            pass = RandomStringUtils.randomAlphabetic(password.length());//generowanie łąncuchów- wszystkich kombinacji
            counter = counter.add(BigInteger.ONE); //zwiększamy counter o 1
            if(pass.equalsIgnoreCase(password)){
                break;
            }
            if(showLog.showValue()){
                System.out.println(pass + " | "+ counter);
            }

            if (slowRun>0) {
                try {
                    Thread.sleep(slowRun);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long stop= System.nanoTime();
        double elapsedTime = (double)(stop - start)/1000000000;
        double convert = TimeUnit.MILLISECONDS.convert((stop - start), TimeUnit.NANOSECONDS);
        System.out.println("BROKEN " +counter + " | "+ elapsedTime + "  " + convert);
    }
}
