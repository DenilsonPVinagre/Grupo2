/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Login;
import Model.Login;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface LoginDAO {
    public void save(Login login);
    public void update(Login login);
    public void delete(Login login);
    public Login getLogin (Long idLogin);
    public Login getLoginByNome (String nome);
    public List<Login> lista();
    public Login acessar(String nome, String senha);
}