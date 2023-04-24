package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.PedidoCarga
import br.com.space.controleentrega.servidor.repository.PedidoCargaRepository
import br.com.space.controleentrega.servidor.request.ItensPedidoRequest
import br.com.space.controleentrega.servidor.request.PedidoEntregueMotoristaRequest
import org.springframework.stereotype.Service

@Service
class PedidoCargaService(val repository: PedidoCargaRepository) {

    fun getPedidosCarga(codigo:Int,filial:Int): List<PedidoCarga>{
        return repository.getPedidosCarga(codigo,filial)
    }

    fun getPedidosEntreguesMotorista(request: PedidoEntregueMotoristaRequest):List<PedidoCarga> {
        return repository.getPedidosEntreguesMotorista(request.filial,request.usuario,request.dataEntrega)
    }

    fun getCountPedidos(filial: Int , carga:Int):Int {
        return repository.getCountPedidos(filial,carga)
    }


}