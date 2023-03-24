package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.Carga
import br.com.space.controleentrega.servidor.repository.CargaRepository
import org.springframework.stereotype.Service

@Service
class CargaService(val repository: CargaRepository) {

    fun getCargaMotorista(codigo:Int , filial:Int): List<Carga> {
        return repository.getCargaMotorista(codigo,filial)
    }

    fun getCargaTransportador(codigo:Int, filial:Int): List<Carga> {
        return repository.getCargaTransportador(codigo,filial)
    }

}