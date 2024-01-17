import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        int chosenNumber = 0;

        while (chosenNumber <= 0) {
            System.out.println("Você gostaria de ver a pirâmide de qual número?");
            System.out.println("Insira um número maior que zero.");

            chosenNumber = userInput.nextInt();
        }

        System.out.println("");

        for (int i = 1; i <= chosenNumber; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
