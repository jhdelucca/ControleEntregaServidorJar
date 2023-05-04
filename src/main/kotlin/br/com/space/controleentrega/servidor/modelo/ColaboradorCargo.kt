package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class ColaboradorCargo(    @Id
                           @Column(name = "CLB_CODIGO", unique = true)
                           var codigo:Int? =null,
                           @Column(name="CLB_RAZAO")
                           var razao: String = "",
                           @Column(name="CRG_MOTORISTA")
                           var motorista:Int = 0,
                           @Column(name="CRG_COORDENADOR")
                           var coordenador:Int = 0,
                           @Column(name="CLB_CELULAR")
                           var celular:String="") {


}