package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.Dto.FlowerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlowerService {
    public void save(FlowerDto flowerDto);

    public void update(FlowerDto flowerDto);

    FlowerDto findById(Integer id);

   List<FlowerDto>findAll();

    public void deleteById(Integer id);
}
