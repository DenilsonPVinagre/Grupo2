/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.HibernateUtil;

/**
 *
 * @author Denilson
 */
public class ligarHibernate {
    
    public static void main(String[] args) {
    HibernateUtil.getSessionFactory().openSession();
    HibernateUtil.getSessionFactory().close();
    
    }
    
}
