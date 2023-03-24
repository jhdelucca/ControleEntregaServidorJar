package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.NotFoundException
import br.com.space.controleentrega.servidor.modelo.Filial
import br.com.space.controleentrega.servidor.repository.FilialRepository
import org.springframework.stereotype.Service

@Service
class FilialService(val filialRepository: FilialRepository) {

    fun getFiliais(): List<Filial> {
        return filialRepository.findAll().toList()
    }

    fun getFiliaisUsuario(usuario:String) : List<Filial> {
        try {
            return filialRepository.getFiliais(usuario)
        }catch (e:Exception) {
            throw NotFoundException(Errors.VK001.message,Errors.VK001.code)
        }

    }
}