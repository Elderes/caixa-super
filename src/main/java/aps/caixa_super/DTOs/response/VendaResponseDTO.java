package aps.caixa_super.DTOs.response;

import aps.caixa_super.model.Caixa;
import aps.caixa_super.model.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VendaResponseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime dataDeVenda;
    private BigDecimal valorTotal;
    private Caixa caixa;

}

