/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Quartos.Quarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class QuartoDAO {
    
    
    public void cadastrar(Quarto q){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(q);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    
    
    
    
    public List<Quarto> listarQuartos(){
      EntityManager em = JPAUtil.getEntityManager();
      List quartos = null;
      try{
          String textoQuery = "SELECT q FROM quarto q";
          
          Query consulta = em.createQuery(textoQuery);
           
          quartos = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return quartos;
    }  
    
    
    
    public Quarto quartoPorNumero(int numero) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Quarto quarto = null;
                          
        try {
                              
            String textoQuery = "SELECT q FROM quarto q "+
                    " WHERE (:numero = numero) ";
          
            TypedQuery<Quarto> consulta = em.createQuery(textoQuery, Quarto.class);
                                
            consulta.setParameter("numero", numero);

            quarto = consulta.getSingleResult();
                            
        }catch(NoResultException e){
            
            return quarto;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return quarto;
                     
    } 
    
    
    public boolean validaQuartoPorNumero(int numero) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Quarto quarto = null;
        boolean valido = false;
                          
        try {
                              
            String textoQuery = "SELECT q FROM quarto q "+
                    " WHERE (:numero = numero) ";
          
            TypedQuery<Quarto> consulta = em.createQuery(textoQuery, Quarto.class);
                                
            consulta.setParameter("numero", numero);

            quarto = consulta.getSingleResult();
            
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
