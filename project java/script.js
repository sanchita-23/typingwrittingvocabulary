// Prompts for Typing, Writing, and Vocabulary
const typingPrompts = [
    "The quick brown fox jumps over the lazy dog.",
    "Practice makes perfect, so keep typing.",
    "Never stop learning, as life never stops teaching."
  ];
  
  const writingChallenges = [
    { task: "Fill in the blank: The _____ brown fox.", answer: "quick", hint: "It's a short word for fast." },
    { task: "Rearrange: over the jumps fox brown lazy dog the.", answer: "The quick brown fox jumps over the lazy dog.", hint: "Arrange in correct grammatical order." },
    { task: "Correct the sentence: the quick brown dog jumps ovr the lazy fox.", answer: "The quick brown dog jumps over the lazy fox.", hint: "Fix the typo 'ovr' and capitalize." }
  ];
  
  const vocabularyWords = ["ephemeral", "serendipity", "ineffable", "sonder", "labyrinth"];
  
  // Flags for running challenges
  let isWritingChallengeRunning = false;
  let isVocabularyChallengeRunning = false;
  
  // Mode Selection Logic
  document.querySelectorAll(".mode-btn").forEach(button => {
    button.addEventListener("click", () => {
      const mode = button.getAttribute("data-mode");
      hideAllSections();
      if (mode === "typing") {
        document.getElementById("typing-section").classList.remove("hidden");
      } else if (mode === "writing") {
        document.getElementById("writing-section").classList.remove("hidden");
        if (!isWritingChallengeRunning) startWritingChallenge();
      } else if (mode === "vocabulary") {
        document.getElementById("vocabulary-section").classList.remove("hidden");
        if (!isVocabularyChallengeRunning) startVocabularyChallenge();
      }
    });
  });
  
  // Hide All Sections
  function hideAllSections() {
    document.getElementById("typing-section").classList.add("hidden");
    document.getElementById("writing-section").classList.add("hidden");
    document.getElementById("vocabulary-section").classList.add("hidden");
  }
  
  // Typing Speed Test Logic
  document.getElementById("start-btn").addEventListener("click", startTypingTest);
  
  function startTypingTest() {
    const promptElement = document.getElementById("prompt");
    const userInput = document.getElementById("user-input");
    const wpmValue = document.getElementById("wpm-value");
    const accuracyValue = document.getElementById("accuracy-value");
    const nextButton = document.getElementById("next-btn");
  
    let prompt = typingPrompts[Math.floor(Math.random() * typingPrompts.length)];
    promptElement.innerText = prompt;
  
    userInput.disabled = false;
    userInput.value = "";
    userInput.focus();
    nextButton.disabled = false;
  
    wpmValue.innerText = "0"; // Reset WPM
    accuracyValue.innerText = "0"; // Reset Accuracy
  
    let startTime = Date.now(); // Record start time
  
    function calculateResults() {
      const typedText = userInput.value;
  
      const endTime = Date.now();
      const timeTaken = (endTime - startTime) / 1000; // Time in seconds
  
      const wordsTyped = typedText.split(" ").length;
      const wpm = ((wordsTyped / timeTaken) * 60).toFixed(2);
  
      const correctChars = [...typedText].filter((char, i) => char === prompt[i]).length;
      const accuracy = ((correctChars / prompt.length) * 100).toFixed(2);
  
      // Update WPM and Accuracy
      wpmValue.innerText = wpm;
      accuracyValue.innerText = accuracy;
    }
  
    function inputListener() {
      const typedText = userInput.value;
  
      // Calculate accuracy dynamically
      const correctChars = [...typedText].filter((char, i) => char === prompt[i]).length;
      const accuracy = ((correctChars / prompt.length) * 100).toFixed(2);
      accuracyValue.innerText = accuracy;
  
      if (typedText === prompt) {
        calculateResults();
        userInput.disabled = true;
        userInput.removeEventListener("input", inputListener);
      }
    }
  
    userInput.addEventListener("input", inputListener);
  
    nextButton.addEventListener("click", () => {
      // Select a new random prompt
      prompt = typingPrompts[Math.floor(Math.random() * typingPrompts.length)];
      promptElement.innerText = prompt;
  
      // Reset input and results
      userInput.disabled = false;
      userInput.value = "";
      userInput.focus();
      wpmValue.innerText = "0";
      accuracyValue.innerText = "0";
  
      // Reset timer
      startTime = Date.now();
  
      // Ensure inputListener is re-attached for the new sentence
      userInput.removeEventListener("input", inputListener);
      userInput.addEventListener("input", inputListener);
    });
  }
  
  // Writing Proficiency Test Logic
  function startWritingChallenge() {
    isWritingChallengeRunning = true;
    let challengeIndex = 0;
  
    function loadNextChallenge() {
      if (challengeIndex < writingChallenges.length) {
        const challenge = writingChallenges[challengeIndex];
        document.getElementById("challenge-task").innerText = challenge.task;
  
        const challengeInput = document.getElementById("challenge-input");
        const hintButton = document.getElementById("hint-btn");
        const solutionButton = document.getElementById("solution-btn");
  
        challengeInput.value = "";
        challengeInput.disabled = false;
        challengeInput.focus();
        hintButton.disabled = false;
        solutionButton.disabled = false;
  
        hintButton.addEventListener("click", () => {
          document.getElementById("feedback").innerText = `Hint: ${challenge.hint}`;
        });
  
        solutionButton.addEventListener("click", () => {
          document.getElementById("feedback").innerText = `Solution: ${challenge.answer}`;
          challengeInput.disabled = true;
          hintButton.disabled = true;
          solutionButton.disabled = true;
        });
  
        document.getElementById("feedback").innerText = "";
        challengeInput.addEventListener("input", function inputListener() {
          const answer = challengeInput.value.trim();
          if (answer === challenge.answer) {
            document.getElementById("feedback").innerText = "Correct!";
            challengeInput.disabled = true;
            hintButton.disabled = true;
            solutionButton.disabled = true;
            challengeInput.removeEventListener("input", inputListener);
            challengeIndex++;
            setTimeout(loadNextChallenge, 1000);
          } else if (!challenge.answer.startsWith(answer)) {
            document.getElementById("feedback").innerText = "Incorrect! Try again.";
          }
        });
      } else {
        document.getElementById("challenge-task").innerText = "All challenges completed!";
        document.getElementById("challenge-input").disabled = true;
        document.getElementById("hint-btn").disabled = true;
        document.getElementById("solution-btn").disabled = true;
        isWritingChallengeRunning = false;
      }
    }
  
    loadNextChallenge();
  }
  
  // Vocabulary Challenge Logic
  function startVocabularyChallenge() {
    isVocabularyChallengeRunning = true;
    let wordIndex = 0;
  
    function loadNextWord() {
      if (wordIndex < vocabularyWords.length) {
        const word = vocabularyWords[wordIndex];
        document.getElementById("vocab-word").innerText = word;
  
        const vocabInput = document.getElementById("vocab-input");
        vocabInput.value = "";
        vocabInput.disabled = false;
        vocabInput.focus();
  
        document.getElementById("vocab-feedback").innerText = "";
        vocabInput.addEventListener("input", function inputListener() {
          const typedWord = vocabInput.value.trim();
          if (typedWord === word) {
            document.getElementById("vocab-feedback").innerText = "Correct!";
            vocabInput.disabled = true;
            vocabInput.removeEventListener("input", inputListener);
            wordIndex++;
            setTimeout(loadNextWord, 1000);
          } else if (!word.startsWith(typedWord)) {
            document.getElementById("vocab-feedback").innerText = "Incorrect! Try again.";
          }
        });
      } else {
        document.getElementById("vocab-word").innerText = "All words completed!";
        document.getElementById("vocab-input").disabled = true;
        isVocabularyChallengeRunning = false;
      }
    }
  
    loadNextWord();
  }
  