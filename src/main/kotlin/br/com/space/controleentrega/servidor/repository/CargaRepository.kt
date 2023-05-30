package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.Carga
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CargaRepository:CrudRepository<Carga,Int> {

        @Query("select car_codigo,car_peso,car_valor,car_data,car_entregue,pa7_infprappcen from carga,usuario,parametro7 where car_clbcodigo = usr_clbcodigo and car_situacao = 'T' " +
                "and car_clbcodigo = :codigo and car_filcodigo = :filial and car_entregue <> 'S'  and car_filcodigo = pa7_filcodigo " , nativeQuery = true)
        fun getCargaMotorista(codigo:Int, filial:Int): List<Carga>

        @Query("select car_codigo,car_peso,car_valor,car_data,car_entregue, pa7_infprappcen from carga,usuario,parametro7 where car_pescodigo = usr_pescodigot and car_situacao = 'T' " +
                "and car_pescodigo = :codigo and car_filcodigo = :filial and car_entregue <> 'S' and car_filcodigo = pa7_filcodigo ",  nativeQuery = true)
        fun getCargaTransportador(codigo:Int , filial:Int): List<Carga>

        @Modifying
        @Transactional
        @Query("update carga set car_entregue = 'S' where car_codigo = :carga and car_filcodigo = :filial" , nativeQuery = true)
        fun alteraCargaEntregue(filial:Int, carga:Int )

}