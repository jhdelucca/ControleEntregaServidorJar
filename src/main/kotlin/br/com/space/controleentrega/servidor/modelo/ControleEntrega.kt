package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "contentregaped")
class ControleEntrega(@Id
                      @Column(name = "cen_codigo")
                      var codigo:Int,
                      @Column(name = "cen_filcodigo")
                      var filial:Int = 0,
                      @Column(name = "cen_spvcodigo")
                      var serie:String = "",
                      @Column(name = "cen_pednumero")
                      var numPed:Int = 0,
                      @Column(name = "cen_carga")
                      var carga:Int = 0,
                      @Column(name = "cen_usrlogin")
                      var usuario:String = "",
                      @Column(name = "cen_dataentrega")
                      var data:String?=null,
                      @Column(name = "cen_horaentrega")
                      var hora:String = "",
                      @Column(name = "cen_latitude")
                      var latitude:Double = 0.00,
                      @Column(name = "cen_longitude")
                      var longitude:Double = 0.00,
                      @Column(name = "cen_ocecodigo")
                      var codigoOcorrencia:Int = 0,
                      @Column(name="cen_recebedor")
                      var recebedor:String = "",
                      @Column(name = "cen_assinatura")
                      var assinatura:ByteArray?=null,
                      @Column(name = "cen_parcial")
                      var parcial:Int=0,
                      @Column(name="cen_tipodoc")
                      var tipoDoc:Int=0,
                      @Column(name="cen_documento")
                      var documento:String){ }