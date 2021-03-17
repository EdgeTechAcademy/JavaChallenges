import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static Scanner sc = new Scanner(System.in);
    static String[] lines = Utils.readLines("C:/Projects/csv/Dictionaries/10KWords.txt");

    /**
     * 		getInput	-	Prompt the user to type something in the console window
     *
     * @param prompt		String - The message telling the user what to enter
     * @return				String - The users response
     */
    public static String getInput(String prompt) {
        String response;					//	will hold the response from the user
        System.out.print(prompt);			//	hey user - give me some information
        response = sc.nextLine();			//	I will wait here until you type something
        return response;					//	much thanks I will return this to the calling method
    }

    /**
     * 	getDouble		-	Prompt the user to respond with a number
     *
     * @param prompt		String - The message telling the user what to enter
     * @return				double - The users response converted to a number
     */
    public static double getDouble(String prompt) {
        double number = 0;							//	will hold the numeric response from the user
        String response;						//	the String user response that needs to be converted to a number
        do {									//	infinite do-while until the user enters a number
            response = getInput(prompt);		//	ask user for a response
            try {								//	protect the code from dieing if we don't get a number from the user
                number = Double.parseDouble(response);	//	convert to a number
                break;							//	Yay! The user gave us a valid number
            } catch (NumberFormatException e) {			//	bad news. We did not get a number
                System.out.println( response + " Is not a number");		//	warn the user and continue prompting
            }
        } while(true);							//	stay in the loop until we get a number from the user
        return number;							//	yes this could go after the parseDouble, I like all methods to end at the bottom
    }

    /**
     * 	getNumber		-	Prompt the user to respond with a number
     *
     * @param prompt		String - The message telling the user what to enter
     * @return				int - The users response converted to a number
     */
    public static int getNumber(String prompt) {
        int number = 0;							//	will hold the numeric response from the user
        String response;						//	the String user response that needs to be converted to a number
        do {									//	infinite do-while until the user enters a number
            response = getInput(prompt);		//	ask user for a response
            try {								//	protect the code from dieing if we don't get a number from the user
                number = Integer.parseInt(response);	//	convert to a number
                break;							//	Yay! The user gave us a valid number
            } catch (NumberFormatException e) {			//	bad news. We did not get a number
                System.out.println( response + " Is not a number");		//	warn the user and continue prompting
            }
        } while(true);							//	stay in the loop until we get a number from the user
        return number;							//	yes this could go after the parseInt, I like all methods to end at the bottom
    }

    /**
     *
     * 	getNumber		-	Prompt the user to respond with a number less than or equal to max
     *
     * @param prompt		String - The message telling the user what to enter
     * @param max			int - max number the user can enter
     * @return				int - The users response converted to a number
     */
    public static int getNumber(String prompt, int max) {
        int number = 0;							//	will hold the numeric response from the user
        do {									//	infinite do-while until the user enters a number
            number = getNumber(prompt);			//	ask user for a response
            if (number >= 0 && number <= max)	//	if number is between 0 and max we have a good number
                break;							//	now we can exit out loop
            System.out.println(number + " is not between 0 and " + max);
        } while (true);	//	stay at it until the user enters a proper number
        return number;							//	yay, we have our number
    }

    /**
     * FileToList
     * We read the entire file into memory. Each line is saved to a String which is added to a ListArray
     *
     * @param from file to be read
     * @return return a list of lines of the file read
     */
    public static List<String> FileToList(String from) {
        //  list is the variable that will hold the file we are reading
        List<String> list = new ArrayList<>();
        String line;

        //  convert the string of the file name in to a File object
        File fin = new File(from);
        try {
            //  Construct BufferedReader from FileReader
            //  The BufferedReader is designed to read line based text from a file
            BufferedReader br = new BufferedReader(new FileReader(fin));

            //  while there is data to be read
            while ((line = br.readLine()) != null) {
                //  add each line to the list
                list.add(line);
            }
            //  close the file
            br.close();
        } catch (IOException e) {
            System.out.println("File IO error on read: " + e);
        }

        //  return the list of text lines
        return list;
    }           //  end of FileToList

    public static int convertToInt(String num) {
        int number;
        try {								//	protect the code from dieing if we don"t get a number from the user
            number = Integer.parseInt(num);	//	convert to a number
        } catch (NumberFormatException e) {			//	bad news. We did not get a number
            number = 0;		//	warn the user and continue prompting
        }
        return number;
    }

    public static float convertToFloat(String num) {
        float number;
        try {								//	protect the code from dieing if we don"t get a number from the user
            number = Float.parseFloat(num);	//	convert to a number
        } catch (NumberFormatException e) {			//	bad news. We did not get a number
            number = 0;		//	warn the user and continue prompting
        }
        return number;
    }

    /**
     * getIntArray
     * Create an integer array with 20-40 elements and fill it with random numbers between 0 and 100
     *
     * @return an int array of random numbers
     */
    public static int[] getIntArray() {
        int size = getRandomNum(10) + 10;               //  keep it less the 20 numbers but at least 10
        int[] randomNumbers = new int[size];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = getRandomNum(100);       //  just numbers between 0 and 99 inclusive
        }
        return randomNumbers;
    }

    public static int getRandomNum(int max) {
        return (int) (Math.random() * max);     //  numbers between 0 and max-1 inclusive
    }

    /**
     * getStrArray
     * Create a String array with 10-30 elements and fill it with random Strings between A-Z, a-z, 0-9, ' '
     *
     * @return an int array of random numbers
     */
    public static String[] getStrArray() {
        int size = (int) (Math.random() * 30) + 10;
        String[] randomStrings = new String[size];
        for (int i = 0; i < randomStrings.length; i++) {
            randomStrings[i] = getRandomString();
        }
        return randomStrings;
    }

    /**
     * getRandomString
     * Create a random sized string between 10 and 70 characters long
     */
    public static String getRandomString() {
        String src = "abcde fghijklmn opqrs tuvwx yz0 12345 6789AB CDEFGH IJKLMNOPQ RSTUV WXYZ";
        String strOut = "";

        int size = (int) (Math.random() * 60) + 10;
        for (int i = 0; i < size; i++) {
            int z = (int) (Math.random() * src.length());
            if ( src.charAt(z) == ' ')      //  if the next character is a space
                strOut = strOut.trim();     //  trim the string to not allow double spaces
            strOut += src.charAt(z);
        }
        return strOut.trim();
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static String[] readLines(String fileName) {
        try {
            return readFile(fileName).split("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //  read the list of 10,000 words and randomly chosen some to add to a String array
    public static String[] getRandomWords() {
        int size = (int) (Math.random() * 20) + 10;
        String[] randomWords = new String[size];

        for (int i = 0; i < size; i++) {
            randomWords[i] = getRandomWord();
        }

        return randomWords;
    }

    //  read the list of 10,000 words and randomly chosen some to add to a String array
    public static String getRandomLine() {
        return String.join(" ", getRandomWords());
    }


    //  read the list of 10,000 words and randomly chosen some to add to a String array
    public static String getRandomWord() {
        return lines[getRandomNum(lines.length)];
    }

    public static void main(String[] args) {
        int max, number;
        int[] intAr = getIntArray();
        String str = getRandomString();
        System.out.println("strAr = " + str);
        for ( int x : intAr) {
            if ( x % 2 == 0) {
                System.out.println("Even " + x);
            }
        }
        do {
            max = getNumber("Enter Maximum number: ");						//	ask user for a maximum number
            number = getNumber("Enter a number <= to " + max + ": ", max);	//	test code to see if we can only enter numbers < max
            //	yay, here is the users response
            System.out.println("User entered: " + number + " which is less than or equal to " + max);
        }	while (number != 0);
    }
}
