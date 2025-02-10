// What options can you choose when creating a project in IntelliJ?
// - Java, Kotlin, Groovy, Empty, Gradle, Maven

// Restrictions for naming a local directory?
// - No *, ?, <, >, :, |, ", and spaces

// Data type for suitcase weight (with decimals)?
// - double or long

// Data type for whole numbers?
// - int

// Data type for true/false?
// - boolean

public class Date {
    public static void main(String[] args) {
        // Variables for today's date
        String day = "Thursday";
        int date = 16;
        String month = "July";
        int year = 2015;

        // Print each variable separately
        System.out.println(day);
        System.out.println(date);
        System.out.println(month);
        System.out.println(year);

        // Print date in American format
        System.out.println("American format:");
        System.out.println(day + ", " + month + " " + date + ", " + year);

        // Print date in European format
        System.out.println("European format:");
        System.out.println(day + " " + date + " " + month + " " + year);
    }
}
