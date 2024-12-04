import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListDifference {

    public List<String> getDifference(List<String> L1, List<String> L2) {
        HashSet<String> setL2 = new HashSet<>(L2); // Создаем множество элементов из L2 для быстрого поиска
        List<String> L = new ArrayList<>(); // Создаём пустой результирующий список

        for (String element : L1) { // Проходимся по списку L1
            if (!setL2.contains(element) && !L.contains(element)) {
                L.add(element); // Добавляем элемент в resultList, только если его нет в L2 и в resultList
            }
        }
        L.removeFirst(); // Для удаления первого нулевого элемента
        return L; // Возвращаем результат
    }
}