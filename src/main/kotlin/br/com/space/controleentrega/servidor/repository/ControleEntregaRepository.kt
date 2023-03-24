package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import org.springframework.data.repository.CrudRepository

interface ControleEntregaRepository:CrudRepository<ControleEntrega,Int> {
}