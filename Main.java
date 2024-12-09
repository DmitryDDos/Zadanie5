import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // менюшка
            System.out.println("Выберите действие от 0 до 8: ");
            System.out.println("1 - Задание с дробью;");
            System.out.println("2 - Количество мяуканий;");
            System.out.println("3 - Списки");
            System.out.println("4 - Мап");
            System.out.println("5 - Сет");
            System.out.println("6 - Очередь");
            System.out.println("7 - Стрим 1");
            System.out.println("8 - Стрим 2");
            System.out.println("0 - Выход из программы.");
            System.out.print("Выбранное действие: ");

            while (!scanner.hasNextInt()) { // Проверка на ввод числа
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next(); // Очистка ввода
            }
            int d = scanner.nextInt();
            System.out.println();

            if (d < 0 || d > 8) { // Проверка на диапазон допустимых значений числа
                System.out.println("Введено неверное значение!");
                continue;
            }

            switch (d) {
                case 0: // Остановка программы
                    System.out.println("Программа остановлена.");
                    return;

                case 1: // Задание с дробью
                    System.out.println("Введите первую дробь: (числитель и знаменатель)");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int c = scanner.nextInt();
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int d1 = scanner.nextInt();

                    // Создаем экземпляр CachedFraction
                    CachedFraction fraction1 = new CachedFraction(c, d1);
                    System.out.println("Полученная дробь: " + fraction1);
                    System.out.println("Десятичный вид этой дроби: " + fraction1.getValue()); // Вывод 10-й дроби
                    System.out.println(); // Оставляем пустую строку для красоты

                    // Изменяем дробь
                    System.out.print("Введите новый числитель: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int c1 = scanner.nextInt();
                    fraction1.setNumerator(c1); // Меняем числитель дроби
                    System.out.println("Новая дробь: " + fraction1);
                    System.out.println("Десятичный вид этой дроби: " + fraction1.getValue()); // Вывод 10-й дроби
                    System.out.println(); // Оставляем пустую строку для красоты

                    System.out.print("Введите новый знаменатель: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int d2 = scanner.nextInt();
                    fraction1.setDenominator(d2); // Меняем знаменатель
                    System.out.println("Новая дробь: " + fraction1);
                    System.out.println("Десятичный вид этой дроби: " + fraction1.getValue()); // Вывод 10-й дроби

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 2: // Задание с котами
                    List<MeowCounter> counters = new ArrayList<>(); // Список счетчиков котов
                    System.out.print("Введите количество котов/кошек: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int numberOfCats = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после ввода числа

                    for (int i = 0; i < numberOfCats; i++) {
                        System.out.print("Введите имя кота/кошки " + (i + 1) + ": ");
                        String name = scanner.nextLine();
                        counters.add(new MeowCounter(new Cat(name))); // Создаем кота и добавляем в список счетчиков
                    }

                    // Вывод строкового представления всех котов
                    System.out.println("Список котов/кошек: ");
                    for (int i = 0; i < counters.size(); i++) {
                        System.out.println(i + 1 + ". " + counters.get(i).getCat().toString()); // Выводим строковое представление кота с индексом
                    }

                    // Цикл для мяуканья
                    while (true) {
                        System.out.print("Выберите кота/кошку, чтобы погладить (введите номер кота/кошки)\nИли введите 0, чтобы погладить всех\nИли введите -1, чтобы закончить. \nВыбранное действие: ");
                        while (!scanner.hasNextInt()) { // Проверка на ввод числа
                            System.out.print("Ошибка! Введите целое число: ");
                            scanner.next(); // Очистка ввода
                        }
                        int choice = scanner.nextInt();

                        if (choice == 0) {
                            // Гладим всех котов/кошек
                            System.out.println("Все коты/кошки: ");
                            for (MeowCounter counter : counters) {
                                counter.meow(); // Вызываем мяуканье для каждого кота
                            }
                        } else if (choice == -1) {
                            break; // Выход из цикла, если введено -1
                        } else if (choice > 0 && choice <= counters.size()) {
                            // Гладим выбранного кота
                            counters.get(choice - 1).meow(); // Вызываем мяуканье для выбранного кота
                        } else {
                            System.out.println("Выбран неверный номер кота/кошки.");
                        }
                    }

                    // Вывод количества мяуканий для каждого кота
                    System.out.println("\nКоличество мяуканий для каждого кота:");
                    for (MeowCounter counter : counters) {
                        System.out.println(counter.getCat().toString() + " мяукал " + counter.getMeowCount() + " раз(а).");
                    }

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 3: // Списки
                    // Ввод элементов для списка L1
                    List<String> L1 = new ArrayList<>();
                    System.out.println("Введите элементы для списка L1 (введите 'stop' для завершения):");
                    while (true) {
                        String input = scanner.nextLine();
                        if (Objects.equals(input, "stop")) break;
                        L1.add(input);
                    }

                    // Ввод элементов для списка L2
                    List<String> L2 = new ArrayList<>();
                    System.out.println("Введите элементы для списка L2 (введите 'stop' для завершения):");
                    while (true) {
                        String input = scanner.nextLine();
                        if (Objects.equals(input, "stop")) break;
                        L2.add(input);
                    }
                    ListDifference L = new ListDifference(); // Создаем список L
                    List<String> result = L.getDifference(L1, L2); // Добавляем в список элементы L1 без повторений и которых нет в L2
                    System.out.println("Элементы из L1, которые отсутствуют в L2: " + result);

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 4:
                    // Обработка данных о студентах из файла
                    Map<String, Object[]> studentsMap = new HashMap<>();
                    int errorCount = 0;

                    try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(" ");

                            // Проверка входных данных
                            if (parts.length != 4) {
                                System.out.println("Ошибка: неверный формат данных в строке: " + line);
                                errorCount++;
                                continue;
                            }

                            String lastName = parts[0];
                            String firstName = parts[1];
                            int schoolNumber;
                            int score;

                            // Проверка длины фамилии и имени
                            if (lastName.length() > 20 || firstName.length() > 20) {
                                System.out.println("Ошибка: Фамилия и имя должны содержать не более 20 символов в строке: " + line);
                                errorCount++;
                                continue;
                            }

                            // Проверка номера школы
                            try {
                                schoolNumber = Integer.parseInt(parts[2]);
                                if (schoolNumber < 1 || schoolNumber > 99) {
                                    System.out.println("Ошибка: Номер школы должен быть от 1 до 99 в строке: " + line);
                                    errorCount++;
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: Номер школы должен быть целым числом в строке: " + line);
                                errorCount++;
                                continue;
                            }

                            // Проверка балла
                            try {
                                score = Integer.parseInt(parts[3]);
                                if (score < 1 || score > 100) {
                                    System.out.println("Ошибка: Балл должен быть от 1 до 100 в строке: " + line);
                                    errorCount++;
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: Балл должен быть целым числом в строке: " + line);
                                errorCount++;
                                continue;
                            }

                            // Сохраняем имя + фамилию и номер школы с баллом
                            studentsMap.put(lastName + " " + firstName, new Object[]{schoolNumber, score});
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("Ошибка: Файл не найден: " + e.getMessage());
                        return;
                    } catch (IOException e) {
                        System.err.println("Ошибка при чтении файла: " + e.getMessage());
                        return;
                    }

                    // Обработка данных для школы № 50
                    List<Map.Entry<String, Object[]>> school50Students = new ArrayList<>();
                    for (Map.Entry<String, Object[]> entry : studentsMap.entrySet()) {
                        if ((int) entry.getValue()[0] == 50) { // Проверяем номер школы
                            school50Students.add(entry);
                        }
                    }

                    // Сортировка учеников по баллам (по убыванию)
                    school50Students.sort((e1, e2) -> (int) e2.getValue()[1] - (int) e1.getValue()[1]);

                    // Определяем наивысший балл
                    if (!school50Students.isEmpty()) {
                        int highestScore = (int) school50Students.getFirst().getValue()[1]; // Получаем наивысший балл
                        List<String> topStudents = new ArrayList<>();

                        for (Map.Entry<String, Object[]> entry : school50Students) {
                            if ((int) entry.getValue()[1] == highestScore) {
                                topStudents.add(entry.getKey());
                            }
                        }

                        // Вывод результата
                        if (topStudents.size() > 2) {
                            System.out.println(topStudents.size());
                        } else if (topStudents.size() == 1) {
                            System.out.println(topStudents.getFirst());
                        } else {
                            for (String student : topStudents) {
                                System.out.println(student);
                            }
                        }
                    } else {
                        System.out.println("Нет учеников из школы № 50.");
                    }

                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 5: // Сет
                    TextAnalyzer<Set<String>> analyzer = new TextAnalyzer<>();
                    Set<String> uniqueLines = new HashSet<>(); // Создаем множество для хранения уникальных строк

                    // Чтение строк из файла и добавление их в Set
                    try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            uniqueLines.add(line); // Добавляем уникальные строки в множество
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Анализируем текст
                    analyzer.countMissingLetters(uniqueLines);

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 6: // Очередь
                    Queue<Object> queue = new LinkedList<>(); // Создаем очередь для обобщенного типа

                    System.out.print("Введите количество элементов для добавления в очередь: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next();
                    }
                    int n = scanner.nextInt(); // Считываем количество элементов
                    scanner.nextLine(); // Очищаем буфер

                    System.out.println("Введите " + n + " элементов для добавления в очередь:");

                    for (int i = 0; i < n; i++) {
                        String input = scanner.nextLine(); // Считываем ввод пользователя
                        queue.add(input); // Добавляем элемент в очередь
                    }

                    // Проверяем, есть ли равные соседи
                    boolean hasEqualNeighbors = QueueAnalyzer.hasEqualAdjacent(queue);
                    if (hasEqualNeighbors) {
                        System.out.println("В очереди есть хотя бы один элемент, который равен следующему за ним элементу (по кругу).");
                    } else {
                        System.out.println("В очереди нет элементов, которые равны следующему за ним элементу (по кругу).");
                    }

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 7: // Стрим 1
                    List<Point> points = new ArrayList<>(); // Создаём пустой список точек
                    System.out.print("Введите количество точек для ввода: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next();
                    }
                    int kt = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < kt; i++) { // Ввод точек
                        System.out.print("Введите координаты точки " + (i + 1) + " в формате 'X Y': ");
                        String input = scanner.nextLine();
                        String[] coordinates = input.trim().split("\\s+"); // Удаляем лишние пробелы и разбиваем по пробелам

                        if (coordinates.length != 2) {
                            System.out.println("Неверный формат. Пожалуйста, введите координаты в формате 'X Y'.");
                            i--; // Уменьшаем счетчик, чтобы повторно запросить ввод для этой точки
                            continue;
                        }

                        try { // Проверка точек
                            double x = Double.parseDouble(coordinates[0]);
                            double y = Double.parseDouble(coordinates[1]);
                            points.add(new Point(x, y));
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка ввода. Пожалуйста, введите числовые координаты.");
                            i--; // Уменьшаем счетчик, чтобы повторно запросить ввод для этой точки
                        }
                    }

                    // Обработка точек
                    Polyline polyline = new Polyline(points.stream()
                            .distinct() // Убираем дубликаты
                            .map(point -> new Point(point.getX(), Math.abs(point.getY()))) // Делаем Y положительными
                            .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                            .collect(Collectors.toList())); // Собираем в список

                    System.out.println(polyline); // Выводим результат

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 8: // Стрим 2
                    PersonProcessor processor = new PersonProcessor();
                    String FilePath = "text1.txt"; // Укажите путь к вашему файлу

                    // Выводим содержимое файла
                    processor.printFileContent(FilePath);

                    // Обрабатываем файл
                    Map<Integer, List<String>> groupedPeople = processor.processFile(FilePath);
                    System.out.println(); // Оставляем пустую строку для красоты
                    System.out.println("Полученный результат группировки: ");
                    System.out.println(groupedPeople);

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;
            }
        }
    }
}