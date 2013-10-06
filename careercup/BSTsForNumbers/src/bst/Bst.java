package bst;

/*
 * http://www.careercup.com/question?id=14586067
 * You are given N unique numbers a1<a2<a3<...an. 
 * Find out the count of all possible binary search tress that can be constructed using 
 * these numbers. for example with 3 elements 1,2,3 there are 5 possible BST and 
 * for 1,2,3,4 there are 14 bst
 * 
 * Formula count = Sum(i from 1 to N) (count(i-1) * count (n-i)
 * catalan numbers http://en.wikipedia.org/wiki/Catalan_number
 * good video: http://www.youtube.com/watch?v=UfA_v0VmiDg
 * 
 */
public class Bst {
	
	private static int[] memo;
	public static int count(int numElements){
		if( numElements == 0) {
			return 1;
		}
		if( memo[numElements -1] != 0) {
			return memo[numElements -1];
		}
		int count = 0;
		for(int i = 1; i <= numElements; i++) {
			int tmpCount = count( i - 1) * count( numElements - i );
			count += tmpCount;
		}
		
		memo[numElements -1] = count;
		return count;
	}
	
	public static void main (String args[]){
		int N = 4;
		memo = new int[N];
		System.out.println(count(N));
		
	}

}
