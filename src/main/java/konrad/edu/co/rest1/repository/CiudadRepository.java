/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.edu.co.rest1.repository;

import konrad.edu.co.rest1.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Julian Miranda
 */
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{
    
}

