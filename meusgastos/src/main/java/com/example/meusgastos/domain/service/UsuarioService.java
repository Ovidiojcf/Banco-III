package com.example.meusgastos.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meusgastos.domain.dto.usuario.UsuarioRequestDTO;
import com.example.meusgastos.domain.dto.usuario.UsuarioResponseDTO;
import com.example.meusgastos.domain.exception.ResourceBadRequestExcpetion;
import com.example.meusgastos.domain.exception.ResourceNotFoundException;
import com.example.meusgastos.domain.model.Usuario;
import com.example.meusgastos.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDTO, UsuarioResponseDTO>{
@Autowired
private UsuarioRepository usuarioRepository;
@Autowired
private ModelMapper mapper;


@Override
public List<UsuarioResponseDTO> obterTodos() {
    List<Usuario> usuarios = usuarioRepository.findAll();
    return usuarios.stream()
    .map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class))
    .collect(Collectors.toList());
}
@Override
public UsuarioResponseDTO obterPorId(Long id) {
    Optional<Usuario> optUsuario = usuarioRepository.findById(id);
    if(optUsuario.isEmpty()){
        throw new ResourceNotFoundException("Não foi possivel encontrar o usuario com o id:" + id);
    }
    return mapper.map(optUsuario.get(),UsuarioResponseDTO.class);
}
@Override
public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
    if(dto.getEmail() == null || dto.getSenha() == null){
        throw new ResourceBadRequestExcpetion("Email e senha são onrigatorios");
    }
    Optional<Usuario> optUsuario = usuarioRepository.findByEmail(dto.getEmail());
    if(optUsuario.isPresent()){
        throw new ResourceBadRequestExcpetion("Já existe um ususario cadastrado com esse email"+ 
        dto.getEmail());
    }
    Usuario usuario = mapper.map(dto, Usuario.class);
    usuario.setDataCadastro(new Date());
    //encriptar a senha
    usuario = usuarioRepository.save(usuario);
    return mapper.map(usuario,UsuarioResponseDTO.class);
}
@Override
public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
    obterPorId(id);
    if(dto.getEmail() == null || dto.getSenha() == null){
        throw new ResourceBadRequestExcpetion("Email e senha são onrigatorios");
    }
    Usuario usuario = mapper.map(dto, Usuario.class);
    usuario.setId(id);
    usuario = usuarioRepository.save(usuario);
    return mapper.map(usuario,UsuarioResponseDTO.class);
}
@Override
public void deletar(Long id) {
  // apagar usuario
    //  obterPorId(id);
    //usuarioRepository.deleteById(id);

    //inativar usuario
    Optional<Usuario> optUsuario = usuarioRepository.findById(id);
    if(optUsuario.isEmpty()){
        throw new ResourceNotFoundException("Não foi possivel encontrar o usuario com o id:" + id);
    }
    
    Usuario usuario= optUsuario.get();
    usuario.setDataInativacao(new Date());
    usuarioRepository.save(usuario);
}


    
}
