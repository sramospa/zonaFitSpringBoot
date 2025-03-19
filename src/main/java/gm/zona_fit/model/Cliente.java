package gm.zona_fit.model;

import jakarta.persistence.Entity;//jpa
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data  //se generan los metodos get and set gracias a lombok
@NoArgsConstructor  //el constructor vacio
@AllArgsConstructor // crea los constructores con todos los argumentos
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id  //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //VALORES AUTOINCREMENTABLES
    private Integer id;//cuando trabajamos con objetos el vlor por defecto es null
    private String nombre;
    private String apellido;
    private Integer membresia;


}
