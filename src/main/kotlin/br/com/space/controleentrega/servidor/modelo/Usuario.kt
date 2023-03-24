package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "usuario")
class Usuario( @Id
               @Column(name = "USR_LOGIN", unique = true)
               var login:String = "",
               @Column(name="USR_NOME")
               var nome:String,
               @Column(name="USR_CLBCODIGO")
               var colaboradorCodigo:Int,
               @Column(name = "USR_PESCODIGOT")
               var codigoTransportador:Int) { }