package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.modelo.LogPedido
import br.com.space.controleentrega.servidor.services.LogPedidosService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("logpedidos")
class LogPedidosController(val service: LogPedidosService) {

    @PostMapping
    fun saveLogPedidos(@RequestBody logPedidos: LogPedido): LogPedido {
            return service.saveLogPedidos(logPedidos)
    }
}