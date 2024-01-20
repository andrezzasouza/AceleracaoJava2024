import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int chosenOption = 0;

        List<Holiday> allHolidays = generateHolidays();

        Scanner userInput = new Scanner(System.in);

        while (chosenOption != 1 || chosenOption != 2) {
            System.out.println("Digite o número do que você deseja consultar:");
            System.out.println("1 -> Ver lista de feriados de 2024");
            System.out.println("2 -> Verificar se uma data é feriado");

            chosenOption = userInput.nextInt();
        }

        if (chosenOption == 1) {
            printHolidays(allHolidays);
        }

        if (chosenOption == 2) {
            boolean isValidDateAsString = false;
            String insertedValue = "";
            while (isValidDateAsString == false) {
                System.out.println("Qual é a data que você deseja saber se é um feriado ou não? (Formato: dd-mm-yyyy)");

                insertedValue = userInput.nextLine();

                isValidDateAsString = validateDateAsString(insertedValue);
            }

            LocalDate inputtedDate = formatDate(insertedValue);
            checkIfDateIsAHoliday(inputtedDate);
        }
    }

    public static LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static List<Holiday> generateHolidays() {
        List<Holiday> listOfHolidays = new ArrayList<Holiday>();

        listOfHolidays.add(new Holiday(formatDate("01-01-2024"), "Confraternização Mundial", true, true));

        listOfHolidays.add(new Holiday(formatDate("12-02-2024"), "Carnaval", true, false));

        listOfHolidays.add(new Holiday(formatDate("13-02-2024"), "Carnaval", true, false));

        listOfHolidays.add(new Holiday(formatDate("29-03-2024"), "Sexta-feira Santa", true, false));

        listOfHolidays.add(new Holiday(formatDate("21-04-2024"), "Tiradentes", true, true));

        listOfHolidays.add(new Holiday(formatDate("01-05-2024"), "Dia do Trabalho", true, true));

        listOfHolidays.add(new Holiday(formatDate("30-05-2024"), "Corpus Christi", true, false));

        listOfHolidays.add(new Holiday(formatDate("07-09-2024"), "Independência do Brasil", true, true));

        listOfHolidays.add(new Holiday(formatDate("12-10-2024"), "Nossa Senhora Aparecida", true, true));

        listOfHolidays.add(new Holiday(formatDate("02-11-2024"), "Finados", true, true));

        listOfHolidays.add(new Holiday(formatDate("15-11-2024"), "Proclamação da República", true, true));

        listOfHolidays
                .add(new Holiday(formatDate("20-11-2024"), "Dia Nacional de Zumbi e da Consciência Negra", true, true));

        listOfHolidays.add(new Holiday(formatDate("25-12-2024"), "Natal", true, true));

        return listOfHolidays;
    }

    public static void printHolidays(List<Holiday> allHolidays) {
        // Create for
        // Format output
        // Sout output
    }

    public static boolean validateDateAsString(String insertedValue) {
        boolean isValidDateAsString = false;

        boolean hasCorrectLength = insertedValue.length() == 10;
        boolean hasCorrectSeparator = insertedValue.charAt(2) == '-' && insertedValue.charAt(5) == '-';
        boolean isTheYear2024 = insertedValue.charAt(6) == '2' && insertedValue.charAt(7) == '0' && insertedValue.charAt(8) == '2' && insertedValue.charAt(9) == '4';

        boolean isConvertibleToInt = false;
            // check if day, month and year are strings that have a numeric data stored on them
        boolean isTheMonthValid = false;
            // min value for month is 01
            // max value for month is 12
        boolean isTheDayValid = false;
            // february has X days in 2024
            // check either other months have 30 or 31 days accordingly
            // max value for day is 31
            // min value for day is 01

        // isValidDateAsString will receive all other booleans with &&
        // consider separating code into smaller functions


        return isValidDateAsString;
    }

    public static void checkIfDateIsAHoliday(LocalDate inputtedDate) {

    }
}
