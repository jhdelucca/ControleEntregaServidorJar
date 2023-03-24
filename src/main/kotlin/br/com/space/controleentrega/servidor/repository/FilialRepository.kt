package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.Filial
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface FilialRepository:CrudRepository<Filial,Int> {

    @Query("Select FIL_CODIGO, FIL_RAZAO, FIL_FANTASIA\n" +
            "From  filial , usrfilial\n" +
            "Where filial.FIL_CODIGO = usrfilial.USF_FILCODIGO And\n" +
            "usrfilial.USF_USRLOGIN = :usuario" , nativeQuery = true)
    fun getFiliais(usuario:String):List<Filial>
}