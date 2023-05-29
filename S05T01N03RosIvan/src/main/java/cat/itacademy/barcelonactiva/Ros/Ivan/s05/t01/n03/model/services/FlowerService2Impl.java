package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.dto.FlowerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.constants.FlowerConstants.*;
@Service
public class FlowerService2Impl implements FlowerService2 {

    //inject webclient
    @Autowired
    private WebClient webClient;

    public Mono<Void> save(FlowerDto flowerDto) {
        return webClient.post()
                .uri(ADD_ONE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flowerDto), FlowerDto.class)
                .retrieve()
                .bodyToMono(Void.class);
    }


    @Override
    public Mono<Void> update(FlowerDto flowerDto) {
        return webClient.put()
                .uri(UPDATE_ONE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flowerDto), FlowerDto.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<FlowerDto> findById(Integer id) {
        return webClient.get()
                .uri(GET_ONE+id)
                .retrieve().
                bodyToMono(FlowerDto.class);
    }

    //we use bodyToFlux for multiple
    @Override
    public Flux<FlowerDto> findAll() {
      return webClient.get()
                .uri(GET_ALL_EMPLOYEES)
                .retrieve()
                .bodyToFlux(FlowerDto.class);
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return webClient.delete()
                .uri(DELETE_ONE+id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
