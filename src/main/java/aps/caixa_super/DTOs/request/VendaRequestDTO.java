package aps.caixa_super.DTOs.request;

import aps.caixa_super.DTOs.request.ProdutoVendaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VendaRequestDTO {
    private Long caixaId;
    private List<ProdutoVendaDTO> produtos;

}
