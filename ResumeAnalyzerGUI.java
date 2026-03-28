import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResumeAnalyzerGUI extends JFrame {
    private JTextArea resumeInput;
    private JTextArea outputArea;
    private JButton analyzeButton;
    private JLabel scoreLabel;

    public ResumeAnalyzerGUI() {
        setTitle("AI Resume Analyzer (Swing Edition)");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Paste Resume Text Here"));
        resumeInput = new JTextArea(10, 40);
        resumeInput.setLineWrap(true);
        inputPanel.add(new JScrollPane(resumeInput), BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        analyzeButton = new JButton("Analyze Resume");
        analyzeButton.setBackground(new Color(50, 150, 250));
        analyzeButton.setForeground(Color.WHITE);
        controlPanel.add(analyzeButton);

        // Output Panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Analysis Results"));
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        scoreLabel = new JLabel("Score: --/100", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        outputPanel.add(scoreLabel, BorderLayout.SOUTH);

        // Add to main frame
        add(inputPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // Button action
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resumeText = resumeInput.getText();
                if (resumeText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter some text.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Analyzer analyzer = new Analyzer(resumeText);
                analyzer.analyze();

                SuggestionEngine engine = new SuggestionEngine();
                engine.generateSuggestions(analyzer);

                // Build output
                StringBuilder sb = new StringBuilder();
                sb.append("Skills Found: ").append(String.join(", ", analyzer.getSkillsFound())).append("\n\n");
                sb.append("--- Suggestions ---\n");
                for (String suggestion : engine.getSuggestions()) {
                    sb.append("- ").append(suggestion).append("\n");
                }

                outputArea.setText(sb.toString());
                scoreLabel.setText("Score: " + analyzer.getScore() + "/100");
                scoreLabel.setForeground(analyzer.getScore() >= 70 ? Color.GREEN : (analyzer.getScore() >= 50 ? Color.ORANGE : Color.RED));
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ResumeAnalyzerGUI().setVisible(true);
        });
    }
}
