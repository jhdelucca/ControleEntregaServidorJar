package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.Coordenador
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CoordenadorRepository:CrudRepository<Coordenador , Int> {

    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim and car_filcodigo = :filial \n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaCargasUsuario(dataInicio: String , dataFim: String , filial:Int):List<Coordenador>
    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim and car_entregue = 'S' and " +
            "coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario and car_filcodigo = :filial\n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaCargasEntregues(usuario:String,dataInicio: String , dataFim: String , filial:Int) : List<Coordenador>


    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim  and cen_codigo is null " +
            "and coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario and car_filcodigo = :filial \n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaPedidosPendentes(usuario: String,dataInicio: String , dataFim: String , filial:Int) : List<Coordenador>
    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim  and " +
            "cen_codigo > 0 and cen_ocecodigo = 0 and coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario and car_filcodigo = :filial\n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaPedidosEntregues(usuario: String,dataInicio: String , dataFim: String , filial:Int) : List<Coordenador>
    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim  and " +
            "cen_codigo > 0 and cen_ocecodigo > 0 and cen_parcial = 1 and coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario and car_filcodigo = :filial\n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaPedidosParcial(usuario: String,dataInicio: String , dataFim: String , filial:Int) : List<Coordenador>
    @Query("select coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) as usuario,\n" +
            "round(sum(ped_valor),2) as valor, count(*) as pedidos, count(distinct car_codigo) as cargas from carga inner join pedidos on car_codigo = ped_carga and car_filcodigo = ped_filcodigo\n" +
            "left join contentregaped on ped_filcodigo = cen_filcodigo and ped_spvcodigo = cen_spvcodigo and ped_numero = cen_pednumero\n" +
            "where car_situacao in ('T','R','B') and car_data between :dataInicio and :dataFim  and " +
            "cen_codigo > 0 and cen_ocecodigo > 0 and cen_parcial = 0 and coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1)) = :usuario and car_filcodigo = :filial \n" +
            "group by coalesce((select max(usr_login) from usuario where usr_pescodigot = car_pescodigo and usr_ativo=1),(select max(usr_login) from usuario where usr_clbcodigo = car_clbcodigo and usr_ativo=1))" , nativeQuery = true)
    fun verificaPedidosNaoEntregues(usuario: String,dataInicio: String , dataFim: String , filial: Int) : List<Coordenador>
}