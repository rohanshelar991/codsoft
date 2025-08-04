# Number Guessing Game 🎮

**CODSOFT Task 1: Java Development Internship**

A fun and interactive number guessing game built in Java with advanced features including scoring system, multiple rounds, and detailed statistics.

## 🎯 Features

### Core Features
- **Random Number Generation**: Generates random numbers between 1-100
- **User Input Validation**: Robust input handling with error checking
- **Smart Feedback**: Provides hints (too high/too low) for each guess
- **Attempt Limiting**: Maximum 10 attempts per round
- **Multiple Rounds**: Play as many rounds as you want
- **Scoring System**: Points based on number of attempts (lower = better)

### Advanced Features
- **Real-time Statistics**: Track rounds played, win rate, and best performance
- **Beautiful UI**: ASCII art borders and emojis for enhanced user experience
- **Performance Tracking**: Records best score across all rounds
- **Detailed Results**: Comprehensive final report with all statistics

## 🚀 Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Build Instructions

1. **Clone or download the project**
   ```bash
   cd number-guessing-game
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Run the game**
   ```bash
   mvn exec:java -Dexec.mainClass="com.codsoft.NumberGuessingGame"
   ```

   Or build and run the JAR:
   ```bash
   mvn clean package
   java -jar target/number-guessing-game-1.0.0.jar
   ```

## 🎮 How to Play

1. **Start the Game**: Run the application
2. **Read Rules**: Review the game rules displayed at startup
3. **Make Guesses**: Enter numbers between 1-100
4. **Get Feedback**: Receive hints after each guess
5. **Win or Lose**: Guess correctly within 10 attempts or try again
6. **Play Again**: Choose to play multiple rounds
7. **View Results**: See your final statistics and performance

## 📊 Scoring System

- **1 attempt**: 100 points
- **2 attempts**: 90 points
- **3 attempts**: 80 points
- **...and so on**
- **10+ attempts**: 10 points (minimum)

## 🏆 Game Statistics

The game tracks:
- Total rounds played
- Rounds won
- Win rate percentage
- Best performance (lowest attempts)
- Best score (highest points)

## 🎨 Sample Output

```
╔══════════════════════════════════════════════════════════════╗
║                    NUMBER GUESSING GAME                     ║
║                        CODSOFT Task 1                       ║
╠══════════════════════════════════════════════════════════════╣
║  Rules:                                                      ║
║  • Guess a number between 1 and 100                    ║
║  • You have 10 attempts per round                           ║
║  • Score is based on number of attempts (lower = better)     ║
║  • Play multiple rounds to improve your score!               ║
╚══════════════════════════════════════════════════════════════╝

🎮 ROUND 1 🎮
==================================================
📝 Enter your guess (1-100) [Attempt 1/10]: 50
⬇️  Too high! Try a lower number.
💡 Hints remaining: 9

📝 Enter your guess (1-100) [Attempt 2/10]: 25
⬆️  Too low! Try a higher number.
💡 Hints remaining: 8

🎉 CONGRATULATIONS! You guessed it in 3 attempts!
🏆 Your score for this round: 80 points
```

## 🛠️ Technical Details

### Project Structure
```
number-guessing-game/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
└── src/
    └── main/
        └── java/
            └── com/
                └── codsoft/
                    └── NumberGuessingGame.java  # Main game class
```

### Key Classes
- **NumberGuessingGame**: Main game logic and user interface
- **Random**: Java utility for random number generation
- **Scanner**: Input handling and validation

### Design Patterns
- **Single Responsibility**: Each method has a specific purpose
- **Input Validation**: Robust error handling for user input
- **Modular Design**: Clean separation of concerns

## 🎯 Learning Objectives

This project demonstrates:
- **Java Fundamentals**: Variables, loops, conditionals, methods
- **Object-Oriented Programming**: Classes, encapsulation, data organization
- **User Input Handling**: Scanner class, input validation, error handling
- **Random Number Generation**: Math.random() and Random class
- **String Manipulation**: Formatting, concatenation, emoji usage
- **Maven Project Management**: Build configuration and dependencies

## 📝 CODSOFT Internship Requirements

✅ **Task Completion**: Complete number guessing game with all required features  
✅ **GitHub Repository**: Properly organized project structure  
✅ **Documentation**: Comprehensive README with setup instructions  
✅ **Code Quality**: Clean, well-commented, and maintainable code  
✅ **Advanced Features**: Scoring system, multiple rounds, statistics  

## 🏷️ Tags

#codsoft #internship #javadevelopment #numbergame #consoleapp

## 📞 Support

For questions or issues related to this CODSOFT task, please refer to the internship guidelines or contact your mentor.

---

**Developed for CODSOFT Java Development Internship**  
**Task 1: Number Guessing Game**  
**Author: [Your Name]**  
**Date: [Current Date]** 