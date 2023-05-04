package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.ColaboradorCargo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ColaboradorCargoRepository:CrudRepository<ColaboradorCargo, Int> {

    @Query("Select colaborador.CLB_CODIGO, colaborador.CLB_RAZAO,cargo.crg_motorista,cargo.crg_coordenador,clb_celular From\n" +
            "usuario, colaborador Left Join cargo On colaborador.CLB_CRGCODIGO = cargo.CRG_CODIGO Where\n" +
            "colaborador.CLB_CODIGO = usuario.USR_CLBCODIGO And usuario.USR_LOGIN = :usuario", nativeQuery = true)
    fun getColaboradorCargo(usuario:String): ColaboradorCargo

}