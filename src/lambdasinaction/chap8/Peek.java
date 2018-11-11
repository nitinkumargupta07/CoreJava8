package lambdasinaction.chap8;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Peek {

    public static void main(String[] args) {
    	Stream<Integer>  ster =Stream.of(2, 3, 4, 5 ,6,7,8,9,10,11);
        List<Integer> result = Stream.of(2, 3, 4, 5 ,6,7,8,9,10,11)
                .peek(x -> System.out.println("taking from stream: " + x)).map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x)).filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x)).limit(22)
                .peek(x -> System.out.println("after limit: " + x)).collect(toList());
        
        result.forEach(s -> System.out.println(s));
       /* System.out.println("************************888888888888888888*******\n");
        Stream.of(2, 3, 4, 5).peek(x -> System.out.println("taking from stream: " + x)).map(x -> x + 17)
      ////  .map(x -> x + 17).peek(x -> System.out.println("after map: " + x)).filter(x -> x % 2 == 0)
        .peek(x -> System.out.println("after filter: " + x)).collect(toList());
*/    }
}
