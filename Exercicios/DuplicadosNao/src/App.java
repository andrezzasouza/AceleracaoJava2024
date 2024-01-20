import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite os elementos da primeira lista separados por vírgulas:");

        String elementsForFirstList = userInput.nextLine();

        System.out.println("Digite os elementos da segunda lista separados por vírgulas:");

        String elementsForSecondList = userInput.nextLine();

        List<String> firstListOfElements = new ArrayList<String>(Arrays.asList(elementsForFirstList.split(", ")));
        List<String> secondListOfElements = new ArrayList<String>(Arrays.asList(elementsForSecondList.split(", ")));

        for (int i = 0; i < firstListOfElements.size(); i++) {
            String currentElement = firstListOfElements.get(i);
            boolean isRepeated = secondListOfElements.contains(currentElement);

            if (isRepeated) {
                System.out.println(currentElement);
            }
        }
    }
}
