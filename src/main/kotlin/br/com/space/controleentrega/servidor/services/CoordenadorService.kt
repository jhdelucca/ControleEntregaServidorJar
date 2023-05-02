package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.Coordenador
import br.com.space.controleentrega.servidor.repository.CoordenadorRepository
import br.com.space.controleentrega.servidor.request.VisaoCoordenadorRequest
import org.springframework.stereotype.Service

@Service
class CoordenadorService(val repository: CoordenadorRepository) {

    fun verificaCargasUsuario(dataInicio:String, dataFim:String,filial:Int):List<Coordenador> {
        return repository.verificaCargasUsuario(dataInicio,dataFim,filial)
    }

    fun verificaCargasEntregues(coordenadorRequest: VisaoCoordenadorRequest) : List<Coordenador> {
        return repository.verificaCargasEntregues(coordenadorRequest.usuario,coordenadorRequest.dataInicio,
            coordenadorRequest.dataFim,coordenadorRequest.filial)
    }

    fun verificaPedidosPendentes(coordenadorRequest: VisaoCoordenadorRequest) : List<Coordenador> {
        return repository.verificaPedidosPendentes(coordenadorRequest.usuario,coordenadorRequest.dataInicio,
            coordenadorRequest.dataFim, coordenadorRequest.filial)
    }
    fun verificaPedidosEntregues(coordenadorRequest: VisaoCoordenadorRequest) : List<Coordenador> {
        return repository.verificaPedidosEntregues(coordenadorRequest.usuario,coordenadorRequest.dataInicio,
            coordenadorRequest.dataFim,coordenadorRequest.filial)
    }

    fun verificaPedidosParcial(coordenadorRequest: VisaoCoordenadorRequest) : List<Coordenador> {
        return repository.verificaPedidosParcial(coordenadorRequest.usuario,coordenadorRequest.dataInicio,
            coordenadorRequest.dataFim,coordenadorRequest.filial)
    }

    fun verificaPedidosNaoEntregues(coordenadorRequest: VisaoCoordenadorRequest) : List<Coordenador> {
        return repository.verificaPedidosNaoEntregues(coordenadorRequest.usuario,coordenadorRequest.dataInicio,
            coordenadorRequest.dataFim,coordenadorRequest.filial)
    }

}