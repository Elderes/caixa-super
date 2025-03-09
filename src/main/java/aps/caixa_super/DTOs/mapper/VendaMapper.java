package aps.caixa_super.DTOs.mapper;

import aps.caixa_super.DTOs.response.VendaResponseDTO;
import aps.caixa_super.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public class VendaMapper {
    public static VendaResponseDTO toDTO(Venda venda) {
        return new VendaResponseDTO(
                venda.getDataDeVenda(), // Mantém como LocalDateTime
                venda.getValorTotal(),
                venda.getCaixa()
        );
    }

    public static List<VendaResponseDTO> toDTOList(List<Venda> vendas) {
        return vendas.stream().map(VendaMapper::toDTO).collect(Collectors.toList());
    }
}
