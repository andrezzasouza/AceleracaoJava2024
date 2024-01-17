import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int chosenNumber = 0;
        Scanner userInput = new Scanner(System.in);

        while (chosenNumber <= 0 || chosenNumber >= 94) {
            if (chosenNumber <= 0) {
                System.out.println("Seu número deve ser maior que 0 para que o algoritmo funcione.");
            } else if (chosenNumber >= 94) {
                System.out.println("Seu número deve ser menor que 94 para que o algoritmo funcione.");
            }
            System.out.println("Qual é o tamanho que você quer para sua sequência de Fibonacci?");

            chosenNumber = userInput.nextInt();
        }

        String fibonacciSequence = "";
        long formerNumber = 0;
        long latterNumber = 1;

        for (int i = 1; i <= chosenNumber; i++) {
            if (i == 1) {
                fibonacciSequence += formerNumber;
            } else if (i == 2) {
                fibonacciSequence += " " + latterNumber;
            } else {
                long currentNumber = formerNumber + latterNumber;
                fibonacciSequence += " " + currentNumber;

                formerNumber = latterNumber;
                latterNumber = currentNumber;
            }
        }

        System.out.println(fibonacciSequence);
    }
}
