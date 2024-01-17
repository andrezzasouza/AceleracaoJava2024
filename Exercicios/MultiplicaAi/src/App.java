import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Você deseja ver a tabuada de qual número?");
        Scanner userInput = new Scanner(System.in);

        int chosenNumber = userInput.nextInt();

        System.out.println("Tabela de multiplicação por " + chosenNumber);

        for (int i = 1; i <= 10; i++) {
            int result = chosenNumber * i;
            System.out.println(chosenNumber + " x " + i + " = " + result);
        }
    }
}
