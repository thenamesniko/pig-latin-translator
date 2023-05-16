//import java.util.Scanner;

public class App {

    public static String pigLatinTranslator(String s) {
        //Will use this later to check if a character contains a vowel. Y is counted as a vowel.
        String vowels = "AEIOUYaeiouy";
        //Splits sentence from user into individual words
        String[] words = s.split("\\s+");

        //Uses Stringbuilder to dynamically update the translation over time
        StringBuilder pigLatinSentence = new StringBuilder();

        //Notes the index of the vowel in a word
        int vowelLocation = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                //Notes the character of the word. Moves by one character when the loop updates
                char c = words[i].charAt(j);
                //If the word starts with a vowel, add "yay" to the end of it
                if (vowels.contains(String.valueOf(words[i].charAt(0)))) {
                    pigLatinSentence.append(words[i] + "yay");
                    break;
                }
                //Finds the first location of a vowel in the word, moves the part before the vowel to the end of the word. Then adds "ay" to the end of the word
                if (vowels.contains(String.valueOf(c))) {
                    vowelLocation = j;
                    String partToMove = words[i].substring(0, vowelLocation);
                    String remaining = words[i].substring(vowelLocation);

                    pigLatinSentence.append(remaining + partToMove + "ay");
                    break;
                }
            }
            //Adds a space after each word
            pigLatinSentence.append(" ");
        }

        String firstLetter = pigLatinSentence.toString().substring(0, 1).toUpperCase();
        String remaininingString = pigLatinSentence.toString().substring(1).toLowerCase();

        return firstLetter + remaininingString;
    }

    public static void main(String[] args) throws Exception {

        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        
    }
}
