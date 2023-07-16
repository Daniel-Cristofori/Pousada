/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Quartos.TipoQuarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class TipoQuartoDAO {
    
    public List<TipoQuarto> listarTipoQuarto(){
      EntityManager em = JPAUtil.getEntityManager();
      List tipoQuarto = null;
      try{
          String textoQuery = "SELECT tp FROM tipoQuarto tp";
          
          Query consulta = em.createQuery(textoQuery);
           
          tipoQuarto = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return tipoQuarto;
    }  
    
}
