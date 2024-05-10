import console.Consola
import dbconnection.DataSourceFactory

fun main() {

    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)
    val consola = Consola()
    val product = Product(1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO(dataSource,consola).createProduct(product)

    println("Product ID: $productId")

}