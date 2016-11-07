/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Alunos;
import Model.Cargo;
import Model.Categoria;
import Model.ContasBancarias;
import Model.Funcionarios;
import Model.Horarios;
import Model.Login;
import Model.Matriculas;
import Model.Pagamentos;
import Model.Perfil;
import Model.Provincia;
import Model.TiposPagamento;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 *
 * @author Denilson
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    private HibernateUtil(){
        
    }
    
    public static SessionFactory getSessionFactory(){
        
        if(sessionFactory == null){
            try {
                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Alunos.class);
                ac.addAnnotatedClass(Login.class);
                ac.addAnnotatedClass(Cargo.class);
                ac.addAnnotatedClass(Categoria.class);
                ac.addAnnotatedClass(Provincia.class);
                ac.addAnnotatedClass(ContasBancarias.class);
                ac.addAnnotatedClass(Funcionarios.class);
                ac.addAnnotatedClass(Horarios.class);
                ac.addAnnotatedClass(Matriculas.class);
                ac.addAnnotatedClass(Pagamentos.class);
                ac.addAnnotatedClass(Perfil.class);
                ac.addAnnotatedClass(TiposPagamento.class);
               
                sessionFactory = ac.configure().buildSessionFactory();
            
            }catch (Throwable ex) {
                System.err.println("Erro ao criar a SessionFactory."+ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
    }else{
            return sessionFactory;
        }
        
        
    }
    
    
}
