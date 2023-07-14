package br.com.banco.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaFilterDTO {

    @Nullable
    private String nomeOperador;

    @Nullable
    private OffsetDateTime initialDate;

    @Nullable
    private OffsetDateTime  endDate;

}
