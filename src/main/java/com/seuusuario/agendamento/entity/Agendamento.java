package com.seuusuario.agendamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    private boolean notificacaoEnviada;
    private Long idCliente;
    private Long idProfissional;
    private Long idServico;
}
