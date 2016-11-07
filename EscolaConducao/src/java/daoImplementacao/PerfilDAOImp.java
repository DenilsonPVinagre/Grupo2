/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Perfil;
import Utils.HibernateUtil;
import daoInterface.PerfilDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class PerfilDAOImp implements PerfilDAO{
    public void save(Perfil perfil){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(perfil);
        t.commit();
    }
    
    
    public void update(Perfil perfil){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(perfil);
        t.commit();
    }
        
    
    public void delete(Perfil perfil){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(perfil);
        t.commit();
    }
    
    
    public Perfil getPerfil(Long idPerfil){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Perfil) session.load(Perfil.class, idPerfil);
    }
        
    
    public Perfil getPerfilByDescricao(String descricao) {
        List<Perfil> perfil = lista();
        for(int i=0; i<= lista().size(); i++){
            if(perfil.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return perfil.get(i);
            }
        }
        return null;
    }
    
    public List<Perfil> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Perfil").list();
        t.commit();
        return lista;
    }
        
}