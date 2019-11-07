package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<String, Integer>();
		
		System.out.print("Enter file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				String candidate = line.split(",")[0];
				int numVotes = Integer.parseInt(line.split(",")[1]);
				
				if (votes.containsKey(candidate)) {
					numVotes += votes.get(candidate);
				}
				
				votes.put(candidate, numVotes);
				
				line = br.readLine();
			}
			
			System.out.println();
			System.out.println("VOTES SUMMARY");
			
			for (String c : votes.keySet()) {
				System.out.printf("%s: %d%n", c, votes.get(c));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
