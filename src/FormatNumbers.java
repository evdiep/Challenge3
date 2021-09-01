import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class FormatNumbers {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> outputList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line; 
		System.out.println("Enter 1 for a Phone# and 2 for a SSN, followed by the number on a new line");
		
		while(true) {
			line = br.readLine();
			if(line.equals("Q")) {
				break;
			}
			if(line.equals("1")) {
				line =br.readLine();
				if(line.length()!=10 || !line.matches("[0-9]+")) {
					if (line.equals("Q"))
						break;
					outputList.add("Error! Phone numbers should be 10 digits long.");
				}
				else {
					outputList.add(
						String.format(
								"(%s)", line.substring(0, 3))+line.substring(3, 6)+"-"+line.substring(6, 10)
					);
				}
			}
			else if(line.equals("2")) {
				line =br.readLine();
				if(line.length()!=9 || !line.matches("[0-9]+")) {
					if (line.equals("Q"))
						break;
					outputList.add("Error! Social security numbers should be 9 digits long.");
				}
				else{
					outputList.add(
						line.substring(0, 3)+"-"+line.substring(3,5)+"-"+line.substring(5,9)
						);
				}
			}
			else {
				outputList.add("Error! Input should either be 1 for a phone number or 2 for a SSN or Q to quit.");
			}
		}
		for(String output: outputList) {
			System.out.println(output);
		}
	}
}
