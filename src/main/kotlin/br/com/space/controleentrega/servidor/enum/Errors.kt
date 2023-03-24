package br.com.space.controleentrega.servidor.enum

enum class Errors(val code:String, val message: String) {

    VK001("VK-001","Filial não encontrada"),
    VK002("VK-002","Usuário não encontrado"),
    VK003("VK-003","Nenhuma carga encontrada para motorista"),
    VK004("VK-003","Ja existe controle de entrega com esse ID")

}