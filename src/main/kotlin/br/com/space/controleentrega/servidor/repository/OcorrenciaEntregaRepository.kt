package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.OcorrenciaEntrega
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface OcorrenciaEntregaRepository:CrudRepository<OcorrenciaEntrega ,Int> {

    @Query("select oce_codigo, oce_desc from ocorentrega where oce_ativo = 1" , nativeQuery = true)
    fun getOcorrenciaEntrega() : List<OcorrenciaEntrega>
}