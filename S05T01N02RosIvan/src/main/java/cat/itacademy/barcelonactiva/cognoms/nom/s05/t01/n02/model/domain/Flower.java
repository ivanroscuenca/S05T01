package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name="Flowers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_FlowerID")
    private Integer pk_FlowerID;

    @Column(name="countryFlower")
    private String countryFlower;

    @Column(name="nameFlower")
    private String nameFlower;


}
