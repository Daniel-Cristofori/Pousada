
package Hospedes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pi.Pessoa;


@Entity(name="hospede")
@Table(name="hospede")
public class Hospede extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String rg;
    private String endereco;
    private String telefone;
    private String observacoes;


    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
     
     
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
