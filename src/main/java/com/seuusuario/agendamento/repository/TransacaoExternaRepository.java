package com.seuusuario.agendamento.repository;

import com.seuusuario.agendamento.entity.TransacaoExterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoExternaRepository extends JpaRepository<TransacaoExterna, Long> {
}
