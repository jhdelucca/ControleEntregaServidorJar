package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.modelo.OcorrenciaEntrega
import br.com.space.controleentrega.servidor.repository.OcorrenciaEntregaRepository
import org.springframework.stereotype.Service

@Service
class OcorrenciaEntregaService(val repository: OcorrenciaEntregaRepository) {

    fun getOcorrenciaEntrega():List<OcorrenciaEntrega> {
        return repository.getOcorrenciaEntrega()
    }
}