package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.ColaboradorCargo
import br.com.space.controleentrega.servidor.repository.ColaboradorCargoRepository
import org.springframework.stereotype.Service

@Service
class ColaboradorCargoService(val repository: ColaboradorCargoRepository) {

    fun getColaboradorCargo(usuario:String):ColaboradorCargo {
        return repository.getColaboradorCargo(usuario)
    }

}