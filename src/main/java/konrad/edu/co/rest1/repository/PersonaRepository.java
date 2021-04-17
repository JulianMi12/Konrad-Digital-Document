package konrad.edu.co.rest1.repository;

import konrad.edu.co.rest1.entity.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Julian Miranda
 */
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
    
}
