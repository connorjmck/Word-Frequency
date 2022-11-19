import java.util.*;

public class Main {

    public static String[] wordFrequency(String initialString) {
        //split words in string based on spaces and remove excess characters(.,!)
        String[] words = initialString.toLowerCase().replace(".","")
                .replace(";","").replace("!","")
                .replace(",","").replace("?","")
                .split(" ");
        //create arrays for a word and its count
        ArrayList<String> wordCollection = new ArrayList<String>();
        ArrayList<Integer> countCollection = new ArrayList<Integer>();
        String[] returnWords;

        //iterate through array, check if word already present, if so +1/else add word(start at 1)
        for (int i = 0; i < words.length; i++) {
            if (!wordCollection.contains(words[i])) {
                //add to list
                //System.out.println("Adding: " + words[i]);
                wordCollection.add(words[i]);
                countCollection.add(1);
                //System.out.println("Initial Count: " + countCollection);
                //wf.add(new WordFrequency(words[i], 1));

            } else {
                //adjust count
                //System.out.println("Not Adding: " + words[i]);
                countCollection.set(
                        wordCollection.indexOf(words[i]),
                        countCollection.get(
                                wordCollection.indexOf(words[i]))
                                + 1);
                //System.out.println("adjusted count: " + countCollection);
            }
        }

        returnWords = new String[countCollection.size()];

        for (int i = 0; i < returnWords.length; i++) {
            returnWords[i] = countCollection.get(i) + " " + wordCollection.get(i);
        }
        Arrays.sort(returnWords, Comparator.reverseOrder());
        return returnWords;
    }

    public static void main(String[] args) {
        String test1 = "the cat cat is in the bag.";
        String test2 = "Well well well, what have we here?";

        String[] test = wordFrequency(test1);

        for(String answer : test)
        {
            System.out.println(answer);
        }
    }
}
