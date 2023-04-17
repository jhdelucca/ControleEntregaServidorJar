package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.PedidoCarga
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PedidoCargaRepository:CrudRepository<PedidoCarga,Int> {

    @Query("select ped_carga, ped_spvcodigo, ped_numero,ped_filcodigo, ped_stpcodigo,ped_valor, ped_pescodigo, pes_razao, " +
            " pes_fantasia, ped_qtdevol, ped_fpgcodigo, pes_cnpjcpf, fpg_desc, end_logradouro, end_numero, " +
            " end_complemento, end_fone1,end_celular,bai_desc, cid_desc, end_ufsigla, ped_ordement,cen_codigo,cen_ocecodigo,\n" +
            " coalesce((select max(not_snfnumero) from nota where not_lnpcodigo = ped_lnpcodigo and not_filcodigo = ped_filcodigo and ped_lnpcodigo <> 0),0) as numnota\n" +
            " from pedidos left join contentregaped on ped_numero = cen_pednumero and ped_spvcodigo = cen_spvcodigo and " +
            " ped_filcodigo = cen_filcodigo left join ocorentrega on cen_ocecodigo = oce_codigo ,carga, pessoa, formapagto, enderecos, bairro, cidade\n" +
            " where ped_carga = car_codigo and ped_filcodigo = car_filcodigo and ped_pescodigo = pes_codigo and ped_fpgcodigo = fpg_codigo\n" +
            " and ped_endentrega = end_codigo and ped_pescodigo = end_pescodigo and end_baicodigo = bai_codigo and end_cidcodigo = cid_codigo\n" +
            " and car_situacao = 'T' and car_codigo = :codigo and ped_filcodigo = :filial order by ped_ordement" , nativeQuery = true)
    fun getPedidosCarga(codigo:Int , filial:Int) : List<PedidoCarga>


    @Query("select ped_filcodigo, ped_carga, ped_spvcodigo, ped_numero, ped_stpcodigo , ped_valor, ped_pescodigo, pes_razao, pes_fantasia, ped_qtdevol, ped_fpgcodigo,\n" +
            "pes_cnpjcpf, fpg_desc, end_logradouro, end_numero, end_complemento, bai_desc, cid_desc, end_ufsigla, end_fone1,end_celular, ped_ordement,cen_codigo,cen_ocecodigo,\n" +
            "coalesce((select max(not_snfnumero) from nota where not_lnpcodigo = ped_lnpcodigo and not_filcodigo = ped_filcodigo and ped_lnpcodigo <> 0),0) as numnota\n" +
            "from pedidos left join contentregaped on ped_numero = cen_pednumero and ped_spvcodigo = cen_spvcodigo and ped_filcodigo = cen_filcodigo left join ocorentrega on cen_ocecodigo = oce_codigo ,carga, pessoa, formapagto, enderecos, bairro, cidade\n" +
            "where ped_carga = car_codigo and ped_filcodigo = car_filcodigo and ped_pescodigo = pes_codigo and ped_fpgcodigo = fpg_codigo\n" +
            "and ped_endentrega = end_codigo and ped_pescodigo = end_pescodigo and end_baicodigo = bai_codigo and end_cidcodigo = cid_codigo and cen_usrlogin = :usuario and (cen_ocecodigo = 0 or cen_parcial = 1) and cen_dataentrega = :dataEntrega " +
            "and ped_filcodigo = :filial" , nativeQuery = true)
    fun getPedidosEntreguesMotorista(filial: Int,usuario:String,dataEntrega:String) :List<PedidoCarga>

    @Query("select count(ped_carga)as cont_pedidos from pedidos where ped_carga = :carga and ped_filCodigo = :filial" , nativeQuery = true)
    fun getCountPedidos(filial:Int , carga:Int) : Int
}