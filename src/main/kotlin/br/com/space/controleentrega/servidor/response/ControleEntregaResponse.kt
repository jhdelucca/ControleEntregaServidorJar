package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.ControleEntrega

class ControleEntregaResponse(var resposta:Boolean, var message:String, var dados: ControleEntrega? = null) {
}