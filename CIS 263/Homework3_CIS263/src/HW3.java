//
// The file pP-1000000.txt was downloaded from 
// http://www.naturalnumbers.org/primes.html
//
import java.util.*;
import java.io.*;
public class HW3 {

    public static void main(String args[]) {
        ArrayList < Long > primes = new ArrayList < Long > (1000000);
        // Read the first million primes from a text file
        try{
            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream("P-1000000.txt");
            Scanner scnr = new Scanner(fileByteStream);

            // keep reading as long as there is more data
            while(scnr.hasNext()) {
                long position = scnr.nextLong();
                long prime = scnr.nextLong();
                long gap = scnr.nextLong();
                primes.add(prime);
            }

            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: P-1000000.txt");
        }
        long startTime;
        long endTime;
        long duration;
        startTime = System.currentTimeMillis();
        HashSet < Long > hashPrimes = new HashSet < Long > (primes);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Time to create the HashSet: "+duration);
        startTime = System.currentTimeMillis();
        TreeSet < Long > treePrimes = new TreeSet < Long > (primes);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Time to create the TreeSet: "+duration);
        long productOfPrimes1 = 15485857L * 15485863L ;
        System.out.println("productOfPrimes1: "+productOfPrimes1);
        startTime = System.currentTimeMillis();
        long factor = hashPrimes.stream().filter( e -> productOfPrimes1 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes1/factor+". Time With HashSet: " + duration);
        startTime = System.currentTimeMillis();
        factor = treePrimes.stream().filter( e -> productOfPrimes1 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes1/factor+". Time With TreeSet: " + duration);
        startTime = System.currentTimeMillis();
        factor = hashPrimes.parallelStream().filter( e -> productOfPrimes1 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes1/factor+". Time With HashSet and parallel stream: " + duration);
        startTime = System.currentTimeMillis();
        factor = treePrimes.parallelStream().filter( e -> productOfPrimes1 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes1/factor+". Time With TreeSet and parallel stream: " + duration);
        long productOfPrimes2 = 2L * 3L ;
        System.out.println("productOfPrimes2: "+productOfPrimes2);
        startTime = System.currentTimeMillis();
        factor = hashPrimes.stream().filter( e -> productOfPrimes2 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes2/factor+". Time With HashSet: " + duration);
        startTime = System.currentTimeMillis();
        factor = treePrimes.stream().filter( e -> productOfPrimes2 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes2/factor+". Time With TreeSet: " + duration);
        startTime = System.currentTimeMillis();
        factor = hashPrimes.parallelStream().filter( e -> productOfPrimes2 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes2/factor+". Time With HashSet and parallel stream: " + duration);
        startTime = System.currentTimeMillis();
        factor = treePrimes.parallelStream().filter( e -> productOfPrimes2 % e == 0).reduce(0L,(a,b)->Math.max(a,b));
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Factors: "+factor+" "+productOfPrimes2/factor+". Time With TreeSet and parallel stream: " + duration);
    }

}