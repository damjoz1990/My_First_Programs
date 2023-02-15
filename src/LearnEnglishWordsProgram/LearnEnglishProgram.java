package LearnEnglishWordsProgram;
/**
 * LearnEnglishWordsProgram is a program to help user learn English words.
 * The program reads words and their definitions from a text file (words.txt)
 * and shuffles the words in a random order.
 * The user is then prompted to guess the definition of the word.
 * The program then prints out a list of words that the user missed at the end.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LearnEnglishProgram {
    private Map<String, String> wordToDefMap;
    private Map<String, Boolean> wordToResultMap;

    public LearnEnglishProgram() {
        wordToDefMap = new HashMap<>();
        wordToResultMap = new HashMap<>();
    }

    public void loadWordsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length != 2) {
                continue;
            }
            wordToDefMap.put(parts[0].trim().toLowerCase(), parts[1].trim().toLowerCase());
            wordToResultMap.put(parts[0].trim().toLowerCase(), false);
        }
        reader.close();
    }

    public void startLearning() {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>(wordToDefMap.keySet());
        Collections.shuffle(words);
        for (String word : words) {
            System.out.print("What does \"" + word + "\" mean? ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals(wordToDefMap.get(word))) {
                System.out.println("Correct!");
                wordToResultMap.put(word, true);
            } else {
                System.out.println("Incorrect. The correct answer is: \"" + wordToDefMap.get(word) + "\"");
            }
        }
        System.out.println("\nHere are the words you missed:");
        boolean allCorrect = true;
        for (String word : wordToResultMap.keySet()) {
            if (!wordToResultMap.get(word)) {
                allCorrect = false;
                System.out.println("- \"" + word + "\": \"" + wordToDefMap.get(word) + "\"");
            }
        }
        if (allCorrect) {
            System.out.println("Congratulations! You got them all correct!");
        }
    }

    public static void main(String[] args) {
        LearnEnglishProgram program = new LearnEnglishProgram();
        try {
            program.loadWordsFromFile("C:\\Users\\damjo\\IdeaProjects\\My_First_Programs\\out\\production\\My_First_Programs\\LearnEnglishWordsProgram\\words.txt");
            program.startLearning();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
