/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Reservas.OrcamentoReserva;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class OrcamentoDAO {
    
    
    public void cadastrar(OrcamentoReserva o){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(o);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    public void atualizar(OrcamentoReserva o){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEtityManager();
        }
    }
    
}
