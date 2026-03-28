import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private String resumeText;
    private List<String> skillsFound;
    private List<String> sectionsFound;
    private int score;

    public Analyzer(String resumeText) {
        this.resumeText = resumeText.toLowerCase();
        this.skillsFound = new ArrayList<>();
        this.sectionsFound = new ArrayList<>();
        this.score = 0;
    }

    public void analyze() {
        // Detect predefined skills
        detectSkills();
        // Check for sections
        checkSections();
        // Calculate score
        calculateScore();
    }

    private void detectSkills() {
        String[] skills = {"java", "python", "sql", "c++", "javascript", "react", "node.js", "data structures", "algorithms"};
        for (String skill : skills) {
            if (resumeText.contains(skill.toLowerCase())) {
                skillsFound.add(skill);
            }
        }
    }

    private void checkSections() {
        String[] sections = {"skills", "projects", "experience", "education", "contact"};
        for (String section : sections) {
            if (resumeText.contains(section.toLowerCase())) {
                sectionsFound.add(section);
            }
        }
    }

    private void calculateScore() {
        // Points for skills (up to 40)
        score += Math.min(skillsFound.size() * 10, 40);

        // Points for sections (up to 30)
        score += Math.min(sectionsFound.size() * 6, 30);

        // Points for content length (up to 30)
        int length = resumeText.split("\\s+").length;
        if (length > 200) {
            score += 30;
        } else if (length > 100) {
            score += 15;
        } else if (length > 50) {
            score += 5;
        }
    }

    public List<String> getSkillsFound() {
        return skillsFound;
    }

    public List<String> getSectionsFound() {
        return sectionsFound;
    }

    public int getScore() {
        return score;
    }
}
