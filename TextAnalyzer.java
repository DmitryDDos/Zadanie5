import java.util.HashSet;
import java.util.Set;

public class TextAnalyzer<T extends Iterable<String>> {
    // Метод для подсчета отсутствующих букв русского алфавита в тексте
    public void countMissingLetters(T textSource) {
        // Русский алфавит
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        Set<Character> alphabetSet = new HashSet<>();
        for (char letter : alphabet.toCharArray()) {
            alphabetSet.add(letter);
        }

        // Чтение текста
        Set<Character> foundLetters = new HashSet<>();
        Set<String> uniqueLines = new HashSet<>(); // Множество для хранения уникальных строк

        for (String line : textSource) {
            uniqueLines.add(line); // Добавляем уникальные строки в множество
            // Преобразуем строку в нижний регистр и добавляем буквы в множество
            for (char ch : line.toLowerCase().toCharArray()) {
                if (alphabetSet.contains(ch)) {
                    foundLetters.add(ch);
                }
            }
        }

        // Вывод уникальных строк
        System.out.println("Полученные данные из файла:");
        for (String uniqueLine : uniqueLines) {
            System.out.println(uniqueLine);
        }

        // Подсчет отсутствующих букв
        alphabetSet.removeAll(foundLetters); // Удаляем найденные буквы
        System.out.print("Количество букв русского алфавита, не встречающихся в тексте: " + alphabetSet.size());
        System.out.println();
    }
}