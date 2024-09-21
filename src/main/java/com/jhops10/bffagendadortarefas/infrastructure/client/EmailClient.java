package com.jhops10.bffagendadortarefas.infrastructure.client;


import com.jhops10.bffagendadortarefas.business.dto.TarefasDTO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasDTO dto);

}
