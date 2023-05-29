package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.modelo.OcorrenciaEntrega
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface ControleEntregaRepository:CrudRepository<ControleEntrega,Int> {
    @Query(" select * from contentregaped where cen_pednumero = :pedido and cen_spvcodigo = :serie\n" +
            "and cen_filcodigo = :filial " , nativeQuery = true)
    fun getControleEntrega(pedido:Int, serie:String , filial:Int) : ControleEntrega

    @Query("select count(*)as cont_entregas from contentregaped where cen_filcodigo = :filial and cen_carga = :carga" , nativeQuery = true)
    fun getCountEntrega(filial:Int , carga:Int) : Int

    @Modifying
    @Transactional
    @Query("update contentregaped set cen_assinatura = :assinatura , cen_recebedor = :recebedor , " +
            "cen_tipoDoc = :tipoDoc , cen_documento = :documento where cen_filcodigo = :filial and " +
            "cen_spvcodigo = :serie and cen_pednumero = :numeroPedido" , nativeQuery = true)
    fun alteraControleEntrega(filial:Int , numeroPedido:Int , serie:String ,assinatura:ByteArray,
                              recebedor:String,tipoDoc:Int,documento:String)

}