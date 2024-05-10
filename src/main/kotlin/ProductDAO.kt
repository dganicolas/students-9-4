import console.Iconsola
import java.sql.SQLException
import javax.sql.DataSource

class ProductDAO(
    private val dataSource: DataSource,
    private val consola : Iconsola
) {
    fun createProduct(user: Product): Product? {
        val sql = "INSERT INTO PRODUCTS (ID ,NAME ,PRICE ,DESCRIPTION ,BRAND ,CATEGORY ) values(?, ?, ?, ?, ?, ?)"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, user.id.toString())
                    stmt.setString(2, user.name)
                    stmt.setString(3, user.price.toString())
                    stmt.setString(4, user.description)
                    stmt.setString(5, user.brand)
                    stmt.setString(6, user.category)
                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        user
                    } else {
                        consola.showMessage("error insert query failed! ($rs records inserted)")
                        null
                    }
                }
            }
        } catch (e: SQLException) {
            consola.showMessage("error* insert query failed! (${e.message})")
            null
        }
    }

}
