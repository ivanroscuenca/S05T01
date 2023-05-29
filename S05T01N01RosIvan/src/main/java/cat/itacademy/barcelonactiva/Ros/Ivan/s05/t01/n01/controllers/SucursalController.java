package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//No usar RestController solo @Controller
@Controller
@RequestMapping("/sucursals")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //http://localhost:9000/sucursal/getAll
    @GetMapping({"/getAll","/",""})
    public String getAllSucursals(Model model) {
        model.addAttribute("sucursals", sucursalService.findAll());
        if (sucursalService.findAll().isEmpty()) {
            return HttpStatus.NO_CONTENT.toString();
        }
        return "sucursals";
    }


    //http://localhost:9000/sucursal/add
    @GetMapping ({"/add","/add/"})
    public String addSucursalFromForm(Model model) {
        Sucursal newSucursal = new Sucursal();
        model.addAttribute("sucursal",newSucursal);
        return "new_sucursal";
    }

    @PostMapping ({"/getAll","/",""})
    public String guardarSucursalForm (@ModelAttribute("sucursal") SucursalDto sucursalDto){
        sucursalService.save(sucursalDto);
        return "redirect:/sucursals";
    }


    //http://localhost:9000/sucursal/update/{id}
    @GetMapping("/update/{id}")
    public String showEditSucursalForm(@PathVariable Integer id, Model model) {
        model.addAttribute("sucursal", sucursalService.findById(id));
        return "update_sucursal";
    }

    @PostMapping("/update/{id}")
    public String saveEditSucursalForm(@PathVariable Integer id, @ModelAttribute("sucursal") SucursalDto sucursalDto,Model model) {
        SucursalDto actualizadaSucursalDto = sucursalService.findById(id);
        actualizadaSucursalDto.setNomSucursal(sucursalDto.getNomSucursal());
        actualizadaSucursalDto.setPaisSucursal(sucursalDto.getPaisSucursal());
        sucursalService.update(actualizadaSucursalDto);
        return "redirect:/sucursals";
    }



    //http://localhost:9000/sucursal/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable Integer id){
        sucursalService.deleteById(id);
        return "redirect:/sucursals";
    }


    // http://localhost:9000/sucursal/getOne/{id}
    @GetMapping("/getOne/{id}")
    public String getSucursalById(@PathVariable Integer id, Model model ) {
        model.addAttribute("sucursal", sucursalService.findById(id));
        return "show_sucursal";
    }






}
