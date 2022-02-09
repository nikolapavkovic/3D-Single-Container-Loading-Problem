package hr.Base58;

import java.util.Random;

//Singleton random double number generator to prevent multiple instance creation with the same feed
public class RandomDoubleGenerator {

    private static RandomDoubleGenerator instance;
    private final Random randomGenerator;

    private RandomDoubleGenerator() {

        randomGenerator = new Random();

    }

    public static RandomDoubleGenerator getInstance() {

        if(instance == null) {
            instance = new RandomDoubleGenerator();
        }

        return instance;
    }

    public double nextDouble(double upperBound) {

        return randomGenerator.nextDouble() * upperBound;

    }
}
