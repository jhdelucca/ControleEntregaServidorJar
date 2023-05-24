package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.ItensPedido
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ItensPedidoRepository:CrudRepository<ItensPedido , Int> {

    @Query("select ped_numero,ped_spvcodigo,ped_filcodigo,ipv_procodigo,pro_desc,ipv_numitem,ipv_unpunidade,coalesce(cei_status,' ') as cei_status,\n" +
            "            ipv_unpquant,ipv_quantidade,ipv_precovenda from pedidos,itenspedido left join\n" +
            "            contentregapdit on cei_filcodigo=ipv_filcodigo and cei_spvcodigo = ipv_spvcodigo and\n" +
            "            cei_pednumero=ipv_pednumero and cei_numitem=ipv_numitem,produto where pedidos.ped_Filcodigo =\n" +
            "            itenspedido.Ipv_Filcodigo And pedidos.ped_Spvcodigo = itenspedido.Ipv_Spvcodigo And pedidos.ped_Numero =\n" +
            "            itenspedido.Ipv_pedNumero And itenspedido.Ipv_Procodigo = produto.pro_codigo And pedidos.ped_filcodigo =\n" +
            "            :filial And pedidos.ped_spvcodigo = :serie And pedidos.ped_numero = :pedido order by ipv_procodigo" , nativeQuery = true)
    fun getItensPedidoCarga(filial:Int, serie:String , pedido:Int) : List<ItensPedido>
}