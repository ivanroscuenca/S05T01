package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.dto.FlowerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FlowerService2 {

    //We use Mono for just one object and Flux for multiple
    Mono <Void> save(FlowerDto flowerDto);

    Mono <Void> update(FlowerDto flowerDto);

    Mono<FlowerDto> findById(Integer id);
    Flux<FlowerDto> findAll();

    Mono <Void> deleteById(Integer id);
}
