package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.Carga
import br.com.space.controleentrega.servidor.modelo.ColaboradorCargo
import br.com.space.controleentrega.servidor.modelo.Coordenador

class CoordenadorResponse(var resposta:Boolean, var message:String, var dados: List<Coordenador>? = null) {
}