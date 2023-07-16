
package Reservas;

import Hospedes.Hospede;
import Quartos.Quarto;
import data.OrcamentoDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;


@Entity(name="reserva")
@Table(name="reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data_reserva  = LocalDate.now();
    private LocalDate data_entrada;
    private LocalDate data_saida;
    private boolean checkIn = false;
    private boolean checkOut = false;
    
    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;
    
    @ManyToOne
    @JoinColumn(name = "id_orcamento")
    private OrcamentoReserva orcamento;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public LocalDate getDataReserva() {
        return data_reserva;
    }

    public LocalDate getDataEntrada() {
        return data_entrada;
    }

    public LocalDate getDataSaida() {
        return data_saida;
    }

    public void setData_entrada(LocalDate data_entrada) {
        this.data_entrada = data_entrada;
    }

    
    
    public void setDataSaida(LocalDate dataSaida) {
        this.data_saida = dataSaida;
    }

    public Quarto getQuarto() {
        return quarto;
    }
   
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
    
    
    public OrcamentoReserva getOrcamento() {
        return orcamento;
    }
    
    

   
////   cria o orçamento para reserva
   public void criarOrcamento(List<Hospede> hospedes) {
       
       orcamento = new OrcamentoReserva();
       
       for (Hospede hospede : hospedes) {
           
           orcamento.calcularOrcamento(hospede.getNascimento(), data_entrada, data_saida, quarto);
           
       }
       
       OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
       orcamentoDAO.cadastrar(orcamento);

   }


    
    public boolean  validaCapacidade(List<Hospede> hospedes) {
        
        if (hospedes.size() == this.quarto.getTipoQuarto().getCapacidade()) {
            
            return false;
            
        }
        else if (hospedes.size() < this.quarto.getTipoQuarto().getCapacidade()) {

            return true;
            
        }
        
        return false;

    }
    
    public boolean validaHospedeR(List<Hospede> hospedes, Hospede hospede){
        
        for (Hospede h : hospedes) {
            
            return !hospede.getCpf().equals(h.getCpf());
            
        }
        
        return  true;
        
    }

}
