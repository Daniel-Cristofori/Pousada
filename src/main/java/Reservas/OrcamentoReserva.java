
package Reservas;

import Quartos.Quarto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;


@Entity(name="orcamento")
@Table(name="orcamento")
public class OrcamentoReserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private double  valor_final;
    private boolean pagamento_realizado = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorFinal() {
        return valor_final;
    }

    public boolean getPagamentoRealizado() {
        return pagamento_realizado;
    }

    public void setValorFinal(double valorFinal) {
        this.valor_final = valorFinal;
    }

    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamento_realizado = pagamentoRealizado;
    }
    
    
    
    
    
    
//      faz o calculo e aplica o orçamento final
    public void calcularOrcamento(LocalDate dataNascimento, LocalDate dataEntrada, LocalDate dataSaida, Quarto quarto) {
        
        double valor;
        long diasHospedagem = DAYS.between(dataEntrada, dataSaida);
        
        if (validaDesconto(dataNascimento)) {
            
            valor = aplicaDesconto(quarto);
            
        }
        else{
            
            valor = quarto.getTipoQuarto().getValorDiaria();
            
        }
        
        this.valor_final += valor * diasHospedagem;
         
    }
    
//    aplica um desconto
    public double aplicaDesconto(Quarto quarto) {
        
        int d = 8;
        double valorDiaria = quarto.getTipoQuarto().getValorDiaria();
        
        double descontoFinal = valorDiaria - ((valorDiaria * d) / 100);
        
        return descontoFinal;
        
    }
    
//  valida o desconto
    public boolean validaDesconto(LocalDate dataNascimento){
        
        LocalDate today = LocalDate.now();
        long idade = YEARS.between(dataNascimento, today);
        
         return (idade < 4 || idade > 80);
        
    }
    
}
