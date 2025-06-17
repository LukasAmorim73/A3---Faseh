package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.Repository.ProfissionalRepository;
import com.seuusuario.agendamento.entity.Profissional;

import java.util.List;

public class ProfissionalService {
    private ProfissionalRepository profissionalRepository = new ProfissionalRepository();

    public void adicionarProfissional(Profissional profissional, List<Profissional> profissionaisExistentes) {
        for (Profissional p : profissionaisExistentes) {
            if (p.getNome().equalsIgnoreCase(profissional.getNome())
                    && p.getEspecialidade().equalsIgnoreCase(profissional.getEspecialidade())) {
                System.out.println("Profissional já cadastrado.");
                return;
            }
        }
        profissionalRepository.cadastrarProfissional(profissional);
        System.out.println("Profissional cadastrado com sucesso!");
    }
}
