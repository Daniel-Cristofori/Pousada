package Quartos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity(name="quarto")
@Table(name="quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  int numero;
    @ManyToOne
    @JoinColumn(name = "id_tipo_quarto")
    TipoQuarto tipoQuarto;

//    public Quarto(int numero, TipoQuarto tipoQuarto) {
//        this.numero = numero;
//        this.tipoQuarto = tipoQuarto;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    
}
