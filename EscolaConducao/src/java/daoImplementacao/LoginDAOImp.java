/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementacao;

import Model.Login;
import Utils.HibernateUtil;
import daoInterface.LoginDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Denilson
 */
public class LoginDAOImp implements LoginDAO {
    public void save(Login login){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(login);
        t.commit();
    }
    
    
    public void update(Login login){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(login);
        t.commit();
    }
        
    
    public void delete(Login login){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(login);
        t.commit();
    }
    
    
    public Login getLogin(Long idLogin){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Login) session.load(Login.class, idLogin);
    }
        
    
    public Login getLoginByNome(String nome) {
        List<Login> login = lista();
        for(int i=0; i<= lista().size(); i++){
            if(login.get(i).getNome().equalsIgnoreCase(nome)){
                return login.get(i);
            }
        }
        return null;
    }
    
    public List<Login> lista(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Login").list();
        t.commit();
        return lista;
    }
    
    public Login acessar(String nome, String senha){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Login login  = null;
        
        Query c=session.getNamedQuery("login.a");
        c.setString("nome", nome);
        c.setString("senha", senha);
        login=(Login)c.uniqueResult();
        return login;
    }
    
}