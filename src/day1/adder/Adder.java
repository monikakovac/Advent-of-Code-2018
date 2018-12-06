package day1.adder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Adder {

	public static void main(String[] args) {
		
		List<Integer> numbers = null;
		try {
			numbers = Files.lines(Paths.get("src/day1/data/numbers.txt")).map(Integer::valueOf).collect(Collectors.toList());
		} catch (IOException e) {
			System.err.println("The file was not found.");
		}
		
		firstPart(numbers);	
		secondPart(numbers);
		
	}

	private static void firstPart(List<Integer> numbers) {
		System.out.println("Result is: " + numbers.stream().collect(Collectors.summingInt(Integer::intValue)));
	}
	
	private static void secondPart(List<Integer> numbers) {
		int result = 0;
		Set<Integer> set = new TreeSet<>();
		while (!set.contains(result)) {
			for(int num : numbers) {
				set.add(result);
				result += num;
				if(set.contains(result)) {
					System.out.println("First frequency that appears twice is: " + result);
					break;
				}
			}
		
		}
	}
}
