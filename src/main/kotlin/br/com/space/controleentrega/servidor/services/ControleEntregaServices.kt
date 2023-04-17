package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.repository.ControleEntregaRepository
import br.com.space.controleentrega.servidor.request.AlteraControleEntregaRequest
import br.com.space.controleentrega.servidor.request.ItensPedidoRequest
import org.springframework.stereotype.Service

@Service
class ControleEntregaServices(val repository: ControleEntregaRepository) {

    fun saveControleEntrega(controleEntrega: ControleEntrega) : ControleEntrega {
        if (repository.existsById(controleEntrega.codigo.toString().toInt())) {
            throw BadRequestException(Errors.VK004.code,Errors.VK004.message) ;
        }

        return repository.save(controleEntrega)
    }

    fun getControleEntrega(itensPedidoRequest: ItensPedidoRequest) : ControleEntrega {
       return  repository.getControleEntrega(itensPedidoRequest.pedido,itensPedidoRequest.serie,itensPedidoRequest.filial)
    }

    fun getCountControle(filal:Int,carga:Int):Int {
        return repository.getCountEntrega(filal,carga)
    }

    fun alteraControleEntrega(controleEntrega: AlteraControleEntregaRequest) {
        repository.alteraControleEntrega(controleEntrega.filial,controleEntrega.numeroPedido,
            controleEntrega.serie,controleEntrega.assinatura,controleEntrega.recebedor)
    }
}