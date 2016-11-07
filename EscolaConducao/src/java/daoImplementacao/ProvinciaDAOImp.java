/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Provincia;
import Utils.HibernateUtil;
import daoInterface.ProvinciaDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class ProvinciaDAOImp implements ProvinciaDAO{
    public void save(Provincia provincia){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(provincia);
        t.commit();
    }
    
    
    public void update(Provincia provincia){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(provincia);
        t.commit();
    }
        
    
    public void delete(Provincia provincia){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(provincia);
        t.commit();
    }
    
    
    public Provincia getProvincia(Long idProvincia){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Provincia) session.load(Provincia.class, idProvincia);
    }
        
    
    public Provincia getProvinciaByDescricao(String descricao) {
        List<Provincia> provincia = lista();
        for(int i=0; i<= lista().size(); i++){
            if(provincia.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return provincia.get(i);
            }
        }
        return null;
    }
    
    public List<Provincia> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Provincia").list();
        t.commit();
        return lista;
    }
        
}