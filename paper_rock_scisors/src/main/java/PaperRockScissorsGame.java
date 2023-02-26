import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PaperRockScissorsGame {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final ArrayList<String> arrayList = new ArrayList<>();
    private static final String PAPER = "Paper";
    private static final String ROCK = "Rock";
    private static final String SCISSORS = "Scissors";

    public void play() {
        ArrayList<String> arrays = addValues();
        printValues(arrays);
        int userChoice = getUserChoice(scanner, arrays);
        int computerChoice = getComputerChoice(arrays);
        checkWhoWon(userChoice, computerChoice);
    }

    private ArrayList<String> addValues() {
        arrayList.add(PAPER);
        arrayList.add(ROCK);
        arrayList.add(SCISSORS);
        return arrayList;
    }

    private void printValues(ArrayList<String> strings) {
        System.out.println("Choose one of the following numbers:");
        int counter = 0;
        for (String element : strings) {
            counter++;
            System.out.println("[" + counter + "]" + " " + element);
        }
    }
    private int getUserChoice(Scanner scanner, ArrayList<String> strings) {
        int userIndexChoice = scanner.nextInt() - 1;
        String userChoice = strings.get(userIndexChoice);
        System.out.println("You choose: " + userChoice);
        return userIndexChoice;
    }
    private int getComputerChoice(ArrayList<String> strings) {
        int computerIndexChoice = random.nextInt(3);
        String randomValue = strings.get(computerIndexChoice);
        System.out.println("Computer choose: " + randomValue);
        return computerIndexChoice;
    }

    private void checkWhoWon(int userChoice, int computerChoice) {
        if (checkComputerWon(userChoice, computerChoice)) {
            System.out.println("Computer won.");
        } else if (checkUserWon(userChoice, computerChoice)) {
            System.out.println("User won.");
        } else {
            System.out.println("Draw.");
        }
    }
    private boolean checkComputerWon(int userChoice, int computerChoice) {
        return userChoice == 0 && computerChoice == 2 || userChoice == 1 && computerChoice == 0 || userChoice == 2 && computerChoice == 1;
    }
    private boolean checkUserWon(int userChoice, int computerChoice) {
        return userChoice == 2 && computerChoice == 0 || userChoice == 0 && computerChoice == 1 || userChoice == 1 && computerChoice == 2;
    }
}