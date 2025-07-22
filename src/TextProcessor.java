public class TextProcessor {

    /** Count words in a sentence (splits on whitespace, ignores empty) */
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] parts = sentence.trim().split("\\s+");
        return parts.length;
    }

    /** Replace all occurrences of oldWord with newWord */
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null) return null;
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String test = "Java is fun and Java is powerful";

        System.out.println("Sentence: " + test);
        System.out.println("Word count: " + countWords(test));

        String replaced = replaceWord(test, "Java", "Programming");
        System.out.println("After replace: " + replaced);

    }
}
