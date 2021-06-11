package konrad.edu.co.kdd.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Funcionario;
import konrad.edu.co.kdd.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Grupo 2
 */
@Service
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
        while (rec2.hasNext()) {
            Funcionario funcionario;
            funcionario = rec2.next();
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    public Funcionario getById(int id) {
        try {
            return funcionarioRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public void updateFuncionarios(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionarios(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    @Autowired
    private JavaMailSender javaMailSender;
}
