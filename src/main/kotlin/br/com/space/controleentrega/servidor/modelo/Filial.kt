package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name="filial")
class Filial (
    @Id
    @Column(name="FIL_CODIGO", unique = true)
    var codigo : Int?= null,
    @Column(name="FIL_RAZAO")
    var razao:String,
    @Column(name="FIL_FANTASIA")
    var fantasia:String){ }