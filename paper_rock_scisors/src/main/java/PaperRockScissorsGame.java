import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PaperRockScissorsGame {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final ArrayList<String> arrayList = new ArrayList<>();

    public void play() {
        ArrayList<String> arrays = addValues();
        getValuesFromArrayList(arrays);
        int userChoice = getUserValue(scanner);
        int computerChoice = getRandomValueFromArray(arrays);
        checkWhoWon(userChoice, computerChoice);
    }

    private ArrayList<String> addValues() {
        arrayList.add("paper");
        arrayList.add( "rock");
        arrayList.add( "scissors");
        return arrayList;
    }

    private void getValuesFromArrayList(ArrayList<String> strings) {
        System.out.println("Choose one of the following numbers:");
        int counter = 0;
        for (String element : strings) {
            counter++;
            System.out.println("[" + counter + "]" + " " + element);
        }
    }
    private int getUserValue(Scanner scanner) {
        return scanner.nextInt() - 1;
    }
    private int getRandomValueFromArray(ArrayList<String> strings) {
        int randomNumber = random.nextInt(3);
        String randomValue = strings.get(randomNumber);
        System.out.println("Computer choose " + randomValue);
        return randomNumber;
    }

    private void checkWhoWon(int userChoose, int computerChoose) {
        if (userChoose == 0 && computerChoose == 2 || userChoose == 1 && computerChoose == 0 || userChoose == 2 && computerChoose == 1) {
            System.out.println("Computer won.");
        } else if (userChoose == 2 && computerChoose == 0 || userChoose == 0 && computerChoose == 1 || userChoose == 1 && computerChoose == 2) {
            System.out.println("User won.");
        } else {
            System.out.println("Draw.");
        }
    }
}