package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
    public class FlowerDto{
    private static List<String> countries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));

    private Integer pk_FlowerID;
    private String countryFlower;
    private String nameFlower;

    private String KindOfFlower;

    public FlowerDto(String countryFlower, String nameFlower) {
        this.countryFlower = countryFlower;
        this.nameFlower = nameFlower;
        setKindOfFlower();
    }

    public void setCountryFlower(String countryFlower) {
        this.countryFlower = countryFlower;
        setKindOfFlower();
    }

    //funcion saber si es UE o NO
    public void setKindOfFlower() {
        if (countries.contains(getCountryFlower())){
            this.KindOfFlower="UE";
        }else {
            this.KindOfFlower="NO UE";
        }
    }

}



