import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I've generated a number between " + minRange + " and " + maxRange + ".");
            
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } 
                else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } 
                else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
