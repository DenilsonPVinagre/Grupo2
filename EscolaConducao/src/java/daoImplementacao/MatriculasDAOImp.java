/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Matriculas;
import Utils.HibernateUtil;
import daoInterface.MatriculasDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class MatriculasDAOImp implements MatriculasDAO{
    public void save(Matriculas matriculas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(matriculas);
        t.commit();
    }
    
    
    public void update(Matriculas matriculas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(matriculas);
        t.commit();
    }
        
    
    public void delete(Matriculas matriculas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(matriculas);
        t.commit();
    }
    
    
    public Matriculas getMatriculas(Long idMatriculas){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Matriculas) session.load(Matriculas.class, idMatriculas);
    }
        
    
    public Matriculas getMatriculasByData_matricula(Date data_matricula) {
        List<Matriculas> matriculas = lista();
        for(int i=0; i<= lista().size(); i++){
            if(matriculas.get(i).getData_matricula().equals(data_matricula)){
                return matriculas.get(i);
            }
        }
        return null;
    }
    
    public List<Matriculas> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Matriculas").list();
        t.commit();
        return lista;
    }
        
}
