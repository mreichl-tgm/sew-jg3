/**
 * @author kojote
 * @version 1.1
 * 
 * Testing environment for TreeMaps
 */

package au06;

import java.util.TreeMap;

public class TreeMapTest extends TreeMap<Integer, Integer> implements Testable {
	private static final long serialVersionUID = 1L;
	
	double startTime;
	double endTime;
	int runs;
	
	public TreeMapTest(int runs) {
		this.runs = runs;
	}
	
	@Override
	public void log() {
		System.out.println((endTime - startTime) /* + "ns -> " + ((endTime - startTime) / 1000) + "ms" */);
	}

	@Override
	public void addTest() {
		System.out.println("- addTest ----");
		
		startTime = System.nanoTime();
		this.put(0, rand.nextInt(50));
		endTime = System.nanoTime();
		
		//System.out.print("Adding 1 element: ");
		log();
		
		for (int i = 1; i < runs + 1; i++) {
			this.clear();
			startTime = System.nanoTime();
			for (int j = 0; j < (50 * i); j++) {
				this.put(j, rand.nextInt(50));
			}
			endTime = System.nanoTime();
			//System.out.print("Adding " + (50 * i) + " elements: ");
			log();
		}
		
		this.clear();
	}

	@Override
	public void removeTest() {
		System.out.println("- removeTest ----");
		
		this.put(0, 1);
		startTime = System.nanoTime();
		this.remove(0);
		endTime = System.nanoTime();
		
		//System.out.print("Removing 1 element: ");
		log();
		
		for (int i = 1; i < runs + 1; i++) {
			// Clear and add
			this.clear();
			for (int j = 0; j < (50 * i); j++) {
				this.put(j, rand.nextInt(50));
			}
			// Remove
			startTime = System.nanoTime();
			for (int j = 0; j < this.size(); j++) {
				this.remove(j);
			}
			endTime = System.nanoTime();
			// Log
			//System.out.print("Removing " + (50 * i) + " elements: ");
			log();
		}
	}

	@Override
	public void searchTest() {
		System.out.println("- searchTest ----");
		for (int i = 1; i < runs + 1; i++) {
			// Clear and add
			this.clear();
			for (int j = 0; j < (50 * i); j++) {
				this.put(j, rand.nextInt(50));
			}
			// Remove
			int n = rand.nextInt(50);
			startTime = System.nanoTime();
			for (int j = 0; j < this.size(); j++) {
				this.values().contains(n);
			}
			endTime = System.nanoTime();
			// Log
			//System.out.print("Searching in " + (50 * i) + " elements: ");
			log();
		}
	}
}