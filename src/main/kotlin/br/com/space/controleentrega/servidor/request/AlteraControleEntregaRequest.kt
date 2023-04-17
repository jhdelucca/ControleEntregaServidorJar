package br.com.space.controleentrega.servidor.request

class AlteraControleEntregaRequest(val filial:Int , val numeroPedido:Int , val serie:String, val assinatura:ByteArray,
    val recebedor:String) {
}