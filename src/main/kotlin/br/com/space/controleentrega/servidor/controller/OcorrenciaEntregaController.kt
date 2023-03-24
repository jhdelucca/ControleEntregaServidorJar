package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.response.OcorrenciaEntregaResponse
import br.com.space.controleentrega.servidor.services.OcorrenciaEntregaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("ocorrencia")
class OcorrenciaEntregaController(val service: OcorrenciaEntregaService) {

    @GetMapping
    fun getOcorrenciaEntrega() : OcorrenciaEntregaResponse{
        var ocorrencia = service.getOcorrenciaEntrega()

        if(ocorrencia.isEmpty()) {
            return OcorrenciaEntregaResponse(false,"Ocorrencias não encontradas" , ocorrencia)
        }else{
            return OcorrenciaEntregaResponse(true,"Ocorrencias recuperadas" , ocorrencia)
        }
    }
}