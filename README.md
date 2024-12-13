# Typing, Writing, and Vocabulary Proficiency Game
To develop an educational game designed to enhance typing speed, writing proficiency, and vocabulary. The game encourages users to write with precision, expand their vocabulary, and improve typing accuracy through gamified challenges.

**<h3>Table of Contents</h3>**
<br>Introduction
<br>1.1 Objective
<br>1.2 Problem Statement
<br>1.3 Goals
<br>Scope
<br>Functional Requirements
<br>Non-Functional Requirements
<br>Technical Requirements
<br>System Design and Architecture
<br>6.1 Overview
<br>6.2 Diagrams
<br>User Interface Design
<br>Testing Plan
<br>Monitoring Plan
<br>Glossary
<br>References

**<h3>Introduction</h3>**

**<h5>1.1 Objective</h5>**

The primary objective of this project is to create an innovative and engaging platform that combines the elements of gamification with language skill development. The application aims to holistically improve three core areas of language proficiency:

**Typing Speed and Accuracy:**

Measure and enhance users' typing abilities by testing their speed (Words Per Minute or WPM) and accuracy through dynamic and progressively challenging tasks.
Provide instant feedback to help users identify and correct mistakes, thus fostering real-time learning.

**Writing Proficiency:**

Focus on improving grammatical accuracy, punctuation, and sentence structure through carefully designed writing challenges.<br>
Help users develop their skills in sentence construction, error correction, and coherent expression of ideas.

**Vocabulary Development:**

Introduce new vocabulary to users in an interactive manner, encouraging retention through repetitive tasks and contextual usage.
Expand the user's lexicon by challenging them to type and incorporate words correctly within sentences or scenarios.<br>
By integrating these elements, the game seeks to address the limitations of traditional typing applications that focus solely on speed, neglecting other critical components of language proficiency. The platform aspires to become a comprehensive tool for individuals looking to enhance their typing skills alongside their command of grammar and vocabulary, making it suitable for students, professionals, and language enthusiasts.

**Specific Goals:**

Engage users through gamified tasks to make learning enjoyable and sustainable.
Foster measurable improvement in both technical (typing) and language (writing and vocabulary) skills.<br>
Encourage continuous learning by offering detailed progress tracking and personalized feedback.
Provide a scalable platform that supports users at varying levels of proficiency, from beginners to advanced learners.<br>

**Impact:**

Empower users with enhanced typing efficiency for personal and professional communication.
Build stronger language skills that contribute to academic and workplace success.
Promote lifelong learning habits through an engaging and adaptive educational tool.

**<h5>1.2 Problem Statement</h5>**

Most typing games focus only on speed and accuracy, neglecting other essential language skills such as writing proficiency and vocabulary building. This project addresses this gap, creating a holistic platform to improve typing, writing, and vocabulary skills simultaneously.

**<h5>1.3 Goals</h5>**

The Typing, Writing, and Vocabulary Proficiency Game is designed with a holistic approach to improve multiple aspects of language and typing skills. The detailed goals are categorized into three main areas, with a focus on measurable improvements and impactful learning.

**1. Improve Typing Proficiency**
   
The game aims to develop speed and accuracy in typing by:

<h6>Speed Improvement:</h6> Help users increase their typing speed (measured in Words Per Minute, or WPM) through structured and progressively challenging exercises.<br>

<h6>Error Reduction:</h6> Focus on minimizing typing errors, including spelling, punctuation, and capitalization.<br>

<h6>Muscle Memory:</h6> Encourage repetitive exercises to instill efficient typing habits, fostering faster and error-free typing through muscle memory.<br>

<h6>Real-Time Feedback:</h6> Provide instant feedback to users, showing WPM, error rates, and missed keypresses, enabling continuous improvement.<br>

<br>**2. Enhance Writing Proficiency**

Developing strong writing skills is a core goal of this application, achieved through:

<h6>Grammar Mastery:</h6> Teach users the rules of grammar and syntax through interactive exercises. Users will identify, correct, and learn from grammatical mistakes in sentences.<br>

<h6>Sentence Structuring:</h6> Improve users' ability to construct coherent and grammatically correct sentences by presenting tasks such as:<br>

Rearranging Sentences: Unscrambling words or phrases to form logical sentences.<br>
Fill-in-the-Blank: Completing sentences with appropriate grammar and vocabulary.<br>

<h6>Punctuation Awareness:</h6> Train users to apply punctuation correctly through structured challenges that target commas, periods, colons, semicolons, and more.<br>

<h6>Contextual Writing:</h6> Encourage users to write responses to prompts using correct grammar, structure, and style.<br>


<br>**3. Build Vocabulary Proficiency**

The game emphasizes vocabulary development through:

<h6>Word Familiarity:</h6> Introduce new words in each session, increasing users’ exposure to diverse vocabulary.<br>

<h6>Spelling Accuracy:</h6> Train users to spell words correctly, focusing on both commonly used and challenging terms.<br>

<h6>Contextual Usage:</h6> Encourage users to use newly introduced words in proper contexts, improving comprehension and sentence-level application.<br>

<h6>Retention:</h6> Track learned words and periodically test users on them to ensure long-term retention.<br>

<h6>Feedback Mechanisms:</h6> Highlight common errors in vocabulary usage and provide suggestions for improvement.<br>

<br>**Impact Goals**

<h6>Accessibility:</h6> Make the platform user-friendly and accessible to a wide audience, from beginners to advanced users.<br>
<h6>Sustainability:</h6> Foster lifelong learning habits through engaging and incremental skill-building exercises.<br>
<h6>Skill Transferability:</h6> Ensure that skills gained in the game translate to real-world scenarios, such as faster typing on exams, better grammar in professional emails, and improved vocabulary in communication.<br>

