package com.seuusuario.agendamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;
    private LocalDateTime dataRegistro;
    @Column(columnDefinition = "TEXT")
    private String relatorioTexto;
    private Long idAgendamento;
    private Long idCliente;
}
