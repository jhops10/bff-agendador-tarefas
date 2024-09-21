package com.jhops10.bffagendadortarefas.business.service;

import com.jhops10.bffagendadortarefas.business.dto.TarefasDTO;
import com.jhops10.bffagendadortarefas.business.dto.UsuarioDTO;
import com.jhops10.bffagendadortarefas.infrastructure.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;


    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefasDTO> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaFutura, horaFuturaMaisCinco, token);

        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            tarefasService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);
        });

    }

    public String login(UsuarioDTO usuarioDTO) {
        return usuarioService.loginUsuario(usuarioDTO);
    }

    public UsuarioDTO converterParaRequestDTO() {
        return UsuarioDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }


}
