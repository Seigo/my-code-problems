package topcoder;

public class YahtzeeScore {
	public int maxPoints(int[] toss) {
		int highestScore = 0;
		int[] sumForDiceFace = {0,0,0,0,0,0};
		for (int tossed = 0; tossed < toss.length; tossed++) {
			int face = toss[tossed] - 1;
			sumForDiceFace[face] += toss[tossed];
			if (sumForDiceFace[face] > highestScore) {
				highestScore = sumForDiceFace[face];
			}
		}
		return highestScore;
	}
}