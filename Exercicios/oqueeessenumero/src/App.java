import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira um número:");
        
        Scanner userInput = new Scanner(System.in);
        int chosenNumber = userInput.nextInt();

        String tipoDoNumber = chosenNumber + " é ";

        if (chosenNumber % 2 == 0) {
            tipoDoNumber += "par";
        } else {
            tipoDoNumber += "ímpar";
        }

        if (chosenNumber >= 0) {
            tipoDoNumber += " e positivo.";
        } else {
            tipoDoNumber += " e negativo.";
        }

        System.out.println(tipoDoNumber);
    }
}
