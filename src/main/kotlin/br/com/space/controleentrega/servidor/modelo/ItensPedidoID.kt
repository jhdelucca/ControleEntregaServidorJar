package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Id
import java.io.Serializable

@Embeddable
class ItensPedidoID:Serializable {
    @Id
    @Column(name="ipv_unpunidade")
    var unpunidade:String? = null
    @Id
    @Column(name="ipv_unpquant")
    var unpquant:Int?=null
    @Id
    @Column(name="ipv_procodigo")
    var procodigo:Int?=null
}