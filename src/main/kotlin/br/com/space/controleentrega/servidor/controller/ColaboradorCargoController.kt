package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.NotFoundException
import br.com.space.controleentrega.servidor.exception.UnauthorizedException
import br.com.space.controleentrega.servidor.response.ColaboradorCargoResponse
import br.com.space.controleentrega.servidor.services.ColaboradorCargoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("colaborador")
class ColaboradorCargoController(val service: ColaboradorCargoService) {

    @GetMapping("/{usuario}")
    fun getColaboradorCargo(@PathVariable(name="usuario") usr:String): ColaboradorCargoResponse {
        try {
            var colaborador = service.getColaboradorCargo(usr)
        if(colaborador.coordenador > 0 || colaborador.motorista > 0) {
            return ColaboradorCargoResponse(true,"Usuario $usr logado com sucesso" , colaborador)
        } else{
            return ColaboradorCargoResponse(false,"Usuario $usr não é coordenador ou motorista" ,colaborador)
        }
        }catch (e:Exception) {
            throw NotFoundException(Errors.VK002.message,Errors.VK002.code);
        }
    }
}