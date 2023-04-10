package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.LogPedido
import org.springframework.data.repository.CrudRepository

interface LogPedidoRepository:CrudRepository<LogPedido,Int> {
}