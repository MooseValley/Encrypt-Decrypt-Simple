/*
   Author: Mike O'Malley
   Description: EncryptDecrypt (Encode / Decode)
   My solution Q29, Q30, and Q31 - Chapter 9, p326-327.

   Structured Fortran 77 for Engineers and Scientists,
   D. M. Etter.
   (C) 1983.  ISBN: 0-8053-2520-4

My old QIT (Uni) textbook from my uni days 1983-1987 - VERY weather beaten and worn now (almost 30 years later).

Q29, Q30, and Q31 - Chapter 9, p326-327.

*************************************
Q29, Q30, Q31:  (Re-worded, rewritten, and greatly streamlined by Mike O)
*************************************

Write a method called Decode (or Decrypt) that receives a Key string and a character string,
and returns an "encoded" ("encrypted") string.

Also write a method called Encode (or Encrypt) that receives a Key string and an
"encoded" ("encrypted") character string, and returns a "decoded" ("decrypted") string.

* Encoding / Encryption:
The encoding the string using a simple substitution code where the 1st letter in the
Key string is substituted for "A", the 2nd letter for "B", and so on.

If the Key string is:     "YXAZKLMBJOCFDVSWTREGHNIPUZ"
And the source string is: "MEET AT AIRPORT SATURDAY"

The 1st letter in the source string "M" is the 13th letter in
the alphabet, so it substituted for the 13th letter in the Key String "D".

The 2st letter in the source string "E" is the 5th letter in
the alphabet, so it substituted for the 5th letter in the Key String "K".
And so on.

The result is the "encoded" ("encrypted") string:

   "DKKG YG YJRWSRG EYGHRZYU"

* Decoding / Decryption:
The "decoding" ("decryption") process is the reverse of the above.

If the Key string is:     "YXAZKLMBJOCFDVSWTREGHNIPUZ"
And the encoded string is: "DKKG YG YJRWSRG EYGHRZYU"

The 1st letter in the encoded string "D" and this letter is the 13th letter in
the Key string, so it substituted for the 13th letter in alphabet "M".

The 2nd letter in the encoded string "K" and this letter is the 5th letter in
the Key string, so it substituted for the 5th letter in alphabet "E".
And so on.

The result is the "decoded" ("decrypted") string:

   "MEET AT AIRPORT SATURDAY"


Write a program that encodes and then decodes the source string is:
"MEET AT AIRPORT SATURDAY" using the following key string is: "YXAZKLMBJOCFDVSWTREGHNIPUZ".
And display your all results to the screen.


*************************************
Follow on Question:  (by Mike O)
*************************************
Ammend your program to accept lines of text from the user and encode and
then decode each of these.  Repeat the process until the user wants to quit the program.
(You are free to decide how you want the user to quit.  e.g. a blank line of text
may signal a desire to quit).


*/

/*
Sample Output:

MEET AT AIRPORT SATURDAY
DKKG YG YJRWSRG EYGHRZYU
MEET AT AIRPORT SATURDAY

*/

public class Ch09_Q29_Q30_Q31__EncryptDecrypt
{
   // Constants:


   public static String Encrypt (String keyString, String sourceString)
   {
      String destString   = "";
      int index;

      for (int k = 0; k < sourceString.length(); k++)
      {
         char nextChar = sourceString.charAt (k);

         index = -1;

         if (keyString.contains ("" + nextChar) == true)
            index = nextChar - 'A';

         if (index >= 0)
            destString = destString + keyString.charAt (index);
         else
            destString = destString + nextChar;
      }
      return destString;
   }

   public static String Decrypt (String keyString, String sourceString)
   {
      String destString   = "";
      int index;
      boolean found;

      for (int k = 0; k < sourceString.length(); k++)
      {
         char nextChar = sourceString.charAt (k);
         char decodeChar;

         index = 0;
         found = false;
         while ((index < keyString.length())  && (found == false))
         {
            if (nextChar == keyString.charAt (index))
               found = true;
            else
               index++;
         }

         //System.out.println (nextChar + " - " + index);

         if (found == false)
            decodeChar = nextChar; // No replacement - use the source char.
         else
            decodeChar = (char) (index + 'A');


         if (index >= 0)
            destString = destString + decodeChar;
         else
            destString = destString + nextChar;
      }
      return destString;
   }

   public static void main (String[] args)
   {
      String keyString    = "YXAZKLMBJOCFDVSWTREGHNIPUZ";
      String sourceString = "MEET AT AIRPORT SATURDAY";
      String destString   = "";

      System.out.println (sourceString);

      destString   = Encrypt (keyString, sourceString);
      System.out.println (destString);

      destString   = Decrypt (keyString, destString);
      System.out.println (destString);
   }
} // public class EncryptDecrypt
