package lifesum;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LadderLengthCalculator {

	private int calculate(int wallHeight, int degrees) {
		return (int) Math.ceil(wallHeight / Math.sin(Math.toRadians(degrees)));
	}
	
	public static void main(String[] args) {
//		if (args.length != 1) {
//			System.out.println("Wrong number of arguments!");
//			System.exit(1);
//		}
		
		File testFile = new File(args[0]);
		
		assert testFile.canRead();
		
		List<String> fileLines = null;
		try {
			fileLines = Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		if (fileLines == null || fileLines.size() != 1) {
//			System.out.println("Wrong number of lines in file: " + args[0]);
//			System.exit(2);
//		}
		String inputLine = fileLines.get(0);
		inputLine = inputLine.replace("\r", "")
				.replace("\n", "")
				.trim();
		String[] inputs = inputLine.split(" ");
		
		int wallHeight = Integer.parseInt(inputs[0]);
		int degrees = Integer.parseInt(inputs[1]);
		
		LadderLengthCalculator calculator = new LadderLengthCalculator();
		int result = calculator.calculate(wallHeight, degrees);
		
		System.out.println(result);
	}
	
	public static void mainReceivingInArgs(String[] args) {
		if (args.length != 2) {
			System.out.println("Wrong number of arguments!");
			System.exit(1);
		}
		
		int wallHeight = Integer.parseInt(args[0]);
		int degrees = Integer.parseInt(args[1]);
		
		LadderLengthCalculator calculator = new LadderLengthCalculator();
		int result = calculator.calculate(wallHeight, degrees);
		
		System.out.println(result);
	}
	
	public static void mainReceivingInStandardInput(String[] args) {
//		System.out.println("Program initialized.");
		
		LadderLengthCalculator calculator = new LadderLengthCalculator();
		
		int ladderLengthTest = calculator.calculate(500, 70);
		if (ladderLengthTest != 533) {
			System.out.println("Test 1 failed: expected 533 but received " + ladderLengthTest);			
		}
		ladderLengthTest = calculator.calculate(1000, 10);
		if (ladderLengthTest != 5759) {
			System.out.println("Test 2 failed: expected 5759 but received " + ladderLengthTest);			
		}

		String buffer = "";

		while (true) {
			try {				
				char dataByte = (char) (System.in.read() & 0xFF);

				buffer += dataByte;

				if (dataByte != '\n') {
					continue;
				}
				buffer = buffer.replace("\r", "");
				buffer = buffer.replace("\n", "");

//				System.out.println("Input received: " + buffer);
				String[] input = buffer.split(" ");
								
				if (input.length != 2)  {
					System.out.println("Wrong number of arguments!");
					continue;
				}
				
				int wallHeight = Integer.parseInt(input[0]);
				int degrees = Integer.parseInt(input[1]);
				
				int result = calculator.calculate(wallHeight, degrees);
				
				System.out.println(result);

				buffer = "";
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				buffer = "";
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				buffer = "";
			}
		}
	}
}
