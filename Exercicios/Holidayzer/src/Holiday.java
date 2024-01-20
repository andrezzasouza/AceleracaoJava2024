import java.time.LocalDate;

public class Holiday {
  private LocalDate date;
  private String name;
  private boolean isANationalHoliday;
  private boolean isAFixedHoliday;

  Holiday() {
  }

  Holiday(LocalDate date, String name, boolean isANationalHoliday, boolean isAFixedHoliday) {
    this.date = date;
    this.name = name;
    this.isANationalHoliday = isANationalHoliday;
    this.isAFixedHoliday = isAFixedHoliday;
  }

  void setDate(LocalDate newDate) {
    this.date = newDate;
  }

  LocalDate getDate() {
    return this.date;
  }

  void setName(String newName) {
    this.name = newName;
  }

  String getName() {
    return this.name;
  }

  void setIsANationalHoliday(boolean updatedIsANationalHoliday) {
    this.isANationalHoliday = updatedIsANationalHoliday;
  }

  boolean isANationalHoliday() {
    return this.isANationalHoliday;
  }

  void setIsAFixedHoliday(boolean updatedIsAFixedHoliday) {
    this.isAFixedHoliday = updatedIsAFixedHoliday;
  }

  boolean isAFixedHoliday() {
    return this.isAFixedHoliday;
  }
}
