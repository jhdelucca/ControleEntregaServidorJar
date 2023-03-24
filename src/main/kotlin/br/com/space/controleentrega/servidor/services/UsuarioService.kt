package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.Usuario
import br.com.space.controleentrega.servidor.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val repository: UsuarioRepository) {

    fun verificaUsuarioTransportador(usuario:String):Usuario {
        return repository.verificaUsuarioTransportador(usuario)
    }
}