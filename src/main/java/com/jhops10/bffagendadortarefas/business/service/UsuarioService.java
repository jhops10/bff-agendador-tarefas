package com.jhops10.bffagendadortarefas.business.service;


import com.jhops10.bffagendadortarefas.business.dto.EnderecoDTO;
import com.jhops10.bffagendadortarefas.business.dto.TelefoneDTO;
import com.jhops10.bffagendadortarefas.business.dto.UsuarioDTO;
import com.jhops10.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

   private final UsuarioClient usuarioClient;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token) {
       return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deleteByEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO usuarioDTO) {
        return usuarioClient.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token) {
       return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO telefoneDTO, String token) {
       return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTO cadastraEndereco(String token, EnderecoDTO enderecoDTO) {
       return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTO cadastraTelefone(String token, TelefoneDTO telefoneDTO) {
       return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }

}
