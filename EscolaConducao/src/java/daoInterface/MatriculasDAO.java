/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Matriculas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface MatriculasDAO {
    public void save(Matriculas matriculas);
    public void update(Matriculas matriculas);
    public void delete(Matriculas matriculas);
    public Matriculas getMatriculas (Long idMatriculas);
    public Matriculas getMatriculasByData_matricula (Date Data_matricula);
    public List<Matriculas> lista();
}