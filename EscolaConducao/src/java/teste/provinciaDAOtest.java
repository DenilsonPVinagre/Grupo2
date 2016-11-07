/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Model.Provincia;
import daoImplementacao.ProvinciaDAOImp;

/**
 *
 * @author Denilson
 */
public class provinciaDAOtest {
    
    
    public void salvar(){
    
    ProvinciaDAOImp provDAOimp = new ProvinciaDAOImp();
    Provincia provincia = new Provincia();
    
    provincia.setDescricao("Cunene");
    
    provDAOimp.save(provincia);
    
    
    }
    
}
