package me.aravindh.reactivespring.fluxandmonoplayground;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
        Flux<String> strFlux = Flux.just("Spring", "Spring boot", "reactive spring")
                .concatWith(Flux.error(new RuntimeException("Something happened")))
                .concatWith(Flux.just("Another flux"))
                .log();
        strFlux.subscribe(System.out::println, e -> System.err.println("Exception is: " + e),()->System.out.println("completed"));

    }
}
