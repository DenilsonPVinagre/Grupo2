/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Horarios;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface HorariosDAO {
    public void save(Horarios horarios);
    public void update(Horarios horarios);
    public void delete(Horarios horarios);
    public Horarios getHorarios (Long idHorarios);
    public Horarios getHorariosByDescricao (String descricao);
    public List<Horarios> lista();
}