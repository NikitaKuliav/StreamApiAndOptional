import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Car> carStream = Stream.of(new Car("C1", 2008),
        new Car("logan", 2015),
        new Car("model S", 2021));

        BiConsumer<Car, Car> biConsumer = (min, max) -> System.out.println(min.toString() + max.toString());
        Comparator<Car> carComparator = Comparator.comparing(Car::getModel).thenComparing(Car::getYear);
        Comparator<String> comparator = Comparator.comparing(String::length);
        findMinMax(carStream, carComparator, biConsumer);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }



}