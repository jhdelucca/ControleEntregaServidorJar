package br.com.space.controleentrega.servidor.services

import br.com.space.controleentrega.servidor.enum.Errors
import br.com.space.controleentrega.servidor.exception.BadRequestException
import br.com.space.controleentrega.servidor.modelo.ControleEntrega
import br.com.space.controleentrega.servidor.modelo.LogPedido
import br.com.space.controleentrega.servidor.modelo.StatusMovPedido
import br.com.space.controleentrega.servidor.repository.LogPedidoRepository
import br.com.space.controleentrega.servidor.repository.StatusMovPedidoRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Service
class LogPedidosService(val repository: LogPedidoRepository , val statusMovPedidoRepository: StatusMovPedidoRepository) {

    fun saveLogPedidos(logPedido: LogPedido): LogPedido {
        if (repository.existsById(logPedido.codigo.toString().toInt())) {
            throw BadRequestException(Errors.VK008.code,Errors.VK008.message) ;
        }

        return repository.save(logPedido)
    }

    fun saveStatusPedido(movPedido: StatusMovPedido) : StatusMovPedido {
        return statusMovPedidoRepository.save(movPedido)
    }
}