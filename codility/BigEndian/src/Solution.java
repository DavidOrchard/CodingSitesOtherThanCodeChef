
public class Solution {
	// parse strings, such as "2F" into # of bits, in this case 5
	
    public int solution(String S) {
    	int count = 0;
    	int[] bits = new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
    	for(int i = 0; i < S.length(); i++) {
    		char c = S.charAt(i);
    		int val;
    		// 0 ascii = 48 decimal
    		// 9 ascii = 57 decimal
    		// A ascii = 65 decimal
    		if( c <= '9') {
    			val = c - '0';
    		} else {
    			val = c - 55;
    		}
    		count += bits[val];   		
    	}
        return count;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.solution("31D"));
    }

}
