package br.com.banco.entity;

import br.com.banco.entity.enums.tipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer valor;

    private String nomeOperadorTransacao;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR")
    private tipoTransacao tipo;

    private String contaId;

    private OffsetDateTime dataTransferencia;
}
