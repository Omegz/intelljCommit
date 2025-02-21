import java.util.Random; // import random class
import java.util.Scanner; // import scanner class

public class DiceGame { // lav en class med navnet DiceGame
    static Random random = new Random();// lav en random generator
    static Scanner scanner = new Scanner(System.in);// lav en ny scanner

    public static void main(String[] args) { // lav main metode
        int playerScore = 0; // definer player score som integer
        int dealerScore = 0; // definer dealer score som integer

        System.out.println("Welcome to the Dice Game!");

        // Player's turn
        System.out.println("\n--- PLAYER'S TURN ---");
        playerScore = rollDice("Player", playerScore); // the player rolls and gets a score

        // Dealer's turn
        System.out.println("\n--- DEALER'S TURN ---");
        dealerScore = rollDice("Dealer", dealerScore); // the dealer rolls and gets a score

        // Announce winner
        announceWinner(playerScore, dealerScore); // both scores geta announced

        scanner.close(); // lukker scanner
    }

    public static int rollDice(String role, int score) { // ny metode som bruger player/dealer + scor som perimeter
        String userChoice; // definer string som user choice

        do { // begin a loop
            int dice1 = random.nextInt(6) + 1; // Dice roll (1-6)
            int dice2 = random.nextInt(6) + 1; // Dice roll (1-6)
            int sum = dice1 + dice2; // show a sum of the two rolls

            score += sum; // Add sum to total score

            System.out.println(role + " rolled: " + dice1 + " + " + dice2 + " = " + sum);
            System.out.println(role + "'s total score is: " + score);

            // Stop rolling if score reaches 21 or more
            if (score >= 21) {
                System.out.println(role + " has reached or exceeded 21! Stopping...");
                break; // end loop
            }

            // If dealer, roll automatically until score is 15+
            if (role.equals("Dealer")) {
                if (score >= 15) {
                    System.out.println("Dealer stops rolling.");
                    break;
                }
                System.out.println("Dealer rolls again...");
            } else {
                // Ask player if they want to roll again
                System.out.print("Do you want to roll again? (yes/no): ");
                userChoice = scanner.nextLine().toLowerCase();
                if (!userChoice.equals("yes")) break;
            }

        } while (true); // Dealer keeps rolling until score reaches 15+

        return score; // display score
    }

    public static void announceWinner(int playerScore, int dealerScore) { //announce both scores
        System.out.println("\nFinal Scores:");
        System.out.println("Player's Score: " + playerScore);
        System.out.println("Dealer's Score: " + dealerScore); //show both scores

        if (playerScore > 21) {
            System.out.println("Player busted! Dealer wins!");
        } else if (dealerScore > 21) {
            System.out.println("Dealer busted! Player wins!");
        } else if (playerScore > dealerScore) {
            System.out.println("Player Wins!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer Wins!");
        } else {
            System.out.println("It's a Tie!");
        }
    }
}
