import java.util.ArrayList;

public class RotatingBot {

	public int minArea(int[] moves) {
		byte minWidth = 1;
		//byte dinamicHorizontalRestriction = -1; // used to limit horizontal movement
		byte maxWidth = -1;
		byte minHeight = 1;
		//byte dinamicVerticalRestriction = -1; // used to limit vertical movement
		byte maxHeight = -1;
		
		for (int i = 0; i < moves.length; i++) {
			if (i % 2 == 0) { // iteration number is even, so the movement is horizontal
				if (maxWidth > 0) {
				} else {
					minWidth += moves[i];
					maxWidth++;
				}

			} else { // iteration number is odd, so the movement is vertical
				if (maxHeight > 0) {
				} else {
					minHeight += moves[i];
					maxHeight++;
				}
			}
		}

		return minWidth * minHeight;
	}
	
	public static void main(String[] args) {
		RotatingBot bot = new RotatingBot();
		
		int[] moves = {15};
		int result = bot.minArea(moves);
		int expected = 16;
		printTestResults(moves, expected, result);

		int[] moves1 = {3, 10};
		result = bot.minArea(moves1);
		expected = 44;
		printTestResults(moves1, expected, result);
		
		int[] moves2 = {1,1,1,1};
		result = bot.minArea(moves2);
		expected = -1;
		printTestResults(moves2, expected, result);
		
		int[] moves3 = {9,5,11,10,11,4,10};
		result = bot.minArea(moves3);
		expected = 132;
		printTestResults(moves3, expected, result);
		
		int[] moves4 = {12,1,27,14,27,12,26,11,25,10,24,9,23,8,22,7,21,6,20,5,19,4,18,3,17,2,16,1,15};
		result = bot.minArea(moves4);
		expected = 420;
		printTestResults(moves4, expected, result);
		
		int[] moves5 = {8,6,6,1};
		result = bot.minArea(moves5);
		expected = -1;
		printTestResults(moves5, expected, result);
		
		int[] moves6 = {8,6,6};
		result = bot.minArea(moves6);
		expected = 63;
		printTestResults(moves6, expected, result);
		
		int[] moves7 = {5,4,5,3,3};
		result = bot.minArea(moves7);
		expected = 30;
		printTestResults(moves7, expected, result);

	}

	private static void printTestResults(int[] moves, int expected, int result) {
		System.out.print("Input: [");
		for (int i = 0; i < moves.length; i++) {
			System.out.print(" " + moves[i]);
		}
		System.out.print(" ]\n");
		System.out.println("Result: " + result);
		System.out.println("Expected: "+ expected);
		if (result == expected) {
			System.out.println("Success!\n");
		} else {
			System.out.println("TEST FAIL!\n");
		}
		

	}
}
