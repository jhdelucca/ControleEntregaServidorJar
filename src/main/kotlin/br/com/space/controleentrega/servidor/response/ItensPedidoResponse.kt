package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.ItensPedido

class ItensPedidoResponse(var resposta:Boolean, var message:String, var dados: List<ItensPedido>? = null) {
}