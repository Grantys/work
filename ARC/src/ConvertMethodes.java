import java.util.HashMap;
import java.util.Map;

public class ConvertMethodes {

	// Create Instance of the ValidationMethodes
	ValidationMethodes vMethode = new ValidationMethodes();

	public String toRoman(int num) {

		// Validation check
		if (vMethode.isValidArabic(num)) {
			// This will be our result string.
			// StringBuffer can be used, but I used this way because it's not a
			// big Application
			String Roman = "";

			// Declare and Initiate our Arrays
			String onesArray[] = { "I", "II", "III", "IV", "V", "VI", "VII",
					"VIII", "IX" };
			String tensArray[] = { "X", "XX", "XXX", "XL", "L", "LX", "LXX",
					"LXXX", "XC" };
			String hundredsArray[] = { "C", "CC", "CCC", "CD", "D", "DC",
					"DCC", "DCCC", "CM" };

			// Get the ones in the number
			int ones = num % 10;

			// Get the tens in the number
			num = (num - ones) / 10;
			int tens = num % 10;

			// Get hundreds
			num = (num - tens) / 10;
			int hundreds = num % 10;

			// Get and write thousands
			num = (num - hundreds) / 10;
			for (int i = 0; i < num; i++) {
				Roman += "M";
			}

			// Write hundreds
			if (hundreds >= 1) {
				Roman += hundredsArray[hundreds - 1];
			}

			// Write tens
			if (tens >= 1) {
				Roman += tensArray[tens - 1];
			}

			// Write ones
			if (ones >= 1) {
				Roman += onesArray[ones - 1];
			}

			// Return the string
			return String.valueOf(Roman);
		} else {
			return null;
		}
	}

	public String toArabic(String s) {

		String arab = null;

		if (vMethode.isValidRoman(s)) {

			ConvertMethodes convert = new ConvertMethodes();
			// Creating a MAP 
			Map<String, Integer> relations = new HashMap<String, Integer>();
			// Populating the map using the Arabic to Roman convert methode
			for (int i = 0; i < 4000; i++) {
				String roman = convert.toRoman(i);
				relations.put(roman, i);

			}
			if (relations.containsKey(s)) {
				Integer data = relations.get(s);
				arab = Integer.toString(data);
			}

		}
		// returning the Arabic form of the Roman number
		return arab;
	}

}
