public class GradeManager {
    /** Reverse each student name ("John" → "nhoJ"), array order unchanged */
public static String[] reverseStudentNames(String[] names) {
    String[] reversed = new String[names.length];
    for (int i = 0; i < names.length; i++) {
        StringBuilder sb = new StringBuilder(names[i]);
        reversed[i] = sb.reverse().toString();
    }
    return reversed;
}

    /** Return letter grade for a numeric score */
    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100) return 'A';
        else if (score >= 80)          return 'B';
        else if (score >= 70)          return 'C';
        else if (score >= 60)          return 'D';
        else                            return 'F';
    }

    /** Return names of students whose score is below 60 */
    public static String[] findFailingStudents(String[] names, int[] scores) {
        java.util.List<String> out = new java.util.ArrayList<>();
        for (int i = 0; i < names.length && i < scores.length; i++) {
            if (scores[i] < 60) {
                out.add(names[i]);
            }
        }
        return out.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] students = { "Alice", "Bob", "Charlie", "Diana" };
        int[]    scores   = { 95,       67,     45,        78 };

        System.out.println("Original names:   " + java.util.Arrays.toString(students));
        System.out.println("Reversed names:   " + java.util.Arrays.toString(
                reverseStudentNames(students)));

        System.out.print("Letter grades:    ");
        for (int s : scores) {
            System.out.print(getLetterGrade(s) + " ");
        }
        System.out.println();

        System.out.println("Failing students: " +
                java.util.Arrays.toString(findFailingStudents(students, scores)));
    }
}
