import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ResumeReader {
    private String resumeText;

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your resume text (type 'END' on a new line when finished):");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            sb.append(line).append("\n");
        }
        this.resumeText = sb.toString();
    }

    public void readFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
