import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.Random;
public class MaxPairwiseProduct {

	static BigInteger getMaxPairwiseProduct(int[] numbers) {
		BigInteger product = new BigInteger ("0");
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				BigInteger bigOne = BigInteger.valueOf(numbers[i]);
				BigInteger bigTwo = BigInteger.valueOf(numbers[j]);
				product = product.max(bigOne.multiply(bigTwo));
			}
		}
		return product;
	}

	static BigInteger getMaxPairwiseProductFast(int[] numbers) {
		BigInteger product = new BigInteger ("0");
		Arrays.sort(numbers);
		int n = numbers.length;
		BigInteger maxOne = BigInteger.valueOf(numbers[n-1]);
		BigInteger maxTwo = BigInteger.valueOf(numbers[n-2]);
		product = maxOne.multiply(maxTwo);
		return product;		
	}

	static BigInteger getMaxPairwiseProductCheck(int[] numbers) {
		BigInteger product = new BigInteger ("0");
		//List<Integer> clist = new ArrayList<> ();
		int firstLargeVal = 0;
		int firstIndex = -1;
		int secondLargeVal = 0;
		
		// First large value
		for(int i=0; i<numbers.length; i++){
			if( numbers[i] > firstLargeVal){
				firstLargeVal = numbers[i];
				firstIndex = i;
			}
		}
		
		// 
		System.out.println("The firstLargeValue is: " + firstLargeVal);
		for(int i=0; i<numbers.length; i++){
			if(firstIndex != i){
				if( numbers[i] > secondLargeVal){
					secondLargeVal = numbers[i];
				}
			}
		}
		
		System.out.println("The SecondLargeVal is:" + secondLargeVal);

		BigInteger bigOne = BigInteger.valueOf(firstLargeVal);
		BigInteger bigTwo = BigInteger.valueOf(secondLargeVal);
	
		System.out.println("BigOne=" + bigOne);
		System.out.println("BigTwo=" + bigTwo);

		product = bigOne.multiply(bigTwo);
		return product;		
	}

	public static void main(String[] args) throws InterruptedException {
		//STRESS TEST

		/* while(true){
			Random rand = new Random ();
			int randInt1 = Math.abs(rand.nextInt()) % 1000 + 2;

			
			//System.out.println(randInt1);

			List<Integer> clist = new ArrayList<Integer>();
			for (int r=0; r<randInt1; r++){
				clist.add(Math.abs(rand.nextInt()) % 100000);
			} 
			for(int r: clist){
				System.out.println(r + " ");
			}
			
			BigInteger res1 = getMaxPairwiseProductFast(clist.stream()
                            .mapToInt(Integer::intValue)
                            .toArray());
 
			BigInteger res2 = getMaxPairwiseProduct(clist.stream()
                            .mapToInt(Integer::intValue)
                            .toArray());
			if(!res1.equals(res2)){
				System.out.println("Wrong answer" + " " + res1 + " " + res2);
				break;
			}
			else{
				System.out.print("OK");
			}
			
		} */
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
		numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProductFast(numbers));
	}

	static class FastScanner {
		
		BufferedReader br;
		StringTokenizer st;
		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new
				InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}