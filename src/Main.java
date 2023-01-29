import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//    Задание 1
//Написать Predicate, который проверяет, является ли число положительным.
//То есть, если число положительное, то предикат должен возвращать true, в противном случае false.
//Реализовать Predicate в двух вариантах:
//через анонимный класс
//через лямбду
        Set<Integer> number = new LinkedHashSet<>();
        number.add(2);
        number.add(-2);
        number.add(5);
        number.add(-9);
        number.add(7);
        number.add(0);
        number.add(-4);
        number.add(8);

        for (Integer integer : number) {
            System.out.println(integer);
        }
        System.out.println("=========== Predicate через анонимный клас ==========");

        // Predicate через анонимный клас
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        };

        number.removeIf(predicate);
        for (Integer integer : number) {
            System.out.println(integer);
        }

        System.out.println("========== Predicate через лямбду ===========");
        Predicate<Integer> predicate1 = integer -> integer < 0;

        number.removeIf(predicate1);
        for (Integer integer : number) {
            System.out.println(integer);
        }
//Задание 2
//Создать Consumer, который будет принимать на вход имя человека и выводить в консоль его приветствие.
//Реализовать Consumer в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("=============== Consumer через анонимный клас ==========");
        Consumer<String> name = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s + "!");
            }
        };
        name.accept("Саша");
        name.accept("Миша");

        System.out.println("=============== Consumer через лямбду ==========");
        Consumer<String> name1 = s -> System.out.println("Привет " + s + "!");
        name.accept("Петя");
        name.accept("Юля");


//        Задание 3
//Реализовать функциональный интерфейс Function, который принимает на вход вещественное число типа Double, а возвращает его округленный вариант типа Long.
//Реализовать Function в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("============== Function через анонимный клас ==================");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }

        };
        System.out.println(function.apply(113_001.31121434));
        System.out.println(function.apply(500_123_940_103.1212343));

        System.out.println("============== Function через лямбду ==================");

        Function<Double, Long> function1 = aDouble -> Math.round(aDouble);
        System.out.println(function1.apply(400_430_400_201.31999));
        System.out.println(function1.apply(872_349_859_494.8209999));

//Написать Supplier, который будет возвращать случайное число от 0 до 100.
//Реализовать Supplier в двух вариантах:
//через анонимный класс
//через лямбду
        System.out.println("============== Supplier через анонимный клас ==================");
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());

        System.out.println("============== Supplier через лямбду ==================");
        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(supplier1.get());



        System.out.println("======================= Задание 5 =========================");

        Predicate<Integer> notEqual0 = x -> x % 2 != 0;
        Function<Integer,Integer> multiplyByTwo = x -> {
            System.out.print( x + " нечетное: " + x +" умножаем на 2 = ");
            return x * 2;
        };
        Function<Integer,Integer> multiplyByThree = x -> {
            System.out.print( x + " четное: " + x +" умножаем на 3 = ");
            return x * 3;
        };
        Function<Integer,Integer> result = ternaryOperator(notEqual0,multiplyByTwo,multiplyByThree);
        result.apply(0);
    }

    public static <T, U>  Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            U result = condition.test(t) ? ifTrue.apply(t):ifFalse.apply(t);
            System.out.println(result);
            return result;
        };

    }

}