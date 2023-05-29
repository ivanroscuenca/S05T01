package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.Dto.FlowerDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlowerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FlowerRepo flowerRepo;

    @Override
    public void save(FlowerDto flowerDto) {
        flowerRepo.save(modelMapper.map(flowerDto, Flower.class));
    }


    @Override
    public void update(FlowerDto flowerDto) {
        Flower flower = convertDTOToEntity(flowerDto);
        flowerRepo.save(flower);
    }

    @Override
    public FlowerDto findById(Integer id) {
        Optional<Flower> optionalFlower = flowerRepo.findById(id);
        FlowerDto flowerDto = null;
        if (optionalFlower.isPresent()) {
            flowerDto = convertEntityToDTO(optionalFlower.get());
        }
        return flowerDto;
    }

    @Override
    public List<FlowerDto> findAll() {
        return flowerRepo.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        flowerRepo.deleteById(id);

    }

    //metodos de conversión
    public FlowerDto convertEntityToDTO(Flower flower) {
        return modelMapper.map(flower, FlowerDto.class);
    }

    public Flower convertDTOToEntity(FlowerDto flowerDto) {
        return modelMapper.map(flowerDto, Flower.class);
    }
}
