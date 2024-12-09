import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueAnalyzer {
    public static <T> boolean hasEqualAdjacent(Queue<T> queue) {
        if (queue.size() < 2) {
            return false; // Если в очереди меньше двух элементов, соседей нет
        }

        // Создаем список и заполняем его элементами из очереди
        List<T> elements = new ArrayList<>(queue);

        // Проверяем соседей
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            // Сравниваем текущий элемент со следующим (по кругу)
            if (elements.get(i).equals(elements.get((i + 1) % size))) {
                return true; // Найдены равные соседи
            }
        }

        return false; // Равных соседей не найдено
    }
}