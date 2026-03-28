import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("         Welcome to AI Resume Analyzer            ");
        System.out.println("--------------------------------------------------");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose Input Method:");
            System.out.println("1. Console Input (Type your resume manually)");
            System.out.println("2. File Input (Provide path to a text file)");
            System.out.print("Enter choice (1 or 2): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                return;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            ResumeReader reader = new ResumeReader();
            if (choice == 1) {
                reader.readFromConsole(scanner);
            } else if (choice == 2) {
                System.out.print("Enter file path: ");
                String filePath = scanner.nextLine();
                reader.readFromFile(filePath);
            } else {
                System.out.println("Invalid choice. Exiting...");
                return;
            }

            String resumeText = reader.getResumeText();
            if (resumeText == null || resumeText.isEmpty()) {
                System.out.println("Empty resume provided. Analysis cannot proceed.");
                return;
            }

            // Analysis
            Analyzer analyzer = new Analyzer(resumeText);
            analyzer.analyze();

            // Suggestions
            SuggestionEngine engine = new SuggestionEngine();
            engine.generateSuggestions(analyzer);

            // Output results
            System.out.println("\n--------------------------------------------------");
            System.out.println("               Analysis Results                   ");
            System.out.println("--------------------------------------------------");
            System.out.println("Resume Score: " + analyzer.getScore() + "/100");
            System.out.print("Skills Detected: ");
            System.out.println(String.join(", ", analyzer.getSkillsFound()));

            System.out.println("\n--- Suggestions for Improvement ---");
            for (String suggestion : engine.getSuggestions()) {
                System.out.println("- " + suggestion);
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