**<h3>Scope</h3>**

**Included Features**

<h6>Typing Speed Test:</h6> Test typing speed and accuracy using sentences and paragraphs.<br>
<h6>Writing Proficiency Challenges:</h6>
Grammar correction tasks.<br>
Sentence rearrangement.<br>
Fill-in-the-blank challenges.<br>

<h6>Vocabulary Challenges:</h6>
Typing and spelling new words.<br>
Using words in sentences with contextual hints.<br>
<h6>Scoring System:</h6> Real-time feedback and scoring based on performance metrics.
<h6>Progress Tracking:</h6> Display graphs and reports showing improvement over time.

**Excluded Features**
Multiplayer mode.<br>
Advanced AI grammar and essay analysis.<br>
Customizable text prompts.<br>


**<h3>Functional Requirements</h3>**

**Core Features**

<h6>Typing Test:</h6>

Displays dynamic sentences or paragraphs.<br>
Measures Words Per Minute (WPM) and accuracy.<br>
Increases difficulty with user progress.<br>

<h6>Writing Challenges:</h6>

Grammar Correction: Identify and fix grammatical errors.<br>
Sentence Rearrangement: Organize jumbled sentences.<br>
Fill-in-the-Blank: Complete sentences with appropriate words.<br>

<h6>Vocabulary Building:</h6>

Introduces random words for spelling tests.<br>
Prompts contextual word usage in sentences.<br>
Tracks learned words and tests recall.<br>

**Additional Features**

Comprehensive scoring system for typing and writing proficiency.<br>
Progress tracking graphs for typing speed and vocabulary mastery.<br>


**<h3>Non-Functional Requirements</h3>**

<h5>Performance:</h5> Must handle 1000 concurrent users for web versions.
<h5>Reliability:</h5> Ensure 99.9% uptime.
<h5>Scalability:</h5> Support dynamic addition of new challenges and words.
<h5>Security:</h5> Data encryption and user authentication.

**<h3>Technical Requirements</h3>**

**Technology Stack**
•	<h5>Programming Language(s):</h5>

o	Java: For building the desktop version with JavaFX to manage UI and game logic.<br>

o	JavaScript/HTML5 (for a web-based version): If developed for browsers, JavaScript would be used alongside HTML5/CSS.
•	<h5>Frameworks:</h5>

o	JavaFX: To handle the UI and game flow for the desktop version.<br>

o	React or Vue.js (for a web-based version): If building a web version, React or Vue.js could be used for creating dynamic and interactive web pages.
•	<h5>Tools:</h5>

o	Git: For version control.<br>

o	Maven: For managing dependencies in the Java-based project.<br>

o	ESLint/Prettier: For ensuring code quality (if using JavaScript for the web version).
•	<h5>Libraries:</h5>

o	JUnit: For unit testing, particularly to ensure that typing mechanics and the scoring system function correctly.<br>

o	SQLite: To store player statistics locally, such as their scores, WPM, accuracy, and vocabulary usage history.<br>


**<h3>System Design and Architecture</h3>**

**<h5>6.1 Overview</h5>**

The application has three main layers:

<h5>User Interface (UI):</h5> Displays game prompts and collects user input.<br>
<h5>Logic Layer:</h5> Processes input, calculates scores, and generates feedback.<br>
<h5>Database Layer:</h5> Stores user data, scores, and progress history.<br>

**<h5>6.2 Diagrams</h5>**

<h5>Component Diagram:</h5>


| User Interface  |  <-->  | Logic Layer    | <-->  | Database Layer |
              


<h5>Data Flow Diagram:</h5>


User Input -> Logic -> Score Calculation -> Feedback -> UI Update


**<h3>User Interface Design</h3>**

<h5>Navigation Flow</h5>

Login/Sign-Up -> Dashboard -> Game Modes -> Results/Feedback.

<h5>UI Features</h5>

<h6>Typing Test Screen:</h6>
Timer and real-time WPM display.<br>
Text input field with dynamic prompts.<br>
<h6>Writing Task Screen:</h6>
Highlighted text for grammar corrections.<br>
Drag-and-drop for sentence rearrangement.<br>
<h6>Vocabulary Task Screen:</h6>
Flashcards with spelling tasks.<br>
Sentence prompts with word suggestions<br>

**<h3>Testing Plan</h3>**

**Testing Plan**

<h6>Test Objectives</h6>
Verify typing accuracy and speed calculations.<br>
Validate grammar correction logic.<br>
Test progress tracking and data persistence.<br>

<h6>Sample Test Cases</h6>

Test ID	:&nbsp;&nbsp;&nbsp;  Input	Expected Output <br>
TC001	 :&nbsp;&nbsp;&nbsp;     Typing test paragraph	 :&nbsp;&nbsp;&nbsp;     WPM and accuracy calculated correctly<br>
TC002    :&nbsp;&nbsp;&nbsp;  	Incorrect sentence input:&nbsp;&nbsp;&nbsp;	  Correct grammar displayed<br>
TC003	    :&nbsp;&nbsp;&nbsp;  Misspelled word	  :&nbsp;&nbsp;&nbsp;         Feedback with correct spelling<br>

**<h3>Monitoring Plan</h3>**
**Key Metrics**
<h5>Performance:</h5> Response time, server load.
<h5>Engagement:</h5> Active users, average session time.
<h5>Error Tracking:</h5> Input validation errors, crashes.


**<h3>Glossary</h3>**
<h5>WPM:</h5> Words Per Minute, a metric for typing speed.
<h5>UI:</h5>User Interface.
<h5>ERD:</h5> Entity Relationship Diagram.

**<h3>References</h3>**
Project specifications and design templates​​.<br>
Best practices in gamified learning.<br>


