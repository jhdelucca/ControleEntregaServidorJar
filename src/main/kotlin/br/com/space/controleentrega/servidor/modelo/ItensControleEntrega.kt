package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity(name="contentregapdit")
@IdClass(ItensControleEntregaID::class)
class ItensControleEntrega(@Id
                           @Column(name="cei_filcodigo")
                           var filial:Int? = null,
                           @Id
                           @Column(name="cei_spvcodigo")
                           var serie:String?=null,
                           @Id
                           @Column(name="cei_pednumero")
                           var numPedido:Int?=null,
                           @Id
                           @Column(name="cei_numitem")
                           var numItem:Int?=null,
                           @Column(name="cei_status")
                           var status:String?=null) {
}