package gm.zona_fit.repositorio;

import gm.zona_fit.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {  //tipo de dato de la clase y el tipo de la clave primaria
}
