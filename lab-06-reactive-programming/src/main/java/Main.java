import reactor.core.publisher.Flux;

public class Main {
    int a = 1;
    static int b = 2;

    class Inner{
        int c = a;
        int d = b;
//        static int e = 1;
    }

    static class Inner2{
        static int e = 1;
        int g = 2;
    }

    public static void main(String[] args) {

//        Flux<Integer> ints = Flux.range(1, 3);
//        ints.subscribe(System.out::println);

        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        ints.subscribe(
                System.out::println,
                error -> System.err.println("Error: " + error)
        );
    }
}
