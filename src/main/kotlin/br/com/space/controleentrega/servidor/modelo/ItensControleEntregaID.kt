package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Id
@Embeddable
class ItensControleEntregaID {

    @Id
    @Column(name="cei_filcodigo")
    var filial:Int? = null
    @Id
    @Column(name="cei_spvcodigo")
    var serie:String?=null
    @Id
    @Column(name="cei_pednumero")
    var numPedido:Int?=null
    @Id
    @Column(name="cei_numitem")
    var numItem:Int?=null

}