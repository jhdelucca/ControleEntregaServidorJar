package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.ItensControleEntrega
import org.springframework.data.repository.CrudRepository

interface ItensControleEntregaRepository:CrudRepository<ItensControleEntrega,Int> { }