package br.com.space.controleentrega.servidor.response

data class ErroResponse (var httpCode : Int,
                         var message:String,
                         var internalCode: String,
                         var resposta: Boolean ) { }