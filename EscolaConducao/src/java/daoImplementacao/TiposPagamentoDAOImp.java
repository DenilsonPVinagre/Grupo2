/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.TiposPagamento;
import Utils.HibernateUtil;
import daoInterface.TiposPagamentoDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class TiposPagamentoDAOImp implements TiposPagamentoDAO{
    public void save(TiposPagamento tiposPagamento){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(tiposPagamento);
        t.commit();
    }
    
    
    public void update(TiposPagamento tiposPagamento){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(tiposPagamento);
        t.commit();
    }
        
    
    public void delete(TiposPagamento tiposPagamento){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(tiposPagamento);
        t.commit();
    }
    
    
    public TiposPagamento getTiposPagamento(Long idTiposPagamento){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (TiposPagamento) session.load(TiposPagamento.class, idTiposPagamento);
    }
        
    
    public TiposPagamento getTiposPagamentoByDescricao(String descricao) {
        List<TiposPagamento> tiposPagamento = lista();
        for(int i=0; i<= lista().size(); i++){
            if(tiposPagamento.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return tiposPagamento.get(i);
            }
        }
        return null;
    }
    
    public List<TiposPagamento> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TiposPagamento").list();
        t.commit();
        return lista;
    }
        
}