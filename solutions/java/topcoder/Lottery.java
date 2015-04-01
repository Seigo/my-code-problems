package topcoder;

public class Lottery {
	
	/**
	 * Rule format: "CHOICES BLANKS SORTED UNIQUE"
	 *  - "CHOICES" is the highest valid number: 1, 2, .., CHOICES
	 *  - "BLANKS" is the number of spot on the ticket that can be written
	 *  - "SORTED" true means the ticket numbers must be in non-descending order
	 *  - "UNIQUE" true means each ticket number must be distinct 
	 * 
	 * @param rules
	 * @return
	 */
	public String[] sortByOdds(String[] rules) {
		if (rules.length < 1) {
			String[] empty = {}; 
			return empty;
		}
			
		String[][] odds = new String[rules.length][2];
				
		for (int rule = 0; rule < rules.length; rule++) {
			String[] ruleParts = rules[rule].split(":");
			String ruleName = ruleParts[0];
			String[] rulePredicate = ruleParts[1].trim().split(" ");
			
			int choices = Integer.parseInt(rulePredicate[0]);
			int blanks = Integer.parseInt(rulePredicate[1]);
			boolean sorted = "T".equals(rulePredicate[2]) ? true : false;
			boolean unique = "T".equals(rulePredicate[3]) ? true : false;
			
			long ruleOdds = choices;
			
			for (int i = 0; i < blanks - 1; i++) {
				ruleOdds *= choices;
			}
			
			if (sorted && unique) {
				long invalidCombinations = 0;
								
				for (int r = 0; r < blanks - 1; r++) {
					long innerInvalids = 0;
					for (int p = 0; p < choices; p++) {
						innerInvalids += (p * Math.pow(choices, blanks-r-2) * Math.pow(choices - p, r)) 
								+ Math.pow(choices, blanks-r-2);
					}
					
					invalidCombinations += innerInvalids;
				}

				ruleOdds -= invalidCombinations;

			} else if (sorted) {
				long invalidCombinations = 0;
				
				for (int r = 0; r < blanks - 1; r++) {
					long innerInvalids = 0;
					for (int p = 0; p < choices; p++) {
						innerInvalids += (p * Math.pow(choices, blanks-r-2) * Math.pow(choices - p, r));
					}
					
					invalidCombinations += innerInvalids;
				}

				ruleOdds -= invalidCombinations;

			} else if (unique) {
				long invalidCombinations = 0;
				
				for (int r = 0; r < blanks - 1; r++) {
					long innerInvalids = 0;
					for (int p = 0; p < choices; p++) {
						innerInvalids += Math.pow(choices, blanks-r-2);
					}
					
					invalidCombinations += innerInvalids;
				}

				ruleOdds -= invalidCombinations;
				
			}
			
			insertIntoOdds(odds, ruleOdds, ruleName);
		}
						
		String[] sortedOdds = new String[rules.length];
		for (int i = 0; i < sortedOdds.length; i++) {
			sortedOdds[i] = odds[i][1];
		}
		
		return sortedOdds;
	}
	
	private void insertIntoOdds(String[][] odds, long ruleOdds, String ruleName) {
		for (int i = 0; i < odds.length; i++) {
			if (odds[i][0] == null) {
				odds[i][0] = Long.toString(ruleOdds);
				odds[i][1] = ruleName;
				break;
//			} else if (ruleOdds == Long.parseLong(odds[i][0])) {
				
			} else if (ruleOdds < Long.parseLong(odds[i][0])) {
				for (int j = odds.length - 1; j > i; j--) {
					odds[j][0] = odds[j-1][0];
					odds[j][1] = odds[j-1][1];
				}
				odds[i][0] = Long.toString(ruleOdds);
				odds[i][1] = ruleName;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Lottery lottery = new Lottery();
	
//		String[] example1 = {
//			"PICK ANY TWO: 10 2 F F",
//			"PICK TWO IN ORDER: 10 2 T F",
//			"PICK TWO DIFFERENT: 10 2 F T",
//			"PICK TWO LIMITED: 10 2 T T"
//			};
//		
//		String[] example1Results = lottery.sortByOdds(example1);
//		if (example1Results[0].equals("PICK TWO LIMITED") &&
//			example1Results[1].equals("PICK TWO IN ORDER") &&
//			example1Results[2].equals("PICK TWO DIFFERENT") &&
//			example1Results[3].equals("PICK ANY TWO")) {
//			System.out.println("Example 1: OK!");
//		} else {
//			System.out.println("Example 1: Incorrect output..");
//			
//			if (!example1Results[0].equals("PICK TWO LIMITED")) { System.out.println("Expected \'PICK TWO LIMITED\', actual: "+ example1Results[0]); }
//			if (!example1Results[1].equals("PICK TWO IN ORDER")) { System.out.println("Expected \'PICK TWO IN ORDER\', actual: "+ example1Results[1]); }
//			if (!example1Results[2].equals("PICK TWO DIFFERENT")) { System.out.println("Expected \'PICK TWO DIFFERENT\', actual: "+ example1Results[2]); }
//			if (!example1Results[3].equals("PICK ANY TWO")) { System.out.println("Expected \'PICK ANY TWO\', actual: "+ example1Results[3]); }
//		}
//		
		String[] example2 = {
			"INDIGO: 93 8 T F",
			"ORANGE: 29 8 F T",
			"VIOLET: 76 6 F F",
			"BLUE: 100 8 T T",
			"RED: 99 8 T T",
			"GREEN: 78 6 F T",
			"YELLOW: 75 6 F F"
			};
		
		String[] example2Results = lottery.sortByOdds(example2);
		if (example2Results[0].equals("INDIGO") &&
			example2Results[1].equals("ORANGE") &&
			example2Results[2].equals("VIOLET") &&
			example2Results[3].equals("BLUE") &&
			example2Results[4].equals("RED") &&
			example2Results[5].equals("GREEN") &&
			example2Results[6].equals("YELLOW")) {
			System.out.println("Example 2: OK!");
		} else {
			System.out.println("Example 2: Incorrect output..");

			if (!example2Results[0].equals("RED")) { System.out.println("Expected \'RED\', actual: "+ example2Results[0]); }
			if (!example2Results[1].equals("ORANGE")) { System.out.println("Expected \'ORANGE\', actual: "+ example2Results[1]); }
			if (!example2Results[2].equals("YELLOW")) { System.out.println("Expected \'YELLOW\', actual: "+ example2Results[2]); }
			if (!example2Results[3].equals("GREEN")) { System.out.println("Expected \'GREEN\', actual: "+ example2Results[3]); }
			if (!example2Results[4].equals("BLUE")) { System.out.println("Expected \'BLUE\', actual: "+ example2Results[4]); }
			if (!example2Results[5].equals("INDIGO")) { System.out.println("Expected \'INDIGO\', actual: "+ example2Results[5]); }
			if (!example2Results[6].equals("VIOLET")) { System.out.println("Expected \'VIOLET\', actual: "+ example2Results[6]); }
		}
	}
}