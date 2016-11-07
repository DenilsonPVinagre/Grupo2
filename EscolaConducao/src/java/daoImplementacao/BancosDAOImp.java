/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.Bancos;
import Utils.HibernateUtil;
import daoInterface.BancosDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class BancosDAOImp implements BancosDAO{
    public void save(Bancos bancos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(bancos);
        t.commit();
    }
    
    
    public void update(Bancos bancos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(bancos);
        t.commit();
    }
        
    
    public void delete(Bancos bancos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(bancos);
        t.commit();
    }
    
    
    public Bancos getBancos(Long idBancos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Bancos) session.load(Bancos.class, idBancos);
    }
        
    
    public Bancos getBancosByDescricao(String descricao) {
        List<Bancos> bancos = lista();
        for(int i=0; i<= lista().size(); i++){
            if(bancos.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return bancos.get(i);
            }
        }
        return null;
    }
    
    public List<Bancos> lista() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Bancos").list();
        t.commit();
        return lista;
    }
}