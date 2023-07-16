
package Quartos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name="tipoQuarto")
@Table(name="tipo_quarto")
public  class TipoQuarto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private int capacidade_pessoas;
    private double valor_diaria;

//    public TipoQuarto(String descricao, int capacidade, double valorDiaria) {
//        this.descricao = descricao;
//        this.capacidade_pessoas = capacidade;
//        this.valor_diaria = valorDiaria;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade_pessoas;
    }

    public double getValorDiaria() {
        return valor_diaria;
    }
    
}


