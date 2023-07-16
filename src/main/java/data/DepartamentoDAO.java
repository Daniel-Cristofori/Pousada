/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Departamentos.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class DepartamentoDAO {
    
    
    public List<Departamento> listarDepartamentos(){
      EntityManager em = JPAUtil.getEntityManager();
      List departamentos = null;
      try{
          String textoQuery = "SELECT d FROM departamento d";
          
          Query consulta = em.createQuery(textoQuery);
           
          departamentos = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return departamentos;
    } 
    
}
