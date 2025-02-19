package aps.caixa_super.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VendaRequestDTO {
    private Long caixaId;
    private List<ProdutoVendaDTO> produtos;

}
