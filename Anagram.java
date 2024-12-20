/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String first = preProcess(str1);
		String second = preProcess(str2);
		if ((first.length())!=(second.length())){
			return false;
		}
		for (int i = 0; i < first.length(); i++) {
        char c = first.charAt(i); 
        int index = second.indexOf(c); //
        if (index == -1) {
            return false;
		}
		second = second.substring(0, index) + second.substring(index + 1);
		}	
		return true;
	}   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String clean = ""; 
   
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i); 
        if (Character.isLetter(c)) { 
            clean = clean + Character.toLowerCase(c); 
        }
    }
    return clean; // Return the cleaned-up string
}
	
	
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String input = str;
		String output = "";
		java.util.Random random = new java.util.Random();
		while (input.length()>0){
			int index = random.nextInt(input.length());
			char picked = input.charAt(index);
			output = output + picked;
			input = input.substring(0, index) + input.substring(index + 1);
		}
		return output;
	}
}