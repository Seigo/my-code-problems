import java.util.ArrayList;
import java.util.Collection;

/**
 * 

Given 2 arrays
   A: ["pear", "pineapple", "apple", "orange", "melon", "coconut"]
   R: ["banana", "orange", "apple"]

sort A like this:
- elements in R comes first, in the order of appearance
- alphabetically for other elements

the example should be sorted to: ["orange", "apple", "coconut", "melon", "pear", "pineapple"]

 * 
 * */

public class MySorter {

	public ArrayList<String> sort2(ArrayList<String> arrayA, ArrayList<String> arrayB) {
		ArrayList<String> sorted = new ArrayList<String>();
		
		for (int i = 0; i < arrayB.size(); i++) {
			for (int j = 0; j < arrayA.size(); j++) {
				if (arrayB.get(i).equals(arrayA.get(j))) {
					sorted.add(arrayB.get(i));
					arrayA.remove(j);
				}
			}
		}
		
//		sorted.addAll(dumbishSort(arrayA));
		sorted.addAll(slightlyLessDumbSort(arrayA));
		
		return sorted;
	}
	
	private Collection<? extends String> slightlyLessDumbSort(
			ArrayList<String> arrayA) {
		boolean switchOccurred = false;
		
		for (int i = 0; i < arrayA.size(); i++) {
			if (i == arrayA.size() - 1) {
				if (switchOccurred) {
					i = -1;
					switchOccurred = false;
				} else {
					return arrayA;
				}
			} else if (compare(arrayA.get(i), arrayA.get(i+1)) > 0) {
				switchStr(arrayA, i, i+1);
				switchOccurred = true;
			}
		}
		
		return null;
	}

	private Collection<? extends String> dumbishSort(ArrayList<String> arrayA) {

		for (int i = 0; i < arrayA.size() - 1; i++) {
			if (compare(arrayA.get(i), arrayA.get(i+1)) > 0) {
				switchStr(arrayA, i, i+1);
				i = -1;
			}
		}
		
		return arrayA;
	}

	private void switchStr(ArrayList<String> arrayA, int i, int j) {
		String iStr = arrayA.get(i);
		arrayA.set(i, arrayA.get(j));
		arrayA.set(j, iStr);
		System.out.println("Switched " + arrayA.get(i) + " for " + arrayA.get(j));
	}

	private int compare(String string1, String string2) {
		System.out.println("Comparing " + string1 + " with " + string2);
		return string1.compareTo(string2);
	}

	public static void main(String[] args) {

		byte digit = '0';
		byte digit2 = '1';
		byte baite = (byte) ("l1la".charAt(1) - 48);
		
		System.out.print("num is " + baite);
		
		return;
		
//		System.out.println("Sorting...");
//
////		String[] a = {"pear", "pineapple", "apple", "orange", "melon", "coconut"};
//		String[] a = {"pear", "pineapple", "apple", "orange", "melon", "coconut", "avocado", "alface", "abobora"};
//		String[] b = {"banana", "orange", "apple"};
//		String[] answer = {"orange", "apple", "abobora", "alface", "avocado", "coconut", "melon", "pear", "pineapple"};
//		
//		ArrayList<String> arrayA = new ArrayList<String>();
//		for (int i = 0; i < a.length; i++) {
//			arrayA.add(a[i]);
//		}
//		ArrayList<String> arrayB = new ArrayList<String>();
//		for (int i = 0; i < b.length; i++) {
//			arrayB.add(b[i]);
//		}
//
//		MySorter sorter = new MySorter();
//		long startMillis = System.currentTimeMillis();
//		long endMillis = 0L;
//		ArrayList<String> sorted = sorter.sort2(arrayA, arrayB);
//		endMillis = System.currentTimeMillis();
//		String strSorted = "[";
//		String ok = "OK! ";
//		
//		for (int i = 0; i < sorted.size(); i++) {
//			if (!sorted.get(i).equals(answer[i])) {
//				ok = "Wrong answer.. ";
//			}
//			strSorted += sorted.get(i) + ", ";
//		}
//		strSorted += "]";
//		strSorted = strSorted.replace(", ]", "]");
//		System.out.println(ok + strSorted);
//		System.out.println("Sorted in " + (endMillis - startMillis) + " millis");
		
	}
}
