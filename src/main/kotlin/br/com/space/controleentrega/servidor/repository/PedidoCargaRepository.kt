package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.PedidoCarga
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface PedidoCargaRepository:CrudRepository<PedidoCarga,Int> {

    @Query("select ped_carga, ped_spvcodigo, ped_numero,ped_filcodigo, ped_stpcodigo,ped_valor, ped_pescodigo, pes_razao,\n" +
            " pes_fantasia, ped_qtdevol, ped_fpgcodigo, pes_cnpjcpf, fpg_desc, end_logradouro, end_numero,\n" +
            " end_complemento, end_fone1,end_celular,bai_desc, cid_desc, end_ufsigla, ped_ordement,coalesce(cen_codigo,0)as cen_codigo,coalesce(cen_ocecodigo,0)as cen_ocecodigo, coalesce(cen_parcial,0) as cen_parcial,\n" +
            " if(ped_lnpcodigo=0,ped_lnpcodigo-ped_lnpcodigo,(select max(not_snfnumero) from nota where not_lnpcodigo = ped_lnpcodigo)) as numnota\n" +
            " from pedidos left join contentregaped on ped_numero = cen_pednumero and ped_spvcodigo = cen_spvcodigo and\n" +
            " ped_filcodigo = cen_filcodigo left join ocorentrega on cen_ocecodigo = oce_codigo ,carga, pessoa, formapagto, enderecos, bairro, cidade\n" +
            " where ped_carga = car_codigo and ped_filcodigo = car_filcodigo and ped_pescodigo = pes_codigo and ped_fpgcodigo = fpg_codigo\n" +
            " and ped_endentrega = end_codigo and ped_pescodigo = end_pescodigo and end_baicodigo = bai_codigo and end_cidcodigo = cid_codigo\n" +
            " and car_situacao = 'T' and car_codigo = :codigo and ped_filcodigo = :filial order by  cen_codigo, ped_ordement", nativeQuery = true)
    fun getPedidosCarga(codigo:Int , filial:Int) : List<PedidoCarga>


    @Query("select ped_filcodigo, ped_carga, ped_spvcodigo, ped_numero, ped_stpcodigo , ped_valor, ped_pescodigo, pes_razao, pes_fantasia, ped_qtdevol, ped_fpgcodigo,\n" +
            "pes_cnpjcpf, fpg_desc, end_logradouro, end_numero, end_complemento, bai_desc, cid_desc, end_ufsigla, end_fone1,end_celular, ped_ordement,cen_codigo,cen_ocecodigo,cen_parcial,\n" +
            "if(ped_lnpcodigo=0,ped_lnpcodigo-ped_lnpcodigo,(select max(not_snfnumero) from nota where not_lnpcodigo = ped_lnpcodigo)) as numnota\n" +
            "from pedidos left join contentregaped on ped_numero = cen_pednumero and ped_spvcodigo = cen_spvcodigo and ped_filcodigo = cen_filcodigo left join ocorentrega on cen_ocecodigo = oce_codigo ,carga, pessoa, formapagto, enderecos, bairro, cidade\n" +
            "where ped_carga = car_codigo and ped_filcodigo = car_filcodigo and ped_pescodigo = pes_codigo and ped_fpgcodigo = fpg_codigo\n" +
            "and ped_endentrega = end_codigo and ped_pescodigo = end_pescodigo and end_baicodigo = bai_codigo and end_cidcodigo = cid_codigo and cen_usrlogin = :usuario and (cen_ocecodigo = 0 or cen_parcial = 1) and cen_dataentrega = :dataEntrega " +
            "and ped_filcodigo = :filial" , nativeQuery = true)
    fun getPedidosEntreguesMotorista(filial: Int,usuario:String,dataEntrega:String) :List<PedidoCarga>

    @Query("select count(ped_carga)as cont_pedidos from pedidos where ped_carga = :carga and ped_filCodigo = :filial" , nativeQuery = true)
    fun getCountPedidos(filial:Int , carga:Int) : Int

    @Query("select ped_carga, ped_spvcodigo, ped_numero,ped_filcodigo, ped_stpcodigo,ped_valor, ped_pescodigo, pes_razao,\n" +
            "pes_fantasia, ped_qtdevol, ped_fpgcodigo, pes_cnpjcpf, fpg_desc, end_logradouro, end_numero,\n" +
            "end_complemento, end_fone1,end_celular,bai_desc, cid_desc, end_ufsigla, ped_ordement,coalesce(cen_codigo,0)as cen_codigo,coalesce(cen_ocecodigo,0)as cen_ocecodigo, coalesce(cen_parcial,0) as cen_parcial,\n" +
            "if(ped_lnpcodigo=0,ped_lnpcodigo-ped_lnpcodigo,(select max(not_snfnumero) from nota where not_lnpcodigo = ped_lnpcodigo)) as numnota\n" +
            "from pedidos left join contentregaped on ped_numero = cen_pednumero and ped_spvcodigo = cen_spvcodigo and\n" +
            "ped_filcodigo = cen_filcodigo left join ocorentrega on cen_ocecodigo = oce_codigo ,carga, pessoa, formapagto, enderecos, bairro, cidade\n" +
            "where ped_carga = car_codigo and ped_filcodigo = car_filcodigo and ped_pescodigo = pes_codigo and ped_fpgcodigo = fpg_codigo\n" +
            "and ped_endentrega = end_codigo and ped_pescodigo = end_pescodigo and end_baicodigo = bai_codigo and end_cidcodigo = cid_codigo\n" +
            "and car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim and ped_filcodigo = :filial " +
            "and coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario order by  ped_numero " , nativeQuery = true)
    fun getPedidosCoordenador(filial: Int , usuario:String , dataInicio:String , dataFim:String) : List<PedidoCarga>

}