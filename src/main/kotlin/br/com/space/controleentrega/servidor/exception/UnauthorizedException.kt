package br.com.space.controleentrega.servidor.exception

import java.lang.Exception

class UnauthorizedException(override val message:String, val errorCode:String):Exception() {
}