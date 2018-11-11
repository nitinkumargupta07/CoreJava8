package lambdasinaction.chap5;
import static lambdasinaction.chap4.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

import lambdasinaction.chap4.Dish;

public class Reducing{

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);
        int sum21 = numbers.stream().map(a ->a).reduce(Integer::sum).get();
        numbers.stream().mapToInt(i -> i).sum();
        numbers. stream().mapToInt(i -> i.intValue()).sum();
        numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        LongAdder a = new LongAdder();
        
        numbers.stream().forEach(a ::add);
     Long aaa  = numbers.stream().filter(Objects::nonNull).count();
       // int sum21 = numbers.stream().collect(reduce(Integer::sum));
        System.out.println(sum21);

        int max1111 = numbers.stream().reduce(0, (a1, b1) -> Integer.max(a1, b1));
        System.out.println(max1111);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
