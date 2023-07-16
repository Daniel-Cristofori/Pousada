package Funcionarios;

import Departamentos.Departamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pi.Pessoa;

@Entity(name="funcionario")
@Table(name="funcionario")
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private double salario;
    private String login;
    private String senha;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    Departamento departamento;

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    
    public double getSalario() {
        return salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

}
