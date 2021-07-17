import java.util.Random;

/**
 * Class to generate a random prime number for hash calculation.
 * 
 * @author	n-c0de-r
 * @author	jonasblome
 * @author GitYusuf
 * @version	17.07.2021
 */
public class GeneratePrimes {
	
	/**
	 * Method to create a prime number.
	 * 
	 * @return	Integer, if it is a true prime.
	 */
	public int generatePrime() {
		Random r = new Random();
		//Initialize to 4, as it is definitely not a prime.
		int p = 4;
		
		//While it is not a prime, generate a new number.
		while (!isPrime(p)) {
			//Bounds of numbers are 13-42, magic numbers ;)
			p = r.nextInt(29)+13;
		}
		return p;
	}
	
	/**
	 * Helper method, checking if any given number is a prime
	 * 
	 * @param i	Integer to check.
	 * @return	Returns true if it is a prime.
	 */
	private boolean isPrime(int i) {
		//Check until the square root of the number
		//after that the factors flip anyway.
		for (int n = 2; n <= Math.sqrt(i); n++) {
			if (i % n == 0) {
				return false;
			}
		}
		return true;
	}
	
}
