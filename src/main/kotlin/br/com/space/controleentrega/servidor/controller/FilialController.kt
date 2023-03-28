package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.modelo.Filial
import br.com.space.controleentrega.servidor.response.FilialResponse
import br.com.space.controleentrega.servidor.services.FilialService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("filial")
class FilialController(val filialServices:FilialService) {

    @GetMapping("/{usuario}")
    fun getFiliaisUsr(@PathVariable(name="usuario") usuario:String) : FilialResponse {
        val filial = filialServices.getFiliaisUsuario(usuario)
        if (filial.isEmpty()) {
            return FilialResponse(false, "Verifique se usuario está correto.", filial)
        } else {
            return FilialResponse(true, "Filiais retornadas", filial)
        }
    }

    @GetMapping
    fun getFiliais() : List<Filial> {
        return filialServices.getFiliais()
    }

}