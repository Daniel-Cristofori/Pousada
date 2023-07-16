/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Quartos.Quarto;
import Reservas.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class ReservaDAO {
    
    
    public void cadastrar(Reserva r){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(r);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    
    
    public List<Reserva> listarReservas(){
      EntityManager em = JPAUtil.getEntityManager();
      List reservas = null;
      try{
          String textoQuery = "SELECT r FROM reserva r";
          
          Query consulta = em.createQuery(textoQuery);
           
          reservas = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return reservas;
    } 
    
    
    
    
    public void atualizar(Reserva r){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEtityManager();
        }
    }
    
    
    
    
    public boolean validaQuartoR(LocalDate dataE, LocalDate dataS, Quarto quarto) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Reserva usuarioEncontrado = null;
        boolean valido = false;
                          
        try {
                              
            String textoQuery = "SELECT r FROM reserva r "+
                    "JOIN quarto q" +
                    " WHERE (:dataE = r.data_entrada) "+
                    " AND (:dataS = r.data_saida)" +
                    " AND (:quarto = q)";
          
            TypedQuery<Reserva> consulta = em.createQuery(textoQuery, Reserva.class);
                                
            consulta.setParameter("dataE", dataE);
            consulta.setParameter("dataS", dataS);
            consulta.setParameter("quarto", quarto);

            usuarioEncontrado = consulta.getSingleResult();
            
            valido = true;
            
            
                            
        }catch (NoResultException e) {
            
            valido = false;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
                            
        }
                          
        return valido;
                      
    }    
    
    
    public Reserva reservaPorId(int id) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Reserva reserva = null;
                          
        try {
                              
            String textoQuery = "SELECT r FROM reserva r "+
                    " WHERE (:id = id) ";
          
            TypedQuery<Reserva> consulta = em.createQuery(textoQuery, Reserva.class);
                                
            consulta.setParameter("id", id);

            reserva = consulta.getSingleResult();
                            
        }catch(NoResultException e){
            
            return reserva;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return reserva;
                     
    } 
    
    
    
    
    
}
