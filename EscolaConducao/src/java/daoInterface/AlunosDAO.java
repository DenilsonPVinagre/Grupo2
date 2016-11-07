/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Alunos;
import java.util.List;

/**
 *
 * @author Denilson
 */

public interface AlunosDAO {
    public void save(Alunos alunos);
    public void update(Alunos alunos);
    public void delete(Alunos alunos);
    public Alunos getAlunos (Long idAlunos);
    public Alunos getAlunosByNome (String nome);
    public List<Alunos> lista();
}