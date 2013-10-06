package kilomanx;

/* http://community.topcoder.com/stat?c=problem_statement&pm=2288&rd=4725
 * data set
 * {"070","500","140"}
{150,150,150}
 */
public class Kilomanx {
	
	private String[] damageChart;
	private int[] bossHealth;
	
	PriorityQueue pq = new PriorityQueue();
	
	public Kilomanx( String[] damageChart, int[] bossHealth) {
		this.damageChart = damageChart;
		this.bossHealth = bossHealth;
	}
	
	public int dijkstra() {
		int allVisited = (int)Math.pow(2, bossHealth.length) - 1;
		
		PriorityQueue.PriorityItem pi = pq.new PriorityItem(0, 0);
		pq.push(pi);
		while(pq.empty() == false) {
			pi = pq.pop();
			int thisVisited = pi.priority;
			int damage = (int)pi.o;
			if( thisVisited == allVisited) {
				return damage;
			}
			for(int i = 0; i < bossHealth.length; i++) {
				int visited = thisVisited;
				int mask = 1 << i;
				if((visited & mask) == 0) {
					visited |= mask;
					int damageToDo = 1;
					// need to visit ith boss, but check every weapon
					for(int j = 0; j < bossHealth.length; j++) {
						int bossMask = 1 << j;
						if( (visited & bossMask) != 0) {
							// we have this weapon
							String damageToBossByWeaponStr = damageChart[j];
							if( damageToBossByWeaponStr.charAt(i) - 48 > damageToDo ) {
								damageToDo = damageToBossByWeaponStr.charAt(i) - 48;
							}							
						}
					}
					int newDamage = damage + bossHealth[i] / damageToDo;
					if (bossHealth[i] % damageToDo > 0) {
						newDamage++;
					}
					pq.push(pq.new PriorityItem(visited, newDamage ));
				}
			}
		}		
		return pq.pop().priority;
	}

	public static void main(String[] args) {
		String[] damageChart = {"070","500","140"};
		int[] bossHealth = {150,150,150};
		
		Kilomanx k = new Kilomanx( damageChart, bossHealth);
		int time = k.dijkstra();
		System.out.println(time);

	}

}
