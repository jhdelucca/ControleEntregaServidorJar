package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.request.PedidoEntregueMotoristaRequest
import br.com.space.controleentrega.servidor.response.PedidoCargaResponse
import br.com.space.controleentrega.servidor.services.PedidoCargaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pedidos")
class PedidoCargaController(val service: PedidoCargaService) {

    @GetMapping("/{filial}/{codigo}")
    fun getPedidosCarga(
        @PathVariable(name = "codigo") codigo: Int,
        @PathVariable(name = "filial") filial: Int
    ): PedidoCargaResponse {
        var pedido = service.getPedidosCarga(codigo, filial)

        if (pedido.isEmpty()) {
            return PedidoCargaResponse(false, "Nenhum pedido encontrado", pedido)
        } else {
            return PedidoCargaResponse(true, "Pedidos recuperados", pedido)

        }
    }

    @PostMapping("/entregues")
    fun getPedidosEntreguesMotorista(@RequestBody request: PedidoEntregueMotoristaRequest): PedidoCargaResponse {
        var pedido = service.getPedidosEntreguesMotorista(request)

        if (pedido.isEmpty()) {
            return PedidoCargaResponse(false, "Não há pedidos entregues", pedido)
        } else {
            return PedidoCargaResponse(true, "Pedidos entregues retornados", pedido)
        }
    }

    @GetMapping("/contador/{filial}/{carga}")
    fun getCountPedidos(
        @PathVariable(name = "filial") filial: Int,
        @PathVariable(name = "carga") carga: Int
    ): Int {
        return service.getCountPedidos(filial, carga)
    }

}