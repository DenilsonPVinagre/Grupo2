/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.Cargo;
import Utils.HibernateUtil;
import daoInterface.CargoDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class CargoDAOImp implements CargoDAO{
    public void save(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cargo);
        t.commit();
    }
    
    
    public void update(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(cargo);
        t.commit();
    }
        
    
    public void delete(Cargo cargo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cargo);
        t.commit();
    }
    
    
    public Cargo getCargo(Long idCargo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Cargo) session.load(Cargo.class, idCargo);
    }
        
    
    public Cargo getCargoByDescricao(String descricao) {
        List<Cargo> cargo = lista();
        for(int i=0; i<= lista().size(); i++){
            if(cargo.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return cargo.get(i);
            }
        }
        return null;
    }
    
    public List<Cargo> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cargo").list();
        t.commit();
        return lista;
    }
        
}