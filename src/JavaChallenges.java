import java.util.Arrays;
import java.util.Calendar;

public class JavaChallenges {
    public static void main(String[] args) {
        //  I will use TODO in the comments to get your attention

        //  getIntArray will create a random length array with random numbers. It will generate different numbers each time
        int[] intAr = Utils.getIntArray();
        System.out.print("[");
        for(int num : intAr) System.out.print(num+", ");
        System.out.println("]");

        //      F.	Given a string create an array of the words in the string.
        String[] words = Utils.getRandomWords();
        System.out.print("[");
        for(String word : words) System.out.print(word+", ");
        System.out.println("]");

        int rand = Utils.getRandomNum(20);

        Q_A(intAr);                             //  A.	Given an array of integers find the largest, smallest and the average.
        Q_B(intAr);                             //  B.	Given an array of integers find the second largest and the second smallest.
        Q_C(intAr);                             //  C.	Given an array of integers return the total of all values.
        Q_D(intAr, Utils.getRandomNum(100));    //  D.	Given an array of integers return count of numbers > some value.
        Q_E(words);                             //  E.	Given an array of strings find the longest string.
        Q_G(rand);                              //  G.	Given a number print a square with that as the length and width of the sides.
        Q_H(rand);                              //  H.	Given a number print a tree shape.
        Q_I(words);                             //  I.	Given a string convert to an array words print words within a box.
        Q_J(words);                             //  J.	Given a string with a person’s name return a string of their initials
        Q_K();                                  //  K.	Generate two random numbers, between 10 and 25; loop from the first to the last.
        Q_L();                                  //  L.	Given a string print the individual characters front to back and back to front.
        Q_M();                                  //  M.	Given a string reverse it..ti esrever gnirts a neviG
        Q_N();                                  //  N.	Create a method to proper case all words in a string.
        Q_O();                                  //  O.	Create an Enum class for the Planets in the Solar System.
        Q_P();                                  //  P.	Given a Planet return the distance from the Sun. (Use your Planet Enum)
        Q_Q();                                  //  Q.	Create a Class for a Shoe. Must have at least 4 properties.
        Q_R();                                  //  R.	Create a base class with 3 properties, create a child class from that base class
        Q_S();                                  //  S.	Given a temperature return the type of clothing you should wear.
        Q_T();                                  //  T.	Given a distance in miles convert to kilometers.
        Q_U();                                  //  U.	Given a number calculate the date that many days in the future.
        Q_V();                                  //  V.	Loop 0 to 100, print Fizz if divisible by 3, Buzz if divisible by 5 and # otherwise
        Q_W();                                  //  W.	Find the sum of all the multiples of 3 or 5 below 1000.
        Q_X();                                  //  X.	Given two coordinates {x1, y1} and {x2, y2} what is the distance between them
        Q_Y();                                  //  Y.	Give the center coordinate of a circle {x, y} and the radius r, determine if a point {x1, y1} is inside the circle. (distance from x, y is < r)
        Q_Z();                                  //  Z.	Read a file from your hard drive and print the contents
    }

    static void Q_A(int[] intAr) {
        //  A.	Given an array of integers find the largest, smallest and the average.

        int     max, min;
        double  total = 0.0, average;

        max = min = intAr[0];       //  initialized the min and max vars to just the first element of the array
        for (int num : intAr) {
            total += num;
            max = Math.max(max, num);       //  TODO the same as doing       max = (max > num) ? max : num;     if (num > max) max = num;
            min = Math.min(min, num);       //  TODO or we could use         min = (min < num) ? min : num;     if (num < min) min = num;
        }

        average = total / intAr.length;
        System.out.println(min + " is the smallest number and " + max + " is the largest and the average is " + average);

        Arrays.sort(intAr);     //  if you don't changing the order of the values in the array
        System.out.println(intAr[0] + " is the smallest number and " + intAr[intAr.length-1] + " is the largest");

        //  TODO    now let's use the lambda expressions
        //      the getAsInt method is there because min, max and reduce all return an Optional value
        //      Java says this function MIGHT not return a value, it is optional. So we have to do an additional step
        //      to get the value. If we wanted to be very formal we would use
        //          OptionalInt smallest = Arrays.stream(intAr).min();
        //          if (smallest.isPresent()) {
        //              min = smallest.getAsInt();
        //          }

        min = Arrays.stream(intAr).min().getAsInt();        //  you can use min/max or 'reduce' the array which is more code
        max = Arrays.stream(intAr).max().getAsInt();
        min = Arrays.stream(intAr).reduce((minimun, next) -> next < minimun ? next : minimun ).getAsInt();
        max = Arrays.stream(intAr).reduce((maximum, next) -> next > maximum ? next : maximum ).getAsInt();
        average = Arrays.stream(intAr).average().getAsDouble();
        System.out.println(min + " is the smallest number and " + max + " is the largest and the average is " + average);
    }

