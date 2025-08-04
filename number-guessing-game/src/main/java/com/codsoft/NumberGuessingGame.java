package com.codsoft;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * CODSOFT Task 1: Number Guessing Game
 * 
 * Features:
 * 1. Generate random number (1-100)
 * 2. User input for guessing
 * 3. Feedback (correct, too high, too low)
 * 4. Limited attempts
 * 5. Multiple rounds
 * 6. Scoring system
 */
public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    private int totalRounds = 0;
    private int roundsWon = 0;
    private int bestScore = Integer.MAX_VALUE;
    private int totalScore = 0;
    private int consecutiveWins = 0;
    private int maxConsecutiveWins = 0;
    private long startTime;
    private List<String> achievements = new ArrayList<>();
    private Map<String, Integer> difficultyStats = new HashMap<>();
    
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startTime = System.currentTimeMillis();
        game.displayWelcomeMessage();
        game.playGame();
        game.displayFinalResults();
        game.displayAchievements();
        scanner.close();
    }
    
    private void displayWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    NUMBER GUESSING GAME                     ║");
        System.out.println("║                        CODSOFT Task 1                       ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Rules:                                                      ║");
        System.out.println("║  • Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "                    ║");
        System.out.println("║  • You have " + MAX_ATTEMPTS + " attempts per round                           ║");
        System.out.println("║  • Score is based on number of attempts (lower = better)     ║");
        System.out.println("║  • Play multiple rounds to improve your score!               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private void playGame() {
        boolean playAgain = true;
        
        while (playAgain) {
            totalRounds++;
            System.out.println("🎮 ROUND " + totalRounds + " 🎮");
            System.out.println("=" .repeat(50));
            
            int targetNumber = generateRandomNumber();
            int attempts = playRound(targetNumber);
            
            if (attempts <= MAX_ATTEMPTS) {
                roundsWon++;
                consecutiveWins++;
                if (consecutiveWins > maxConsecutiveWins) {
                    maxConsecutiveWins = consecutiveWins;
                }
                updateBestScore(attempts);
                int roundScore = calculateScore(attempts);
                totalScore += roundScore;
                
                System.out.println("🎉 CONGRATULATIONS! You guessed it in " + attempts + " attempts!");
                System.out.println("🏆 Your score for this round: " + roundScore + " points");
                System.out.println("🔥 Consecutive wins: " + consecutiveWins);
                
                // Check for achievements
                checkAchievements(attempts, consecutiveWins, totalScore);
                
            } else {
                consecutiveWins = 0;
                System.out.println("❌ Game Over! You've used all " + MAX_ATTEMPTS + " attempts.");
                System.out.println("🔢 The number was: " + targetNumber);
                System.out.println("💔 Consecutive wins reset to 0");
            }
            
            displayRoundStats();
            playAgain = askToPlayAgain();
            System.out.println();
        }
    }
    
    private int generateRandomNumber() {
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
    
    private int playRound(int targetNumber) {
        int attempts = 0;
        
        while (attempts < MAX_ATTEMPTS) {
            attempts++;
            int remainingAttempts = MAX_ATTEMPTS - attempts;
            
            System.out.print("📝 Enter your guess (1-100) [Attempt " + attempts + "/" + MAX_ATTEMPTS + "]: ");
            
            int userGuess = getUserInput();
            
            if (userGuess == targetNumber) {
                return attempts;
            } else if (userGuess < targetNumber) {
                System.out.println("⬆️  Too low! Try a higher number.");
            } else {
                System.out.println("⬇️  Too high! Try a lower number.");
            }
            
            if (remainingAttempts > 0) {
                System.out.println("💡 Hints remaining: " + remainingAttempts);
            }
            System.out.println();
        }
        
        return attempts;
    }
    
    private int getUserInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= MIN_NUMBER && input <= MAX_NUMBER) {
                    return input;
                } else {
                    System.out.println("❌ Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private void updateBestScore(int attempts) {
        if (attempts < bestScore) {
            bestScore = attempts;
        }
    }
    
    private int calculateScore(int attempts) {
        // Score calculation: 100 points for 1 attempt, decreasing by 10 for each additional attempt
        return Math.max(10, 100 - (attempts - 1) * 10);
    }
    
    private void displayRoundStats() {
        System.out.println();
        System.out.println("📊 ROUND STATISTICS:");
        System.out.println("   • Rounds played: " + totalRounds);
        System.out.println("   • Rounds won: " + roundsWon);
        System.out.println("   • Win rate: " + String.format("%.1f", (double) roundsWon / totalRounds * 100) + "%");
        System.out.println("   • Total score: " + totalScore + " points");
        System.out.println("   • Consecutive wins: " + consecutiveWins);
        System.out.println("   • Max consecutive wins: " + maxConsecutiveWins);
        if (bestScore != Integer.MAX_VALUE) {
            System.out.println("   • Best performance: " + bestScore + " attempts");
        }
        System.out.println("   • Achievements unlocked: " + achievements.size());
        System.out.println();
    }
    
    private boolean askToPlayAgain() {
        while (true) {
            System.out.print("🔄 Would you like to play another round? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
    
    private void displayFinalResults() {
        long playTime = (System.currentTimeMillis() - startTime) / 1000; // in seconds
        
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        FINAL RESULTS                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Total Rounds Played: " + String.format("%-35s", totalRounds) + "║");
        System.out.println("║  Rounds Won: " + String.format("%-40s", roundsWon) + "║");
        System.out.println("║  Win Rate: " + String.format("%-41s", String.format("%.1f%%", (double) roundsWon / totalRounds * 100)) + "║");
        System.out.println("║  Total Score: " + String.format("%-38s", totalScore + " points") + "║");
        System.out.println("║  Max Consecutive Wins: " + String.format("%-32s", maxConsecutiveWins) + "║");
        System.out.println("║  Play Time: " + String.format("%-40s", formatTime(playTime)) + "║");
        
        if (bestScore != Integer.MAX_VALUE) {
            System.out.println("║  Best Performance: " + String.format("%-35s", bestScore + " attempts") + "║");
            System.out.println("║  Best Score: " + String.format("%-40s", calculateScore(bestScore) + " points") + "║");
        }
        
        System.out.println("║  Achievements Unlocked: " + String.format("%-30s", achievements.size()) + "║");
        System.out.println("║                                                              ║");
        System.out.println("║  Thank you for playing! 🎮                                  ║");
        System.out.println("║  #codsoft #internship #javadevelopment                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
    
    private void checkAchievements(int attempts, int consecutiveWins, int totalScore) {
        // First win achievement
        if (roundsWon == 1 && !achievements.contains("🎯 First Victory")) {
            achievements.add("🎯 First Victory");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: First Victory!");
        }
        
        // Perfect guess achievement
        if (attempts == 1 && !achievements.contains("⚡ Lightning Fast")) {
            achievements.add("⚡ Lightning Fast");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Lightning Fast (1 attempt)!");
        }
        
        // Consecutive wins achievements
        if (consecutiveWins == 3 && !achievements.contains("🔥 Hot Streak")) {
            achievements.add("🔥 Hot Streak");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Hot Streak (3 consecutive wins)!");
        }
        
        if (consecutiveWins == 5 && !achievements.contains("🔥🔥 On Fire")) {
            achievements.add("🔥🔥 On Fire");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: On Fire (5 consecutive wins)!");
        }
        
        if (consecutiveWins == 10 && !achievements.contains("🔥🔥🔥 Unstoppable")) {
            achievements.add("🔥🔥🔥 Unstoppable");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Unstoppable (10 consecutive wins)!");
        }
        
        // Score achievements
        if (totalScore >= 500 && !achievements.contains("💰 Score Collector")) {
            achievements.add("💰 Score Collector");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Score Collector (500+ points)!");
        }
        
        if (totalScore >= 1000 && !achievements.contains("💰💰 High Roller")) {
            achievements.add("💰💰 High Roller");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: High Roller (1000+ points)!");
        }
        
        // Rounds achievements
        if (totalRounds >= 10 && !achievements.contains("🎮 Dedicated Player")) {
            achievements.add("🎮 Dedicated Player");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Dedicated Player (10+ rounds)!");
        }
        
        if (totalRounds >= 25 && !achievements.contains("🎮🎮 Veteran Player")) {
            achievements.add("🎮🎮 Veteran Player");
            System.out.println("🏆 ACHIEVEMENT UNLOCKED: Veteran Player (25+ rounds)!");
        }
    }
    
    private void displayAchievements() {
        if (!achievements.isEmpty()) {
            System.out.println("\n🏆 ACHIEVEMENTS UNLOCKED:");
            System.out.println("=" .repeat(50));
            for (String achievement : achievements) {
                System.out.println("   " + achievement);
            }
            System.out.println("=" .repeat(50));
        }
    }
    
    private String formatTime(long seconds) {
        if (seconds < 60) {
            return seconds + " seconds";
        } else if (seconds < 3600) {
            return (seconds / 60) + " minutes " + (seconds % 60) + " seconds";
        } else {
            return (seconds / 3600) + " hours " + ((seconds % 3600) / 60) + " minutes";
        }
    }
} 