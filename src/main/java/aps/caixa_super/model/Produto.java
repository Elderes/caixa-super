package aps.caixa_super.model;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private double quantidade;

    private BigDecimal precoUnitario;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