    static void Q_B(int[] intAr) {
        //  B.	Given an array of integers find the second largest and the second smallest.

        //  getIntArray will create a random length array with random numbers. It will generate different numbers each time
        int min, min2nd, max, max2nd;
        min = min2nd = Integer.MAX_VALUE;       //  set the minimum numbers to the max possible
        max = max2nd = Integer.MIN_VALUE;       //  set the maximum to the smallest possible number
        for (int num : intAr) {
            //  find the largest and 2nd to the largest numbers
            if (num > max) {
                max2nd = max;
                max = num;
            }
            else if(num > max2nd && num < max) {    //  if the next num is between the 2nd largest and the largest
                max2nd = num;                       //  then it must be the new 2nd largest
            }

            //  do something similar to find the smallest and 2nd to the smallest numbers
            if (num < min) {
                min2nd = min;
                min = num;
            }
            else if(num < min2nd && num > min) {    //  if the next num is between the 2nd smallest and the smallest
                min2nd = num;                       //  then it must be the new 2nd smallest
            }
        }
        System.out.println(min2nd + " is the 2nd smallest number and " + max2nd + " is the 2nd largest");
    }

    static void Q_C(int[] intAr) {
        //  C.	Given an array of integers return the total of all values.
        int total = 0;
        for (int num : intAr) {
            total += num;
        }
        total = Arrays.stream(intAr).sum();
        total = Arrays.stream(intAr).reduce((tot, next) -> tot + next ).getAsInt();
        System.out.println("The total for the array is: " + total);
    }

    static void Q_D(int[] intAr, int max) {
        //  D.	Given an array of integers return count of numbers > some value.
        int count = 0;
        for (int num : intAr) {
            count += num > max ? 1 : 0;
        }
        count = (int)Arrays.stream(intAr).filter(num -> num > max).count();
        System.out.println("There are " + count + " numbers greater than " + max);
    }

    static void Q_E(String[] strAr) {
        //  E.	Given an array of strings find the longest string.
        String longStr = "";
        for (String str : strAr) {                      //  look at each string in the array
            if (str.length() > longStr.length())        //  if it is longer than the record holder
                longStr = str;                          //  then it becomes the new longest
        }
        System.out.println("The longest string is: " + longStr);

        //      now let's try it with a lambda expression
        longStr = (String)Arrays.stream(strAr).reduce((longest, next) -> next.length() > longest.length() ? next : longest).get();
        System.out.println("The longest string is: " + longStr);
    }

    static void Q_G(int size) {
        //  G.	Given a number print a square with that as the length and width of the sides.
        //      extra spaces added to make the square look square. Characters in the console are twice as tall as they are wide
        System.out.println("* ".repeat(size));          //  for(int i = 0; i < size; i++)   System.out.print("*");
        for (int i = 0; i < size-2; i++) {
            System.out.print("* ");                     //  System.out.print("\n*");
            System.out.print("  ".repeat(size - 2));    //  for(int i = 0; i < size; i++)   System.out.print(" ");
            System.out.print("*\n");                    //  System.out.print("*\n");
        }
        System.out.println("* ".repeat(size));          //  for(int i = 0; i < size; i++)   System.out.print("*");
    }

    static void Q_H(int howTall) {
        //  H.	Given a number print a tree shape.
        for (int i = 0; i < howTall;  i++) {
            for (int j = 0; j < howTall - i; j++) {         //  j number of spaces we need to the left
                System.out.print(" ");
            }
            for (int k = 0; k < i*2+1; k++) {               //  k is the number of asterisks used
                System.out.print("*");
            }
            System.out.println();                           //  kick out a blank linke
        }

        //  build the entire layer in one line of code
        for (int i = 0; i < howTall;  i++) {
            System.out.println(" ".repeat(howTall-i) + "*".repeat(i*2+1));
            //  System.out.print(" ".repeat(howTall-i));            //  this is a little more descriptive to see
            //  System.out.println("*".repeat(i*2+1));              //  it done in two lines
        }
    }

