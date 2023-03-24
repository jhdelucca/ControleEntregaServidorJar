package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.request.ItensPedidoRequest
import br.com.space.controleentrega.servidor.response.ItensPedidoResponse
import br.com.space.controleentrega.servidor.services.ItensPedidoService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pedido/itens")
class ItensPedidoController(val service: ItensPedidoService) {

    @PostMapping
    fun getItensPedidoCarga(@RequestBody itensPedido: ItensPedidoRequest) : ItensPedidoResponse {
        var itens = service.getItensPedidoCarga(itensPedido.filial,itensPedido.serie,itensPedido.pedido)

        if(itens.isEmpty()) {
            return ItensPedidoResponse(false,"Produtos não encontrados" , itens)
        }else{
            return ItensPedidoResponse(true,"Produtos retornados" , itens)
        }
    }
}