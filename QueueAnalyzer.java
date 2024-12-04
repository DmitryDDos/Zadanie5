import java.util.Queue;

public class QueueAnalyzer {
    public static boolean hasEqualAdjacent(Queue<String> queue) {
        if (queue.size() < 2) {
            return false; // Если в очереди меньше двух элементов, соседей нет
        }

        // Преобразуем очередь в массив, чтобы легко получить доступ по индексу
        String[] elements = queue.toArray(new String[0]);
        int size = elements.length;

        // Проверяем соседей
        for (int i = 0; i < size; i++) {
            // Сравниваем текущий элемент со следующим (по кругу)
            if (elements[i].equals(elements[(i + 1) % size])) {
                return true; // Найдены равные соседи
            }
        }

        return false; // Равных соседей не найдено
    }
}
