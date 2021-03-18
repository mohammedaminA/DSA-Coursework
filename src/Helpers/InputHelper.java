/**
 * Allows the user to input data and handles potential errors from user
 */
package Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @ author MohammedaminS
 */
public class InputHelper {
    private final Scanner reader;

    /**
     *
     */
    public InputHelper() {
        reader = new Scanner(System.in);
    }

    // Read Character

    /**
     *
     * @param prompt
     * @return
     */
    public char readCharacter(String prompt) {

        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    // Read Character - set of valid values

    /**
     *
     * @param prompt
     * @param validCharacters
     * @return
     */
    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    // Read String

    /**
     *
     * @param prompt
     * @return
     */
    public String readString(String prompt) {

        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    // Read Int

    /**
     *
     * @param prompt
     * @param max
     * @param min
     * @return
     */
    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    // Read Int

    /**
     *
     * @param prompt
     * @return
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    // Read Date

    /**
     *
     * @param prompt
     * @param format
     * @return
     */
    public String readDate(String prompt) {
		String inputText;
		boolean inputError;
		do {
			inputError = false;
			System.out.println(prompt + ": ");

			inputText = reader.nextLine();
			String[] a = inputText.split(inputText);
			for (String c: a) {
				if (c.isBlank() && c.isEmpty()) {
					inputError = true;
					System.out.println("Invalid entry. Please re-enter: ");
				}
			}
			for (char c: inputText.toCharArray()) {
				if (Character.isAlphabetic(c)) {
					inputError = true;
					System.out.println("Contains alphabets. Please re-enter: ");
				}
			}
		} while ( inputError );
		return inputText;
	}

}
