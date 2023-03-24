package br.com.space.controleentrega.servidor.modelo
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class PedidoID : Serializable {
    @Column(name = "PED_FILCODIGO")
    var filial: Int? = null

    @Column(name = "PED_SPVCODIGO")
    var serie: String? = null

    @Column(name = "PED_NUMERO")
    var numero: Int? = null
}