    static void Q_I(String[] strAr) {
        //  I.	Given a string convert to an array words print words within a box.

        //  get the longest string in our array
        String longStr = (String)Arrays.stream(strAr).reduce((longest, next) -> next.length() > longest.length() ? next : longest).get();
        int strLength = longStr.length();       //  get the length of that string

        //  the box needs to be 4 characters wider. We need a '*' and 1 space of padding on each end
        System.out.println("*".repeat(strLength+4));        //  print out the top of the box
        for (String str : strAr) {
            System.out.println("* " + str + " ".repeat(strLength-str.length()) + " *");
        }
        System.out.println("*".repeat(strLength+4));        //  now print out the bottom of the box
    }

    static void Q_J(String[] strAr) {
        //  J.	Given a string with a person’s name return a string of their initials
        //  our array of strings is already split. So we will skip that step
        String initials = "";
        for (String name : strAr) {
            initials += name.charAt(0);
        }
        System.out.println(initials.toUpperCase());

        //  the below stream/lambda expression is exact functionality as above
        initials = Arrays.stream(strAr).reduce("", (letters, str) -> letters + str.charAt(0));
        System.out.println(initials.toUpperCase());

        //  if you have a string with three name, you can use index to find the spaces separating the names
        String name = "Edge Tech Academy";
        int space1 = name.indexOf(" ") + 1;       //  indexOf will find the first space.
                                                  // The +1 gets the location of the 'T'
        int space2 = name.indexOf(" ", space1 + 1) + 1;     //  find the next space after the first space
                                                  //  the +1 gets the location of the 'A'
        initials = "" +name.charAt(0) + name.charAt(space1) + name.charAt(space2);
        System.out.println(initials);
    }

    static void Q_K() {
        //  K.	Generate two random numbers, between 10 and 25; loop from the first to the last.
        int start = (int) (Math.random() * 16) + 10;    //  *15 gives a number between 0 and 15.
                                                        // +10 moves the numbers from 10 to 25
        int end = (int) (Math.random() * 16) + 10;
        for (int i = start; i < end; i++) {             //  sometimes end will be less than start
            System.out.println("Loop index: " + i);     //  and the loop will do zero loops
        }
    }

