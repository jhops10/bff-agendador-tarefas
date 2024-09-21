package com.jhops10.bffagendadortarefas.business.service;


import com.jhops10.bffagendadortarefas.business.dto.TarefasDTO;
import com.jhops10.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTO tarefasDTO) {
        emailClient.enviarEmail(tarefasDTO);
    }


}
