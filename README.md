# AI Resume Analyzer 📄🤖

An intelligent, core Java-based application designed to help students and job seekers evaluate their resumes and receive actionable feedback.

## 🌟 Features
- **Skill Detection**: Automatically identifies key technical skills (Java, Python, SQL, C++, etc.).
- **Section Analysis**: Checks for essential sections like Projects, Experience, and Education.
- **Resume Scoring**: Provides a score (0–100) based on content, length, and technical depth.
- **Suggestion Engine**: Generates specific, actionable feedback for improvement.
- **Dual Interface**:
  - **Console Version**: Lightweight and fast.
  - **GUI Version**: Modern Swing-based interface with real-time feedback.

## 🛠 Tech Stack
- **Language**: Java 11+
- **Architecture**: Modular, Object-Oriented Design (OOP)
- **GUI Framework**: Java Swing

## 📁 Project Structure
- `Main.java`: Entry point for the console application.
- `ResumeReader.java`: Handles input from UI or text files.
- `Analyzer.java`: Core analysis and scoring logic.
- `SuggestionEngine.java`: Suggestion generation logic.
- `ResumeAnalyzerGUI.java`: Graphical User Interface.

## 🚀 How to Run

### Prerequisites
- JDK 11 or higher installed.

### Step 1: Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/AIResumeAnalyzer.git
cd AIResumeAnalyzer
```

### Step 2: Compile the project
```bash
javac *.java
```

### Step 3: Run the Application
**For Console Version:**
```bash
java Main
```

**For GUI Version:**
```bash
java ResumeAnalyzerGUI
```

## 📈 Example Results
- **Skills Found**: Java, SQL, React
- **Resume Score**: 75/100
- **Suggestions**: 
  - Add a 'Projects' section to showcase your work.
  - Include more detailed descriptions in your experience.

## 🤝 Contributing
Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## 📜 License
This project is licensed under the [MIT License](LICENSE).
