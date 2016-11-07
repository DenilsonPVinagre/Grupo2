/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

/**
 *
 * @author Denilson
 */


import Model.Horarios;
import Utils.HibernateUtil;
import daoInterface.HorariosDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class HorariosDAOImp implements HorariosDAO {
    public void save(Horarios horarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(horarios);
        t.commit();
    }
    
    
    public void update(Horarios horarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(horarios);
        t.commit();
    }
        
    
    public void delete(Horarios horarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(horarios);
        t.commit();
    }
    
    
    public Horarios getHorarios(Long idHorarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Horarios) session.load(Horarios.class, idHorarios);
    }
        
    
    public Horarios getHorariosByDescricao(String descricao) {
        List<Horarios> horarios = lista();
        for(int i=0; i<= lista().size(); i++){
            if(horarios.get(i).getDescricao().equalsIgnoreCase(descricao)){
                return horarios.get(i);
            }
        }
        return null;
    }
    
    public List<Horarios> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Horarios").list();
        t.commit();
        return lista;
    }
        
}
