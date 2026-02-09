package Module1.Practice.ZyBookPractices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Characters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Input file: ");
      String inputFileName = console.next();
      File inputFile = new File(inputFileName);
      Scanner in = new Scanner(inputFile);
      in.useDelimiter("");
      int uppercase = 0;
      int lowercase = 0;
      int digits = 0;
      int whitespace = 0;
      int other = 0;

      while (in.hasNext())
      {
         char ch = in.next().charAt(0);
         if (Character.isUpperCase(ch)) { uppercase++; }
         else if (Character.isLowerCase(ch)) { lowercase++; }
         else if (Character.isDigit(ch)) { digits++; }
         else if (Character.isWhitespace(ch)) { whitespace++; }
         else { other++; }
      }

      in.close();
      
      System.out.println("Uppercase: " + uppercase);
      System.out.println("Lowercase: " + lowercase);
      System.out.println("Digits: " + digits);
      System.out.println("Whitespace: " + whitespace);
      System.out.println("Other: " + other);
   }
}
