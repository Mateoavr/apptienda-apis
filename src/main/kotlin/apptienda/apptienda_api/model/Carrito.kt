package apptienda.apptienda_api.model

data class Carrito (
    val id: Long,
    val productoCodigo: String,
    val usuarioId: Long,
    val nombreProducto: String,
    val precioUnitario: Int,
    val cantidad: Int
)