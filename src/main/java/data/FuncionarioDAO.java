/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Funcionarios.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class FuncionarioDAO {
    
    
    public void cadastrar(Funcionario f) {
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(f);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
    
    
    
    
    public List<Funcionario> listarFuncionarios(){
      EntityManager em = JPAUtil.getEntityManager();
      List funcionarios = null;
      try{
          String textoQuery = "SELECT f FROM funcionario f";
          
          Query consulta = em.createQuery(textoQuery);
           
          funcionarios = consulta.getResultList();
      }
      finally{
          JPAUtil.closeEtityManager();
      }
      return funcionarios;
    }  
    
    
    
    
    
    
    public boolean validaFuncionarioPorCpf(String cpf) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario funcionario = null;
        boolean valido = false;
                          
        try {
                              
            String textoQuery = "SELECT f FROM funcionario f "+
                    " WHERE (:cpf = cpf) ";
          
            TypedQuery<Funcionario> consulta = em.createQuery(textoQuery, Funcionario.class);
                                
            consulta.setParameter("cpf", cpf);

            funcionario = consulta.getSingleResult();
            
             valido = true;
                            
        }catch(NoResultException e){
            
             valido = false;
            
        }
        finally{
                                 
            JPAUtil.closeEtityManager();
            
                            
        }
        
        return valido;
                     
    } 
    
    
    public static Funcionario validarUsuario(String login, String senha) {
                             
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario usuarioEncontrado = null;
                          
        try {
                              
            String textoQuery = "SELECT f FROM funcionario f "+
                    " WHERE (:login = f.login) "+
                    " AND (:senha = f.senha)";
          
            TypedQuery<Funcionario> consulta = em.createQuery(textoQuery, Funcionario.class);
                                
            consulta.setParameter("login", login);
            consulta.setParameter("senha", senha);

            usuarioEncontrado = consulta.getSingleResult();
                            
        }finally{
                                 
            JPAUtil.closeEtityManager();
                            
        }
                          
        return usuarioEncontrado;
                      
    }    
    
}
