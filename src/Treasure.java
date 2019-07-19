package treasurehunt;

// see: https://stackoverflow.com/questions/20062375/treasure-hunt-program-in-java

import java.util.Scanner;

public class Treasure {

	// public int POSITIONS_PER_ROW = 20;
	// public int MAX_DISTANCE = 401;
	private String name;
	private int xLocation;
	private int yLocation;
	private Boolean found;

	// put here

	public static final int MAX_DISTANCE = 401;
	public static final int POSITIONS_PER_ROW = 20;

	public Treasure() {
		name = "";
		xLocation = 0;
		yLocation = 0;
		found = false;
	}

	public Treasure(String name) {
		this.name = name;
		xLocation = 0;
		yLocation = 0;
		found = false;
	}

	public int getXLocation() {
		return xLocation;
	}

	public int getYLocation() {
		return yLocation;
	}

	public boolean isFound() {
		return found;
	}

	public void hideTreasure() {
		xLocation = 1 + (int) (Math.random() * POSITIONS_PER_ROW);
		yLocation = 1 + (int) (Math.random() * POSITIONS_PER_ROW);
	}

	public int treasureStatus(int xStick, int yStick) {
		if (xStick == xLocation && yStick == yLocation) {
			return 0;
		} else if (xStick != xLocation || yStick != yLocation) {
			return Math.abs((yStick - yLocation) + (xStick - xLocation));
		} else
			return MAX_DISTANCE;

	}


	public static void main(String[] args) {
		
		System.out.println("I am being called");

		Treasure gold = new Treasure();
		Treasure diamond = new Treasure();
		char playAgain = 0;

		gold.hideTreasure();
		diamond.hideTreasure();

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Treasures have been hidden.");

		do {
			System.out.println("");
			System.out.print("Enter x and y coordinates to search: ");
			int xStick = keyboard.nextInt();
			int yStick = keyboard.nextInt();

			int dist1 = diamond.treasureStatus(xStick, yStick);
			int dist2 = gold.treasureStatus(xStick, yStick);

			if (dist1 == 0 || dist1 == MAX_DISTANCE) {
				System.out.println("Diamonds: FOUND!");
			} else {
				System.out.println("Diamonds: " + dist1 + " away");
			}

			if (dist2 == 0 || dist2 == MAX_DISTANCE) {
				System.out.println("Gold: FOUND!");
			} else {
				System.out.println("Gold: " + dist2 + " away");
			}

		} while (!diamond.isFound() && !gold.isFound());

		do {
			System.out.println("Play again? y/n:");
			playAgain = keyboard.next().charAt(0);
		} while (diamond.isFound() && gold.isFound());

	}
}

// }

/**
 * 
 * package treasurehunt;
 * 
 * import java.util.Scanner;
 * 
 * public class TreasureHunt {
 * 
 * public static final int MAX_DISTANCE = 401; public static final int
 * POSITIONS_PER_ROW = 20;
 * 
 * public static void main(String[] args) { Treasure gold = new Treasure();
 * Treasure diamond = new Treasure(); char playAgain = 0;
 * 
 * gold.hideTreasure(); diamond.hideTreasure();
 * 
 * Scanner keyboard = new Scanner(System.in);
 * 
 * System.out.println("Treasures have been hidden.");
 * 
 * do{ System.out.println(""); System.out.print("Enter x and y coordinates to
 * search: "); int xStick = keyboard.nextInt(); int yStick = keyboard.nextInt();
 * 
 * int dist1 = diamond.treasureStatus(xStick, yStick); int dist2 =
 * gold.treasureStatus(xStick , yStick);
 * 
 * if (dist1 == 0 || dist1 == MAX_DISTANCE){ System.out.println("Diamonds:
 * FOUND!"); }else{ System.out.println("Diamonds: " + dist1 + " away"); }
 * 
 * if (dist2 == 0 || dist2 == MAX_DISTANCE){ System.out.println("Gold: FOUND!");
 * }else{ System.out.println("Gold: " + dist2 + " away"); }
 * 
 * }while(!diamond.isFound() && !gold.isFound());
 * 
 * 
 * 
 * 
 * do{ System.out.println("Play again? y/n:"); playAgain =
 * keyboard.next().charAt(0); }while(diamond.isFound() && gold.isFound());
 * 
 * } }
 */

//// ---------------------------------------AND--------------