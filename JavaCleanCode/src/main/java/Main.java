import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int amount;
        while (true){
            System.out.print("Введите число от 1 до 30: ");
            try {
                amount = new Scanner(System.in).nextInt();
                if (amount < 1 || amount > 30){
                    throw new Exception();
                }
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Введите целое число!");
            }
            catch (Exception e){
                System.out.println("Число должно быть от 1 до 30!");
            }
        }
        GenerateAndSave(amount);
    }

    public static void GenerateAndSave(int amount){

        ArrayList<Person> generatedPersons = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            generatedPersons.add(PersonParser.Parse(HttpRequestData.GetData(Constants.personsURL)));
        }
        PdfSaver.SaveDataToPdf(generatedPersons);
        System.out.println("Файл создан. Путь " + Paths.get("People.pdf").toAbsolutePath());
    }
}
