package com.seuusuario.agendamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoExterna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;
    private String canal;
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    private LocalDateTime dataRecebimento;
    private Long idCliente;
}
