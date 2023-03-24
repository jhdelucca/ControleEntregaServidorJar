package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.ItensPedido
import br.com.space.controleentrega.servidor.repository.ItensPedidoRepository
import org.springframework.stereotype.Service

@Service
class ItensPedidoService(val repository:ItensPedidoRepository) {

    fun getItensPedidoCarga(filial:Int, serie:String, pedido:Int): List<ItensPedido> {
        return  repository.getItensPedidoCarga(filial,serie,pedido)
    }


}