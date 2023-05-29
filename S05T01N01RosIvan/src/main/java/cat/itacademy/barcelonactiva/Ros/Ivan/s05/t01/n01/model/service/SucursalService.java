package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.repository.SucursalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public interface SucursalService {

        void save(SucursalDto sucursalDto);

        void update(SucursalDto sucursalDto);

        SucursalDto findById(Integer id);

        List<SucursalDto> findAll();

        void deleteById(Integer id);

    }