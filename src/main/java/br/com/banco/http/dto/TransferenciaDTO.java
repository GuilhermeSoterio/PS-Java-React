package br.com.banco.http.dto;

import br.com.banco.entity.Transferencia;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDTO {
    private String id;

    private Integer valor;

    private String tipo;

    private String nomeOperadorTransacao;

    private String contaId;

    private OffsetDateTime dataTransferencia;

    public TransferenciaDTO(Transferencia entity) {
        id = entity.getId();
        valor = entity.getValor();
        tipo = entity.getTipo().name();
        contaId = entity.getContaId();
        dataTransferencia = entity.getDataTransferencia();
        nomeOperadorTransacao = entity.getNomeOperadorTransacao();
//        setVictimAge(entity.getVictim().getAge());
//        setVictimGenre(entity.getVictim().getGenre());
//        setCrimeTypeName(entity.getCrime().getTypeCrime());
    }
}
