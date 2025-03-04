package aps.caixa_super.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_BaixaDeCaixa")
public class BaixaDeCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String descricao;

    BigDecimal valor;

    LocalDateTime DataBaixa;
}
