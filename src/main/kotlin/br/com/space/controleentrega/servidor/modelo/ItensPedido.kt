package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity
@IdClass(ItensPedidoID::class)
class ItensPedido(@Column(name="PED_FILCODIGO")
                  var filial:Int?=null,
                  @Column(name="PED_SPVCODIGO")
                  var serie:String?=null,
                  @Column(name="PED_NUMERO")
                  var numero:Int?=null,
                  @Id
                  @Column(name="ipv_procodigo" , unique = true)
                  var procodigo:Int?=null,
                  @Column(name="pro_desc")
                  var prodesc:String?=null,
                  @Column(name="ipv_numitem")
                  var numItem:Int?=null,
                  @Id
                  @Column(name="ipv_unpunidade" , unique = true)
                  var unpunidade:String?=null,
                  @Id
                  @Column(name="ipv_unpquant" , unique = true)
                  var unpquant:Int ?=null,
                  @Column(name="ipv_quantidade")
                  var quantidade:Double ?=null,
                  @Column(name="ipv_precovenda")
                  var precovenda:Double ?=null,
                  @Column(name="cei_status")
                  var status:String) { }