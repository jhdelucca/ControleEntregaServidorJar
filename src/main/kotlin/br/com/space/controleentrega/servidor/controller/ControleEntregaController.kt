package br.com.space.controleentrega.servidor.controller

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.exception.NotFoundException
import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.modelo.ItensControleEntrega
import br.com.space.controleentrega.servidor.request.AlteraControleEntregaRequest
import br.com.space.controleentrega.servidor.request.ItensPedidoRequest
import br.com.space.controleentrega.servidor.response.ControleEntregaResponse
import br.com.space.controleentrega.servidor.services.ControleEntregaServices
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/controleentrega")
class ControleEntregaController(val service: ControleEntregaServices) {

    @PostMapping
    fun saveControleEntrega(@RequestBody controleEntrega: ControleEntrega): ControleEntrega {

        try {
            return service.saveControleEntrega(controleEntrega)
        } catch (ex: Exception) {
            throw BadRequestException(Errors.VK005.message, Errors.VK005.code);
        }
    }

    @PostMapping("/recupera")
    fun getControleEntrega(@RequestBody pedido:ItensPedidoRequest) : ControleEntregaResponse {
        try {
            val controle = service.getControleEntrega(pedido)
            return ControleEntregaResponse(true,"Entrega Recuperada" , controle)
        }catch (ex:Exception) {
            throw NotFoundException(Errors.VK006.message, Errors.VK006.code)
        }
    }
    @GetMapping("/contador/{filial}/{carga}")
    fun getCountPedidos(@PathVariable(name="filial") filial: Int,
                        @PathVariable(name="carga") carga:Int):Int {
        return service.getCountControle(filial,carga)
    }

    @PutMapping()
    fun alteraControleEntrega(@RequestBody alteraControle: AlteraControleEntregaRequest) {
        try {
            service.alteraControleEntrega(alteraControle)
        } catch (ex: Exception) {
            throw BadRequestException(Errors.VK006.message, Errors.VK006.code)
        }
    }

    @PostMapping("/itens")
    fun insereItensControleEntrega(@RequestBody itensControleEntrega: MutableList<ItensControleEntrega>) : MutableIterable<ItensControleEntrega> {
        try{
            return service.insereItensControleEntrega(itensControleEntrega)
        } catch (ex: Exception) {
            throw BadRequestException(Errors.VK005.message, Errors.VK005.code);
        }

    }



}