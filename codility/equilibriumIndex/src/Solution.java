

public class Solution {
	public static void main(String[] args) {
		//int[] a = {2, 3, 1, 1, 3}; //result = 2
		//int[] a = {1, 2, 3, 4, 0}; //result = 5
		int[] a = {1, 0}; // result = 2
		//int[] a = {0}; // result = 1
		//int[] a = {2,2,1}; // result = 2
		Solution s = new Solution();
		System.out.println(s.solution(a));
		
	}
	
	public int solution(int[] A) {
		// Use the array to track previous visits
		// the new value in each position will be the negative of the count to reach it.
		int index = 0;
		for(int count = 1; count <= A.length + 1; count++) {
			if(A[index] > 0 ) {
				int tmpIndex = A[index];
				A[index] = -count;
				index = tmpIndex;
			} else {
				return count + A[index];
			}
		}
		return A.length;
	}

}
