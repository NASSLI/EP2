// Please answer the questions (1 point for at least 7 correct answers, 2 points for at least 9 correct answers).

public class MCTest3d2 {

    // If 'answer' in 'new Choice(...)' is true for 'question', please set 'valid' to 'true'.
    // Otherwise, 'valid' shall be 'false'.
    // Comments do not influence assessment.
    // Please do not change anything else. For checking please execute MCTest3d2.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Which of the following statements are correct for iterators in Java?",

                        new Choice(true, "A collection can have several Iterator implementations.              (1A)"),
                        new Choice(false, "The ordering of iterations shows the kind of data structure.         (1B)"),
                        new Choice(false, "Several iterators on the same object disturb each other.             (1C)"),
                        new Choice(false, "An iterator holds copies of all data in the iterated data structure. (1D)"),
                        new Choice(true, "Implementations of iterators are separate classes.                   (1E)")
                ),

                new Question(
                        "Let M and R be reference types such that the compiler translates the following code\n" +
                        "without errors:  'R b = new M();  b.r();'\n" +
                        "Which of the following statements are correct for all appropriate M, R, b and r()?",

                        new Choice(false, "Comments of r() in M must also be valid for r() in R.                (2A)"),
                        new Choice(true, "M must be a class (not an interface).                                (2B)"),
                        new Choice(false, "R must be an interface (no class).                                   (2C)"),
                        new Choice(true, "M is subtype of R.                                                   (2D)"),
                        new Choice(true, "'b.r()' executes the method in M.                                    (2E)")
                )
        );
    }

// End of questions

//------------------------------------------------------------
// Please do not edit below this line.

    private static final String EXPECT = // again the same questions for self checking
            " 1. Which of the following statements are correct for iterators in Java?\n" +
            "    \n" +
            "    XXXXXXXXX A collection can have several Iterator implementations.              (1A)\n" +
            "    XXXXXXXXX The ordering of iterations shows the kind of data structure.         (1B)\n" +
            "    XXXXXXXXX Several iterators on the same object disturb each other.             (1C)\n" +
            "    XXXXXXXXX An iterator holds copies of all data in the iterated data structure. (1D)\n" +
            "    XXXXXXXXX Implementations of iterators are separate classes.                   (1E)\n" +
            "\n" +
            " 2. Let M and R be reference types such that the compiler translates the following code\n" +
            "    without errors:  'R b = new M();  b.r();'\n" +
            "    Which of the following statements are correct for all appropriate M, R, b and r()?\n" +
            "    \n" +
            "    XXXXXXXXX Comments of r() in M must also be valid for r() in R.                (2A)\n" +
            "    XXXXXXXXX M must be a class (not an interface).                                (2B)\n" +
            "    XXXXXXXXX R must be an interface (no class).                                   (2C)\n" +
            "    XXXXXXXXX M is subtype of R.                                                   (2D)\n" +
            "    XXXXXXXXX 'b.r()' executes the method in M.                                    (2E)\n" +
            "\n";

    public static final long UID = 251674619379960L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("True:    ", "XXXXXXXXX").replace("False:   ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Instead of line: " + fl + "\nthere should be: " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "These are the expected questions and answer choices in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("WARNING: You have changed program parts that sould not be changed.\n" +
                    "As it is, assessment is not possible.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("You answered the questions as follows\n" +
                "(here are only your answers, no statement on correctness):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "True:     " : "False:    ") + answer;
        }
    }
}