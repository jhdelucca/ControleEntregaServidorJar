package br.com.space.controleentrega.servidor.exception

class BadRequestException(override val message:String, val errorCode:String):Exception() {
}