package typinggame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TypingGameUI extends JFrame {
    private JPanel headerPanel, contentPanel;
    private JTextArea typingArea;
    private JLabel challengeLabel, wpmLabel, accuracyLabel, feedbackLabel;
    private JButton typingSpeedButton, writingProficiencyButton, vocabularyChallengeButton;
    private JButton startTestButton, nextSentenceButton, showHintButton, showSolutionButton, changeModeButton;

    private String currentChallenge = "";
    private int totalCharactersTyped = 0, totalCorrectCharacters = 0, totalMistakes = 0;
    private int currentChallengeIndex = 0;
    private long startTime;

    private final List<String> sentenceChallenges = Arrays.asList(
            "The quick brown fox jumps over the lazy dog.",
            "Practice makes perfect.",
            "A journey of a thousand miles begins with a single step."
    );

    private final List<String> writingChallenges = Arrays.asList(
            "Fill in the blank: The ______ brown fox.",
            "Fill in the blank: A journey of ______ steps.",
            "Fill in the blank: Practice makes ______."
    );

    private final List<String> writingSolutions = Arrays.asList(
            "quick", "thousand", "perfect"
    );

    private final List<String> vocabularyWords1 = Arrays.asList(
            "Serendipity", "Eloquent", "Ambivalent", "Empathy", "Resilient"
    );

    private final Random random = new Random();
	private List<String> vocabularyWords;

    public TypingGameUI() {
        setTitle("Typing, Writing & Vocabulary Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 650);
        setLayout(new BorderLayout());

        // Header Section
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(76, 175, 80)); // Green background
        headerPanel.setPreferredSize(new Dimension(getWidth(), 80));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel titleLabel = new JLabel("Typing, Writing & Vocabulary Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Content Panel
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(new Color(245, 245, 245));
        add(contentPanel, BorderLayout.CENTER);

        // Show the Select Mode Screen
        showSelectModeScreen();

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(100, 181, 246));
        button.setForeground(Color.WHITE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(76, 175, 80), 2, true));
        return button;
    }

    private void showSelectModeScreen() {
        contentPanel.removeAll();

        JPanel modeSelectionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        modeSelectionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        modeSelectionPanel.setBackground(Color.WHITE);

        JLabel modeLabel = new JLabel("Select Mode", SwingConstants.CENTER);
        modeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        modeSelectionPanel.add(modeLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        buttonPanel.setOpaque(false);

        typingSpeedButton = createStyledButton("Typing Speed Test");
        writingProficiencyButton = createStyledButton("Writing Proficiency Test");
        vocabularyChallengeButton = createStyledButton("Vocabulary Challenge");

        buttonPanel.add(typingSpeedButton);
        buttonPanel.add(writingProficiencyButton);
        buttonPanel.add(vocabularyChallengeButton);

        modeSelectionPanel.add(buttonPanel);

        contentPanel.add(modeSelectionPanel);
        contentPanel.revalidate();
        contentPanel.repaint();

        // Button Listeners
        typingSpeedButton.addActionListener(e -> showTypingSpeedTest());
        writingProficiencyButton.addActionListener(e -> showWritingProficiencyTest());
        vocabularyChallengeButton.addActionListener(e -> showVocabularyChallenge());
    }

    private void addChangeModeButton(JPanel panel) {
        changeModeButton = new JButton("Change Mode");
        changeModeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        changeModeButton.setBackground(new Color(193, 245, 245)); 
        changeModeButton.setForeground(Color.BLACK);
        changeModeButton.setFocusPainted(false);

        changeModeButton.addActionListener(e -> showSelectModeScreen());
        panel.add(changeModeButton);
    }

    private void showTypingSpeedTest() {
        contentPanel.removeAll();

        JPanel typingPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        typingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        typingPanel.setBackground(Color.WHITE);

        challengeLabel = new JLabel("Press Start to Begin!", SwingConstants.CENTER);
        challengeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        typingPanel.add(challengeLabel);

        typingArea = new JTextArea();
        typingArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        typingArea.setLineWrap(true);
        typingArea.setWrapStyleWord(true);
        typingArea.setEditable(false);

        typingArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                evaluateTypingSpeed();
            }
        });

        typingPanel.add(new JScrollPane(typingArea));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        startTestButton = new JButton("Start Test");
        nextSentenceButton = new JButton("Next Sentence");
        nextSentenceButton.setEnabled(false);

        startTestButton.addActionListener(e -> startTypingSpeedTest());
        nextSentenceButton.addActionListener(e -> nextTypingSentence());

        buttonPanel.add(startTestButton);
        buttonPanel.add(nextSentenceButton);

        typingPanel.add(buttonPanel);

        JPanel metricsPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        metricsPanel.setOpaque(false);

        wpmLabel = new JLabel("WPM: 0", SwingConstants.CENTER);
        accuracyLabel = new JLabel("Accuracy: 0%", SwingConstants.CENTER);

        metricsPanel.add(wpmLabel);
        metricsPanel.add(accuracyLabel);

        typingPanel.add(metricsPanel);

        addChangeModeButton(typingPanel);

        contentPanel.add(typingPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void startTypingSpeedTest() {
        resetMetrics();
        typingArea.setEditable(true);
        currentChallenge = sentenceChallenges.get(random.nextInt(sentenceChallenges.size()));
        challengeLabel.setText(currentChallenge);
        typingArea.setText(""); // Clear the typing area
        nextSentenceButton.setEnabled(true);
        startTime = System.currentTimeMillis(); // Start the timer
    }

    private void nextTypingSentence() {
        resetMetrics();
        typingArea.setEditable(true);
        currentChallenge = sentenceChallenges.get(random.nextInt(sentenceChallenges.size()));
        challengeLabel.setText(currentChallenge);
        typingArea.setText(""); // Clear the typing area
        startTime = System.currentTimeMillis(); // Restart the timer
    }

    private void evaluateTypingSpeed() {
        String input = typingArea.getText();
        int correctCharacters = 0;

        for (int i = 0; i < input.length() && i < currentChallenge.length(); i++) {
            if (input.charAt(i) == currentChallenge.charAt(i)) {
                correctCharacters++;
            } else {
                totalMistakes++;
            }
        }

        totalCorrectCharacters = correctCharacters;
        totalCharactersTyped = input.length();

        double elapsedTimeMinutes = (System.currentTimeMillis() - startTime) / 60000.0;
        int wpm = (int) ((totalCorrectCharacters / 5.0) / elapsedTimeMinutes);
        int accuracy = totalCharactersTyped == 0 ? 0 : (totalCorrectCharacters * 100) / totalCharactersTyped;

        wpmLabel.setText("WPM: " + wpm);
        accuracyLabel.setText("Accuracy: " + accuracy + "%");
    }

    private void showWritingProficiencyTest() {
        contentPanel.removeAll();

        JPanel writingPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        writingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        writingPanel.setBackground(Color.WHITE);

        loadNextWritingChallenge();

        challengeLabel = new JLabel(currentChallenge, SwingConstants.CENTER);
        challengeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        writingPanel.add(challengeLabel);

        typingArea = new JTextArea();
        typingArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        typingArea.setLineWrap(true);
        typingArea.setWrapStyleWord(true);

        typingArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                checkWritingInput();
            }
        });

        writingPanel.add(new JScrollPane(typingArea));

        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        feedbackLabel.setForeground(Color.BLUE);

        showHintButton = new JButton("Show Hint");
        showSolutionButton = new JButton("Show Solution");

        showHintButton.addActionListener(e -> feedbackLabel.setText("Hint: Think about the key concept!"));
        showSolutionButton.addActionListener(e -> feedbackLabel.setText("Solution: " + writingSolutions.get(currentChallengeIndex)));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(showHintButton);
        buttonPanel.add(showSolutionButton);

        writingPanel.add(buttonPanel);
        writingPanel.add(feedbackLabel);

        addChangeModeButton(writingPanel);

        contentPanel.add(writingPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void loadNextWritingChallenge() {
        currentChallengeIndex = random.nextInt(writingChallenges.size());
        currentChallenge = writingChallenges.get(currentChallengeIndex);
    }

    private void checkWritingInput() {
        String userInput = typingArea.getText().trim();
        String correctAnswer = writingSolutions.get(currentChallengeIndex);

        if (userInput.equalsIgnoreCase(correctAnswer)) {
            feedbackLabel.setText("Correct! Moving to next challenge...");
            SwingUtilities.invokeLater(() -> {
                typingArea.setText("");
                loadNextWritingChallenge();
                challengeLabel.setText(currentChallenge);
                feedbackLabel.setText("");
            });
        }
    }

    private void showVocabularyChallenge() {
        contentPanel.removeAll();

        JPanel vocabPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        vocabPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        vocabPanel.setBackground(Color.WHITE);

        loadNextVocabularyWord();

        challengeLabel = new JLabel("Type the word below:", SwingConstants.CENTER);
        challengeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        vocabPanel.add(challengeLabel);

        JLabel wordLabel = new JLabel(currentChallenge, SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 22));
        vocabPanel.add(wordLabel);

        typingArea = new JTextArea();
        typingArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        typingArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                if (typingArea.getText().trim().equalsIgnoreCase(currentChallenge)) {
                    JOptionPane.showMessageDialog(null, "Correct! Moving to next word.");
                    loadNextVocabularyWord();
                    wordLabel.setText(currentChallenge);
                    typingArea.setText("");
                }
            }
        });

        vocabPanel.add(new JScrollPane(typingArea));

        addChangeModeButton(vocabPanel);

        contentPanel.add(vocabPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void loadNextVocabularyWord() {
        currentChallenge = vocabularyWords1.get(random.nextInt(vocabularyWords1.size()));
    }

    private void resetMetrics() {
        totalCharactersTyped = 0;
        totalCorrectCharacters = 0;
        totalMistakes = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TypingGameUI::new);
    }
}
