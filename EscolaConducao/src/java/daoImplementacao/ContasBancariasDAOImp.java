/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.ContasBancarias;
import Utils.HibernateUtil;
import daoInterface.ContasBancariasDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class ContasBancariasDAOImp implements ContasBancariasDAO{
    public void save(ContasBancarias contasBancarias){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(contasBancarias);
        t.commit();
    }
    
    
    public void update(ContasBancarias contasBancarias){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(contasBancarias);
        t.commit();
    }
        
    
    public void delete(ContasBancarias contasBancarias){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(contasBancarias);
        t.commit();
    }
    
    
    public ContasBancarias getContasBancarias(Long idContasBancarias){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (ContasBancarias) session.load(ContasBancarias.class, idContasBancarias);
    }
        
    
    public ContasBancarias getContasBancariasByDescricao(String descricao) {
        List<ContasBancarias> contasBancarias = lista();
        for(int i=0; i<= lista().size(); i++){
            if(contasBancarias.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return contasBancarias.get(i);
            }
        }
        return null;
    }
    
    public List<ContasBancarias> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from ContasBancarias").list();
        t.commit();
        return lista;
    }
        
}