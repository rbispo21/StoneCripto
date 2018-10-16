package br.com.stone.stonecripto.model

import com.google.gson.annotations.SerializedName

data class QuotationModelRest(@SerializedName("cotacaoCompra") val buy: Double,
                              @SerializedName("cotacaoVenda") val sell: Double) {
}