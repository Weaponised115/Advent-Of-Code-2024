import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/The Wraith/eclipse-workspace/AOCDay2/src/file2.txt");
		Scanner scanner = new Scanner(file);
		StringBuilder str = new StringBuilder();
		ArrayList<int[]> List = new ArrayList<int[]>();
		
		while(scanner.hasNextLine()) {
			str.append(scanner.nextLine()).append(System.lineSeparator()).append(System.lineSeparator());
		}
		
		String strReports = str.toString();
		strReports = strReports.replaceAll(System.lineSeparator(), ",").replaceAll(" ", "-");

		String[] reportArray = strReports.split(",,");
		int[][] reports = new int[reportArray.length][];
		
		
		
		for (int i = 0; i < reports.length; i++) {
			String[] tempArray = reportArray[i].split("-");
			reports[i] = new int[tempArray.length];
			
			for(int j = 0; j < tempArray.length; j++) {
				
				reports[i][j] = Integer.parseInt(tempArray[j]);
			}
		}
		
		
		for (int i =0; i<reports.length; i++) {
			List.add(reports[i]);
		}
		
		

		int total = 0;

		for(int i =0; i<reports.length; i++) {
			
			boolean reportIncreasing = true;
			boolean noUnsafesFound = true;
			
			for(int j=0; j< reports[i].length - 1; j++){
				int diff = Math.abs(reports[i][j] - reports[i][j+1]);
				if(reports[i][j] > reports[i][j+1] && diff >=1 && diff <=3) {
					if(j == 0){
						reportIncreasing = true;
					}
					if(j > 0 && !reportIncreasing){
						noUnsafesFound = false;
					}
					
					} else if(reports[i][j] < reports[i][j+1] && diff >=1 && diff <=3) {
						
						if(j == 0){
							reportIncreasing = false;
						}
						if(j > 0 && reportIncreasing){
							noUnsafesFound = false;
					}
					} else {
						noUnsafesFound = false;
						System.out.println("List " + Arrays.toString(reports[i]) + " is wrong");
					}
				}
			if(noUnsafesFound){
				total += 1;
			}
		}
		System.out.println(total);
	}
}
