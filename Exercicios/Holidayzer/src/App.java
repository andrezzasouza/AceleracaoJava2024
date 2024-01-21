import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    int chosenOption = 0;

    final List<Holiday> allHolidays = generateHolidays();

    Scanner userInput = new Scanner(System.in);

    boolean invalidOptions;

    do {
      System.out.println("Digite o número do que você deseja consultar:");
      System.out.println("1 -> Ver lista de feriados de 2024");
      System.out.println("2 -> Verificar se uma data é feriado");
      System.out.println("3 -> Encerrar programa");

      chosenOption = userInput.nextInt();
      invalidOptions = chosenOption < 1 || chosenOption > 3;

      if (invalidOptions) {
        System.out.println("Opção inválida! O número digitado deve estar entre 1 e 3.");
      }

    } while (invalidOptions);

    if (chosenOption == 1) {
      userInput.close();
      printHolidays(allHolidays);
      // fix the printed format
      // currently 2024-11-25
      return;
    }

    if (chosenOption == 2) {
      boolean isValidDateAsString = false;
      String insertedValue;

      do {
        userInput.nextLine();

        System.out.println("Qual é a data que você deseja saber se é um feriado ou não? (Formato: dd-mm-aaaa)");

        insertedValue = userInput.nextLine();

        isValidDateAsString = validateDateAsString(insertedValue);

        if (!isValidDateAsString)
          System.out.println("Data inválida! O formato deve ser: dd-mm-aaaa. O ano deve ser 2024. Tente novamente!");

      } while (!isValidDateAsString);

      LocalDate inputtedDate = formatDateStringToLocalDate(insertedValue);
      boolean isAHoliday = checkIfDateIsAHoliday(allHolidays, inputtedDate);

      if (isAHoliday) {
        System.out.println("Dia é ! 🎉");
        return;
      }

      System.out.println("Dia não é feriado 🥲");
      return;
    }

    if (chosenOption == 3) {
      userInput.close();
      System.out.println("Encerrando o programa...");
      return;
    }
  }

  public static LocalDate formatDateStringToLocalDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return LocalDate.parse(date, formatter);
  }

  public static String formatLocalDateToStringDate(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return date.format(formatter);
  }

  // public static LocalDate formatLocalDateToDateString(LocalDate date) {
  // System.out.println(date.getClass());
  // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  // LocalDate.parse(date, formatter);
  // return;
  // }

  public static List<Holiday> generateHolidays() {
    List<Holiday> listOfHolidays = new ArrayList<Holiday>();

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("01-01-2024"), "Confraternização Mundial", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("12-02-2024"), "Carnaval", true, false));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("13-02-2024"), "Carnaval", true, false));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("29-03-2024"), "Sexta-feira Santa", true, false));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("21-04-2024"), "Tiradentes", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("01-05-2024"), "Dia do Trabalho", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("30-05-2024"), "Corpus Christi", true, false));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("07-09-2024"), "Independência do Brasil", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("12-10-2024"), "Nossa Senhora Aparecida", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("02-11-2024"), "Finados", true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("15-11-2024"), "Proclamação da República", true, true));

    listOfHolidays
        .add(new Holiday(formatDateStringToLocalDate("20-11-2024"), "Dia Nacional de Zumbi e da Consciência Negra",
            true, true));

    listOfHolidays.add(new Holiday(formatDateStringToLocalDate("25-12-2024"), "Natal", true, true));

    return listOfHolidays;
  }

  public static void printHolidays(List<Holiday> allHolidays) {
    for (int i = 0; i < allHolidays.size(); i++) {
      String nameOfTheCurrentHoliday = allHolidays.get(i).getName();
      LocalDate dateOfCurrentHoliday = allHolidays.get(i).getDate();

      System.out.println("\"" + formatLocalDateToStringDate(
          dateOfCurrentHoliday) + "\" => \"" + nameOfTheCurrentHoliday + "\"");
    }
  }

  public static boolean validateDateAsString(String insertedValue) {
    String dayData = insertedValue.substring(0, 2);
    String monthData = insertedValue.substring(3, 5);
    String yearData = insertedValue.substring(6, 10);

    boolean hasCorrectLength = insertedValue.length() == 10;

    boolean hasCorrectSeparator = insertedValue.charAt(2) == '-' && insertedValue.charAt(5) == '-';

    boolean isConvertibleToInt = isConvertibleToInteger(dayData, monthData, yearData);

    boolean isTheYear2024 = "2024".equals(yearData);

    boolean areDayAndMonthValid = checkIfDayAndMonthAreValid(dayData, monthData);

    boolean isValidDateAsString = hasCorrectLength && hasCorrectSeparator && isConvertibleToInt && isTheYear2024
        && areDayAndMonthValid;

    // improve how it deals with problems. It should return if it doesn't match
    // things before an error is thrown

    return isValidDateAsString;
  }

  public static boolean isConvertibleToInteger(String dayData, String monthData, String yearData) {
    boolean isConvertible = false;

    if (dayData.matches("\\d+") && monthData.matches("\\d+") && yearData.matches("\\d+")) {
      isConvertible = true;
    }

    return isConvertible;
  }

  public static boolean checkIfDayAndMonthAreValid(String dayData, String monthData) {
    int dayAsInt = Integer.parseInt(dayData);
    int monthAsInt = Integer.parseInt(monthData);

    boolean isValidDay = dayAsInt >= 1 && dayAsInt <= 31;
    boolean isValidMonth = monthAsInt >= 1 && monthAsInt <= 12;

    boolean isValidFebruaryDate = monthAsInt == 2 && dayAsInt <= 29;
    boolean isValid31DaysMonth = (monthAsInt == 1 || monthAsInt == 3 || monthAsInt == 5 || monthAsInt == 7
        || monthAsInt == 8 || monthAsInt == 10 || monthAsInt == 12) && dayAsInt <= 31;
    boolean isValid30DaysMonth = (monthAsInt == 4 || monthAsInt == 6 || monthAsInt == 9 || monthAsInt == 11)
        && dayAsInt <= 30;

    boolean isValidCombination = isValidFebruaryDate || isValid31DaysMonth || isValid30DaysMonth;

    return isValidDay && isValidMonth && isValidCombination;
  }

  public static boolean checkIfDateIsAHoliday(List<Holiday> allHolidays, LocalDate inputtedDate) {
    boolean isDateAHoliday = false;

    for (Holiday currentHoliday : allHolidays) {
      if (currentHoliday.getDate().equals(inputtedDate)) {
        isDateAHoliday = true;
        break;
      }
    }

    return isDateAHoliday;
  }
}
