/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HannonHillSecret;

import org.apache.commons.math3.primes.Primes;
import java.util.ArrayList;

/**
 *
 * @author CubanoGnzlz
 */
public class HannonHillSecret {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int N = 55;
        int currentNum = 0;
        int x = 0;
        int sizePrimes;
        boolean isAdditive = true;
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        
        currentNum = Primes.nextPrime(currentNum);
        
        //Add all prime numbers less than or equal to N
        while (currentNum <= N)
        {
            primeNumbers.add(currentNum);
            currentNum = Primes.nextPrime(currentNum++);
        }
        
        sizePrimes = primeNumbers.size();
        
        // If there are only two prime numbers in the arraylist, it means it is empty or there
        // is only one.
        if (sizePrimes < 2)
        {
            System.out.println("Cannot test if Secret is additive since there " + 
                    "are not two or more prime numbers less than N!");
        }
        else // Testing for additive property is possible
        {
            outerloop:
            // Assuming the additive test only requires pair combinations, go through
            // all possible pairs until all pass or one fails
            while (x < sizePrimes && isAdditive)
            {
                for (int y = x +1; y <= sizePrimes; y++)
                {
                    isAdditive = isSecretAdditive(primeNumbers.get(x), primeNumbers.get(x));

                    //Failed additive test for a combination of prime numbers,
                    // so break the while loop and return false
                    if (!isAdditive)
                    {
                        break outerloop;
                    }
                }
                x++;
            }
        
            if (isAdditive)
            {
                System.out.println("Secret is additive!");
            } else 
            {
                System.out.println("Secret is NOT additive!");
            }
        }
    }
    
    // This function returns wheteher the pair of numbers passed in, result
    // in Secret adhering to the additive property
    private static boolean isSecretAdditive(Integer x, Integer y)
    {
        return (Secret.secret(x + y) == (Secret.secret(x) + Secret.secret(y)));
    }
}


