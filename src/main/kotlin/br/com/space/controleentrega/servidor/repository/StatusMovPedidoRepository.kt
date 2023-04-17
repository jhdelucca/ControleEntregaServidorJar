package br.com.space.controleentrega.servidor.repository
import br.com.space.controleentrega.servidor.modelo.Filial
import br.com.space.controleentrega.servidor.modelo.StatusMovPedido
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface StatusMovPedidoRepository:CrudRepository<StatusMovPedido , Int> {

    @Query("Select * from statusmovpedido where smp_pednumero = :numero" , nativeQuery = true)
    fun getStatusMov(numero:Int):List<StatusMovPedido>

}