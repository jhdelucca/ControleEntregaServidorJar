package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "ocorentrega")
class OcorrenciaEntrega(
    @Id
    @Column(name = "oce_codigo")
    var codigo:Int?=null,
    @Column(name = "oce_desc")
    var descricao:String?=null) { }