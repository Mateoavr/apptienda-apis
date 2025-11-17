package apptienda.apptienda_api.DTO

data class CarritoAdd (
    val productoCodigo: String,
    val usuarioId: Long,
    val nombreProducto: String? = null,
    val precioUnitario: Int,
    val cantidad: Int
)