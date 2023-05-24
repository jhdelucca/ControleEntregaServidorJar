package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Carga(@Id
            @Column(name = "CAR_CODIGO" , unique = true)
            var codigo:Int,
            @Column(name = "CAR_PESO")
            var peso:Double,
            @Column(name = "CAR_VALOR")
            var valor:Double,
            @Column(name = "CAR_DATA")
            var data:String,
            @Column(name = "CAR_ENTREGUE")
            var statusEntrega:String,
            @Column(name= "PA7_INFPRAPPCEN")
            var informaProduto:Int) { }