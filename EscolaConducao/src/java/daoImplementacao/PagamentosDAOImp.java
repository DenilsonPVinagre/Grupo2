/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Pagamentos;
import Utils.HibernateUtil;
import daoInterface.PagamentosDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class PagamentosDAOImp implements PagamentosDAO{
    public void save(Pagamentos pagamentos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pagamentos);
        t.commit();
    }
    
    
    public void update(Pagamentos pagamentos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pagamentos);
        t.commit();
    }
        
    
    public void delete(Pagamentos pagamentos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pagamentos);
        t.commit();
    }
    
    
    public Pagamentos getPagamentos(Long idPagamentos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pagamentos) session.load(Pagamentos.class, idPagamentos);
    }
        
    
    public Pagamentos getPagamentosByDescricao(String descricao) {
        List<Pagamentos> pagamentos = lista();
        for(int i=0; i<= lista().size(); i++){
            if(pagamentos.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return pagamentos.get(i);
            }
        }
        return null;
    }
    
    public List<Pagamentos> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Pagamentos").list();
        t.commit();
        return lista;
    }
        
}