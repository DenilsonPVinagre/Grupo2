/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Perfil;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface PerfilDAO {
    public void save(Perfil perfil);
    public void update(Perfil perfil);
    public void delete(Perfil perfil);
    public Perfil getPerfil (Long idPerfil);
    public Perfil getPerfilByDescricao (String descricao);
    public List<Perfil> lista();
}