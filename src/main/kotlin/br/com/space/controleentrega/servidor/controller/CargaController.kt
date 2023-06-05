package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.exception.NotFoundException
import br.com.space.controleentrega.servidor.modelo.Carga
import br.com.space.controleentrega.servidor.response.CargaResponse
import br.com.space.controleentrega.servidor.services.CargaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("carga")
class CargaController(val service: CargaService) {

    @GetMapping("/transportador/{filial}/{codigo}/{usuario}")
    fun getCargaTransportador(@PathVariable(name = "codigo") codigo:Int ,
                              @PathVariable(name = "filial",) filial:Int,
                              @PathVariable(name = "usuario") usuario:String):CargaResponse {
        try{

            var carga = service.getCargaTransportador(codigo,filial,usuario)
            if(carga.isEmpty()) {
                return CargaResponse(false,"Não existe carga para motorista" , carga)
            }else{
                return CargaResponse(true,"Cargas Recuperadas" , carga)
            }
        }catch (e:Exception) {
            throw NotFoundException(Errors.VK003.message, Errors.VK003.code);
        }
    }

    @GetMapping("/motorista/{filial}/{codigo}/{usuario}")
    fun getCargaMotorista(@PathVariable(name = "codigo") codigo:Int,
                          @PathVariable(name = "filial") filial:Int,
                          @PathVariable(name = "usuario") usuario:String):CargaResponse {
        try{
            var carga = service.getCargaMotorista(codigo,filial,usuario)
            if(carga.isEmpty()) {
                return CargaResponse(false,"Não existe carga para motorista" , carga)
            }else{
                return CargaResponse(true,"Cargas Recuperadas" , carga)
            }
        }catch (e:Exception) {
            throw NotFoundException(Errors.VK003.message, Errors.VK003.code);
        }
    }

    @PutMapping("/{filial}/{carga}")
    fun alteraCargaEntregue(@PathVariable(name = "filial") filial: Int, @PathVariable(name="carga") carga: Int) {
        try {
             service.alteraCargaEntregue(filial,carga)
        } catch (ex: Exception) {
            throw BadRequestException(Errors.VK007.message, Errors.VK007.code)
        }
    }


}