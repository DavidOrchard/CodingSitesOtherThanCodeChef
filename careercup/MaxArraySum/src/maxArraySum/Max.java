package maxArraySum;

// From: http://www.careercup.com/question?id=21423662
// Calculate the max for traversing an array of ints, can only go down or left
// Traverse each direction keeping track of max
// Space complexity O(n+m)
// Time complxity O(n*m)

// starting with [[1,1],[2,0]] should be 3 max
// step 1: x= 0, y = 0, max = 1
// step 2a: x= 1, y = 0, max = 2;
// step 2b: x= 0, y = 1, max = 3;
// can this be [2,3] to represent 1,0; 0,1?
// step 3: x= 1, y = 1, max = 0 + max previous

//  [[1,1,1],
//   [2,1,0],
//   [2,1,0]]
// should be 6 max
// step 1: x = 0, y = 0, max = 1
// represent as [1]
// step 2a: x = 1, y = 0, max = 2
// step 2b: x = 0, y = 1, max = 3
// represent as [2,3]?
// step 3a: x = 2, y = 0, max = 3
// step 3b: x = 1, y = 1, max = 4 - from x = 1, y = 0 and x = 0, y = 1
// 4 = max( spots 0, 1 in array) + val
// step 3c: x = 0, y = 2, max = 5
// represent as [3,4,5]
// step 4a: x = 2, y = 1, max = 4 - from x = 1, y = 1 and x = 2, y = 0
// step 4b: x = 1, y = 2, max = 6 - from x = 1, y = 1 and x = 0, y = 2
// represent as [4,6]
// step 5: x = 2, y = 2 max = 6   - from x = 2, y = 1 and x = 1, y = 2
// represent as [6]

public class Max {

	public static void main(String[] args) {
		int[][] m = {
				{1,1,1,5},
				{2,1,0,6},
				{2,1,0,8}
		};
		
		int[] prevdiagonal = {};
		for(int i = 0; i < m.length; i++) {
			int[] diagonal = new int[i + 1];
			for( int j = 0; j <= i; j++) {
				if( i == 0 && j == 0 ) {
					diagonal[j] = m[i][j];					
				} else if ( j == 0) {
					diagonal[j] = prevdiagonal[j] + m[j][( m[j].length - 1) - j];
				} else if ( j == i){
					diagonal[j] = prevdiagonal[j - 1 ] + m[j][0];
				} else {
					diagonal[j] = Math.max(prevdiagonal[j - 1], prevdiagonal[j]) + m[j][(m[j].length - 1) - j];
				}
			}
			prevdiagonal = diagonal;			
		}
		for(int i = 0; i < m[0].length -1 ; i++) {
			int[] diagonal = new int[(m[0].length - 1) - i];
			for( int j = 0; j < (m[0].length - 1) - i; j++) {
				// m.length = 3, m[0].length = 3
				// i = 0, j = 0: [1,2];
				// i = 0, j = 1: [2,1]  
				// i = 1, j = 0: [2,2] -> [1 + j + i][ (m.length - 1) - j ]
				diagonal[j] = Math.max(prevdiagonal[j ], prevdiagonal[j + 1]) + m[1 + j + i][ (m.length - 1) - j ];
			}
			prevdiagonal = diagonal;			
		}
		
		System.out.println(prevdiagonal[0]);
	}

}
