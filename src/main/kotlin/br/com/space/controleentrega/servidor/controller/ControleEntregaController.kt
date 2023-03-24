package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.services.ControleEntregaServices
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/controleentrega")
class ControleEntregaController(val service: ControleEntregaServices) {

    @PostMapping
    fun saveControleEntrega(@RequestBody controleEntrega: ControleEntrega): ControleEntrega {
        return service.saveControleEntrega(controleEntrega)
    }
}