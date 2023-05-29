package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.service;


import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.repository.SucursalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public void save(SucursalDto sucursalDto) {
        sucursalRepository.save(modelMapper.map(sucursalDto, Sucursal.class));
    }

    @Override
    public void update(SucursalDto sucursalDto) {
        Sucursal sucursal = convertDTOToEntity(sucursalDto);
        sucursalRepository.save(sucursal);
    }

    @Override
    public SucursalDto findById(Integer id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        SucursalDto sucursalDto= null;
        if (optionalSucursal.isPresent()) {
            sucursalDto = convertEntityToDTO(optionalSucursal.get());
        }
        return sucursalDto;
    }

    @Override
    public List<SucursalDto> findAll() {
        return sucursalRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        sucursalRepository.deleteById(id);
    }

    public SucursalDto convertEntityToDTO(Sucursal sucursal) {
        return  modelMapper.map(sucursal, SucursalDto.class);
    }

    public Sucursal convertDTOToEntity(SucursalDto sucursalDTO) {
        return  modelMapper.map(sucursalDTO, Sucursal.class);
    }
}
