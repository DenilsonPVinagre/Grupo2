
package daoInterface;

import Model.Funcionarios;
import java.util.List;

/**
 *
 * @author Denilson
 */

public interface FuncionariosDAO {
    public void save(Funcionarios funcionarios);
    public void update(Funcionarios funcionarios);
    public void delete(Funcionarios funcionarios);
    public Funcionarios getFuncionarios (long idFuncionarios);
    public Funcionarios getFuncionariosByNome (String nome);
    public List<Funcionarios> lista();
}