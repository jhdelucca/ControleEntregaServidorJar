package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.Carga
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CargaRepository:CrudRepository<Carga,Int> {

        @Query("select car_codigo,car_peso,car_valor,car_data from carga,usuario where car_clbcodigo = usr_clbcodigo and car_situacao = 'T' " +
                "and car_clbcodigo = :codigo and car_filcodigo = :filial" , nativeQuery = true)
        fun getCargaMotorista(codigo:Int, filial:Int): List<Carga>

        @Query("select car_codigo,car_peso,car_valor,car_data from carga,usuario where car_pescodigo = usr_pescodigot and car_situacao = 'T' " +
                "and car_pescodigo = :codigo and car_filcodigo = :filial ",  nativeQuery = true)
        fun getCargaTransportador(codigo:Int , filial:Int): List<Carga>

}