    static void Q_L() {
        //  L.	Given a string print the individual characters front to back and back to front.
        String word = Utils.getRandomWord();
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i));
        }
        System.out.println();           //  kick out a blank line, since print does not print a \n

        for (int i = word.length()-1; i >= 0; i--) {        //  loop from the end of the word to the start
            System.out.print(word.charAt(i));
        }
        System.out.println();           //  kick out a blank line, since print does not print a \n
    }

    static void Q_M() {
        //  M.	Given a string reverse it..ti esrever gnirts a neviG
        String word = Utils.getRandomWord();
        String reverse;

        System.out.println(word);
        //  the old fashioned (probably fastest) way: loop backwards through the characters of the string
        reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }
        System.out.println(reverse);

        //  a little fancier: the StringBuilder object has some methods to do this.
        //  But first we have to convert the String to a StringBuilder
        reverse = (new StringBuilder(word).reverse()).toString();
        System.out.println(reverse);
    }

    static void Q_N() {
        //  N.	Create a method to proper case all words in a string.
        String properWord;
        String word = Utils.getRandomLine();
        System.out.println(word);

        System.out.println(properCase(word));
        System.out.println(properCaseReduce(word));
    }

    static String properCaseWord(String word) {
        return (" "+word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase();
    }
    static String properCase(String input) {
        String[] words = input.split(" ");
        String output = "";
        for (String word : words) {
            //  why this? (""+word.charAt(0))
            //  because charAt returns a char NOT a string.
            //  The ""+ forces the char to be converted to a String then permits us to upper case it
            output += properCaseWord(word);
        }
        return output.trim();
    }

    static String properCaseReduce(String input) {
        String output;
        String[] words = input.split(" ");
        output = Arrays.stream(words).reduce("", (acc, word) -> acc + properCaseWord(word));
        return output.trim();
    }

    static void Q_O() {
        //  O.	Create an Enum class for the Planets in the Solar System.
        System.out.println(Planet.EARTH);
    }

    static void Q_P() {
        //  P.	Given a Planet return the distance from the Sun. (Use your Planet Enum)
        System.out.println(Planet.MARS.name() + " is: " + Planet.MARS.distance() + "KM from the Sun");
    }

    static void Q_Q() {
        //  Q.	Create a Class for a Shoe. Must have at least 4 properties.
        Shoe shoe = new Shoe(9.5f, "leather", "Nike", false);
        System.out.println("I have a new shoe! Size: " + shoe.getSize());
    }

    static void Q_R() {
        //  R.	Create a base class with 3 properties, create a child class from that base class
        RunningShoe runners = new RunningShoe(10.5f, "Nike", "Ursain Bolt");
        System.out.println("I don't run any where without my size " + runners.getSize() + " " + runners.getBrand() + " -- " + runners.getEndorsedBy());
    }

    static void Q_S() {
        //  S.	Given a temperature return the type of clothing you should wear.
        int temp = Utils.getRandomNum(100);
        String recommendation = "It is " + temp + "degrees. Wear a";
        if ( temp < 32 )    recommendation += " heavy coat";
        else if (temp < 43) recommendation += " coat";
        else if (temp < 55) recommendation += " light jacket";
        else if (temp < 62) recommendation += " long sleeve shirt";
        else if (temp < 74) recommendation += " short sleave shirt";
        else if (temp < 80) recommendation += " t-shirt";
        else if (temp < 96) recommendation += " shorts";
        else                recommendation += " swimming suit and go swimming";

        System.out.println(recommendation);
    }

    static void Q_T() {
        //  T.	Given a distance in miles convert to kilometers.
        double miles = Utils.getRandomNum(100);
        double kms   = convertMiToKm(miles);
        System.out.println(miles + " miles is " + kms + " kilometers");
    }

    static double convertMiToKm(double miles) {
        return miles * 1.609344;
    }

    static void Q_U() {
        //  U.	Given a number calculate the date that many days in the future.
        int days = Utils.getRandomNum(1000);
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, days);
        System.out.println("in " + days + " days it will be " + date.getTime());
    }

    static void Q_V() {
        //  V.	Loop 0 to 100, print Fizz if divisible by 3, Buzz if divisible by 5 and # otherwise
        for (int i = 0; i < 100; i++) {
            if      (i % 15 == 0) System.out.println("Fizz Buzz");
            else if (i %  5 == 0) System.out.println("Fizz");
            else if (i %  3 == 0) System.out.println("Buzz");
            else                  System.out.println(i);
        }
    }

    static void Q_W() {
        //  W.	Find the sum of all the multiples of 3 or 5 below 1000.
        int total = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0 || i % 3 == 0)
                total += i;
        }
        System.out.println("The sum of all numbers divisible by 3 and 5 below 1000 is " + total);
    }

    static void Q_X() {
        //  X.	Given two coordinates {x1, y1} and {x2, y2} what is the distance between them
        int x1 = Utils.getRandomNum(20);
        int y1 = Utils.getRandomNum(20);
        int x2 = Utils.getRandomNum(20);
        int y2 = Utils.getRandomNum(20);
        double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        System.out.println("The distance between point {" + x1 + "," + y1 + "} " +
                                                 " and {" + x2 + "," + y2 + "} is " + distance);
    }

    static void Q_Y() {
        //  Y.	Give the center coordinate of a circle {x, y} and the radius r, determine if a point {x1, y1} is inside the circle. (distance from x, y is < r)
        int x1 = Utils.getRandomNum(20);
        int y1 = Utils.getRandomNum(20);
        int radius = Utils.getRandomNum(20);
        int x2 = Utils.getRandomNum(20);
        int y2 = Utils.getRandomNum(20);
        double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        System.out.println("A Circle at point {" + x1 + "," + y1 + "} with Radius " + radius +
                            " and at point at {" + x2 + "," + y2 + "} is at a distance of " + distance);
        if ( distance < radius )
            System.out.println("It is inside the circle. Radius " + radius + " is greater than " + distance);
        else
            System.out.println("It is NOT inside the circle. Radius " + radius + " is less than " + distance);
    }

    static void Q_Z() {
        //  Z.	Read a file from your hard drive and print the contents
        System.out.println("Take a look in the Utils.java file");
        System.out.println("    public static List<String> FileToList(String from)");
        System.out.println("    public static String[] readLines(String fileName)");
        System.out.println("are two very good examples");
    }
}
