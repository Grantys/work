public class ValidationMethodes {

	// Checks whether the input is Arabic number or not
    public boolean isNumeric(String input) {
        try {
        	// If we can convert it into an integer, than it is Arabic number
            Integer.parseInt(input);
            return true;
        }	// If not than it's a Roman number
        catch (NumberFormatException e) {
            return false;
        }
    }
    // Checks whether the entered Arabic number is valid
    public boolean isValidArabic(int x) {
    	
        String num = String.valueOf(x);

        // Checks each character if it is a digit.
        for (int k = 0; k < num.length(); k++) {
            if (Character.isDigit(num.charAt(k)) == false) {
                return false;
            }
        }

        // Checks the if the number is in the correct interval
        if (x < 1 || x > 3999) {
            return false;
        }
        return true;

    }
    // Checks whether the entered Roman number is valid
    public boolean isValidRoman(String num) {
    	
    	String number = num.toUpperCase();
    	// Checks Roman Characters
        for (int k = 0; k < num.length(); k++) {
            if (number.charAt(k) != 'I' &&
                    number.charAt(k) != 'V' &&
                    number.charAt(k) != 'X' &&
                    number.charAt(k) != 'L' &&
                    number.charAt(k) != 'C' &&
                    number.charAt(k) != 'D' &&
                    number.charAt(k) != 'M') {
                return false;
            }
        }
        return true;
    }
}

