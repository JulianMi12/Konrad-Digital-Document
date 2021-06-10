/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.edu.co.kdd.repository;

import konrad.edu.co.kdd.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Grupo 2
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
    
}
