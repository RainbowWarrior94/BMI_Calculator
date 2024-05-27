import java.util.InputMismatchException;
import java.util.Scanner;

public class BMI_calc {

    public static void main(String[] args) {

        //deklaracja zmiennych
        String name;
        double weight = 0.0;
        double height = 0.0;
        double bmi;

        //inicjalizacja obiektu dane
        Scanner dane = new Scanner(System.in);

        System.out.print("Podaj imię i nazwisko: ");

        name = dane.nextLine();

        //pobranie oraz walidacja danych
        do {
            try {
                System.out.print("Podaj swoją wagę (kg): ");
                weight = dane.nextDouble();

                if (weight <= 0) {
                    System.out.println("Waga musi być większa od zera.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Należy wpisać liczbę.");
                dane.nextLine();
                weight = 0.0;
            }
        } while (weight <= 0);

        do {
            try {
                System.out.print("Podaj swój wzrost (m): ");
                height = dane.nextDouble();

                if (height <= 0) {
                    System.out.println("Wzrost muszi być większy od zera.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Należy wpisać liczbę.");
                dane.nextLine();
                height = 0.0;
            }
        } while (height <= 0);

        //wykonanie obliczeń
        bmi = weight / (height * height);

        //wyświetlenie wyniku
        System.out.println("Wyniki: ");
        System.out.println("Imię: " + name);
        System.out.println("Wskaźnik BMI: " + bmi);
        System.out.print("Interpretacja wyniku: " + Interpretacja(bmi));

        dane.close();
    }

    //metoda dla interpretacji wartości BMI
    public static String Interpretacja(double bmi) {
        if (bmi < 16.0) {
            return "Wygłodzenie";
        } else if (bmi > 16.1 && bmi < 16.9) {
            return "Wychudzenie";
        } else if (bmi >= 16.9 && bmi < 18.5) {
            return "Niedowaga";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Waga prawidłowa";
        } else if (bmi >= 24.9 && bmi < 29.9) {
            return "Nadwaga";
        } else if (bmi >= 29.9 && bmi < 34.9) {
            return "Otyłość I stopnia";
        } else if (bmi >= 34.9 && bmi <= 39.9) {
            return "Otyłość II stopnia";
        } else {
            return "Otyłość III stopnia";
        }
    }
}