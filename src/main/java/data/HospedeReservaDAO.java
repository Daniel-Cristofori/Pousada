/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Hospedes.Hospede;
import jakarta.persistence.EntityManager;
import Reservas.HopedeReserva;
import Reservas.Reserva;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HospedeReservaDAO {
    
    public void cadastrar(HopedeReserva hr){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(hr);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    
    
    
    public List<Hospede> hospedesReserva(Reserva reserva) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        List hospedes = null;
                          
        try {
                              
            String textoQuery = "SELECT hr.hospede FROM hospede_reserva hr "+
                    " WHERE (:reserva = hr.reserva) ";
          
           Query consulta = em.createQuery(textoQuery);
                                
            consulta.setParameter("reserva", reserva);

            hospedes = consulta.getResultList();
                            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return hospedes;
                     
    }    
    
}
