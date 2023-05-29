package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.Dto.FlowerDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerservice;

//http://localhost:9001/flower/add
@PostMapping({"/add","/add/"})
@Operation(
tags="POST",
operationId="ADD",
        summary = "This action to add new flowers",
        description = "Please add a flower and fill the parameters required in Requestbody :  countryFlower and nameFlower",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This the requestbody Description",
                content = @Content(schema = @Schema(implementation = FlowerDto.class)))
)
public ResponseEntity<String> saveFlower(@RequestBody FlowerDto flowerDto) {
    try {
        flowerservice.save(flowerDto);
        return ResponseEntity.ok("Flower saved successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save flower.");
    }
};


//    http://localhost:9001/flower/update

    @PutMapping({"/update","/update/"})
    @Operation(
            tags="UPDATE",
            summary = "This action to update a flower",
            description = "Please update a flower and fill the parameters required in Requestbody : pk_FlowerID, countryFlower and nameFlower",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This the requestbody Description",
                    content = @Content(schema = @Schema(implementation = FlowerDto.class)))

    )
    public ResponseEntity<String> updateFlower(
            @RequestBody FlowerDto flowerDto) {
        try {
            flowerservice.update(flowerDto);
            return ResponseEntity.ok("Flower updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update flower: " + e.getMessage());
        }
    };



//    http://localhost:9001/flower/delete/{id}
@DeleteMapping("/delete/{id}")
@Operation(
        tags="DELETE",
        summary = "This action to delete a flower",
        description = "Please write the id to delete"
)

public ResponseEntity<String> deleteFlower(@PathVariable Integer id) {
    try {
        flowerservice.deleteById(id);
        return ResponseEntity.ok("Flower deleted successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to delete flower: " + e.getMessage());
    }
};

    @GetMapping("/getOne/{id}")
    @Operation(
            tags="GETONE",
            summary = "This action to look for a flower",
            description = "Please write the id to search the required flower"
    )
    public ResponseEntity<FlowerDto> getFlowerById(@PathVariable Integer id) {
        FlowerDto flowerDto = flowerservice.findById(id);
        if (flowerDto != null) {
            return new ResponseEntity<>(flowerDto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };


//    http://localhost:9001/flower/getAll

    @GetMapping({"/getAll","/getaAll/"})
    @Operation(
            tags="GETALL",
            summary = "This action list all the flowers",
            description = "Please click to see all of them"
    )
    public ResponseEntity<List<FlowerDto>> getAllFlowers(){
        List<FlowerDto> flowerDtos = flowerservice.findAll();
        if (!flowerDtos.isEmpty()) {
            return new ResponseEntity<>(flowerDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

}
