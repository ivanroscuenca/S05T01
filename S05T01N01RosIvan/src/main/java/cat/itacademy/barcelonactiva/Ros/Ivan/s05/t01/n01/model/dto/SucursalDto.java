package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SucursalDto {

    public static List<String>paisos = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));
    private Integer pk_SucursalID;
    private String nomSucursal;

    private String paisSucursal;

    private String tipusSucursal;

    public SucursalDto( String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        setTipusSucursal();
    }

    public SucursalDto() {

    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
        setTipusSucursal();
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    //funcion saber si es UE o NO
    public void setTipusSucursal() {
        if (paisos.contains(getPaisSucursal())){
            this.tipusSucursal="UE";
        }else {
            this.tipusSucursal="NO UE";
        }
    }

}


