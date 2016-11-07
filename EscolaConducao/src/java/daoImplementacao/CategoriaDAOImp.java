/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Categoria;
import Utils.HibernateUtil;
import daoInterface.CategoriaDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class CategoriaDAOImp implements CategoriaDAO{
    public void save(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(categoria);
        t.commit();
    }
    
    
    public void update(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(categoria);
        t.commit();
    }
        
    
    public void delete(Categoria categoria){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(categoria);
        t.commit();
    }
    
    
    public Categoria getCategoria(Long idCategoria){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Categoria) session.load(Categoria.class, idCategoria);
    }
        
    
    public Categoria getCategoriaByDescricao(String descricao) {
        List<Categoria> categoria = lista();
        for(int i=0; i<= lista().size(); i++){
            if(categoria.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return categoria.get(i);
            }
        }
        return null;
    }
    
    public List<Categoria> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Categoria").list();
        t.commit();
        return lista;
    }
        
}
