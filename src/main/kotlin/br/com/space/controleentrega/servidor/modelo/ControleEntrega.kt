package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "contentregaped")
class ControleEntrega(@Id
                      @Column(name = "cen_codigo")
                      var codigo:Int?=null,
                      @Column(name = "cen_filial")
                      var filial:Int?=null,
                      @Column(name = "cen_spvcodigo")
                      var serie:String?=null,
                      @Column(name = "cen_pednumero")
                      var numPed:Int?=null,
                      @Column(name = "cen_carga")
                      var carga:Int?=null,
                      @Column(name = "cen_usrlogin")
                      var usuario:String?=null,
                      @Column(name = "cen_dataentrega")
                      var data:String?=null,
                      @Column(name = "cen_horaentrega")
                      var hora:String?=null,
                      @Column(name = "cen_latitude")
                      var latitude:Double?=null,
                      @Column(name = "cen_longitude")
                      var longitude:Int?=null,
                      @Column(name = "cen_ocecodigo")
                      var codigoOcorrencia:Int?=null,
                      @Column(name = "cen_assinatura")
                      var assinatura:ByteArray?=null){
}