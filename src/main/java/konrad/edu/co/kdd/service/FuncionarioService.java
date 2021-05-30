/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.edu.co.kdd.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Funcionario;
import konrad.edu.co.kdd.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Grupo 2
 */
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void crearFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public ArrayList<Funcionario> readFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Iterable rec1;
        rec1 = funcionarioRepository.findAll();
        Iterator<Funcionario> rec2 = rec1.iterator();
        while(rec2.hasNext()){
            Funcionario funcionario;
            funcionario = rec2.next();
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    public void updateFuncionarios(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionarios(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }
}