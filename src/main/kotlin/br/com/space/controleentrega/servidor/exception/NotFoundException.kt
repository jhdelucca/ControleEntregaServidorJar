package br.com.space.controleentrega.servidor.exception

class NotFoundException(override val message:String, val errorCode:String):Exception() {
}