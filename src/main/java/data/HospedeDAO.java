/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Hospedes.Hospede;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HospedeDAO {
    
    
    public void cadastrar(Hospede h){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(h);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    
    
    
    public List<Hospede> listarHospedes(){
      EntityManager em = JPAUtil.getEntityManager();
      List hospede = null;
      try{
          String textoQuery = "SELECT h FROM hospede h";
          
          Query consulta = em.createQuery(textoQuery);
           
          hospede = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return hospede;
    }  
    
    
  
    
    public Hospede hospedePorCpf(String cpf) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Hospede hospedeEncontrado = null;
                          
        try {
                              
            String textoQuery = "SELECT h FROM hospede h "+
                    " WHERE (:cpf = cpf) ";
          
            TypedQuery<Hospede> consulta = em.createQuery(textoQuery, Hospede.class);
                                
            consulta.setParameter("cpf", cpf);

            hospedeEncontrado = consulta.getSingleResult();
                            
        }catch(NoResultException e){
            
            return hospedeEncontrado;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return hospedeEncontrado;
                     
    }    
    
    public boolean validaHospedePorCpf(String cpf) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Hospede hospedeEncontrado = null;
        boolean valido = false;
                          
        try {
                              
            String textoQuery = "SELECT h FROM hospede h "+
                    " WHERE (:cpf = cpf) ";
          
            TypedQuery<Hospede> consulta = em.createQuery(textoQuery, Hospede.class);
                                
            consulta.setParameter("cpf", cpf);

            hospedeEncontrado = consulta.getSingleResult();
            
             valido = true;
                            
        }catch(NoResultException e){
            
             valido = false;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return valido;
                     
    }    
    
    
    
}
