package br.com.space.controleentrega.servidor.response

import br.com.space.controleentrega.servidor.modelo.Usuario

class UsuarioResponse(var resposta:Boolean, var message:String, var dados: Usuario? = null) {
}