/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.Alunos;
import Utils.HibernateUtil;
import daoInterface.AlunosDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class AlunosDAOImp implements AlunosDAO{
    public void save(Alunos alunos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(alunos);
        t.commit();
    }
    
    
    public void update(Alunos alunos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(alunos);
        t.commit();
    }
        
    
    public void delete(Alunos alunos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(alunos);
        t.commit();
    }
    
    
    public Alunos getAlunos(Long idAlunos){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Alunos) session.load(Alunos.class, idAlunos);
    }
        
    
    public Alunos getAlunosByNome(String nome) {
        List<Alunos> alunos = lista();
        for(int i=0; i<= lista().size(); i++){
            if(alunos.get(i).getNome().equalsIgnoreCase(nome)){
                return alunos.get(i);
            }
        }
        return null;
    }
    
    public List<Alunos> lista() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Alunos").list();
        t.commit();
        return lista;
    }
}