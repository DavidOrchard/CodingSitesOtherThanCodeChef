/*
 * For example, given S = "abbabba" the function should return 4, because:
proper prefixes of S are: "", "a", "ab", "abb", "abba", "abbab", "abbabb";
proper suffixes of S are: "", "a", "ba", "bba", "abba", "babba", "bbabba";
string "abba" is both a proper prefix and a proper suffix of S;
this is the longest such string.
 */
public class Solution {
	// Start at the beginning character
	// On each iteration, see if the nth characters are at suffixes
    public int solution(String S) {
    	int max = 0;
    	for(int i = 0; i < S.length() - 1; i++) {
    		if(S.substring(0,i+1).equals(S.substring(S.length() - i - 1))) {
    			max = i + 1;
    		}
    	}
    	return max;
    }
    
    public class Tracker {
    	public String allocate(String host_type) {
    		return host_type;
    		   		
    	}
    	public String deallocate(String hostname) {
    		return hostname;
    		
    	}
      }
    
     public static void main(String[] args) {
    	Tracker tracker = new Tracker();
    	System.out.println(tracker.allocate('apibox'));
    	try {
    		System.out.println("should be 2 " + next_server_number(new int[]{1}));
    		System.out.println(next_server_number(new int[]{5,3,1}));
    		System.out.println(next_server_number(new int[]{5, 4, 1, 2}));
    		System.out.println(next_server_number(new int[]{1,2,3,4}));
    		System.out.println(next_server_number(new int[]{}));
    		System.out.println(next_server_number(null));
    		} catch(Exception e){
    			
    	}
    }
    
    public static int next_server_number(int[] servers) throws Exception {
    	final int MAX_SERVERS = 6;
    	if( servers == null || servers.length == 0) {
    		return 1;
    	}
    	java.util.Arrays.sort(servers);
    	for(int i = 0; i < servers.length; i++) {
    		if(servers[i] != i+1) {
    			return i + 1;
    		}
    	}
    	if( servers.length < MAX_SERVERS ) {
    		return servers.length + 1;
    	}
    	throw new Exception("no servers");
    }

}
