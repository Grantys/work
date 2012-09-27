import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Converter {

	public static void main(String[] args) {

		ValidationMethodes vMethode = new ValidationMethodes();
		ConvertMethodes cMethode = new ConvertMethodes();

		try {

			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				strLine = strLine.trim();
				if (strLine.isEmpty() || (strLine == null)) {
					break;
				}

				boolean response = vMethode.isNumeric(strLine);
				if (response) {
					String Converted = cMethode.toRoman(Integer
							.parseInt(strLine));
					// Check if the return is null or not
					if (Converted == null) {
						System.out.println(strLine
								+ " is not a valid, can't be converted!");
					} else {
						System.out.println(strLine + " is converted to "
								+ Converted);
					}
				} else {
					String Converted = cMethode.toArabic(strLine);
					if (Converted == null) {
						System.out.println(strLine
								+ " is not a valid, can't be converted!");
					} else {
						System.out.println(strLine + " is converted to "
								+ Converted);
					}
				}
			}

			in.close();
		} catch (Exception e) {
			// System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
