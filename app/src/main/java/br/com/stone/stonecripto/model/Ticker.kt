package br.com.stone.stonecripto.model

import com.google.gson.annotations.SerializedName

data class Ticker(@SerializedName("buy") val priceBuy: Double,
             @SerializedName("sell") val priceSell: Double) {
}