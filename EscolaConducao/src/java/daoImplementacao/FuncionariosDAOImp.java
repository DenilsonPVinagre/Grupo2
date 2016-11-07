/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;


import Model.Funcionarios;
import Utils.HibernateUtil;
import daoInterface.FuncionariosDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Denilson
 */
public class FuncionariosDAOImp implements FuncionariosDAO{
    public void save(Funcionarios funcionarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(funcionarios);
        t.commit();
    }
    
    
    public void update(Funcionarios funcionarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(funcionarios);
        t.commit();
    }
        
    
    public void delete(Funcionarios funcionarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(funcionarios);
        t.commit();
    }
    
    
    public Funcionarios getFuncionarios(long idFuncionarios){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Funcionarios) session.load(Funcionarios.class, idFuncionarios);
    }
        
    
    public Funcionarios getFuncionariosByNome(String nome) {
        List<Funcionarios> funcionarios = lista();
        for(int i=0; i<= lista().size(); i++){
            if(funcionarios.get(i).getNome().equalsIgnoreCase(nome)){
                return funcionarios.get(i);
            }
        }
        return null;
    }
    
    public List<Funcionarios> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Funcionarios").list();
        t.commit();
        return lista;
    }      
}