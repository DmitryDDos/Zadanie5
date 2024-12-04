import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer {
    // Метод для подсчета отсутствующих букв русского алфавита в тексте
    public static void countMissingLetters(String filePath) {
        // Русский алфавит
        String alphabet = "абвгдезийклмнопрстуфхцчшщъыьэюя";
        Set<Character> alphabetSet = new HashSet<>();
        for (char letter : alphabet.toCharArray()) {
            alphabetSet.add(letter);
        }

        // Чтение текста из файла
        Set<Character> foundLetters = new HashSet<>();
        StringBuilder fileContent = new StringBuilder(); // Новый StringBuilder для хранения текста из файла
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n"); // Добавляем строку в StringBuilder
                // Преобразуем строку в нижний регистр и добавляем буквы в множество
                for (char ch : line.toLowerCase().toCharArray()) {
                    if (alphabetSet.contains(ch)) {
                        foundLetters.add(ch);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Вывод текста из файла
        System.out.println("Текст из файла:");
        System.out.print(fileContent);

        alphabetSet.removeAll(foundLetters); // Подсчет отсутствующих букв
        System.out.print("Количество букв русского алфавита, не встречающихся в тексте: " + alphabetSet.size());
        System.out.println();
    }
}
