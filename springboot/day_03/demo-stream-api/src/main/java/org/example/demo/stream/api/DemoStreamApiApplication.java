package org.example.demo.stream.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoStreamApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        // C1: Sử dụng class implement interface
//        Greeting vietnam = new Vietnam();
//        vietnam.sayHello("Huy");
//
//        // C2: Sử dụng anonymous class
//        Greeting english = new Greeting() {
//            @Override
//            public void sayHello(String name) {
//                System.out.println("Hello " + name);
//            }
//        };
//        english.sayHello("An");
//
//        // C3: Sử dụng lambda expression
//        Greeting china = (name) -> {
//            System.out.println("你好 " + name);
//        };
//        china.sayHello("Hoa");
//
//        Greeting japan = (name) -> System.out.println("こんにちは " + name);
//        japan.sayHello("Bình");
//
//        // Calculator
//        Calculator add = (a, b) -> a + b;
//        System.out.println(add.calculate(1, 2));
//        System.out.println(add.calculate(3, 4));
//
//        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
//////        numbers.forEach(number -> System.out.println(number));
//////        numbers.sort(new Comparator<>() {
//////            @Override
//////            public int compare(Integer o1, Integer o2) {
//////                return o1 - o2;
//////            }
//////        });
//        numbers.sort((n1, n2) -> n2 - n1);
////        numbers.forEach(number -> System.out.println(number));

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//
//        names.stream()
//                .filter(name -> name.startsWith("C"))
//                .map(name -> name.toUpperCase())
//                .forEach(name -> System.out.println(name));

        List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

//        1. Duyệt numbers
        numbers.stream().forEach(number -> System.out.println(number));

//        2. Tìm các giá trị chẵn trong list
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.println(number));

//        3. Tìm các giá trị > 5 trong list
        numbers.stream()
                .filter(number -> number > 5)
                .forEach(number -> System.out.println(number));

//        4. Tìm giá trị max trong list
        numbers.stream()
//                .mapToInt(number -> number)
//                .max()
//                .ifPresent(number -> System.out.println("max = " + number));
                .max(Comparator.comparingInt(n -> n))
                .ifPresent(number -> System.out.println("max = " + number));

//        5. Tìm giá trị min trong list


        // Dũng
//        6. Tính tổng các phần tử của mảng (reduce)
        int total = numbers.stream()
                .reduce(0, (a, b) -> a + b);

//        7. Lấy danh sách các phần tử không trùng nhau (distinct)
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Tuyên
//        8. Lấy 5 phần tử đầu tiên trong mảng (limit)
        List<Integer> list1 = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());

//        9. Lấy phần tử từ thứ 3 -> thứ 5 (limit + skip)
        List<Integer> list2 = numbers.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());

        // Lộc
//        10. Lấy phần tử đầu tiên > 5 (findFirst)
        numbers.stream()
                .filter(number -> number > 5)
                .findFirst()
                .ifPresent(number -> System.out.println("Phan tu dau tien lon hon 5 la: " + number));

//        11. Kiểm tra xem list có phải là list chẵn hay không (allMatch)
        boolean all = numbers.stream()
                .allMatch(number -> number % 2 == 0);

        // Hiển
//        12. Kiểm tra xem list có phần tử > 10 hay không (anyMatch)
        boolean lonHon10 = numbers.stream()
                .anyMatch(num -> num > 10);

//        13. Có bao nhiêu phần tử > 5 (count)
        long count = numbers.stream()
                .filter(num -> num > 5)
                .count();

        // Tùng
//        14. Nhân đôi các phần tủ trong list và trả về list mới (map + collect)
        List<Integer> resultList = numbers.stream().map(number -> number * 2).toList();

//        15. Kiểm tra xem list không chứa giá trị nào = 8 hay không (noneMatch)
        boolean checkExistNumber = numbers.stream().noneMatch(number -> number == 8);
    }
}
