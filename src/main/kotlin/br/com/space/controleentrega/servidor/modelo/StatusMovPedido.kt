package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity(name = "statusmovpedido")
@IdClass(StausMovPedID::class)
class StatusMovPedido(
    @Id
    @Column(name = "SMP_FILCODIGO", unique = true)
    var filial: Int?,
    @Id
    @Column(name = "SMP_SPVCODIGO", unique = true)
    var serie: String,
    @Id
    @Column(name = "SMP_PEDNUMERO", unique = true)
    var pedNumero: Int,
    @Id
    @Column(name = "SMP_STPCODIGO", unique = true)
    var stpCodigo: Int,
    @Id
    @Column(name = "SMP_DATA", unique = true)
    var data: String,
    @Id
    @Column(name = "SMP_HORA", unique = true)
    var hora: String,
    @Column(name="SMP_OBS")
    var obs:String = "") {}