package topcoder;

public class ImageDithering {
	public int count(String dithering, String[] screen) {
		int count = 0;
		for (int line = 0; line < screen.length; line++) {
			for (int pixel = 0; pixel < screen[line].length(); pixel++) {
				for (int ditheringElem = 0; ditheringElem < dithering.length(); ditheringElem++) {
					if (screen[line].charAt(pixel) == dithering.charAt(ditheringElem)) {
						count++;
						break;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String dithered = "BW";
		String[] screen = {"AAAAAAAA",
			 "ABWBWBWA",
			 "AWBWBWBA",
			 "ABWBWBWA",
			 "AWBWBWBA",
			 "AAAAAAAA"
		};
		
		ImageDithering imageDithering = new ImageDithering();
		
		System.out.println(imageDithering.count(dithered, screen));
		
		String dithered2 = "ACEGIKMOQSUWY";
		String[] screen2 = {"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
		 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};
		
		System.out.println(imageDithering.count(dithered2, screen2));
	}
}