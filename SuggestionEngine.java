import java.util.ArrayList;
import java.util.List;

public class SuggestionEngine {
    private List<String> suggestions;

    public SuggestionEngine() {
        this.suggestions = new ArrayList<>();
    }

    public void generateSuggestions(Analyzer analyzer) {
        // Clear previous suggestions if any
        suggestions.clear();

        // Section suggestions
        List<String> sectionsFound = analyzer.getSectionsFound();
        if (!sectionsFound.contains("projects")) {
            suggestions.add("Add a 'Projects' section to showcase your hands-on work.");
        }
        if (!sectionsFound.contains("experience")) {
            suggestions.add("Include an 'Experience' section, even if it's internships or self-projects.");
        }
        if (!sectionsFound.contains("skills")) {
            suggestions.add("Explicitly list your skills in a 'Skills' section.");
        }

        // Skill suggestions
        if (analyzer.getSkillsFound().isEmpty()) {
            suggestions.add("Improve your technical skills: try adding Java, Python, SQL, or other in-demand technologies.");
        }

        // Content length suggestions
        int length = analyzer.getScore(); 
        if (length < 200 && analyzer.getScore() < 70) {
            suggestions.add("Include more detailed descriptions for your projects and roles.");
        }
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}
