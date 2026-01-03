# Number Guessing Game Web Application

A modern, interactive number guessing game built with HTML, CSS, and JavaScript. The game challenges players to guess a randomly generated number within a specified range.

## Features

### ✅ Functional Requirements
- **Random Number Generation**: Generates a random number within a specified range (default: 1-100)
- **User Input**: Prompts the user to enter their guess
- **Intelligent Feedback**: Provides real-time feedback (Too high, Too low, Correct)
- **Attempt Limit**: Limits the number of attempts (10 by default)
- **Multiple Rounds**: Supports multiple rounds with "Play Again" option
- **Score System**: Maintains scores based on attempts taken and rounds won

### 🎨 UI/UX Requirements
- Clean, modern game-card layout
- Large readable input fields and buttons
- Real-time feedback messages
- Progress indicator for attempts left
- Smooth animations and transitions
- Dark/light mode toggle
- Fully responsive design (mobile + desktop)

### 🚀 Advanced Enhancements
- Adjustable number range (1-50, 1-100, 1-200, 1-500)
- Best score tracking using localStorage
- Restart and reset controls
- Guess history tracking
- Visual feedback for game states

## How to Play

1. Open the `index.html` file in any modern web browser
2. Select your preferred number range (1-50, 1-100, 1-200, or 1-500)
3. Enter your guess in the input field
4. Click "Submit Guess" or press Enter
5. Receive feedback on whether your guess was too high or too low
6. Continue guessing until you find the number or run out of attempts
7. Use the control buttons to start a new game, restart, or reset scores

## Technical Details

- Built with vanilla HTML, CSS, and JavaScript (no frameworks)
- Responsive design using CSS Flexbox and Grid
- Modern CSS features like CSS variables for theming
- LocalStorage for score persistence
- Modular JavaScript with clear functions
- Well-commented code for maintainability

## Game Features

- **Scoring System**: Points based on attempts remaining when you guess correctly
- **Progress Bar**: Visual indicator of remaining attempts
- **Guess History**: Track your previous guesses
- **Statistics**: Current score, best score, games played, and games won
- **Range Selection**: Choose from different difficulty levels

## Browser Compatibility

The application works in all modern browsers (Chrome, Firefox, Safari, Edge) that support:
- localStorage
- CSS variables
- Flexbox and Grid layout

## Score Persistence

The game saves your best score, games played, and games won using localStorage, so your progress is maintained between sessions.