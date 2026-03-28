import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ResumeReader {
    private String resumeText;

    public void readFromConsole(Scanner scanner) {
        System.out.println("Enter your resume text (type 'END' on a new line when finished):");
        StringBuilder sb = new StringBuilder();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("END")) break;
            sb.append(line).append("\n");
        }
        this.resumeText = sb.toString();
    }

    public void readFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Error: File not found at " + filePath);
            return;
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            this.resumeText = sb.toString();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }
}
