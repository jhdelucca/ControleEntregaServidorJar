package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.request.VisaoCoordenadorRequest
import br.com.space.controleentrega.servidor.response.CoordenadorResponse
import br.com.space.controleentrega.servidor.services.CoordenadorService
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("coordenador")
class CoordenadorController(val service:CoordenadorService) {
    @GetMapping("/cargas")
    fun verificaCargasUsuario(@Param("dataInicio") dataInicio:String,
                              @Param("dataFim") dataFim:String,
                              @Param("filial") filial:Int):CoordenadorResponse {
        var coordenador = service.verificaCargasUsuario(dataInicio,dataFim,filial)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhuma carga encontrada",coordenador)
        }else{
            return CoordenadorResponse(true,"Cargas recuperadas",coordenador)
        }
    }
    @PostMapping("/cargasfinalizadas")
    fun verificaCargasEntregues(@RequestBody coordenadorRequest: VisaoCoordenadorRequest) :CoordenadorResponse {
        var coordenador = service.verificaCargasEntregues(coordenadorRequest)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhuma carga encontrada",coordenador)
        }else{
            return CoordenadorResponse(true,"Cargas recuperadas",coordenador)
        }
    }

    @PostMapping("/pedidos/pendentes")
    fun verificaPedidosPendentes(@RequestBody coordenadorRequest: VisaoCoordenadorRequest) :CoordenadorResponse {
        var coordenador = service.verificaPedidosPendentes(coordenadorRequest)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhum pedido encontrado",coordenador)
        }else{
            return CoordenadorResponse(true,"Pedidos recuperados",coordenador)
        }
    }

    @PostMapping("/pedidos/entregues")
    fun verificaPedidosEntregues(@RequestBody coordenadorRequest: VisaoCoordenadorRequest) :CoordenadorResponse {
        var coordenador = service.verificaPedidosEntregues(coordenadorRequest)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhum pedido encontrado",coordenador)
        }else{
            return CoordenadorResponse(true,"Pedidos recuperados",coordenador)
        }
    }

    @PostMapping("/pedidos/parcial")
    fun verificaPedidosParcial(@RequestBody coordenadorRequest: VisaoCoordenadorRequest) :CoordenadorResponse {
        var coordenador = service.verificaPedidosParcial(coordenadorRequest)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhum pedido encontrado",coordenador)
        }else{
            return CoordenadorResponse(true,"Pedidos recuperados",coordenador)
        }
    }

    @PostMapping("/pedidos/naoentregues")
    fun verificaPedidosNaoEntregues(@RequestBody coordenadorRequest: VisaoCoordenadorRequest) :CoordenadorResponse {
        var coordenador = service.verificaPedidosNaoEntregues(coordenadorRequest)
        if(coordenador.isEmpty()) {
            return CoordenadorResponse(false,"Nenhum pedido encontrado",coordenador)
        }else{
            return CoordenadorResponse(true,"Pedidos recuperados",coordenador)
        }
    }
}

