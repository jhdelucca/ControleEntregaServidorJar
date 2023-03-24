package br.com.space.controleentrega.servidor.repository

import br.com.space.controleentrega.servidor.modelo.Usuario
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository:CrudRepository<Usuario, Int> {

    @Query("select  usr_login, usr_nome, usr_clbcodigo, usr_pescodigot from usuario where usr_login = :usuario",
        nativeQuery = true)
    fun verificaUsuarioTransportador(usuario:String): Usuario

}