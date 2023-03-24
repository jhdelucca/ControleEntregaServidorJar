package br.com.space.controleentrega.servidor.modelo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity
@IdClass(PedidoID::class)
class PedidoCarga(
    @Id
    @Column(name = "PED_FILCODIGO" , unique = true)
    var filial: Int? = null,
    @Id
    @Column(name = "PED_SPVCODIGO" , unique = true)
    var serie: String? = null,
    @Id
    @Column(name = "PED_NUMERO" , unique = true)
    var numero: Int? = null,
    @Column(name = "PED_CARGA")
    var carga: Int? = null,
    @Column(name="PED_VALOR")
    var valor:Double? = null,
    @Column(name="PED_PESCODIGO")
    var pesCodigo:Int? = null,
    @Column(name="PES_RAZAO")
    var razao:String? = null,
    @Column(name="PES_FANTASIA")
    var fantasia:String? = null,
    @Column(name="PED_QTDEVOL")
    var volume:Double? = null,
    @Column(name="ped_fpgcodigo")
    var fpgCodigo:String? = null,
    @Column(name="PES_CNPJCPF")
    var cnpjCpf:String? = null,
    @Column(name="FPG_DESC")
    var descPagamento:String? = null,
    @Column(name="END_LOGRADOURO")
    var rua:String? = null,
    @Column(name="END_NUMERO")
    var numeroEnd:String?=null,
    @Column(name="END_COMPLEMENTO")
    var complemento:String? = null,
    @Column(name="BAI_DESC")
    var bairro:String? = null,
    @Column(name="CID_DESC")
    var cidade:String? = null,
    @Column(name="END_UFSIGLA")
    var uf:String? = null,
    @Column(name="PED_ORDEMENT")
    var ordemEntrega:Int?=null,
    @Column(name="CEN_CODIGO")
    var codigoControleEntrega:Int ?=null,
    @Column(name="CEN_OCECODIGO")
    var codigoOcorrencia:Int ?=null,
    @Column(name="numnota")
    var numeroNota:Int ?=null) { }