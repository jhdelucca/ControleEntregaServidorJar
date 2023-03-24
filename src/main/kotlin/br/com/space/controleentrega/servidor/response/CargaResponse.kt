package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.Carga
import br.com.space.controleentrega.servidor.modelo.ColaboradorCargo

class CargaResponse(var resposta:Boolean, var message:String, var dados: List<Carga>? = null) {
}