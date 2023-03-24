package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.PedidoCarga

class PedidoCargaResponse(var resposta:Boolean, var message:String, var dados: List<PedidoCarga>? = null) {
}