package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Coordenador(@Id
                  @Column(name = "usuario" , unique = true)
                  var usuario:String,
                  @Column(name = "valor")
                  var valor:Double,
                  @Column(name = "pedidos")
                  var qtdPedidos:Int,
                  @Column(name = "cargas")
                  var qtdCargas:Int) {
}