package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.dto.FlowerDto;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.services.FlowerService2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flower")
public class FlowerController2 {
    @Autowired
    private FlowerService2 flowerservice2;

    //http://localhost:9002/flower/add

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags="POST",
            operationId="ADD",
            summary = "This action to add new flowers",
            description = "Please add a flower and fill the parameters required",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This the requestbody Description",
                    content = @Content(schema = @Schema(implementation = FlowerDto.class)))
    )
    public ResponseEntity<Mono<Void>> saveFlower(@RequestBody FlowerDto flowerDto) {
        try {
            Mono<Void> flowerDtoAdded = flowerservice2.save(flowerDto);
            return new ResponseEntity<>(flowerDtoAdded,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };



//    http://localhost:9001/flower/update
    //consumes =  MediaType.APPLICATION_JSON_VALUE
    @PutMapping(value = "/update/", consumes =  MediaType.APPLICATION_JSON_VALUE )
    @Operation(
            tags="UPDATE",
            summary = "This action to update a flower",
            description = "Please update a flower and fill the parameters required",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This the requestbody Description",
                    content = @Content(schema = @Schema(implementation = FlowerDto.class)))

    )
    public ResponseEntity<Mono<Void>> updateFlower(
            @RequestBody FlowerDto flowerDto) {
        try {
            Mono<Void> flowerDtoUpdated = flowerservice2.update(flowerDto);
            return new ResponseEntity<>(flowerDtoUpdated,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };




    //    http://localhost:9001/flower/delete/{id}
    @DeleteMapping(value="/delete/{id}")
    @Operation(
            tags="DELETE",
            summary = "This action to delete a flower",
            description = "Please write the id to delete"
    )

    public ResponseEntity <Mono<Void>> deleteFlower(@PathVariable Integer id) {
        try {
            Mono<Void> flowerDtoDeleted = flowerservice2.deleteById(id); // Wait for the deletion to complete
            return new ResponseEntity<>(flowerDtoDeleted,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // http://localhost:9001/flower/getOne/{id}
    // produces = MediaType.APPLICATION_JSON_VALUE
    @GetMapping(value="/getOne/{id}")
    @Operation(
            tags="GETONE",
            summary = "This action to look for a flower",
            description = "Please write the id to search the required flower"
    )
    public ResponseEntity<Mono<FlowerDto>> getFlowerById(@PathVariable Integer id) {
        Mono<FlowerDto> flowerDto = flowerservice2.findById(id);
        if (flowerDto != null) {
            return new ResponseEntity<>(flowerDto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };


//    http://localhost:9001/flower/getAll
    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags="GETALL",
            summary = "This action list all the flowers",
            description = "Please click to see all of them"
    )
    public ResponseEntity<Flux<FlowerDto>> getAllFlowers(){
        Flux<FlowerDto> flowerDtos = flowerservice2.findAll();
        if (flowerDtos!=null) {
            return new ResponseEntity<>(flowerDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

}
