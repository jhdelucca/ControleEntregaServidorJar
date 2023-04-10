package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name="logpedidos")
class LogPedido(@Id
                @Column(name="lgp_codigo" , unique = true)
                var codigo:Int,
                @Column(name="lgp_spvcodigo")
                var serie:String,
                @Column(name="lgp_pednumero")
                var numeroPedido:Int,
                @Column(name="lgp_stpcodigo")
                var stpCodigo:Int,
                @Column(name="lgp_data")
                var data:String,
                @Column(name="lgp_usrlogin")
                var usuario:String,
                @Column(name="lgp_obs")
                var obs:String,
                @Column(name="lgp_filcodigo")
                var filial:Int,
                @Column(name="lgp_sescodigo")
                var sessao:Int,
                @Column(name="lgp_strcodigo")
                var strCodigo:Int?=null,
                @Column(name="lgp_hora")
                var hora:String,
                @Column(name="lgp_envpalm")
                var envPalm:Int = 0,
                @Column(name="lgp_obscanc")
                var obsCancela:String = "",
                @Column(name="lgp_codigoaux")
                var codigoAux:Int = 0){ }