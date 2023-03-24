package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.repository.ControleEntregaRepository

class ControleEntregaServices(val repository: ControleEntregaRepository) {

    fun saveControleEntrega(controleEntrega: ControleEntrega) : ControleEntrega {

        if (repository.existsById(controleEntrega.codigo.toString().toInt())) {
            throw BadRequestException(Errors.VK004.code,Errors.VK004.message) ;
        }

        return repository.save(controleEntrega)
    }
}