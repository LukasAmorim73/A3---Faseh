package com.seuusuario.agendamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacao;
    private String tipo;
    private String destinatario;
    private LocalDateTime dataEnvio;
    private String statusEnvio;
    private Long idAgendamento;
}
