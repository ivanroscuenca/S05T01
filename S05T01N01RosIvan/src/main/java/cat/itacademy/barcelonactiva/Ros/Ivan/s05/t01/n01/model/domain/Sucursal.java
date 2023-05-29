package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name="Sucursals")
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @ToString
    public class Sucursal {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer pk_SucursalID;

        @Column(name="nomSucursal")
        private String nomSucursal;

        @Column(name="paisSucursal")
        private String paisSucursal;

    }

