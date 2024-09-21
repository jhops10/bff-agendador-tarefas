package com.jhops10.bffagendadortarefas.business.service;


import com.jhops10.bffagendadortarefas.business.dto.TarefasDTO;
import com.jhops10.bffagendadortarefas.infrastructure.client.TarefasClient;
import com.jhops10.bffagendadortarefas.infrastructure.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTO tarefasDTO) {
        return tarefasClient.gravarTarefas(tarefasDTO, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO tarefasDTO, String id, String token) {
        return tarefasClient.updateTarefas(tarefasDTO, id, token);
    }


}
