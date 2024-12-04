import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class DayThree {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/The Wraith/eclipse-workspace/AOCDay3/src/file3.txt");
		Scanner scanner = new Scanner(file);
		StringBuilder str = new StringBuilder();
		
		while (scanner.hasNextLine()) {
			str.append(scanner.nextLine()).append("---");
		}
		String fullStr = str.toString();
		
		String[] section = fullStr.split("---");
	
		
		
		String target = "mul\\(\\d{1,3},\\d{1,3}\\)";
		Pattern pattern = Pattern.compile(target);
		int result = 0;
		
		for(int i = 0; i< section.length; i++) {
			Matcher matcher = pattern.matcher(section[i]);
			while (matcher.find()) {
				int start = matcher.start();
				int end = matcher.end();
				String match = section[i].substring(start,end);
				match = match.replace("mul","").replace("(", "").replace(")", "");
				String [] matchSplit = match.split(",");
				int[] digits = new int[matchSplit.length];
				for(int j=0; j<digits.length;j++) {
					digits[j] = Integer.parseInt(matchSplit[j]);
				}
				result += arrayMulti(digits);
			}
		}
		System.out.println(result);
	}
	
	public static int arrayMulti(int[] arr) {
        int result = 1; 
        for (int num : arr) {
            result *= num; 
        }
        return result;
    }
}


//	if the text has a "mul" take that