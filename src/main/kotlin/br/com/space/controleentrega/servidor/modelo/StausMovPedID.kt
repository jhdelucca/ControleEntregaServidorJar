package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class StausMovPedID:Serializable {

    @Column(name = "SMP_FILCODIGO")
    var filial: Int? = null

    @Column(name = "SMP_SPVCODIGO")
    var serie: String? = null

    @Column(name = "SMP_PEDNUMERO")
    var pedNumero: Int? = null

    @Column(name = "SMP_STPCODIGO")
    var stpCodigo: Int? = null

    @Column(name = "SMP_DATA")
    var data: String? = null

    @Column(name = "SMP_HORA")
    var hora: String = ""
}