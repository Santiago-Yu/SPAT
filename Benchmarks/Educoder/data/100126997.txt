package step5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Map<String, Integer> menuDict = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			menuDict.put(sc.next(),sc.nextInt());
		}
		/********** Begin **********/
		menuDict.put("lamb", 50);
		System.out.println(menuDict.get("fish"));
		menuDict.put("fish", 100);
		menuDict.remove("noodles");
		System.out.println(menuDict.toString());
		/********** End **********/
	}
	
}
