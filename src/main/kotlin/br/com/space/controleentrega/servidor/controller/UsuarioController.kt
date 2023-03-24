package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.NotFoundException
import br.com.space.controleentrega.servidor.exception.UnauthorizedException
import br.com.space.controleentrega.servidor.response.UsuarioResponse
import br.com.space.controleentrega.servidor.services.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("usuario")
class UsuarioController(val service: UsuarioService) {

    @GetMapping("/{usuario}")
    fun verificaUsuarioTransportador(@PathVariable(name = "usuario") usuario:String) : UsuarioResponse {
        try {
            var usr  = service.verificaUsuarioTransportador(usuario)
            return UsuarioResponse(true,"Usuario Encontrado" , usr)
        }catch (e:Exception) {
            throw NotFoundException(Errors.VK002.message, Errors.VK002.code);
        }
    }
}